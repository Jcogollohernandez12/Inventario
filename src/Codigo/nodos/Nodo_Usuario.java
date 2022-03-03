/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.nodos;

/**
 *
 * @author ESTUDIANTES
 */
public class Nodo_Usuario {
    private String Nombre, clave;
    private boolean Tipo_U;
    private int id;
    private Nodo_Usuario Siguiente, Anterior;

    public Nodo_Usuario() {
        this.Nombre = "";
        this.clave = "";
        this.Tipo_U = false;
        this.Anterior = null;
        this.Siguiente = null;
        this.id = 0;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isTipo_U() {
        return Tipo_U;
    }

    public void setTipo_U(boolean Tipo_U) {
        this.Tipo_U = Tipo_U;
    }

    public Nodo_Usuario getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo_Usuario Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo_Usuario getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo_Usuario Anterior) {
        this.Anterior = Anterior;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
