
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
       
    }
