
package Modelo;

public class Clientes extends Personas{
    private String correoElectronico;
    private NodoCiudad direccion;

    
   
    
    //Constructor
    public Clientes(){
    
    }
    public Clientes(String Nombre, long telefono,String correo, NodoCiudad direccion){
        super(Nombre,telefono);
        this.correoElectronico=correo;
        this.direccion=direccion;
        this.siguienteCliente=null;
        
    }
    public NodoCiudad getDireccion() {
        return direccion;
    }

    public void setDireccion(NodoCiudad direccion) {
        this.direccion = direccion;
    }
    private Clientes siguienteCliente;

  
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    
     public Clientes getSiguienteCliente() {
        return siguienteCliente;
    }

    public void setSiguienteCliente(Clientes siguienteCliente) {
        this.siguienteCliente = siguienteCliente;
    }

}
