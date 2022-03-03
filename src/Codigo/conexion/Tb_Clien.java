
package Codigo.conexion;

import Codigo.listas.Listas_Clientes;
import Codigo.nodos.Nodo_Clientes;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTES
 */
public class Tb_Clien extends Conexion{
    
     public boolean Insertar(Nodo_Clientes obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
  
      String sql = "INSERT INTO Tb_Clientes (IDclie, Nombre, Direc, Tele, TipoP, FormaP, Cant, Valorini, Deuda, ValoCut, Fecha, Codigo_E1) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
      
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getCodigoClie());
           ps.setString(2, obj.getNom_Cli());
           ps.setString(3, obj.getDireccion());          
           ps.setString(4, obj.getTelefono());
           ps.setString(5, obj.getTipo_P());
           ps.setString(6, obj.getForma_P());
           ps.setInt(7, obj.getCant());
           ps.setDouble(8, obj.getPrecio());
           ps.setDouble(9, obj.getPrecio_Vari());
           ps.setDouble(10, obj.Valor_C());
           ps.setString(11, obj.getFecha());
           ps.setInt(12, obj.getCodigoE());
           
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Cliente Registrada en la bd","Genial",JOptionPane.INFORMATION_MESSAGE);
           
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
     
     public boolean Eliminar(Nodo_Clientes obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "DELETE FROM Tb_Clientes WHERE IDclie=?";
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getCodigoClie());
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
 public String CargarLista(Listas_Clientes obj){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Clientes";
      
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                Nodo_Clientes nuevo =  new Nodo_Clientes();  
                
                nuevo.setCodigoClie(rs.getInt(1));
                nuevo.setNom_Cli(rs.getString(2));
                nuevo.setDireccion(rs.getString(3));
                nuevo.setTelefono(rs.getString(4));
                nuevo.setTipo_P(rs.getString(5));
                nuevo.setForma_P(rs.getString(6));
                nuevo.setCant(rs.getInt(7));
                nuevo.setPrecio(rs.getFloat(8));
                nuevo.setPrecio_Vari(rs.getFloat(9));
                nuevo.Valor_C();
                nuevo.setFecha(rs.getString(11));
                nuevo.setCodigoE(rs.getInt(12));
   
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
 
  public boolean ModiDeuda(Nodo_Clientes obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "UPDATE tb_clientes SET Deuda="+obj.getPrecio_Vari()+" WHERE IDclie="+obj.getCodigoClie();
      
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
