package Modelo;

public class Conductores extends Personas{
    
    private long cedula;
    private NodoCiudad CiudadResidencia;

    public NodoCiudad getCiudadResidencia() {
        return CiudadResidencia;
    }

    public void setCiudadResidencia(NodoCiudad CiudadResidencia) {
        this.CiudadResidencia = CiudadResidencia;
    }

   
    private Conductores siguienteConductor;

    public Conductores(){
        
    }
    public Conductores(String Nombre, long cedula,NodoCiudad ciudadResisdencia){
        super(Nombre);
        this.cedula=cedula;
        this.CiudadResidencia=ciudadResisdencia;
        this.siguienteConductor=null;
    }
    
    
    public Conductores getSiguienteConductor() {
        return siguienteConductor;
    }

    public void setSiguienteConductor(Conductores siguienteConductor) {
        this.siguienteConductor = siguienteConductor;
    }

    
    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    
    
}