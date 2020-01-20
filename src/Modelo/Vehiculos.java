
package Modelo;


public class Vehiculos {
    //Atributos de la Clase Vehiculos
    private String Placa;
    private String Marca;
    private String Modelo;
    private double PesoMaximo;
    private double VolumenMaximo;
    private ListaCaracteristicasEspeciales CaracteristicasVehiculo;
    private Vehiculos siguienteVehiculo;
    
    public Vehiculos(){
        
    }
    
    //Constructor
    public Vehiculos(String placa, String marca, String modelo, double peso, double volumen){
        this.Placa=placa;
        this.Marca=marca;
        this.Modelo=modelo;
        this.PesoMaximo=peso;
        this.VolumenMaximo=volumen;
        this.siguienteVehiculo=null;
        this.CaracteristicasVehiculo=new ListaCaracteristicasEspeciales();
    }
    
    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public double getPesoMaximo() {
        return PesoMaximo;
    }

    public void setPesoMaximo(double PesoMaximo) {
        this.PesoMaximo = PesoMaximo;
    }

    public double getVolumenMaximo() {
        return VolumenMaximo;
    }

    public void setVolumenMaximo(double VolumenMaximo) {
        this.VolumenMaximo = VolumenMaximo;
    }
    
    public Vehiculos getSiguienteVehiculo() {
        return siguienteVehiculo;
    }

    public void setSiguienteVehiculo(Vehiculos siguienteVehiculo) {
        this.siguienteVehiculo = siguienteVehiculo;
    }
    
    public ListaCaracteristicasEspeciales getCaracteristicasVehiculo() {
        return CaracteristicasVehiculo;
    }

    public void setCaracteristicasVehiculo(ListaCaracteristicasEspeciales CaracteristicasVehiculo) {
        this.CaracteristicasVehiculo = CaracteristicasVehiculo;
    }
}
