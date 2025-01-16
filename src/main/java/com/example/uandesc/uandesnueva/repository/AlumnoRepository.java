package com.example.uandesc.uandesnueva.repository;

import com.example.uandesc.uandesnueva.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

