
package Codigo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE ANDRES
 */
public class Correos extends Conexion {
    
    
    public boolean EnviarC(){
       boolean x = false; 
       try {
            
            java.sql.Connection con = getConexion();
                    
            String Correos[] = null;//variable que almacena los correos 
            String Nombres[] = null;//variable que almacena los correos 
            ResultSet rs = null;
            PreparedStatement ps = null;
            String sql = "SELECT Correo, Nombre FROM Tb_Empl";
            int tam = 0, Indice = 0;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();//Obtenemos en Meta data desde el ResultSet        
            tam = rd.getColumnCount();//obtenemos el tamaño que le vamos a dar al vector desde el metadata
            Correos = new String[tam + 1];//creamos el arreglo con el tamaño del metadata
            Nombres = new String[tam + 1];//creamos el arreglo con el tamaño del metadata
            while(rs.next()){
                Correos[Indice] = rs.getString("Correo");
                Nombres[Indice] = rs.getString("Nombre");
                Indice++;
            }
            /*
            //vector que recoge los datos del remitente email, pass, asunto,sms 
            String Remitente[] = {"josandres123@gmail.com",
            "#jose2016A",
            "SALARIO DEL MES",
            "Hola, muy buenas \n "
            +"Este es su nomina a cobrar"
            };*/
            Properties props = new Properties();
            props.setProperty("mail.smtp.host","smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port","587");
            props.setProperty("mail.smtp.auth","true");
            Session inicio = Session.getDefaultInstance(props);
            String remitente = "josandres123@gmail.com";
            String  pass = "#jose2016";
            String asunto = "SALARIO DEL MES";
            String mensaje = "Hola, muy buenas \n "
                    +"Este es su nomina a cobrar";
            MimeMessage message = new MimeMessage(inicio);
            message.setFrom(new InternetAddress(remitente));
            Address receptor[] = new Address[Correos.length];
            int i=0;
            while(i <= receptor.length){
                receptor[i] = (Address) new InternetAddress(Correos[i]);
                i++;
            }
            message.addRecipients(Message.RecipientType.TO, receptor);
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8855-1");
            Transport trans = inicio.getTransport("smtp");
            trans.connect(remitente, pass);
            trans.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            trans.close();
            JOptionPane.showMessageDialog(null, "Correo enviado!", "Genial!!", JOptionPane.PLAIN_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(Correos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AddressException ex) {
            Logger.getLogger(Correos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correos.class.getName()).log(Level.SEVERE, null, ex);
        }
  return x; 
    }

}
