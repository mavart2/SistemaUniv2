package com.example.uandesc.uandesnueva.services;

import com.example.uandesc.uandesnueva.dtos.MateriaDTO;
import com.example.uandesc.uandesnueva.models.Materia;
import com.example.uandesc.uandesnueva.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<MateriaDTO> obtenerMateriasPorAlumnoId(Long alumnoId) {
        return materiaRepository.findByAlumnosId(alumnoId).stream()
                .map(this::convertirMateriaADTO)
                .collect(Collectors.toList());
    }

    private MateriaDTO convertirMateriaADTO(Materia materia) {
        return new MateriaDTO(materia.getId(), materia.getNombre());
    }

    public List<MateriaDTO> obtenerMaterias() {
        return materiaRepository.findAll().stream()
                .map(this::convertirMateriaADTO)
                .collect(Collectors.toList());
    }

    public List<Materia> obtenerMateriasPorIds(List<Long> ids) {

        return materiaRepository.findAllById(ids);
    }
}
