/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSE ANDRES
 */
public class Conexion {
    
    
        private final String Sdriver = "com.mysql.cj.jdbc.Driver";
        private final String bd = "bdbodega";        
        private final String Surl = "jdbc:mysql://localhost/"+bd+"?useTimezone=true&serverTimezone=UTC";
        private final String Contraseña = "#jose2016A" ;  
        private final String Usuaio = "Jose Andres";
        private Connection con = null;

     public Connection getConexion(){
         
        try{
        
            Class.forName(Sdriver);
            con = DriverManager.getConnection(Surl,"root",Contraseña);
            System.out.println("Conexion exitosa");
            
        }catch(SQLException ex){
            System.err.println("Error  "+ex.getMessage());
        }catch(ClassNotFoundException e){
          Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
        }
        return con;
    }
}
