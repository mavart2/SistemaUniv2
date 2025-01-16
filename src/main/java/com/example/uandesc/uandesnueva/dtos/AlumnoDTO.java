package com.example.uandesc.uandesnueva.dtos;


public class AlumnoDTO {
    private Long id;
    private String rut;
    private String nombre;
    private String direccion;

    // Constructor

    public AlumnoDTO(Long id, String rut, String nombre, String direccion) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;

    }

    // Getters y Setters
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
    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "id=" + id +
                ", rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

}