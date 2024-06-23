package com.example.api;

import com.example.api.controllers.DuenosController;
import com.example.api.dtos.DuenoDtoResponse;
import com.example.api.dtos.DuenosDtoRequest;
import com.example.api.service.DuenosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DuenosControllerTest {

    @Mock
    private DuenosService duenosService;

    @InjectMocks
    private DuenosController duenosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {

        DuenoDtoResponse dueñoDtoResponse = new DuenoDtoResponse();
        dueñoDtoResponse.setIdDueno(1L);
        List<DuenoDtoResponse> dueñosList = Collections.singletonList(dueñoDtoResponse);

        when(duenosService.devolverTodosLosdueños()).thenReturn(dueñosList);

        List<DuenoDtoResponse> result = duenosController.findAll();
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getIdDueno());
    }

    @Test
    public void testEncontrarPorId() {

        DuenoDtoResponse dueñoDtoResponse = new DuenoDtoResponse();
        dueñoDtoResponse.setIdDueno(1L);
        duenosService.findById(1L);
        when(duenosService.findById(1L)).thenReturn(Optional.of(dueñoDtoResponse));

        ResponseEntity<?> response = duenosController.encontrarPorId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dueñoDtoResponse, response.getBody());
    }

    @Test
    public void testGuardar() {

        DuenosDtoRequest duenoDtoRequest = new DuenosDtoRequest();
        duenoDtoRequest.setNombre("Test");

        when(duenosService.save(duenoDtoRequest)).thenReturn(duenoDtoRequest);

        ResponseEntity<?> response = duenosController.guardar(duenoDtoRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(duenoDtoRequest, response.getBody());
    }

    @Test
    public void testActualizar() {

        DuenosDtoRequest duenoDtoRequest = new DuenosDtoRequest();
        duenoDtoRequest.setNombre("Test Updated");

        when(duenosService.actualizado(duenoDtoRequest, 1L)).thenReturn(duenoDtoRequest);

        ResponseEntity<?> response = duenosController.actualizar(1L, duenoDtoRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(duenoDtoRequest, response.getBody());
    }
}
