/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.listas;

import Codigo.Seguridad;
import Codigo.conexion.Tb_Usuarios;

import Codigo.nodos.Nodo_Usuario;

/**
 *
 * @author ESTUDIANTES
 */
public class Lista_Usuario {
    private Nodo_Usuario Cabeza;

    public Lista_Usuario() {
        this.Cabeza = null;
    }

    public Nodo_Usuario getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo_Usuario Cabeza) {
        this.Cabeza = Cabeza;
    }
    
     //Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo_Usuario ultimo(){
    Nodo_Usuario aux = Cabeza;
   if(aux != null){
       while(aux.getSiguiente() != null){
           aux = aux.getSiguiente();
         }
   }
 return aux;
 }
  //Método que recorre la lista para contar cuantos nodos hay almacenados.
 public int contarNodos(){
 int cantidad = 0;
      Nodo_Usuario aux = Cabeza;
    while(aux != null){
         cantidad++;
       aux = aux.getSiguiente();
    }
   return cantidad;
 }

  //Método para agregar un nuevo nodo en la lista
 public void agregar(Nodo_Usuario nuevo){
        Nodo_Usuario aux = ultimo();
         if(aux != null){ 
             aux.setSiguiente(nuevo);
                 nuevo.setAnterior(aux);
               nuevo.setSiguiente(null);
         } else{
            nuevo.setAnterior(null);
            Cabeza = nuevo;
           }
      }
 
   //Este método devuelve el nodo que se encuentra antes (anterior) de un nodo pasado como
//parámetro. En este caso devuelve el nodo que esta antes del nodo a eliminar.
    public Nodo_Usuario Anterior(Nodo_Usuario nd) {
        Nodo_Usuario temp = Cabeza;
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
    public void eliminar(Nodo_Usuario nd) {
        Nodo_Usuario ante;
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
    
   //metodo para modificar la clave de el empleado pasado como parametro el nombre y la nueva clave
      public Nodo_Usuario CambioClv(String clv, int id){
          Nodo_Usuario aux = Cabeza;
          Tb_Usuarios tem = new Tb_Usuarios();
          while(aux != null){
               if(aux.getId() == id){
                  
                 String nuevaPass = Seguridad.sha1(clv);
                 aux.setClave(clv);
                 tem.Modificar(aux);//modifica en la base de datos
                   System.out.println("Cambio clave con exito");
                 return aux;
               } 
               aux = aux.getSiguiente();
          }
          return null;
      } 
      
       //metodo para modificar la clave de el empleado pasado como parametro el nombre y la nueva clave
      public Nodo_Usuario CambioClvAdm(String clvnueva, String Clv){
          Nodo_Usuario aux = Cabeza;
          while(aux != null){
               if(aux.getClave().equals(Clv)){ 
                 String nuevaPass = Seguridad.sha1(clvnueva);
                 aux.setClave(clvnueva);
                 //JOptionPane.showMessageDialog(null, "Cambio con exito", "Genial!!", JOptionPane.INFORMATION_MESSAGE);
                 return aux;
               } 
               aux = aux.getSiguiente();
          }
          return null;
      } 
      
    //metodo para buscar un empleado por dos parametros pasado Nombre, id
      public boolean Encontrado(String nom, String clv ){
             boolean x;
             Nodo_Usuario aux = Cabeza;            
             while(aux != null){
                   if(aux.getNombre().equalsIgnoreCase(nom) && aux.getClave().equalsIgnoreCase(clv)){
                       if(!aux.isTipo_U()){
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
             Nodo_Usuario aux = Cabeza;            
             while(aux != null){
                   if(aux.getNombre().equalsIgnoreCase(nom) && aux.getClave().equalsIgnoreCase(clv)){
                       if(aux.isTipo_U()){
                       x = true;
                       return x;
                       }
                   }
                   aux = aux.getSiguiente();
             }
        return false;
      }    
       //metodo para buscar un empleado por dos parametros pasado Nombre
      public Nodo_Usuario BuscaEmpleado(String nom){
             Nodo_Usuario aux = Cabeza;            
             while(aux != null){
                   if(aux.getNombre().equalsIgnoreCase(nom)){
                       return aux;
                   }
                   aux = aux.getSiguiente();
             }
        return null;
      }
      
      
      //metodo para buscar un empleado por dos parametros pasado Nombre
      public boolean BuscaEmp(String nom){
             Nodo_Usuario aux = Cabeza;    
             boolean x = false;
             while(aux != null){
                   if(aux.getNombre().equalsIgnoreCase(nom)){
                        if(aux.getClave().equals("0000")){
                       x = true;
                       return x;
                        }
                   }
                   aux = aux.getSiguiente();
             }
        return x;
      }
      
       //metodo para buscar un empleado por dos parametros pasado Nombre
      public boolean Verificar(int id){
             boolean x = false;
             Nodo_Usuario aux = Cabeza;            
             while(aux != null){
                   if(aux.getId() != id){
                       x = true;
                       return x;
                   }
                   aux = aux.getSiguiente();
             }
        return x;
      }
      
      
}
