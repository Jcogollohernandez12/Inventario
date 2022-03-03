
package Codigo.nodos;

import java.io.Serializable;

/**
 *
 * @author JOSE ANDRES
 */
public class Nodo_Clientes implements Serializable{
    private Nodo_Clientes Siguiente, Anterior;
    private String Nom_Cli, Direccion, Telefono, Forma_P, Tipo_P, Fecha;
    private float Precio, Precio_Vari;
    private int Cant, CodigoE, CodigoClie;

    public Nodo_Clientes() {
        this.Siguiente = null;
        this.Anterior = null;
        this.Nom_Cli = "";
        this.Direccion = "";
        this.Telefono = "";
        this.Forma_P = "";
        this.Precio = 0;
        this.Cant = 0;
        this.CodigoE = 0;
        this.CodigoE = 0;
        this.Tipo_P = "";
        this.Fecha = "";
        this. Precio_Vari = Precio;
    }

    public Nodo_Clientes getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo_Clientes Siguiente) {
        this.Siguiente = Siguiente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    

    public float getPrecio_Vari() {
        return Precio_Vari;
    }

    public void setPrecio_Vari(float Precio_Vari) {
        this.Precio_Vari = Precio_Vari;
    }

    public String getTipo_P() {
        return Tipo_P;
    }

    public void setTipo_P(String Tipo_P) {
        this.Tipo_P = Tipo_P;
    }

    public Nodo_Clientes getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo_Clientes Anterior) {
        this.Anterior = Anterior;
    }

    public int getCodigoE() {
        return CodigoE;
    }

    public void setCodigoE(int Codigo) {
        this.CodigoE = Codigo;
    }

    public String getNom_Cli() {
        return Nom_Cli;
    }

    public void setNom_Cli(String Nom_Cli) {
        this.Nom_Cli = Nom_Cli;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getForma_P() {
        return Forma_P;
    }

    public void setForma_P(String Forma_P) {
        this.Forma_P = Forma_P;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float pre) {
        this.Precio = pre;
    }

    public int getCant() {
        return Cant;
    }

    public void setCant(int Cant) {
        this.Cant = Cant;
    }

    public int getCodigoClie() {
        return CodigoClie;
    }

    public void setCodigoClie(int CodigoClie) {
        this.CodigoClie = CodigoClie;
    }
    
    
    //metodo para Calcular el valor de la cuota
    public float Valor_C(){
        float V_c =0;
        
        if(getForma_P().equalsIgnoreCase("Semanal")){
        
        V_c = getPrecio() / 10;

        }else if(getForma_P().equalsIgnoreCase("Quinsenal")){
           
            V_c = getPrecio() / 5;
            
        }else{
            System.out.println("Error al eligir la forma de pago");
        }
        return V_c;
    }
    
    //metodo para sobrescribir el precio
    public float Nuevo_Precio(int Pre){
        float Precio = getPrecio() * Pre;
        setPrecio(Precio);
        return 0;
    }
    
    //metodo para saber cuanto debe segun el valor pagado por cuota
    public float Deuda(float Pre){
        
        if(Pre != 0){
       float P = getPrecio_Vari() - Pre;
        setPrecio_Vari(P);
        }else{
        setPrecio_Vari(getPrecio());
        }
        return 0;
        
    }
}
