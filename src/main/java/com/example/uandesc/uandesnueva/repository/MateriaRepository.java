package com.example.uandesc.uandesnueva.repository;

import com.example.uandesc.uandesnueva.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    List<Materia> findByAlumnosId(Long alumnoId);
}
