
package Restauracion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSE ANDRES
 */
public class RespDados {
    
    
   //metodo para Respaldar los datos  
   public boolean RespaldoDatos(){ 
       boolean x = false;
       try {
           Process p = Runtime.getRuntime().exec("mysqldump -u root -p bdbodega");
           
           new HiloLector(p.getErrorStream()).start();
           
           InputStream is = p.getInputStream();
           FileOutputStream Fos = new FileOutputStream("backup_dbBodega.sql");
           
           byte[] buffer = new byte[1000];
           
           int leido = is.read(buffer);
           
           while( leido > 0){
             
            Fos.write(buffer, 0, leido);
            leido = is.read(buffer);
               
           }

        Fos.close();
           
       } catch (IOException ex) {
           Logger.getLogger(RespDados.class.getName()).log(Level.SEVERE, null, ex);
       }
 
   return x;
   }
   
  //metodo para restaurar los datos  
   public boolean RestaurarDatos(){ 
       boolean x = false;
       try {
           Process p = Runtime.getRuntime().exec("mysql -u root -p bdbodega");
           
           new HiloLector(p.getErrorStream()).start();
           
           OutputStream Os = p.getOutputStream();
           FileInputStream Fis = new FileInputStream("backup_dbBodega.sql");
           
           byte[] buffer = new byte[1000];
           
           int leido = Fis.read(buffer);
           
           while( leido > 0){
             
            Os.write(buffer, 0, leido);
            leido = Fis.read(buffer);
               
           }
        Os.flush();
        Os.close();
        Fis.close();
           
       } catch (IOException ex) {
           Logger.getLogger(RespDados.class.getName()).log(Level.SEVERE, null, ex);
       }
 
   return x;
   }  
   
    
}
