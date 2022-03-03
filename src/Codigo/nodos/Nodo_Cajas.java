
package Codigo.nodos;

import java.io.Serializable;

/**
 *
 * @author JOSE ANDRES
 */
public class Nodo_Cajas implements Serializable  {
      
    
    //atributos de la clase
    private Nodo_Cajas Siguiente, Anterior;
    private String Tipo, Descripcion, Fecha;
    private int Cantidad, Codigo, Stop;
    private float Precio, Precio_U, Precio_V, Ganancia;
    private boolean Pro;

    //constructor de la clase
    public Nodo_Cajas() {
        this.Siguiente = null;
        this.Anterior = null;
        this.Tipo = "";
        this.Descripcion = "";
        this.Fecha = "";
        this.Cantidad = 0;
        this.Precio = 0;
        this.Precio_U = 0;
        this.Precio_V = 0;
        this.Ganancia = 0;
        this.Codigo = 0;
        this.Pro = Pro;
        this.Stop = 0;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Nodo_Cajas getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo_Cajas Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo_Cajas getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo_Cajas Anterior) {
        this.Anterior = Anterior;
    }

    public float getGanancia() {
        return Ganancia;
    }

    public void setGanancia(float Ganancia) {
        this.Ganancia = Ganancia;
    }
    

    public String getTipo() {
        return Tipo;
    }

    public float getPrecio_V() {
        return Precio_V;
    }

    public void setPrecio_V(float Precio_V) {
        this.Precio_V = Precio_V;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    } 

    public boolean isPro() {
        return Pro;
    }

    public void setPro(boolean Pro) {
        this.Pro = Pro;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getStop() {
        return Stop;
    }

    public void setStop(int Stop) {
        this.Stop = Stop;
    }

    public float getPrecio_U() {
        return Precio_U;
    }

    public void setPrecio_U(float Precio_U) {
        this.Precio_U = Precio_U;
    }
    
    
 //metodo para calcular precio de venta 
    //teniendo en cuenta  que se le suma el valor de 30% sobre el precio de la compra
    public float Precio_V(){
         float precio=0; 
        float Pre =0;
         Pre = (float) (Precio * 0.5);//50% De la compra
         
         precio = Precio + Pre;//la compra mas 50%
         setPrecio_V(precio);
         return 0;
         
    }
    
    //metodo para calcular la ganancia de una caja
    public float Ganancia(){
       float g=0;
       g = (float) (getPrecio_V() - Precio);
        setGanancia(g);
       return 0;
    }
    
   //metodo para calcular la ganancia variable con distintos precios de ventas
    //al descontar cualquier cantidad 
    public float Ganancia_V(){
    float gana=0;
    float ga=0;
    
       gana = getGanancia() / getCantidad();//ganancia fija de un caja
       ga = gana * getStop();//ganancia variable dependiendo del Stop (cantidad restante en bodega de una caja
       
       return ga;
    }
   
    //metodo para calcular la ganancia con precio de venta nuevo
    
    //metodo para calcular el precio unitario por cajas a la venta
    public float Precio_u(){
          float p_u = 0;          
          p_u = getPrecio_V() / getStop();
        setPrecio_U(p_u);
        return 0;
    }

    //metodo para descontar al precio de venta luego de descontar algun o algunos  producto de la caja
    public float Precio_Vent_N(int cant){
          float precio = 0;
          float pre = 0;
          precio = getPrecio_U() * cant;//precio total vendido
          pre = getPrecio_V() - precio;//el precio de venta menos l precio tortsal vendido
          setPrecio_V(pre);//precio nuevo obtenido
          return 0;
    }
}
