
package Codigo.conexion;

import Codigo.listas.Lista_Cajas;
import Codigo.nodos.Nodo_Cajas;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ESTUDIANTES
 */
public class Tb_bodega extends Conexion{
    
  DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
        
  public String Consultas_B(Nodo_Cajas obj, JTable tabla){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Bodega";
         javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
        
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
        lista.addColumn("Codigo");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Cant en Bodega");
        lista.addColumn("Precio Compra");
        lista.addColumn("Precio Uni");
        lista.addColumn("Precio Venta");  
        
            
            while(rs.next()){
             lista.addRow(new Object []{
                  obj.getCodigo(),obj.getTipo(),obj.getDescripcion(),obj.getStop()+"/"+
                  obj.getCantidad(),formateador.format(obj.getPrecio())+" $"
                      ,formateador.format(obj.getPrecio_V())+" $",formateador.format(obj.getPrecio_U())+" $"
                      ,formateador.format(obj.getPrecio_V())});
            }
            
            tabla.setModel(lista);
        
        }catch(SQLException ex){
               
        }
        return null;
  }
  

  public boolean Insertar(Nodo_Cajas obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      
      String sql = "INSERT INTO Tb_Bodega (Codigo_p, Tipo_p, Descri, FechaR2, Cant, Stop, Precio, PUni, PVent, UtilInicial, UtilBodega) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
      
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getCodigo());
           ps.setString(2, obj.getTipo());
           ps.setString(3, obj.getDescripcion());
           ps.setString(4, obj.getFecha());
           ps.setInt(5, obj.getCantidad());
           ps.setInt(6, obj.getStop());
           ps.setFloat(7, obj.getPrecio());
           ps.setFloat(8, obj.getPrecio_U());
           ps.setFloat(9, obj.getPrecio_V());
           ps.setFloat(10, obj.getGanancia());
           ps.setFloat(11, obj.Ganancia_V());
           
           ps.execute();
           
           JOptionPane.showMessageDialog(null, "Caja Registrada en la bd","Genial",JOptionPane.INFORMATION_MESSAGE);
           
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
  

public boolean Modificar(Nodo_Cajas obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "UPDATE Tb_Bodega SET Codigo_p="+obj.getCodigo()+", Tipo_p="+obj.getTipo()+", Descri="+obj.getDescripcion()+
              ", Cant="+obj.getCantidad()+", Stop="+obj.getStop()+", Precio="+obj.getPrecio()+", PUni="+obj.getPrecio_U()+
              ", PVent="+obj.getPrecio_V()+", UtilInicial="+obj.getGanancia()+", UtilBodega="+obj.Ganancia_V()+" WHERE Codigo_p="+obj.getCodigo();
      
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
  

public boolean Eliminar(Nodo_Cajas obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "DELETE FROM Tb_Bodega WHERE Codigo_p=?";
      
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

public boolean Buscar(Nodo_Cajas obj, JTable tabla){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "SELECT * FROM Tb_Bodega WHERE Codigo_p=?";
          javax.swing.table.DefaultTableModel lista;
          lista = new javax.swing.table.DefaultTableModel();
          
      try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, obj.getCodigo());
           rs = ps.executeQuery();
             lista.addColumn("Codigo");
        lista.addColumn("Tipo De Producto");
        lista.addColumn("Descripcion");
        lista.addColumn("Cant en Bodega");
        lista.addColumn("Precio Compra");
        lista.addColumn("Precio Uni");
        lista.addColumn("Precio Venta");

           while(rs.next()){
              lista.addRow(new Object []{
                  obj.getCodigo(),obj.getTipo(),obj.getDescripcion(),obj.getStop()+"/"+
                  obj.getCantidad(),formateador.format(obj.getPrecio())+" $"
                      ,formateador.format(obj.getPrecio_V())+" $",formateador.format(obj.getPrecio_U())+" $"
                      ,formateador.format(obj.getPrecio_V())});
           }
           tabla.setModel(lista);
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

 public String CargarLista(Lista_Cajas obj){
        
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM Tb_Bodega";
      
        try{
           PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                Nodo_Cajas nuevo =  new Nodo_Cajas();  
                nuevo.setCodigo(rs.getInt(1));
                nuevo.setTipo(rs.getString(2));
                nuevo.setDescripcion(rs.getString(3));
                nuevo.setFecha(rs.getString(4));
                nuevo.setCantidad(rs.getInt(5));
                nuevo.setStop(rs.getInt(6));
                nuevo.setPrecio(rs.getFloat(7));
                nuevo.setPrecio_U(rs.getFloat(8));
                nuevo.setPrecio_V(rs.getFloat(9));
                nuevo.setGanancia(rs.getFloat(10));
              
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
 
  public boolean ModoCnt(Nodo_Cajas obj){
       
      java.sql.Connection con = getConexion();
      PreparedStatement ps = null;
      String sql = "UPDATE Tb_Bodega SET Cant="+obj.getCantidad()+", Stop="+obj.getStop() +", Precio="+obj.getPrecio()+", PUni="+obj.getPrecio_U()+
              ", PVent="+obj.getPrecio_V()+", UtilInicial="+obj.getGanancia()+", UtilBodega="+obj.Ganancia_V()+" WHERE Codigo_p="+obj.getCodigo();
      
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
