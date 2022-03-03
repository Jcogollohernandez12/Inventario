
package Codigo.nodos;

import Codigo.Empleado;
import java.io.Serializable;

/**
 *
 * @author JOSE ANDRES
 */
public class Nodo_Empleados extends Empleado implements Serializable{
   private Nodo_Empleados Siguiente, Anterior;
   private int cant_venta, codigo,idU;
   private String Correo, cel;
   private String fecha;
   
    public Nodo_Empleados(Nodo_Empleados Siguiente, Nodo_Empleados Anterior, String cargo, String Nombre, String clave,int Idu, int Id, double sue, int can, String celu, String cor, String f) {
        super(cargo, Nombre, clave, Id, sue);
        this.Siguiente = Siguiente;
        this.Anterior = Anterior;
        this.cant_venta = can;
        this.Correo = cor;
        this.cel = celu;
        this.fecha = f;
        this.idU = Idu;
        
    }

    public Nodo_Empleados() {
        super();
        this.Siguiente = null;
        this.Anterior = null;
        this.cant_venta = 0;
        this.Correo = "";
        this.cel = "";
        this.fecha = null;
        this.idU =0;
    }

    public Nodo_Empleados getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo_Empleados Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo_Empleados getAnterior() {
        return Anterior;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAnterior(Nodo_Empleados Anterior) {
        this.Anterior = Anterior;
    }

    public int getCant_venta() {
        return cant_venta;
    }

    public void setCant_venta(int cant_venta) {
        this.cant_venta = cant_venta;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
  //metodo para calcular el neto a pagar de un vendedor segun su venta
    public double N_Pagar() {
        double pago =0;  
        if(getCant_venta() != 0){
            if(getCargo().equals("VENDEDOR")){
      
                pago = (Salario()  * getCant_venta());
        
                    return pago;
            }else{
             pago = Salario();
            }
        }
        return pago;
}    
    
}
