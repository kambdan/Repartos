package Modelo;

public class Conductores extends Personas{
    
    private long cedula;
    private String CiudadReside;
    private Conductores siguienteConductor;

    public Conductores(){
        
    }
    public Conductores(String Nombre, long cedula,String Ciudad){
        super(Nombre);
        this.cedula=cedula;
        this.CiudadReside=Ciudad;
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