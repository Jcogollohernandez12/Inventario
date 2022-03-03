
package Codigo.listas;

import Codigo.nodos.Nodo_Empleados;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE ANDRES
 */
public class Lista_Empleados implements Serializable{
    //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
     
     private Nodo_Empleados Cabeza;

    public Lista_Empleados() {
        this.Cabeza = null;
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
    }

    public Nodo_Empleados getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo_Empleados Cabeza) {
        this.Cabeza = Cabeza;
    }
     
 //Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo_Empleados ultimo(){
    Nodo_Empleados aux = Cabeza;
   if(aux != null){
       while(aux.getSiguiente() != null){
           aux = aux.getSiguiente();
         }
   }
 return aux;
 }

  //Método para agregar un nuevo nodo en la lista
 public void agregar(Nodo_Empleados nuevo){
        Nodo_Empleados aux = ultimo();
         if(aux != null){ 
             aux.setSiguiente(nuevo);
                 nuevo.setAnterior(aux);
               nuevo.setSiguiente(null);
         } else{
            nuevo.setAnterior(null);
            Cabeza = nuevo;
           }
      }

  //metodo para comprobar codigo
 public boolean Comprobar_C(int c){
    Nodo_Empleados aux = Cabeza;
    boolean x = true;
       while(aux != null){
           if(aux.getCodigo()== c){
               x = false;
               JOptionPane.showMessageDialog(null, "Codigo ya existe", "ALERTA!", JOptionPane.WARNING_MESSAGE);
               break;
        }
           aux = aux.getSiguiente();
         }
 return x;
 }
 
   //metodo para comprobar codigo de un empleado para asignar ventas
 public boolean Comprobar_C_E(int c){
    Nodo_Empleados aux = Cabeza;
    boolean x = false;
       while(aux != null){
           if(aux.getCodigo()== c){
               x = true;
               break;
        }
           aux = aux.getSiguiente();
         }
 return x;
 }
 
  //Método que recorre la lista para contar cuantos nodos hay almacenados.
 public int contarNodos(){
 int cantidad = 0;
      Nodo_Empleados aux = Cabeza;
    while(aux != null){
         cantidad++;
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
 //metodo que permite buscar un Nodo por el paremetro del Nombre(Especifico) si lo encuentra vuelve el nodo encontrado
 public Nodo_Empleados buscar_Espec(int cod){
     boolean n = false;
     Nodo_Empleados aux = Cabeza;
         while(aux != null){

             if(aux.getCodigo() == cod){
                 n = true;
                 break;
          }else{
     aux = aux.getSiguiente();
        }

 }
 return aux;
 }
 
    //metodo que me regresa el nodo encontrado por parametro CODIGO
      public Nodo_Empleados Buscar_No(int x){
      Nodo_Empleados aux = Cabeza;
    while(aux != null){
        if(aux.getCodigo() == x){
            return aux;
      } 
        aux = aux.getSiguiente();
    }
   return null;
 }
 
  //metodo para contar las cantidades todal de precios a pagar de los trabajadores 
 public double Precio_Pagar(int c){
 double cantidad = 0;
      Nodo_Empleados aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.N_Pagar();
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
  //Este método devuelve el nodo que se encuentra antes (anterior) de un nodo pasado como
//parámetro. En este caso devuelve el nodo que esta antes del nodo a eliminar.
    public Nodo_Empleados Anterior(Nodo_Empleados nd) {
        Nodo_Empleados temp = Cabeza;
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
    public void eliminar(Nodo_Empleados nd) {
        Nodo_Empleados ante;
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
    
         //metodo para agregar a la Jlist
      public javax.swing.table.DefaultTableModel agre(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Empleados aux = Cabeza;
        lista.addColumn("Codigo");
        lista.addColumn("Identidad");
        lista.addColumn("Nombre");
        lista.addColumn("Correo");
        lista.addColumn("Cant. Ventas");
        lista.addColumn("Telefono cel");
        lista.addColumn("Salario");
        lista.addColumn("Aporte ARL");
          while(aux != null){
  
            lista.addRow(new Object []{
            aux.getCodigo(), aux.getId(), aux.getNombre(), aux.getCorreo(), 
            aux.getCant_venta(), aux.getCel(), formateador.format(aux.N_Pagar()),
            formateador.format(aux.Aporte_ARL())});
             
              aux = aux.getSiguiente();
          }
          return lista;
        
    }
      
   //metodo para buscar un empleado por dos parametros pasado Nombre, id
      public boolean Encontrado(String nom, String clv ){
             boolean x;
             Nodo_Empleados aux = Cabeza;            
             while(aux != null){
                   if(aux.getNombre().equalsIgnoreCase(nom) && aux.getClave().equalsIgnoreCase(clv)){
                       if(aux.getCargo().equalsIgnoreCase("VENDEDOR")){
                       x = true;
                       return x;
                       }
                   }
                   aux = aux.getSiguiente();
             }
        return false;
      }
   //metodo para buscar el empleado administrador por dos parametros pasado Nombre, id
      public boolean EnconAdm(String nom, String clv ){
             boolean x;
             Nodo_Empleados aux = Cabeza;            
             while(aux != null){
                   if(aux.getNombre().equalsIgnoreCase(nom) && aux.getClave().equalsIgnoreCase(clv)){
                       if(aux.getCargo().equalsIgnoreCase("ADMINISTRADOR")){
                       x = true;
                       return x;
                       }
                   }
                   aux = aux.getSiguiente();
             }
        return false;
      }   
  
       //metodo para buscar un empleado por dos parametros pasado Nombre
      public boolean BuscaEmp(String nom){
             boolean x = false;
             Nodo_Empleados aux = Cabeza;            
             while(aux != null){
                   if(aux.getClave().equalsIgnoreCase(nom)){
                       x = true;
                       return x;
                   }
                   aux = aux.getSiguiente();
             }
        return x;
      }
      
 public ArrayList NombreEmp(){
    ArrayList NombreEmpl = new ArrayList();//vector para guardar tipos de productos
    Nodo_Empleados aux = Cabeza; 
    
    while(aux != null){
        NombreEmpl.add(aux.getCodigo());
         aux = aux.getSiguiente();
    }
        return NombreEmpl;
 }     
      
 
 
}
