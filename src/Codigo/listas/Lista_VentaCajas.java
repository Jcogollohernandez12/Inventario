
package Codigo.listas;

import Codigo.nodos.Nodo_Cajas;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
/**
 *
 * @author JOSE ANDRES
 */
public class Lista_VentaCajas implements Serializable{
      //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
    
     private Nodo_Cajas Cabeza;
    
    public Lista_VentaCajas(){
      this.Cabeza = null;
      simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
    }

    public Nodo_Cajas getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo_Cajas Cabeza) {
        this.Cabeza = Cabeza;
    }
    
     //Método que recorre la lista para contar cuantos nodos hay almacenados.
 public int contarNodos(){
 int cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
         cantidad++;
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
    //Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo_Cajas ultimo(){
    Nodo_Cajas aux = Cabeza;
   if(aux != null){
       while(aux.getSiguiente() != null){
           aux = aux.getSiguiente();
         }
   }
 return aux;
 }
 
  //Método para agregar un nuevo nodo en la lista
 public void agregar_V(Nodo_Cajas nuevo){
        Nodo_Cajas aux = ultimo();
         if(aux != null){ 
             aux.setSiguiente(nuevo);
                 nuevo.setAnterior(aux);
               nuevo.setSiguiente(null);
         } else{
            nuevo.setAnterior(null);
            Cabeza = nuevo;
           }
      }
 
 //Método que recorre la lista para contar cuantos nodos hay almacenados segun el tipo
 public int C_Tipos(String tipo){
 int cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals(tipo)){
         cantidad++;
       }
        aux = aux.getSiguiente();
    }
   return cantidad;
 }

  //metodo para contar las cantidades todal de precios de compra 
 public float Precio_C(){
 float cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
         cantidad = (float) (cantidad + aux.getPrecio());
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 //metodo para contar las cantidades de de ventas
 public float Precio_V(){
 float cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.getPrecio_V();
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
 //metodo para contar las cantidades de ganancias de todas las canastas
  public float Precio_G(){
 float cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.getGanancia();
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
  
  //metodo para contar los precios por tipo de bebida
  public float Ganan_Tip(String x){ 
             float p =0;
               Nodo_Cajas aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals(x)){
         p = p + aux.getGanancia();
        }
       aux = aux.getSiguiente();
    }
    return p;
  }
 
   public float PrecioC_Tip(String x){              
             float p =0;
               Nodo_Cajas aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals(x)){
         p = p + aux.getPrecio();
        }
       aux = aux.getSiguiente();
    }
    return p;
  }
  
  //metodo para contar los Precios de Ventas Por tipo de Bebida
   public float PrecioV_Tip(String x){          
             float p =0;
               Nodo_Cajas aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals(x)){
        p = p + aux.getPrecio_V();
        }
       aux = aux.getSiguiente();
    }
    return p;
  }
  
 
//metodo para agregar a la Tabla de Cajas vendidas
      public javax.swing.table.DefaultTableModel Agre_Caja(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Cajas aux = Cabeza;
 
         lista.addColumn("Codigo");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Cantidad Vendida");
        lista.addColumn("Precio Compra");
        lista.addColumn("Precio Uni");
        lista.addColumn("Utilidad");
          
          while(aux != null){
              lista.addRow(new Object []{
                  aux.getCodigo(),aux.getTipo(),aux.getDescripcion(),
                  aux.getCantidad(),formateador.format(aux.getPrecio())
                      ,formateador.format(aux.getPrecio_U())
                      ,formateador.format(aux.getGanancia())
              });
              
              aux = aux.getSiguiente();
          }
          return lista;
        
    }   
      
//------------------------------------------------------------------------------------------------------------------------------------------------

  //Este método devuelve el nodo que se encuentra antes (anterior) de un nodo pasado como
//parámetro. En este caso devuelve el nodo que esta antes del nodo a eliminar.
    public Nodo_Cajas Anterior(Nodo_Cajas nd) {
        Nodo_Cajas temp = Cabeza;
        while (temp != null) {
            if (temp.getSiguiente() == nd) {
                break;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }
      
      
  //Método que eliminar un nodo de la lista enlazada doble.
    public void Eliminar(Nodo_Cajas nd) {
        Nodo_Cajas ante;
        if (nd == Cabeza) { //En caso de que el nodo a eliminar sea el primer nodo de la lista doble.
            Cabeza = Cabeza.getSiguiente();
            if (Cabeza != null) {
                Cabeza.setAnterior(null);
            }
        } else { //De lo contrario, se busca el nodo anterior al que se quiere eliminar (nd).
            ante = Anterior(nd);
            ante.setSiguiente(nd.getSiguiente());
            if (nd.getSiguiente() != null) {
                nd.getSiguiente().setAnterior(ante);
            }
        }
        nd.setAnterior(null);
        nd.setSiguiente(null);
    }     
      
      
//METODO PARA VACIAR LA LISTA
   public void Limpiar(){
 while(Cabeza != null){
 Eliminar(Cabeza);
 }
 Cabeza = null;
 }
}

