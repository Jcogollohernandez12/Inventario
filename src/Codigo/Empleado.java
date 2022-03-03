
package Codigo;

import java.io.Serializable;

/**
 *
 * @author JOSE ANDRES
 */
public class Empleado  implements Serializable{
    
    //atributos  de la clase
    private String Cargo, Clave, Nombre;
    private double sueldo_base;
    private int Id;
   
    //constructores  dela clase  
    public Empleado(String cargo, String Nombre,String clave, int Id, double sue) {
        this.Cargo = cargo;
        this.Clave = clave;
        this.sueldo_base = sue;
        this.Nombre = Nombre;
        this.Id = Id;
        
    }

    public Empleado() {
        this.Cargo = "";
        this.Clave ="";
        this.sueldo_base = 0;
    }

    //metodos modificadores y selectores
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public double getSueldo_base() {
        return sueldo_base;
    }

    public void setSueldo_base(double sueldo) {
        this.sueldo_base = sueldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
    //metodo para establecer el salario del empleado 
    public double Salario(){
     double pago = 0;
        if (getCargo().equalsIgnoreCase("ADMINISTRADOR") ) {
            pago = 700000;
        } else {
            if (getCargo().equalsIgnoreCase("VENDEDOR")) {
             pago = 6000;//6.000 pesos por unidad de producto vendido
            }
            
        }  
        //setSueldo_base(pago);
        return pago;
    }
    
    //metodos para calcular el Aporte del salario del empleado 
    public double Aporte_ARL() {
        double Aporte;
if(getCargo().equalsIgnoreCase("ADMINISTRADOR")){
       Aporte = sueldo_base * 0.2;//aporta un 20% al seguro de trabajo
        return Aporte;   
}else{
   if(getCargo().equalsIgnoreCase("VENDEDOR")){
   Aporte = 150000;
        return Aporte; 
}
}     return 0;
    }

 //metodo para calcular el neto a pagar los aportes al salario
    public double Neto_Pagar(int can) {
        double pago;
   
        if(getCargo().equals("ADMINISTRADOR")){
      pago = Salario()  - Aporte_ARL();
        return pago;   
}else if(getCargo().equals("VENDEDOR")){
      pago = Salario()  * can;
        return pago;    
}    
return 0;
    }

}
