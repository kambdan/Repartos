
package Modelo;

public class Productos {
    //Atributos de la clase Productos
    private String NombreProducto;
    private String Unidad;
    private double Peso;
    private double Volumen;
    private Productos siguienteProducto;
    private ListaCaracteristicasEspeciales listaCaracteristicas;
    private int cantidad;

    
    
    
    public ListaCaracteristicasEspeciales getListaCaracteristicas() {
        return listaCaracteristicas;
    }

    public void setListaCaracteristicas(ListaCaracteristicasEspeciales listaCaracteristicas) {
        this.listaCaracteristicas = listaCaracteristicas;
    }

    public Productos() {
        
    }

    public Productos getSiguienteProducto() {
        return siguienteProducto;
    }

    public void setSiguienteProducto(Productos siguienteProducto) {
        this.siguienteProducto = siguienteProducto;
    }
    
    
    
    public Productos(String NombreProducto,String Unidad, double Peso, double Volumen, ListaCaracteristicasEspeciales listaCaracteristicas){
        this.NombreProducto=NombreProducto;
        this.Unidad=Unidad;
        this.Peso=Peso;
        this.Volumen=Volumen;
        this.siguienteProducto=null;
        this.listaCaracteristicas=listaCaracteristicas;
    
    }
    

 
    
    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getVolumen() {
        return Volumen;
    }

    public void setVolumen(double Volumen) {
        this.Volumen = Volumen;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
