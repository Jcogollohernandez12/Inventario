
package Codigo.conexion;

import Codigo.listas.Lista_Empleados;
import Codigo.nodos.Nodo_Empleados;
import Codigo.nodos.Nodo_Usuario;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTES
 */
public class Tb_Empledos extends Conexion {
    
      DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
     
    //metodo para consultar todos los empleados en la base de datos  
      public ResultSet Consultas_Empl(){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Empl";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
   
        }catch(SQLException ex){
               
        }
        return rs;
  }
  
//metodo para insertar un empleado a la base de datos 
  public boolean Insertar(Nodo_Empleados obj, Nodo_Usuario obj2){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      
      String sql = "INSERT INTO Tb_Empl (Codigo, CantVent, Correo, Tel, Nombre, Ident, Cargo, SuelB, FechaR3, idUsuario) VALUES(?,?,?,?,?,?,?,?,?,?)";
      
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getCodigo());
           ps.setInt(2, obj.getCant_venta());
           ps.setString(3, obj.getCorreo());          
           ps.setString(4, obj.getCel());
           ps.setString(5, obj.getNombre());
           ps.setInt(6, obj.getId());
           ps.setString(7, obj.getCargo());
           ps.setDouble(8, obj.N_Pagar());
           ps.setString(9, obj.getFecha());
           ps.setInt(10, obj2.getId());
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Empleado Registrada en la bd","Genial",JOptionPane.INFORMATION_MESSAGE);
           
           /*Object[] Fila = new Object[9];
           Fila[0] = obj.getTipo();
           Fila[1] = obj.getDescripcion();
           Fila[2] = obj.getCantidad();
           Fila[3] = obj.getCodigo();
           Fila[4] = obj.getStop();
           Fila[5] = obj.getPrecio();
           Fila[6] = obj.getPrecio_U();
           Fila[7] = obj.getPrecio_V();
           Fila[8] = obj.isPro();*/
           return true;
      }catch(HeadlessException | SQLException e){
          System.err.println(e);
       return false;
      } finally {
           try{
             con.close();
           }catch(SQLException ex){
             System.err.println(ex);
           }
      
      }
    
  }
  
  //metodo para modificar un empleado en la base de datos 
  public boolean Modificar(Nodo_Empleados obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "UPDATE Tb_Empl SET CantVent="+obj.getCant_venta()+
              ", Correo="+obj.getCorreo()+", Tel="+obj.getCel()+", Nombre="+obj.getNombre()+", Ident="+obj.getId()+", Cargo="+obj.getCargo()+
              ", Clave="+obj.getClave()+", SuelB="+obj.N_Pagar()+ "WHERE Codigo="+obj.getCodigo();
      try{
           ps = con.prepareStatement(sql);        
           ps.executeUpdate();
           return true;
      }catch(SQLException e){
          System.err.println(e);
       return false;
      } finally {
           try{
             con.close();
           }catch(SQLException ex){
             System.err.println(ex);
           }
      
      }
    
  }
 //metodo para agregar una venta a un empleado en la base de datos 
public boolean AgregarCant(Nodo_Empleados obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      
      String sql = "UPDATE Tb_Empl SET CantVent="+obj.getCant_venta()+", SuelB="+obj.N_Pagar()+" WHERE Codigo="+obj.getCodigo();
      
      try{
           ps = con.prepareStatement(sql);          
           ps.executeUpdate();
           return true;
      }catch(SQLException e){
          System.err.println(e);
       return false;
      } finally {
           try{
             con.close();
           }catch(SQLException ex){
             System.err.println(ex);
           }
      
      }
    
  }    

 //metodo para eliminar un empleado en la base de datos 
public boolean Eliminar(Nodo_Empleados obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "DELETE FROM Tb_Empl WHERE Codigo=?";
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getCodigo());
           ps.execute();
           return true;
      }catch(SQLException e){
          System.err.println(e);
       return false;
      } finally {
           try{
             con.close();
           }catch(SQLException ex){
             System.err.println(ex);
           }
      }
    
  }

 //metodo para lenar las listas enlazada de los empleados 
 public String CargarLista(Lista_Empleados obj){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Empl";
      
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                Nodo_Empleados nuevo =  new Nodo_Empleados();  
                nuevo.setCodigo(rs.getInt(1));
                nuevo.setCant_venta(rs.getInt(2));
                nuevo.setCorreo(rs.getString(3));
                nuevo.setCel(rs.getString(4));
                nuevo.setNombre(rs.getString(5));
                nuevo.setId(rs.getInt(6));
                nuevo.setCargo(rs.getString(7));
                nuevo.setSueldo_base(rs.getFloat(8));
                nuevo.setFecha(rs.getString(9));
                nuevo.setIdU(rs.getInt(10));
              
              obj.agregar(nuevo);
            }
        
        }catch(SQLException ex){
               
        } finally {
           try{
             con.close();
           }catch(SQLException ex){
             System.err.println(ex);
           }
      
      }
    
        return null;
  }

 
 //metodo para consultar todos los empleados en la base de datos  
      public ResultSet Cons_Email(){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT Correo, Nombre FROM Tb_Empl";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
   
        }catch(SQLException ex){
               
        }
        return rs;
  }
 
  //metodo para consultar todos los empleados en la base de datos  
      public String Cons_Nombre(){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT Nombre FROM Tb_Empl";
        String men = "";
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
             
             while(rs.next()){
              men = men + rs.getString("Nombre")+"\n";
             
             }
   
        }catch(SQLException ex){
               
        }
        return men;
  }
      
}
