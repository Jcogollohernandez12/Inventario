
package Codigo.listas;

import Codigo.nodos.Nodo_Clientes;
import java.io.Serializable;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
/**
 *
 * @author JOSE ANDRES
 */
public class Listas_Clientes implements Serializable{
    //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
    
    private Nodo_Clientes Cabeza;
    
    public Listas_Clientes() {
        this.Cabeza = null;
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
    }

    public Nodo_Clientes getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo_Clientes cabeza) {
        this.Cabeza = cabeza;
    }

    //Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo_Clientes ultimo(){
    Nodo_Clientes aux = Cabeza;
   if(aux != null){
       while(aux.getSiguiente() != null){
           aux = aux.getSiguiente();
         }
   }
 return aux;
 }
 
 //metodo para comprobar codigo
 public boolean Comprobar(int c){
    Nodo_Clientes aux = Cabeza;
    boolean x = true;
       while(aux != null){
           if(aux.getCodigoClie()== c){
              x = false;
                JOptionPane.showMessageDialog(null, "Codigo ya existe", "ALERTA!", JOptionPane.WARNING_MESSAGE);
            break;    
           }
           aux = aux.getSiguiente();
         }
 return x;
 }

 //Método para agregar un nuevo nodo en la lista
 public void agregar(Nodo_Clientes nuevo){
        Nodo_Clientes aux = ultimo();
         if(aux != null){ 
             aux.setSiguiente(nuevo);
                 nuevo.setAnterior(aux);
               nuevo.setSiguiente(null);
         } else{
            nuevo.setAnterior(null);
            Cabeza = nuevo;
           }
      }
 
 //Método que recorre la lista para contar cuantos nodos hay almacenados.
 public int contarNodos(){
 int cantidad = 0;
      Nodo_Clientes aux = Cabeza;
    while(aux != null){
         cantidad++;
       aux = aux.getSiguiente();
    }
   return cantidad;
 }

 //Método que recorre la lista para contar cuantos nodos hay almacenados segun el tipo
 public int C_Ederfactor(){
 int cantidad = 0;
      Nodo_Clientes aux = Cabeza;
    while(aux != null){
        if(aux.getTipo_P().equals("Ederfactor")){
         cantidad++;
       }
        aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
 public int C_Flesamin(){
 int cantidad = 0;
      Nodo_Clientes aux = Cabeza;
    while(aux != null){
        if(aux.getTipo_P().equals("Flesamin")){
         cantidad++;
        }
        aux = aux.getSiguiente();
    }
   return cantidad;
 }
 //..., , , , Aloe Vera, Mero Macho, Calced, Drepal, Prostex, Macca, Vit Bin, Delisure
 public int C_Colaginol(){
 int cantidad = 0;
      Nodo_Clientes aux = Cabeza;
    while(aux != null){
        if(aux.getTipo_P().equals("Colaginol")){
         cantidad++;
      } 
        aux = aux.getSiguiente();
    }
   return cantidad;
 }
 //--------------------------------------------------------------------------------------------------------------------------------------------

    //Este método devuelve el nodo que se encuentra antes (anterior) de un nodo pasado como
//parámetro. En este caso devuelve el nodo que esta antes del nodo a eliminar.
    public Nodo_Clientes Anterior(Nodo_Clientes nd) {
        Nodo_Clientes temp = Cabeza;
        while (temp != null) {
            if (temp.getSiguiente() == nd) {
                break;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }
    
    //metodo que me regresa el nodo encontrado por parametro CODIGO
      public Nodo_Clientes Buscar_No(int x){
      Nodo_Clientes aux = Cabeza;
    while(aux != null){
        if(aux.getCodigoClie() == x){
            return aux;
      } 
        aux = aux.getSiguiente();
    }
   return null;
 }
  
  
    //Método que eliminar un nodo de la lista enlazada doble.
    public void eliminar(Nodo_Clientes nd) {
        Nodo_Clientes ante;
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

    //metodo para agregar a la Tabla de Cajas
      public javax.swing.table.DefaultTableModel Agre_Prod_v(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Clientes aux = Cabeza;
 
         lista.addColumn("Codigo de Cartulina");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Cliente");
        lista.addColumn("Direccion");
        lista.addColumn("Telefono");
        lista.addColumn("Cantidad");
        lista.addColumn("Precio Inicial");
        lista.addColumn("Valor Cuota");
        lista.addColumn("Deuda");
        
          while(aux != null){
              lista.addRow(new Object []{
                  aux.getCodigoClie(),aux.getTipo_P(),aux.getNom_Cli(),aux.getDireccion()
                      ,aux.getTelefono(),aux.getCant(), formateador.format(aux.getPrecio()),
                      formateador.format(aux.Valor_C()),formateador.format(aux.getPrecio_Vari())});
              
              aux = aux.getSiguiente();
          }
          return lista;
        
    }   

 //metodo para modifacar el tipo
 public void modi_T(int c, String t){
       Nodo_Clientes aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigoClie() == c){
             
               aux.setTipo_P(t);              
               x = true;
               
               JOptionPane.showMessageDialog(null,"Se Modifico Correctamente","Genial",JOptionPane.INFORMATION_MESSAGE);
               break;
           }
           
           aux = aux.getSiguiente();
       }
       if(!x){
        JOptionPane.showMessageDialog(null,"Codigo no Registrado","ALERTA",JOptionPane.WARNING_MESSAGE);
       }
       
 } 

//modificar Vendedor 
public void modi_Clie(int c, String clie){
       Nodo_Clientes aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigoClie() == c){
               aux.setNom_Cli(clie);
               x = true;
               
               JOptionPane.showMessageDialog(null,"Se Modifico Correctamente","Genial",JOptionPane.INFORMATION_MESSAGE);
               break;
           }
           
           aux = aux.getSiguiente();
       }
       if(!x){
        JOptionPane.showMessageDialog(null,"Codigo no Registrado","ALERTA",JOptionPane.WARNING_MESSAGE);
       }
       
 }  

//metodo para modificar el precio de compra 
public void modi_Pre(int c, float p){
       Nodo_Clientes aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigoClie() == c){
               
               aux.setPrecio(p); 
               aux.Valor_C();
               x = true;
               
               JOptionPane.showMessageDialog(null,"Se Modifico Correctamente","Genial",JOptionPane.INFORMATION_MESSAGE);
               break;
           }
           
           aux = aux.getSiguiente();
       }
       if(!x){
        JOptionPane.showMessageDialog(null,"Codigo no Registrado","ALERTA",JOptionPane.WARNING_MESSAGE);
       }
       
 }  
  

//METODO PARA VACIAR LA LISTA
   public void Limpiar(){
 while(Cabeza != null){
 eliminar(Cabeza);
 }
 Cabeza = null;
 }
 
//metodo para Auto eliminar los nodos que queden en cuota (0) cero   
public void Eliminar_Cero(){
       Nodo_Clientes aux = Cabeza;    
       while(aux != null){
           if(aux.getPrecio_Vari() <= 0){
               eliminar(aux);
           }
           
           aux = aux.getSiguiente();
       }
}

 //metodo que permite buscar un Nodo por el paremetro del Nombre(Especifico) si lo encuentra vuelve el nodo encontrado
 public Nodo_Clientes buscar_Espec(int cod){
     boolean n = false;
     Nodo_Clientes aux = Cabeza;
         while(aux != null){

             if(aux.getCodigoClie() == cod){
                 n = true;
                 break;
          }else{
     aux = aux.getSiguiente();
        }

 }
 return aux;
 }
}