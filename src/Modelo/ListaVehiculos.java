
package Modelo;

public class ListaVehiculos {
    private int tamListaVehiculos;
    private Vehiculos headVehiculos;
    private Vehiculos tailVehiculos;
    private Vehiculos listaFechasOcupadas;
    
    

    //Constructor
    public ListaVehiculos(){
        this.tamListaVehiculos=0;
        this.headVehiculos=null;
        this.tailVehiculos=null;
    }
    
    public Vehiculos getListaFechasOcupadas() {
        return listaFechasOcupadas;
    }

    public void setListaFechasOcupadas(Vehiculos listaFechasOcupadas) {
        this.listaFechasOcupadas = listaFechasOcupadas;
    }
    
    public int getTamListaVehiculos() {
        return tamListaVehiculos;
    }

    public void setTamListaVehiculos(int tamListaVehiculos) {
        this.tamListaVehiculos = tamListaVehiculos;
    }
    public Vehiculos getHeadVehiculos() {
        return headVehiculos;
    }

    public void setHeadVehiculos(Vehiculos headVehiculos) {
        this.headVehiculos = headVehiculos;
    }

    public Vehiculos getTailVehiculos() {
        return tailVehiculos;
    }

    public void setTailVehiculos(Vehiculos tailVehiculos) {
        this.tailVehiculos = tailVehiculos;
    }
    
    //Funcion para agregar un vehiculo a una lista de vehiculos
    //El Peso y el volumen hace referencia a un peso,volumen maximo que transporta Un vehiculo
    public void agregarVehiculo(ListaVehiculos miListaVehic, Vehiculos miVehiculo){
            Vehiculos nuevoVehiculo=new Vehiculos(miVehiculo.getPlaca(),miVehiculo.getMarca(), miVehiculo.getModelo(),miVehiculo.getCiudad(), miVehiculo.getPesoMaximo(), miVehiculo.getVolumenMaximo(),miVehiculo.getCaracteristicasVehiculo(),miVehiculo.getListaFechas());
            if(miListaVehic.getHeadVehiculos()==null){
                miListaVehic.setHeadVehiculos(nuevoVehiculo);
                miListaVehic.setTailVehiculos(nuevoVehiculo);
               
            }else{
                miListaVehic.getTailVehiculos().setSiguienteVehiculo(nuevoVehiculo);
                miListaVehic.setTailVehiculos(nuevoVehiculo);
                
            }

             tamListaVehiculos++;
    }
    
    public Vehiculos consultarVehiculos(ListaVehiculos listaVehiculos,String placa){
        
        Vehiculos miVehiculo;
        miVehiculo=listaVehiculos.getHeadVehiculos();
        while(miVehiculo!=null && !miVehiculo.getPlaca().equals(placa)){
          miVehiculo=miVehiculo.getSiguienteVehiculo();
        }
        if(miVehiculo==null){
            return miVehiculo;
        }else{
            return miVehiculo;
        }
    }
       //Fin vehiculos
    
    
    
    //****************************** validacion para contratos
    
    
    public void consultarAgregarVehiculoLista(ListaVehiculos listaVehiculos, Vehiculos vehiculo){
        Vehiculos aux;
        aux=consultarVehiculos(listaVehiculos,vehiculo.getPlaca());
        if(aux==null){
            agregarVehiculo(listaVehiculos,vehiculo);
        }else{
        
        }
    }
    
    
    

    }
