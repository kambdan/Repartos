

package Modelo;

import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Empresas {
    
    private String direccion;
    private long telefono;
    
    
    private ListaClientes miListaClientes;
    private ListaContratos miListaContratos;
    private ListaProductos miListaProduc;
    private ListaVehiculos miListaVehic;
    private ListaCaracteristicasEspeciales miListaCarac;
    private ListaConductores miListaconductores;
    private ListaCiudades miListaCiudades;
    

    public ListaCiudades getMiListaCiudades() {
        return miListaCiudades;
    }

    public void setMiListaCiudades(ListaCiudades miListaCiudades) {
        this.miListaCiudades = miListaCiudades;
    }
    
   
    public Empresas() {
        
        this.miListaClientes = new ListaClientes();
        this.miListaContratos = new ListaContratos();
        this.miListaProduc = new ListaProductos();
        this.miListaVehic = new ListaVehiculos();
        this.miListaCarac = new ListaCaracteristicasEspeciales();
        this.miListaCiudades=new ListaCiudades();
        miListaconductores=new ListaConductores();
    }
    public ListaConductores getMiListaconductores() {
        return miListaconductores;
    }

    public void setMiListaconductores(ListaConductores miListaconductores) {
        this.miListaconductores = miListaconductores;
    }
    public ListaClientes getMiListaClientes() {
        return miListaClientes;
    }

    public void setMiListaClientes(ListaClientes miListaClientes) {
        this.miListaClientes = miListaClientes;
    }

    public ListaContratos getMiListaContratos() {
        return miListaContratos;
    }

    public void setMiListaContratos(ListaContratos miListaContratos) {
        this.miListaContratos = miListaContratos;
    }

    public ListaProductos getMiListaProduc() {
        return miListaProduc;
    }

    public void setMiListaProduc(ListaProductos miListaProduc) {
        this.miListaProduc = miListaProduc;
    }

    public ListaVehiculos getMiListaVehic() {
        return miListaVehic;
    }

    public void setMiListaVehic(ListaVehiculos miListaVehic) {
        this.miListaVehic = miListaVehic;
    }

    public ListaCaracteristicasEspeciales getMiListaCarac() {
        return miListaCarac;
    }

    public void setMiListaCarac(ListaCaracteristicasEspeciales miListaCarac) {
        this.miListaCarac = miListaCarac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    void registrarActividad(){}
    void dicidirRutas(){}

    //*********Funciones Ciudad
    
    //Fin ciudad
    
    //*********Funciones Vehiculos
    public void agregarVehiculo(String placa, String marca, String modelo, double peso, double volumen,String ciudad,ListaCaracteristicasEspeciales miLista){
            Vehiculos nuevoVehiculo=new Vehiculos(placa, marca, modelo, peso, volumen);
            NodoCiudad nod=consultarCiudad(ciudad);
            nuevoVehiculo.setCiudad(nod);
            nuevoVehiculo.setCaracteristicasVehiculo(miLista);
            if(miListaVehic.getHeadVehiculos()==null){
                miListaVehic.setHeadVehiculos(nuevoVehiculo);
                miListaVehic.setTailVehiculos(nuevoVehiculo);
            }else{
                miListaVehic.getTailVehiculos().setSiguienteVehiculo(nuevoVehiculo);
                miListaVehic.setTailVehiculos(nuevoVehiculo);
            }
            miListaVehic.setTamListaVehiculos(miListaVehic.getTamListaVehiculos()+1);
        }
    
    public Vehiculos consultarVehiculos(String placa){
        
        Vehiculos miVehiculo;
        miVehiculo=miListaVehic.getHeadVehiculos();
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
    
    //*********Funciones Conductores
    public void agregarConductor(String Nombre,long cedula,String Ciudad){
        NodoCiudad miNodo=consultarCiudad(Ciudad);
        Conductores miConductor=new Conductores(Nombre,cedula,miNodo);
        
        if(miListaconductores.getHeadConductor()==null){
            miListaconductores.setHeadConductor(miConductor);
            miListaconductores.setTailConductor(miConductor);
        }else{
            miListaconductores.getTailConductor().setSiguienteConductor(miConductor);
            miListaconductores.setTailConductor(miConductor);
        }
      }    
    //Fin Conductores
    
    //*********Funciones Caracteristicas Especiales
    public void agregarCaracteristica(String caracteristica,String descripcion){
        
        CaracteristicasEspeciales nuevaCaracteristica=new CaracteristicasEspeciales(caracteristica,descripcion);
        
        
        if(miListaCarac.getHeadCaracteristica()==null){
            miListaCarac.setHeadCaracteristica(nuevaCaracteristica);
            miListaCarac.setTailCaracterisitca(nuevaCaracteristica);
        }else{
            miListaCarac.getTailCaracterisitca().setSiguienteCaracteristica(nuevaCaracteristica);
            
            miListaCarac.setTailCaracterisitca(nuevaCaracteristica);
        }       
    }
    
    
    public CaracteristicasEspeciales consultarCaracteristica(String NombreCaracteristica){
       
        CaracteristicasEspeciales miCaracterisitca;
        miCaracterisitca=miListaCarac.getHeadCaracteristica();
        while(miCaracterisitca!=null && !miCaracterisitca.getCaracteristicas().equals(NombreCaracteristica)){
          miCaracterisitca=miCaracterisitca.getSiguienteCaracteristica();
        }
        if(miCaracterisitca==null){
            return miCaracterisitca;
        }else{
            return miCaracterisitca;
        }
    }
    
    public void modificarCaracteristica(String palabraModificar,String NombreCaracteristica, String Descripcion){

    CaracteristicasEspeciales nodAux;
    CaracteristicasEspeciales nodCaracteristica;
    nodAux=miListaCarac.getHeadCaracteristica();
    nodCaracteristica=consultarCaracteristica(palabraModificar);
    if(nodCaracteristica!=null){
	System.out.println("ENCONTRADO");
	while(nodCaracteristica!=nodAux){
             nodAux=nodAux.getSiguienteCaracteristica();
        }
        nodAux.setCaracteristicas(NombreCaracteristica);
        nodAux.setDescripcion(Descripcion);

        System.out.println("MODIFICADO CON EXITO");
    }else{
	System.out.println("NO ENCONTRADO");
        }
    }
    
    public void eliminarCaracteristica(String NombreCaracteristica){

            if(miListaCarac.getHeadCaracteristica()!=null){
                    CaracteristicasEspeciales auxBorrar;
                    CaracteristicasEspeciales anterior=null;
                    auxBorrar=miListaCarac.getHeadCaracteristica();
                    while((auxBorrar!=null)&&(auxBorrar.getCaracteristicas()!=NombreCaracteristica)){
                            anterior=auxBorrar;
                            auxBorrar=auxBorrar.getSiguienteCaracteristica();

                    }
                    if(auxBorrar==null){
                        System.out.println("ELEMENTO NO EXISTE");
                    }else{

                        if(anterior==null){//para eliminar el primer elemento de la lista
                            miListaCarac.setHeadCaracteristica(miListaCarac.getHeadCaracteristica().getSiguienteCaracteristica());
                            auxBorrar=null;
                        }else{//cualquier elemento que se vaya a borrar
                            anterior.setSiguienteCaracteristica(auxBorrar.getSiguienteCaracteristica());
                            auxBorrar=null;
                        }
                        System.out.println("ELIMINADO CON EXITO");
                    }
            }    
        }
    //Fin Caracteristicas Especiales
    
    //**********Funciones Productos
    public void agregarProducto(String NombreProducto,String Unidad, double Peso, double Volumen,ListaCaracteristicasEspeciales miLista){
        
        Productos miProducto=new Productos(NombreProducto,Unidad,Peso,Volumen,miLista);
        
        if(miListaProduc.getHeadProducto()==null){
            miListaProduc.setHeadProducto(miProducto);
            miListaProduc.setTailProducto(miProducto);
        }else{
            miListaProduc.getTailProducto().setSiguienteProducto(miProducto);
            miListaProduc.setTailProducto(miProducto);
            
        }
    }
    
    public Productos consultarProducto(String NombreProducto){
        
        Productos miProducto;
        miProducto=miListaProduc.getHeadProducto();
        while(miProducto!=null && !miProducto.getNombreProducto().equals(NombreProducto)){
          miProducto=miProducto.getSiguienteProducto();
        }
        if(miProducto==null){
            return miProducto;
        }else{
            System.out.println("producto: "+miProducto.getNombreProducto());
            return miProducto;
        }
    }
    
    public void modificarProducto( String palabraModificar,String NombreProducto,String Unidad, double Peso, double Volumen){

        Productos nodAux;
        Productos nodProd;
        nodAux=miListaProduc.getHeadProducto();


        nodProd=consultarProducto(palabraModificar);
        if(nodProd!=null){
            System.out.println("ENCONTRADO");
            while(nodProd!=nodAux){
                 nodAux=nodAux.getSiguienteProducto();
            }


            nodProd.setNombreProducto(NombreProducto);
            nodProd.setUnidad(Unidad);
            nodProd.setPeso(Peso);
            nodProd.setVolumen(Volumen);
            System.out.println("MODIFICADO CON EXITO");
        }else{
            System.out.println("NO ENCONTRADO");
        }
    }

    public void eliminarProducto(String NombreProducto){

	if(miListaProduc.getHeadProducto()!=null){
		Productos auxBorrar;
		Productos anterior=null;
		auxBorrar=miListaProduc.getHeadProducto();
		while((auxBorrar!=null)&&(auxBorrar.getNombreProducto()!=NombreProducto)){
			anterior=auxBorrar;
			auxBorrar=auxBorrar.getSiguienteProducto();

		}
		if(auxBorrar==null){
                    System.out.println("ELEMENTO NO EXISTE");
		}else{
                    
                    if(anterior==null){//para eliminar el primer elemento de la lista
			
                        miListaProduc.setHeadProducto(miListaProduc.getHeadProducto().getSiguienteProducto());
			auxBorrar=null;
                    }else{//cualquier elemento que se vaya a borrar
			anterior.setSiguienteProducto(auxBorrar.getSiguienteProducto());
			auxBorrar=null;
                    }
                    System.out.println("ELIMINADO CON EXITO");
		}
	}
    }
    
    //Fin Productos
    
    //*********Funciones Contratos
    
    
    
    
    
    
    
    
    public void agregarContrato(NodoCiudad ciudadOrigen,NodoCiudad ciudadDestino, int dia, int mes, int año,ListaProductos miLista,Vehiculos vehiculo){
        //agrego las fechas a los vehiculos ----la clase ListaFechas tiene su propio metodo para agregar y eliminar fechas
        //con esto cada vez que contrate se podrá observar las fechas de los vehiculos
        vehiculo.getListaFechas().agregarFechas(dia, mes, año);
        Contratos nuevoContrato=new Contratos(ciudadOrigen,ciudadDestino,dia,mes,año,miLista,vehiculo);
        
        if(miListaContratos.getHeadContratos()==null){
            
            miListaContratos.setHeadContratos(nuevoContrato);
            miListaContratos.setTailContratos(nuevoContrato);
            
        }else{
            
           miListaContratos.getTailContratos().setSiguienteContrato(nuevoContrato);
           miListaContratos.setTailContratos(nuevoContrato);
        }

    }
    
    
    
    
    public void cancelarContratos(UUID id){
        if(miListaContratos.getHeadContratos()!=null){
            Contratos  auxBorrar;
            Contratos anterior=null;
            auxBorrar=miListaContratos.getHeadContratos();
            while((auxBorrar!=null)&&(auxBorrar.getId()!=id)){
                anterior=auxBorrar;
                auxBorrar=auxBorrar.getSiguienteContrato();
            }
            if(auxBorrar==null){
                System.out.println("Elemento no existe");
            }else{
                if(anterior==null){//PARA ELIMINAR LA CABEZA
                    miListaContratos.setHeadContratos(miListaContratos.getHeadContratos().getSiguienteContrato());
                    //SE DEBE REDCORDAR QUE HAY QUE ELIMINAR LA FECHA DEL CARRO ,PARA QUE ESTE ,ésta disppnible para otro viaa
                    //con esto nos aseguramos de librar las fechas
                    auxBorrar.getVehiculo().getListaFechas().eliminarFecha(auxBorrar.getFechaContrato());
                    auxBorrar=null;
                    
                }else{
                    anterior.setSiguienteContrato(auxBorrar.getSiguienteContrato());
                    auxBorrar=null;
                    auxBorrar.getVehiculo().getListaFechas().eliminarFecha(auxBorrar.getFechaContrato());
                }
                System.out.println("Eliminado con exito");
            }
        
        }
    
    }
    
    
    
    //Fin Contratos
    
    //*********Funciones Clientes
    public void agregarCliente(String Nombre, long telefono,String correo, String direccion){
        NodoCiudad nodo=consultarCiudad(direccion);
        Clientes nuevoCliente=new Clientes(Nombre,telefono,correo,nodo);
        
        if(miListaClientes.getHeadCliente()==null){
            miListaClientes.setHeadCliente(nuevoCliente);
            miListaClientes.setTailCliente(nuevoCliente);
        }else{
            miListaClientes.getTailCliente().setSiguienteCliente(nuevoCliente);
            miListaClientes.setTailCliente(nuevoCliente);
        }
    }
    
    public Clientes consultarCliente(String NombreCliente){
        Clientes miCliente;
        miCliente=miListaClientes.getHeadCliente();
        while(miCliente!=null && !miCliente.getNombre().equals(NombreCliente)){
          miCliente=miCliente.getSiguienteCliente();
        }
        if(miCliente==null){
            return miCliente;
        }else{
            return miCliente;
        }
    }

    public void modificarCliente(String palabraModificar,String NombreCliente, long telefono, String correo, String direccion){

        Clientes nodAux;
        Clientes nodCliente;
        nodAux=miListaClientes.getHeadCliente();
        nodCliente=consultarCliente(palabraModificar);
        if(nodCliente!=null){
            System.out.println("ENCONTRADO");
            while(nodCliente!=nodAux){
                 nodAux=nodAux.getSiguienteCliente();
            }
            nodAux.setNombre(NombreCliente);
            nodAux.setTelefono(telefono);
            nodAux.setCorreoElectronico(correo);
            nodAux.getDireccion().setNombre(direccion);

            System.out.println("MODIFICADO CON EXITO");
        }else{
            System.out.println("NO ENCONTRADO");
            }
    }
    
    public void eliminarCliente(String NombreCliente){

        if(miListaClientes.getHeadCliente()!=null){
                Clientes auxBorrar;
                Clientes anterior=null;
                auxBorrar=miListaClientes.getHeadCliente();
                while((auxBorrar!=null)&&(auxBorrar.getNombre()!=NombreCliente)){
                        anterior=auxBorrar;
                        auxBorrar=auxBorrar.getSiguienteCliente();

                }
                if(auxBorrar==null){
                    System.out.println("ELEMENTO NO EXISTE");
                }else{

                    if(anterior==null){//para eliminar el primer elemento de la lista
                        miListaClientes.setHeadCliente(miListaClientes.getHeadCliente().getSiguienteCliente());
                        auxBorrar=null;
                    }else{//cualquier elemento que se vaya a borrar
                        anterior.setSiguienteCliente(auxBorrar.getSiguienteCliente());
                        auxBorrar=null;
                    }
                    System.out.println("ELIMINADO CON EXITO");
                }
        }
    }
    //Fin Clientes

    
    
    
    // ********FUNCIONES CIUDADES
     public void agregarCiudad(String nombre,int x,int y,String otraCiudad,double t,int x1,int y1){
        NodoCiudad miNodo=new NodoCiudad(nombre, x, y, otraCiudad,x1,y1,t);
        if(miListaCiudades.getHeadNodo()==null){
            miListaCiudades.setHeadNodo(miNodo);
            miListaCiudades.setTailNodo(miNodo);
            
        }else{
            miListaCiudades.getTailNodo().setSigNodo(miNodo);
            
            
            //si es diferente de null  quiere decir que se trata de un grafo
            miListaCiudades.setTailNodo(miNodo);
            
        
        }
        if(miListaCiudades.getTailNodo()!=null&&miNodo.getDistanciaEnlace().getNodoCiudad()!=null){
                ConectarCiudades(miNodo);
         }
    }
    
     public NodoCiudad consultarCiudad(String nombreCiudad){
        
        NodoCiudad miNodo;
        miNodo=miListaCiudades.getHeadNodo();
        while(miNodo!=null && !miNodo.getNombre().equals(nombreCiudad)){
          miNodo=miNodo.getSigNodo();
        }
        if(miNodo==null){
            return miNodo;
        }else{
            System.out.println("producto: "+miNodo.getNombre());
            return miNodo;
        }
    }
          
     //aqui me recibe el nodo de la ciudad con la que se conecta
     public void ConectarCiudades(NodoCiudad miNodo){
         String ciudadEnlace=miNodo.getDistanciaEnlace().getNodoCiudad().getNombre();
         System.out.println("ciudad: "+ciudadEnlace);
         NodoCiudad nodAux;
         if(ciudadEnlace!=null){
             nodAux=consultarCiudad(ciudadEnlace);


            if(nodAux!=null){
                   //llamar a una funcion que me consulte el nodo , y en ese momento me conecte

                   //este me va a devolver el nodo consultado

                   //esta añade las listas horizontales
                   //ListaCiudadConectadas miLista=new ListaCiudadConectadas();
                   //miLista=miNodo.getMiListaConectada();


                  nodAux.getMiListaConectada().agregarCiudadesConectadas(miNodo);
                  System.out.println(nodAux.getMiListaConectada().getHeadVetice().getNombre()+" ::"+nodAux.getMiListaConectada().getHeadVetice().getCoordX());
                  ///miNodo.getMiListaConectada().agregarCiudadesConectadas(nodAux, tiempo);
                  // nodAux.getMiListaConectada().agregarCiudadesConectadas(miNodo, tiempo);
                   //agregarCiudadesConectadas(nodAux, tiempo);
               }else{
                System.out.println("aquiiiii");
                agregarCiudad(miNodo.getDistanciaEnlace().getNodoCiudad().getNombre(),miNodo.getDistanciaEnlace().getNodoCiudad().getCoordX(),
               miNodo.getDistanciaEnlace().getNodoCiudad().getCoordY(),null, miNodo.getDistanciaEnlace().getTiempo(),0,0);
            }
         
         }
            
     
     
     }
     
     
     public void mostrarCiudadesConectadas(ListaCiudades miLista){
         NodoCiudad nodAux=new NodoCiudad();
         nodAux=miLista.getHeadNodo();
         while(nodAux!=null){
             //System.out.println("Punto: "+nodAux.getNombre());
             NodoCiudad aux=nodAux.getMiListaConectada().getHeadVetice();
             System.out.print(" "+nodAux.getNombre());
             while(aux!=null){
                 //System.out.print("-->"+aux.getNombre()+"("+aux.getDistancia().getTiempo()+")");
                 //System.out.println("tiempo: "+aux.getDistancia().getTiempo());
                 aux=aux.getSigVertice();
             }
             System.out.println(" ");
             nodAux=nodAux.getSigNodo();
         
         }
     
     } 
     
     //*********************************FECHAS
    
     
     
     
     
     
     
     
     
}
