package Modelo;

import CONTROLADOR.*;
import Modelo.CaracteristicasEspeciales;
import Modelo.ListaCaracteristicasEspeciales;
import Modelo.Vehiculos;
import Vista.*;

import Vista.ventanaEntradaClientes;
import Vista.VentanaPrincipal;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
public class Main{
    
    
    
    //Deberia recibir un Nodo de tipo Caracteristicas especiales para Añadir a la clase vehiculos
    public static void main(String[] args) {

    Vehiculos mivehiculo=new Vehiculos();
    ListaCaracteristicasEspeciales miListaCaracteristivasVehiculo=new ListaCaracteristicasEspeciales();
    mivehiculo.setCaracteristicasVehiculo(miListaCaracteristivasVehiculo);
    miListaCaracteristivasVehiculo=miListaCaracteristivasVehiculo.agregarCaracteristica(mivehiculo.getCaracteristicasVehiculo(), "Nombre Caracteristica", "Deescripcion");
    mivehiculo.setCaracteristicasVehiculo(miListaCaracteristivasVehiculo);
    miListaCaracteristivasVehiculo=miListaCaracteristivasVehiculo.agregarCaracteristica(mivehiculo.getCaracteristicasVehiculo(), "Nombre1 Caracteristica", "Deescripcion1");
    mivehiculo.setCaracteristicasVehiculo(miListaCaracteristivasVehiculo);
    imprimirLis(mivehiculo.getCaracteristicasVehiculo());
    }
    public static void imprimirLis(ListaCaracteristicasEspeciales miLIsta){
        CaracteristicasEspeciales auxCarac=new CaracteristicasEspeciales();
        auxCarac=miLIsta.getHeadCaracteristica();
        while(auxCarac!=null){
            System.out.println("*********Caracteristica= "+auxCarac.getDescripcion());
            auxCarac=auxCarac.getSiguienteCaracteristica();
        }
    }
}