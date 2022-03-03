
package Codigo.listas;

import Codigo.conexion.Tb_Entrega;
import Codigo.nodos.Nodo_Entrega;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE ANDRES
 */
public class Lista_Entrega implements Serializable{
      //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
    
      private Nodo_Entrega Cabeza;

    public Lista_Entrega() {
        this.Cabeza = null;
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
    }

    public Nodo_Entrega getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo_Entrega cabeza) {
        this.Cabeza = cabeza;
    }
   
    //Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo_Entrega ultimo(){
    Nodo_Entrega aux = Cabeza;
   if(aux != null){
       while(aux.getSiguiente() != null){
           aux = aux.getSiguiente();
         }
   }
 return aux;
 }
 
 //metodo para comprobar codigo
 public boolean Comprobar(int c){
    Nodo_Entrega aux = Cabeza;
    boolean x = true;
       while(aux != null){
           if(aux.getCodigo() == c){
              x = false;
                JOptionPane.showMessageDialog(null, "Codigo ya existe", "ALERTA!", JOptionPane.WARNING_MESSAGE);
            break;    
           }
           aux = aux.getSiguiente();
         }
 return x;
 }

 //Método para agregar un nuevo nodo en la lista
 public void agregar(Nodo_Entrega nuevo){
        Nodo_Entrega aux = ultimo();
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
      Nodo_Entrega aux = Cabeza;
    while(aux != null){
         cantidad++;
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
 //metodo para contar las cantidades todal de precios de compra 
 public double Precio_C(){
 double cantidad = 0;
      Nodo_Entrega aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.getPrecio();
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
 //Método que recorre la lista para contar cuantos nodos hay almacenados segun el tipo
 public int C_Ederfactor(){
 int cantidad = 0;
      Nodo_Entrega aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals("Ederfactor")){
         cantidad++;
       }
        aux = aux.getSiguiente();
    }
   return cantidad;
 }
 
 public int C_Flesamin(){
 int cantidad = 0;
      Nodo_Entrega aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals("Flesamin")){
         cantidad++;
        }
        aux = aux.getSiguiente();
    }
   return cantidad;
 }
 //..., , , , Aloe Vera, Mero Macho, Calced, Drepal, Prostex, Macca, Vit Bin, Delisure
 public int C_Colaginol(){
 int cantidad = 0;
      Nodo_Entrega aux = Cabeza;
    while(aux != null){
        if(aux.getTipo().equals("Colaginol")){
         cantidad++;
      } 
        aux = aux.getSiguiente();
    }
   return cantidad;
 }
 //--------------------------------------------------------------------------------------------------------------------------------------------

    //Este método devuelve el nodo que se encuentra antes (anterior) de un nodo pasado como
//parámetro. En este caso devuelve el nodo que esta antes del nodo a eliminar.
    public Nodo_Entrega Anterior(Nodo_Entrega nd) {
        Nodo_Entrega temp = Cabeza;
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
      public Nodo_Entrega Buscar_No(int x){
      Nodo_Entrega aux = Cabeza;
    while(aux != null){
        if(aux.getCodigo() == x){
            return aux;
      } 
        aux = aux.getSiguiente();
    }
   return null;
 }
  
  
    //Método que eliminar un nodo de la lista enlazada doble.
    public void eliminar(Nodo_Entrega nd) {
        Nodo_Entrega ante;
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
    
     
 //metodo que permite buscar un Nodo por el paremetro del Nombre(Especifico) si lo encuentra vuelve el nodo encontrado
 public Nodo_Entrega buscar_Espec(int cod){
     boolean n = false;
     Nodo_Entrega aux = Cabeza;
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

    //metodo para agregar a la Tabla de Cajas
      public javax.swing.table.DefaultTableModel Agre_Prod(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Entrega aux = Cabeza;
 
         lista.addColumn("Codigo tiquete");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Vendedor");
        lista.addColumn("Cantidad");
        lista.addColumn("Precio");
          
          while(aux != null){
              lista.addRow(new Object []{
                  aux.getCodigo(),aux.getTipo(),aux.getDescripcion(),aux.getVendedor(),aux.getStop()
                      ,formateador.format(aux.getPrecio())});
              
              aux = aux.getSiguiente();
          }
          return lista;
        
    }   
      
   //metodo para listar las promocione
       public javax.swing.table.DefaultTableModel Lista_Pro(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Entrega aux = Cabeza;
 
        lista.addColumn("Codigo tiquete");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Vendedor");
        lista.addColumn("Precio");
        lista.addColumn("Prom");
          
          while(aux != null){
               if(aux.isPro()){
                   lista.addRow(new Object []{
                  aux.getCodigo(),aux.getTipo(),aux.getDescripcion(),aux.getVendedor(),formateador.format(aux.getPrecio()),aux.isPro()
              });
               }
              aux = aux.getSiguiente();
          }
          return lista;
        
    } 
            
  //mmetodo para agregar una promocion del 10% a algun Tipo de bebidas
      public boolean Agre_Prom(String x){
          Tb_Entrega tem = new  Tb_Entrega();
          Nodo_Entrega aux = Cabeza;
            boolean f = false;
          while(aux != null){
               if(aux.getTipo().equals(x)){
                   if(!aux.isPro()){  
                   float p;
                    p = (float) (aux.getPrecio() * 0.9);//se saca el 90% pertenenciente al precio 
                   aux.setPrecio(p);
                   aux.setPro(true);
                   tem.AgreProm(aux);//actualizo en la bbase de datos la promocion y precios 
                   f = true;
                   }
               }
               aux = aux.getSiguiente();
          }
          
  return f;
          
      }

 //metodo para modifacar el tipo
 public void modi_T(int c, String t){
       Nodo_Entrega aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigo() == c){
             
               aux.setTipo(t);              
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

//modificar cantidad 
public void modi_Vend(int c, String cli){
       Nodo_Entrega aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigo() == c){
               aux.setVendedor(cli);
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


//metodo para modificar descriccion
public void modi_Desc(int c, String p){
       Nodo_Entrega aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigo() == c){
               aux.setDescripcion(p);                          
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
       Nodo_Entrega aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigo() == c){
               
               aux.setPrecio(p); 
               aux.isPro();
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
       Nodo_Entrega aux = Cabeza;    
       while(aux != null){
           if(aux.getStop() <= 0){
               eliminar(aux);
           }
           
           aux = aux.getSiguiente();
       }
}

public ArrayList NombreEmpEntr(){
    ArrayList NombreEmpl = new ArrayList();//vector para guardar tipos de productos
    Nodo_Entrega aux = Cabeza; 
    while(aux != null){
        NombreEmpl.add(aux.getCodigo());
         aux = aux.getSiguiente();
    }
        return NombreEmpl;
 }     
}

