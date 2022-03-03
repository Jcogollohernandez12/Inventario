
package Codigo.listas;
import Codigo.nodos.Nodo_Cajas;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE ANDRES
 */
public class Lista_Cajas implements Serializable {
    //formato de numeros
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);

    //atributos
    private Nodo_Cajas Cabeza;
    
    public Lista_Cajas(){
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
 
 //metodo para comprobar codigo
 public boolean Comprobar(int c){
    Nodo_Cajas aux = Cabeza;
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

 //metodo que permite buscar un Nodo por el paremetro del Nombre(Especifico) si lo encuentra vuelve el nodo encontrado
 public Nodo_Cajas buscar_Espec(int cod){
     boolean n = false;
     Nodo_Cajas aux = Cabeza;
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
 
 //Método para agregar un nuevo nodo en la lista
 public void agregar(Nodo_Cajas nuevo){
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
 
 //metodo para contar las cantidades todal de precios de compra 
 public double Precio_C(){
 double cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.getPrecio();
       aux = aux.getSiguiente();
    }
   return cantidad;
 }
 //metodo para contar las cantidades de de ventas
 public double Precio_V(){
 double cantidad = 0;
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
  
   //metodo para contar las cantidades de ganancias Variarebles segun la cantidad de todas las canastas
  public float Precio_G_V(){
 float cantidad = 0;
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
         cantidad = cantidad + aux.Ganancia_V();
       aux = aux.getSiguiente();
    }
   return cantidad;
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
 
 //--------------------------------------------------------------------------------------------------------------------------------------------

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
    
    //metodo que me regresa el nodo encontrado por parametro CODIGO
      public Nodo_Cajas Buscar_No(int x){
      Nodo_Cajas aux = Cabeza;
    while(aux != null){
        if(aux.getCodigo() == x){
            return aux;
      } 
        aux = aux.getSiguiente();
    }
   return null;
 }
  
  
    //Método que eliminar un nodo de la lista enlazada doble.
    public void eliminar(Nodo_Cajas nd) {
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

    //metodo para agregar a la Tabla de Cajas
      public javax.swing.table.DefaultTableModel Agre_Caja(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Cajas aux = Cabeza;
 
         lista.addColumn("Codigo");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Cant en Bodega");
        lista.addColumn("Precio Compra");
        lista.addColumn("Precio Venta");
        lista.addColumn("Precio Uni");
        lista.addColumn("Utilidad Inicial");
        lista.addColumn("Utilidad en Bodega");  

          while(aux != null){
              lista.addRow(new Object []{
                  aux.getCodigo(),aux.getTipo(),aux.getDescripcion(),aux.getStop()+"/"+
                  aux.getCantidad(),formateador.format(aux.getPrecio())+" $"
                      ,formateador.format(aux.getPrecio_V())+" $",formateador.format(aux.getPrecio_U())+" $"
                      ,formateador.format(aux.getGanancia())+" $",formateador.format(aux.Ganancia_V())+" $"  });
              
              aux = aux.getSiguiente();
          }
          return lista;
        
    }   
      
   //metodo para listar las promocione
       public javax.swing.table.DefaultTableModel Lista_Pro(){
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
          Nodo_Cajas aux = Cabeza;
 
        lista.addColumn("Codigo");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Cant en Bodega");
        lista.addColumn("Precio Compra");
        lista.addColumn("Precio Venta");
        lista.addColumn("Precio Uni");
        lista.addColumn("Utilidad Inicial");
        lista.addColumn("Utilidad en Bodega"); 
        lista.addColumn("Prom");
          
          while(aux != null){
               if(aux.isPro()){
                   lista.addRow(new Object []{
                  aux.getCodigo(),aux.getTipo(),aux.getDescripcion(),aux.getStop()+"/"+
                  aux.getCantidad(),formateador.format(aux.getPrecio())+" $"
                      ,formateador.format(aux.getPrecio_V())+" $",formateador.format(aux.getPrecio_U())+" $"
                      ,formateador.format(aux.getGanancia()),formateador.format(aux.Ganancia_V())+" $",aux.isPro()
              });
               }
              aux = aux.getSiguiente();
          }
          return lista;
        
    } 
            
  //mmetodo para agregar una promocion del 10% a algun Tipo de bebidas
      public void Agre_Prom(String x){
          
          Nodo_Cajas aux = Cabeza;
          while(aux != null){
               if(aux.getTipo().equals(x)){
                   if(!aux.isPro()){
                   float p;
                    p = (float) (aux.getPrecio() * 0.9);//se saca el 90% pertenenciente al precio 
                   aux.setPrecio(p);
                   aux.Precio_V();
                   aux.Precio_u();
                   aux.Ganancia();
                   aux.setPro(true);
                   }
               }
               aux = aux.getSiguiente();
          }
          
      }

 //metodo para modifacar el tipo
 public void modi_T(int c, String t){
       Nodo_Cajas aux = Cabeza;    
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
public void modi_Ca(int c, int can){
       Nodo_Cajas aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigo() == c){
       
               aux.setCantidad(can);
               aux.Precio_u();
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
       Nodo_Cajas aux = Cabeza;    
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
       Nodo_Cajas aux = Cabeza;    
       boolean x = false;
       while(aux != null){
           if(aux.getCodigo() == c){
               
               aux.setPrecio(p); 
               aux.isPro();
               aux.Precio_V();
               aux.Precio_u();
               aux.Ganancia();
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
   
  //metodo para Auto eliminar los nodos cajas que queden en Cantidad (0) cero   
public void Eliminar_Cero(){
       Nodo_Cajas aux = Cabeza;    
       while(aux != null){
           if(aux.getStop() <= 0){
               eliminar(aux);
           }
           
           aux = aux.getSiguiente();
       }    
} 

}

