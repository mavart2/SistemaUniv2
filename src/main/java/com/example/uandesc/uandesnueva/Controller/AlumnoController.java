package com.example.uandesc.uandesnueva.Controller;

import com.example.uandesc.uandesnueva.dtos.MateriaDTO;
import com.example.uandesc.uandesnueva.models.Alumno;
import com.example.uandesc.uandesnueva.models.Materia;
import com.example.uandesc.uandesnueva.services.AlumnoService;
import com.example.uandesc.uandesnueva.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final MateriaService materiaService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService, MateriaService materiaService) {
        this.alumnoService = alumnoService;
        this.materiaService = materiaService;
    }

    @GetMapping("/lista")
    public String obtenerAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.obtenerAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumnos/lista";
    }

    @GetMapping("/nuevo-alumno")
    public String mostrarFormularioNuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("materias", materiaService.obtenerMaterias());
        return "alumnos/nuevo-alumno";
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno, @RequestParam List<Long> materiaIds) {
        Set<Materia> materias = new HashSet<>(materiaService.obtenerMateriasPorIds(materiaIds));
        alumno.setMateriaList(materias);
        alumnoService.guardarAlumno(alumno);
        return "redirect:/alumnos/lista";
    }

    @GetMapping("/{id}")
    public String mostrarDetallesAlumno(@PathVariable Long id, Model model) {
        Alumno alumno = alumnoService.obtenerAlumnoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado: " + id));

        List<MateriaDTO> materias = materiaService.obtenerMateriasPorAlumnoId(id);

        model.addAttribute("alumno", alumno);
        model.addAttribute("materias", materias);

        return "alumnos/detalle-alumno";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return "redirect:/alumnos/lista";
    }
}
