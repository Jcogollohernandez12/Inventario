/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.conexion;

import Codigo.listas.Lista_Compras;
import Codigo.nodos.Nodo_Compra;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTES
 */
public class Tb_Compras extends Conexion {
    
     public boolean Insertar(Nodo_Compra obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
  
      //					

      String sql = "INSERT INTO Tb_Compras (NombreEmpl, NombreClien, Codigo_E, IDclie1, Codigo_en1) VALUES(?,?,?,?,?)";
      
      try{
           ps = con.prepareStatement(sql);
           ps.setString(1, obj.getNombreE());
           ps.setString(2, obj.getNombreC());          
           ps.setInt(3, obj.getCodigoEmpl());
           ps.setInt(4, obj.getCodigoClien());
           ps.setInt(5, obj.getCodigoEntr());
           
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Compra Registrada en la bd","Genial",JOptionPane.INFORMATION_MESSAGE);

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
     
public boolean Eliminar(Nodo_Compra obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "DELETE FROM Tb_Compras WHERE IDventas=?";
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
 public String CargarLista(Lista_Compras obj){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Compras";
      
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                Nodo_Compra nuevo =  new Nodo_Compra();  
                
                nuevo.setCodigo(rs.getInt(1));
                nuevo.setNombreE(rs.getString(2));
                nuevo.setNombreC(rs.getString(3));
                nuevo.setCodigoEmpl(rs.getInt(4));
                nuevo.setCodigoClien(rs.getInt(5));
                nuevo.setCodigoEntr(rs.getInt(6));
                
              obj.agregar_V(nuevo);
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
     
}
