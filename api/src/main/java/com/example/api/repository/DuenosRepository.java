package com.example.api.repository;

import com.example.api.models.Dueños;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenosRepository extends JpaRepository<Dueños,Long> {



}
