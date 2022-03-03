
package Codigo.nodos;

import java.io.Serializable;

/**
 *
 * @author JOSE ANDRES
 */
public class Nodo_Entrega implements Serializable{
    
  private Nodo_Entrega Siguiente, Anterior;
  private int Codigo, Stop, Codigo_V, Codigo_C;
  private float Precio;
  private String  Vendedor, Tipo, Descripcion, Fecha;
  private boolean Pro;

    public Nodo_Entrega() {
        this.Siguiente = null;
        this.Anterior = null;
        this.Codigo = 0;
        this.Tipo = "";
        this.Descripcion = "";
        this.Vendedor = "";
        this.Precio = 0;
        this.Pro = Pro;
        this.Stop = 0;
        this.Fecha ="";
        this.Codigo_V =0;
        this.Codigo_C =0;
    }
    
    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public Nodo_Entrega getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo_Entrega Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo_Entrega getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo_Entrega Anterior) {
        this.Anterior = Anterior;
    }

    public int getCodigo() {
        return Codigo;
    }

    public int getStop() {
        return Stop;
    }

    public void setStop(int Stop) {
        this.Stop = Stop;
    }

    public boolean isPro() {
        return Pro;
    }

    public void setPro(boolean Pro) {
        this.Pro = Pro;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getCodigo_V() {
        return Codigo_V;
    }

    public void setCodigo_V(int Codigo_V) {
        this.Codigo_V = Codigo_V;
    }

    public int getCodigo_C() {
        return Codigo_C;
    }

    public void setCodigo_C(int Codigo_C) {
        this.Codigo_C = Codigo_C;
    }
  
  
  
}
