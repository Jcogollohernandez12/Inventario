/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.listas;

import Codigo.nodos.Nodo_Compra;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author JOSE ANDRES
 */
public class Lista_Compras {
    //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
    
     private Nodo_Compra Cabeza;
    
    public Lista_Compras(){
      this.Cabeza = null;
      simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
    }

    public Nodo_Compra getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo_Compra Cabeza) {
        this.Cabeza = Cabeza;
    }
    
     //Método que recorre la lista para contar cuantos nodos hay almacenados.
 public int contarNodos(){
 int cantidad = 0;
      Nodo_Compra aux = Cabeza;
    while(aux != null){
         cantidad++;
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
    //Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo_Compra ultimo(){
    Nodo_Compra aux = Cabeza;
   if(aux != null){
       while(aux.getSiguiente() != null){
           aux = aux.getSiguiente();
         }
   }
 return aux;
 }
 
  //Método para agregar un nuevo nodo en la lista
 public void agregar_V(Nodo_Compra nuevo){
        Nodo_Compra aux = ultimo();
         if(aux != null){ 
             aux.setSiguiente(nuevo);
                 nuevo.setAnterior(aux);
               nuevo.setSiguiente(null);
         } else{
            nuevo.setAnterior(null);
            Cabeza = nuevo;
           }
      }

 //metodo para contar las cantidades de de ventas y el prwcio
 public float TPrecio_V(){
 float cantidad = 0;
      Nodo_Compra aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.getPrecio();
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 

//metodo para agregar a la Tabla de Cajas vendidas
      public javax.swing.table.DefaultTableModel Agre_Caja(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Compra aux = Cabeza;
 
         lista.addColumn("Vendedor");
        lista.addColumn("Cliente");
        lista.addColumn("Precio");
          
          while(aux != null){
              lista.addRow(new Object []{
                  aux.getNombreE(),aux.getNombreC(),formateador.format(aux.getPrecio())
              });
              
              aux = aux.getSiguiente();
          }
          return lista;
        
    }   
      
//------------------------------------------------------------------------------------------------------------------------------------------------

  //Este método devuelve el nodo que se encuentra antes (anterior) de un nodo pasado como
//parámetro. En este caso devuelve el nodo que esta antes del nodo a eliminar.
    public Nodo_Compra Anterior(Nodo_Compra nd) {
        Nodo_Compra temp = Cabeza;
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
    public void Eliminar(Nodo_Compra nd) {
        Nodo_Compra ante;
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
