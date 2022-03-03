/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.conexion;

import Codigo.listas.Lista_Entrega;
import Codigo.nodos.Nodo_Entrega;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author ESTUDIANTES
 */
public class Tb_Entrega extends Conexion{
    
    
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
     
     
     
     
     
      public boolean Insertar(Nodo_Entrega obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      
      String sql = "INSERT INTO Tb_Entrega (Vendedor, TipoP, Descr, Stop, Codigo, Precio, Promo, FechaR, Codigo_C, Codigo_emp) VALUES(?,?,?,?,?,?,?,?,?,?)";

      try{
           ps = con.prepareStatement(sql);
           ps.setString(1, obj.getVendedor());
           ps.setString(2, obj.getTipo());
           ps.setString(3, obj.getDescripcion());
           ps.setInt(4, obj.getStop());
           ps.setInt(5, obj.getCodigo());
           ps.setFloat(6, obj.getPrecio());
           ps.setBoolean(7, obj.isPro());
           ps.setString(8, obj.getFecha());
           ps.setInt(9, obj.getCodigo_C());
           ps.setInt(10, obj.getCodigo_V());
           
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
    
     public boolean AgreProm(Nodo_Entrega obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "UPDATE Tb_Entrega SET Precio="+obj.getPrecio()+", Promo="+obj.isPro()+" WHERE Codigo="+obj.getCodigo();
      
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
     
      public String CargarLista(Lista_Entrega obj){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Entrega";
      
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Nodo_Entrega nuevo =  new Nodo_Entrega(); 
                
                nuevo.setVendedor(rs.getString(1));
                nuevo.setTipo(rs.getString(2));                
                nuevo.setDescripcion(rs.getString(3));
                nuevo.setStop(rs.getInt(4));
                nuevo.setCodigo(rs.getInt(5));
                nuevo.setPrecio(rs.getFloat(6));
                nuevo.setPro(rs.getBoolean(7));
                nuevo.setFecha(rs.getString(8));
                nuevo.setCodigo_C(rs.getInt(9));
                nuevo.setCodigo_V(rs.getInt(10));

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
    
      
     public boolean ModoCnt(Nodo_Entrega obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "UPDATE Tb_Entrega SET Stop="+obj.getStop()+" WHERE Codigo="+obj.getCodigo();
      
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
