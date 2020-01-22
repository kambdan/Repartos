/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author STRIX
 */
public class BaseDatos {
    private Empresas miEmpresas;
    public BaseDatos(Empresas miEmpresas){
        this.miEmpresas=miEmpresas;
        init();
    
    }
    
    public void init(){
        
        //******para productos
        ListaCaracteristicasEspeciales miLista=new ListaCaracteristicasEspeciales();
        CaracteristicasEspeciales nodo=new CaracteristicasEspeciales();
         nodo.setCaracteristicas("a mano");
        nodo.setDescripcion("SOLO pequeños");
        miLista.setHeadCaracteristica(nodo);
        miEmpresas.agregarProducto("Manzanas", "fundas", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Peras", "quintales", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Papas", "quintales", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Papayas", "fundas", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Aguacates", "quintales", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Tomates", "quintales", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Guineos", "fundas", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Uvas", "quintales", 1.0, 0,miLista);
        miEmpresas.agregarProducto("Galletas", "quintales", 1.0, 0,miLista);
    
         
        //****************para caracteristicasEspeciales
        miEmpresas.agregarCaracteristica("congelador", "solo carnes");
        miEmpresas.agregarCaracteristica("cajonera", "solo frutas");
        miEmpresas.agregarCaracteristica("serchas", "solo pan");
        miEmpresas.agregarCaracteristica("equipado", "solo ");
        miEmpresas.agregarCaracteristica("congelador", "solo carnes");
        miEmpresas.agregarCaracteristica("tanqueros", "solo carnes");
        miEmpresas.agregarCaracteristica("2222222", "solo carnes");
        miEmpresas.agregarCaracteristica("88888", "solo carnes");
        miEmpresas.agregarCaracteristica("33333", "solo carnes");
        miEmpresas.agregarCaracteristica("44444", "solo carnes");
        
        
        
        
        
        
        //****************para ciudades
        miEmpresas.agregarCiudad("Cuenca", 10, 10, "Quito",100,100, 2);
        miEmpresas.agregarCiudad("Quevedo", 100, 50, "Quito",100,100, 2);
        miEmpresas.agregarCiudad("Manta", 40, 10, "Cuenca",10,10, 52);
        miEmpresas.agregarCiudad("Quito", 100, 100, "Guayaquil",50,75, 2);
        miEmpresas.agregarCiudad("Cuenca", 10, 10, "Azoguez",30,60, 2);
        miEmpresas.agregarCiudad("Azoguez", 30, 60, "Quito",100,100, 32);
        miEmpresas.agregarCiudad("Riobamba", 200, 140, "Cuenca",10,10, 22);
        miEmpresas.agregarCiudad("Guayaquil", 50, 75, "Azoguez",30,60, 22);
        miEmpresas.agregarCiudad("Gualaquiza", 75, 200, "Quito",100,100, 32);
                
        
        
        
        //****************Conductores
        miEmpresas.agregarConductor("Carlos", 0104502220, "Cuenca");
        miEmpresas.agregarConductor("Antonio", 0104570, "Cuenca");
        miEmpresas.agregarConductor("Paul", 010123320, "Cuenca");
        miEmpresas.agregarConductor("Pedro", 0104555220, "Cuenca");
        miEmpresas.agregarConductor("Samuel", 01033220, "Cuenca");
        miEmpresas.agregarConductor("Fredy", 0107720, "Cuenca");
        miEmpresas.agregarConductor("Edison", 010232220, "Cuenca");
        miEmpresas.agregarConductor("Xavier", 0122202220, "Cuenca");
        miEmpresas.agregarConductor("Daniel", 010450320, "Cuenca");
        miEmpresas.agregarConductor("Jorge", 0104501120, "Cuenca");
        
        //****************Vehiculos
        
       
        miEmpresas.agregarVehiculo("ABD2", "Chevrolet", "#wf", 152, 1420,"Cuenca",miLista);
        miEmpresas.agregarVehiculo("VSV2", "Hyndai", "#wf", 152, 1420,"quevedo",miLista);
        miEmpresas.agregarVehiculo("SDD2", "Toyota", "#wf", 152, 1420,"quevedo",miLista);
        miEmpresas.agregarVehiculo("SDS2", "Chevrolet", "#wf", 152, 1420,"quevedo",miLista);
        miEmpresas.agregarVehiculo("XCS2", "Chevrolet", "#wf", 152, 1420,"quevedo",miLista);
        miEmpresas.agregarVehiculo("BAD2", "Toyata", "#wf", 152, 1420,"quevedo",miLista);
        miEmpresas.agregarVehiculo("DAS2", "Mazda", "#wf", 152, 1420,"quevedo",miLista);
        
        
        
        
        
        
        //****************Clientes
        miEmpresas.agregarCliente("Perez", 0121, "jasjj@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Enrique", 011, "bb@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Paul", 0121, "jdd@.gma.com", "Quito");
        miEmpresas.agregarCliente("Luis", 0121, "ndvd@.gma.com", "Quito");
        miEmpresas.agregarCliente("Campos", 0121, "asd@.gma.com", "Quevedo");
        miEmpresas.agregarCliente("Perez", 0121, "mbncv@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Perez", 0121, "jasdas@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Perez", 0121, "eret@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Galo", 0121, "jwwq@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Paco", 0121, "qfss@.gma.com", "Cuenca");
        miEmpresas.agregarCliente("Pepe", 0121, "alksl@.gma.com", "Cuenca");
        
        
        
        
        
        //***************
    
    
    }
    
}
