package com.example.uandesc.uandesnueva.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
//import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 12)
    @NotNull(message = "El rut no puede ser nulo")
    private String rut;

    @Column(nullable = false, length = 100)
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Column(nullable = false, length = 100)
    @NotNull(message = "La dirección no puede ser nula")
    private String direccion;



    @ManyToMany
    @JoinTable(
           name = "alumno_materia",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materiaList = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(Set<Materia> materiaList) {
        this.materiaList = materiaList;
    }


}



