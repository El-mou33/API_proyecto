package com.example.api.repository;

import com.example.api.models.Dueños;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuenosRepository extends JpaRepository<Dueños,Long> {
    //Consulta para buscar el email concreto
    //@Query("Select d from Dueños d where d.email = ?1")
    @Query("Select d from Dueños d where d.email like :email%")
    public List<Dueños> findByEmail(String email);

}
