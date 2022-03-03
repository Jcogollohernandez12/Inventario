/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.nodos;

/**
 *
 * @author JOSE ANDRES
 */
public class Nodo_Compra {
    
    private String NombreE, NombreC;
    private Nodo_Compra Siguiente, Anterior;
    private float Precio;
    private int Codigo, CodigoEmpl, CodigoClien, CodigoEntr;

    public Nodo_Compra() {
        this.NombreE = "";
        this.NombreC = "";
        this.Precio = 0;
        this.Codigo = 0;
        this.CodigoEmpl = 0;
        this.CodigoClien = 0;
        this.CodigoEntr = 0;
        this.Siguiente = null;
        this.Anterior = null;
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getNombreE() {
        return NombreE;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String NombreC) {
        this.NombreC = NombreC;
    }

    public Nodo_Compra getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo_Compra Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo_Compra getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo_Compra Anterior) {
        this.Anterior = Anterior;
    }

    
    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    
    public void setNombreE(String NombreE) {
        this.NombreE = NombreE;
    }

    public int getCodigoEmpl() {
        return CodigoEmpl;
    }

    public void setCodigoEmpl(int CodigoEmpl) {
        this.CodigoEmpl = CodigoEmpl;
    }

    public int getCodigoClien() {
        return CodigoClien;
    }

    public void setCodigoClien(int CodigoClien) {
        this.CodigoClien = CodigoClien;
    }

    public int getCodigoEntr() {
        return CodigoEntr;
    }

    public void setCodigoEntr(int CodigoEntr) {
        this.CodigoEntr = CodigoEntr;
    }


   
}
