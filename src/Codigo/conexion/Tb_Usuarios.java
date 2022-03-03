/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.conexion;

import Codigo.listas.Lista_Usuario;
import Codigo.nodos.Nodo_Usuario;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTES
 */
public class Tb_Usuarios extends Conexion{
    
    public boolean Insertar(Nodo_Usuario obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
  
      String sql = "INSERT INTO Tb_Usuarios (idUsuarios, Nombre, Password, Tipo_U) VALUES(?,?,?,?)";
      
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getId());
           ps.setString(2, obj.getNombre());
           ps.setString(3, obj.getClave());
           ps.setBoolean(4, obj.isTipo_U());
 
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Usuario Registrado en la bd","Genial",JOptionPane.INFORMATION_MESSAGE);
 
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
    
   public boolean Eliminar(Nodo_Usuario obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "DELETE FROM Tb_Usuarios WHERE idUsuarios=?";
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getId());
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
 public String CargarLista(Lista_Usuario obj){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Usuarios";
      
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                Nodo_Usuario nuevo =  new Nodo_Usuario();  
                nuevo.setId(rs.getInt(1));
                nuevo.setNombre(rs.getString(2));
                nuevo.setClave(rs.getString(3));
                nuevo.setTipo_U(rs.getBoolean(4));
   
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
 
 public boolean Modificar(Nodo_Usuario obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;

      String sql = "UPDATE tb_usuarios SET Password="+obj.getClave()+" WHERE idUsuarios="+obj.getId();
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
    
}
