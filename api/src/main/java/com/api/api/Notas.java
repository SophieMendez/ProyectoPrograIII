package com.api.api;

public class Notas {

    //Atributos
    private int id_nota;
    private String nombre_nota;
    private String estado_nota;
    private String descripcion_nota;

    public Notas (int id_nota, String nombre_nota, String estado_nota,String descripcion_nota ){
        this.id_nota = id_nota;
        this.nombre_nota = nombre_nota;
        this.estado_nota = estado_nota;
        this.descripcion_nota = descripcion_nota;
    }

    //setter and getters

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public String getNombre_nota() {
        return nombre_nota;
    }

    public void setNombre_nota(String nombre_nota) {
        this.nombre_nota = nombre_nota;
    }

    public String getEstado_nota() {
        return estado_nota;
    }

    public void setEstado_nota(String estado_nota) {
        this.estado_nota = estado_nota;
    }

    public String getDescripcion_nota() {
        return descripcion_nota;
    }

    public void setDescripcion_nota(String descripcion_nota) {
        this.descripcion_nota = descripcion_nota;
    }
    
    
}
