
package Modelo;

import java.util.UUID;

public class Contratos {
    
    
    private Fechas fechaContrato;
    private Contratos siguienteContrato;
    private ListaProductos miListaProductos;
    private NodoCiudad ciudadOrigen;
    private NodoCiudad ciudadDestino;
    private Vehiculos vehiculo;
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

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
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
    
    
    
    
    public Contratos(NodoCiudad ciudadOrigen,NodoCiudad ciudadDestino, int dia, int mes, int ano,ListaProductos miListaProductos,Vehiculos vehiculo) {
        
        fechaContrato.setAño(ano);
        fechaContrato.setMes(mes);
        fechaContrato.setDia(dia);
        this.ciudadOrigen=ciudadOrigen;
        this.ciudadDestino=ciudadDestino;
        this.miListaProductos=miListaProductos;
        this.vehiculo=vehiculo;
        this.siguienteContrato=null;
        setId();
    }
    
    
    
    
    
    
    
    void alquilarViaje(){}
    void transportar(){}
    void solicitarProducto(){}
    void calcular(){}   
    //calcula el peso y volumentootal del paquete
    //Funcion para obtener el peso o el Volumen Total
    /*//Crear una funcion para obtener el peso total de los productos
            double pesoTotalContrato=0;
            double VolumenTotalContrato=0;
            pesoTotalContrato=miEmpresas.getMiListaContratos().getTailContratos().TotalContrato("Peso");
            VolumenTotalContrato=miEmpresas.getMiListaContratos().getTailContratos().TotalContrato("Volumen");    */
    public double TotalContrato(String tipo){
        double Total=0;
        Productos miProducto=new Productos();
        miProducto=miListaProductos.getHeadProducto();
        while(miProducto!=null){
            if(tipo.equalsIgnoreCase("Peso")){//Aqui se calcula el peso maximo
               Total=Total+(miProducto.getCantidad()*miProducto.getPeso());
                miProducto=miProducto.getSiguienteProducto();
                continue;
            }
            if(tipo.equalsIgnoreCase("Volumen")){//Aqui se calcula el volumen maximo
               Total=Total+(miProducto.getCantidad()*miProducto.getVolumen());
               miProducto=miProducto.getSiguienteProducto();
               continue;
            }
        }
        return Total;
    }
    //Esta funcion va a validar si existe un vehiculo capaz de transportar ese peso y volumen total
    public int ValidarVehiculo(ListaVehiculos misVehiculos){
        double pesoTotal=0;
        double volumenTotal=0;
        int bandera=0;
        Vehiculos miVehiculo=new Vehiculos();
        miVehiculo=misVehiculos.getHeadVehiculos();
        while(miVehiculo!=null && miVehiculo.getPesoMaximo()<pesoTotal && miVehiculo.getVolumenMaximo()<volumenTotal){
            
        }
        return bandera;
    }
    
}
