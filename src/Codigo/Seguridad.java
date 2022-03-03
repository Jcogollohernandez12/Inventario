/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author JOSE ANDRES
 */
public class Seguridad {
    
    public static String getHash(String txt, String TipoSeg){
         try{
             java.security.MessageDigest md = java.security.MessageDigest.getInstance(TipoSeg);
             byte[] array = md.digest(txt.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; i++){
               sb.append(Integer.toHexString((array[i] & 0xFF) |  0x100).substring(1, 3) );
             }
         return sb.toString();
         
         } catch(java.security.NoSuchAlgorithmException e){
         
             System.out.println(e.getMessage());
         }
    return null;
    }
    
//retorna un hash MD5 a partir de un texto
public static String md5(String txt){
   return Seguridad.getHash(txt, "MD5");
}    
   
//retorna un hash SHA1 a partir de un texto
public static String sha1(String txt){
   return Seguridad.getHash(txt, "SHA1");
}   

}
