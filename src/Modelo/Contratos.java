
package Modelo;

import java.util.UUID;

public class Contratos {
    
    
    private Fechas fechaContrato;
    private Contratos siguienteContrato;
    private ListaProductos miListaProductos;
    private NodoCiudad ciudadOrigen;
    private NodoCiudad ciudadDestino;
    private ListaVehiculos listaVehiculo;

    public ListaVehiculos getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(ListaVehiculos listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }
    private Clientes cliente;
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    
    
    public Contratos getSiguienteContrato() {
        return siguienteContrato;
    }

    public void setSiguienteContrato(Contratos siguienteContrato) {
        this.siguienteContrato = siguienteContrato;
    }

    public ListaProductos getMiListaProductos() {
        return miListaProductos;
    }

    public void setMiListaProductos(ListaProductos miListaProductos) {
        this.miListaProductos = miListaProductos;
    }

    public NodoCiudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(NodoCiudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public NodoCiudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(NodoCiudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
   
    
    public Fechas getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Fechas fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    
    
    public ListaProductos getMiLista() {
        return miListaProductos;
    }

    public void setMiLista(ListaProductos miListaProduct) {
        this.miListaProductos = miListaProduct;
    }
    public Contratos(){
        
    }
    
    
    
    
    public Contratos(NodoCiudad ciudadOrigen,NodoCiudad ciudadDestino, int dia, int mes, int ano,ListaProductos miListaProductos,ListaVehiculos listaVehiculo) {
        
        fechaContrato.setAño(ano);
        fechaContrato.setMes(mes);
        fechaContrato.setDia(dia);
        this.ciudadOrigen=ciudadOrigen;
        this.ciudadDestino=ciudadDestino;
        this.miListaProductos=miListaProductos;
        this.listaVehiculo=listaVehiculo;
        this.siguienteContrato=null;
        setId();
    }
    
    
    
    
    
    
    
    void alquilarViaje(){}
    void transportar(){}
    void solicitarProducto(){}
    void calcular(){}   //calcula el peso y volumentootal del paquete
    
    
}
