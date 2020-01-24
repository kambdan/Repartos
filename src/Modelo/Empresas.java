

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
    
    
    
    //****************************** validacion para contratos
    
    
    public void consultarAgregarVehiculoLista(Vehiculos vehiculo){
        Vehiculos aux;
        aux=consultarVehiculos(vehiculo.getPlaca());
        if(aux!=null){
            agregarVehiculo(vehiculo.getPlaca(),vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getPesoMaximo(), vehiculo.getVolumenMaximo(),
                    vehiculo.getCiudad().getNombre(),vehiculo.getCaracteristicasVehiculo());
        }else{
        
        }
    }
    
    
    
    
    
    
    public int consultarCaracter(ListaCaracteristicasEspeciales lista1,ListaCaracteristicasEspeciales lista2){
        int cont=0;
        CaracteristicasEspeciales aux=lista1.getHeadCaracteristica();
        CaracteristicasEspeciales aux1=lista2.getHeadCaracteristica();
        while(aux!=null){
            if(aux.getCaracteristicas().equals(aux1.getCaracteristicas())){
                
                cont++;
            }
            aux=aux.getSiguienteCaracteristica();
            aux1=aux1.getSiguienteCaracteristica();
        
        }
        return cont;
    }
    
    
    public Vehiculos consultarVehiculoPorCaracteristicas(ListaCaracteristicasEspeciales lista){
        Vehiculos vehiculo=miListaVehic.getHeadVehiculos();
        int tam=vehiculo.getCaracteristicasVehiculo().getTam();
        int bandera=consultarCaracter(lista, vehiculo.getCaracteristicasVehiculo());
        while(vehiculo!=null&&bandera!=tam){
            bandera=consultarCaracter(lista, vehiculo.getCaracteristicasVehiculo());
            vehiculo=vehiculo.getSiguienteVehiculo();
        }
        if(vehiculo==null){
            return null;
        }else{
            return vehiculo;
        }
    
    }
    
    public int compararFechas(ListaFechas lista1,Fechas fecha){
        int bandera=0;
        if(lista1!=null){
            Fechas aux=lista1.getHeadFecha();
        
            while(aux!=null){
                if(aux.getAño()==fecha.getDia() && aux.getMes()==fecha.getMes() && aux.getDia()==fecha.getDia()){
                    bandera++;
                }
                aux=aux.getSigFecha();
            }
        }
        
        return bandera;//retorna 0 si hay fechas disponibles
                        //retorna 1 si no hay fechas disponibles
    }
    
    
    public int consultarFechaDisponible(ListaCaracteristicasEspeciales miLista,int dia,int mes,int año){
        //para consultar fechas ,primero debe obtener el vehiculo con las caracteristicas especiales
        //luego debo obtener las fechas del vehiculo y verificar si hay una fecha disponible
        int bandera=0;
        Fechas fecha=new Fechas(dia, mes, año);
        Vehiculos vehiculo;
        vehiculo=consultarVehiculoPorCaracteristicas(miLista);
        if(vehiculo!=null){//cuando si existe un vehiculo
            
            //me devuelve cero si  hay fechas dsiponibles 
            bandera=bandera+compararFechas(vehiculo.getListaFechas(), fecha);
        }
        
        return bandera;// bandera>1 no hay fecha ......bandera=0 si hay fecha
    }
    
    //esta funcion me ayuda a comparar si las ciudades a viajar estan disponibles
    public int consultarConexionCiudades(String ciudadOrigen, String ciudadDestino){
        int bandera=0;
        //obtenemos la ciudad de la columna la ciudad origen del pedido
        NodoCiudad ciudad=consultarCiudad(ciudadOrigen);
        //obtenemos la lista de las ciudades con las que estan conectadas miNodo de la columna
        ciudad=ciudad.getMiListaConectada().getHeadVetice();
        NodoCiudad aux=ciudad.getMiListaConectada().getHeadVetice();
        System.out.println(ciudad.getSigVertice());
        while(ciudad!=null){
            if(ciudad.getNombre().equals(ciudadDestino)){
                bandera++;
            }
            ciudad=ciudad.getSigVertice();
        }
                
        
        return bandera;/// bandera=1 si hay conexiones si se puede realizar los viajes
                        // bandera=0 no hay conexiones 
    }
    
    
    
    
    
 
    
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
    
    
    
    
    
    
    
    
    public void agregarContrato(NodoCiudad ciudadOrigen,NodoCiudad ciudadDestino, int dia, int mes, int año,ListaProductos miLista,ListaVehiculos listaVehiculos){
        //agrego las fechas a los vehiculos ----la clase ListaFechas tiene su propio metodo para agregar y eliminar fechas
        //con esto cada vez que contrate se podrá observar las fechas de los vehiculos
       // vehiculo.getListaFechas().agregarFechas(dia, mes, año);
        Contratos nuevoContrato=new Contratos(ciudadOrigen,ciudadDestino,dia,mes,año,miLista,listaVehiculos);
        
        if(miListaContratos.getHeadContratos()==null){
            
            miListaContratos.setHeadContratos(nuevoContrato);
            miListaContratos.setTailContratos(nuevoContrato);
            
        }else{
            
           miListaContratos.getTailContratos().setSiguienteContrato(nuevoContrato);
           miListaContratos.setTailContratos(nuevoContrato);
        }

    }
    
    public void limpiarFechas(Fechas fecha){
        Vehiculos vehiculo=miListaVehic.getHeadVehiculos();
        while(vehiculo!=null){
            vehiculo.getListaFechas().eliminarFecha(fecha);
            vehiculo=vehiculo.getSiguienteVehiculo();
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
                    
                    limpiarFechas(auxBorrar.getFechaContrato());
                    auxBorrar=null;
                    
                }else{
                    anterior.setSiguienteContrato(auxBorrar.getSiguienteContrato());
                     limpiarFechas(auxBorrar.getFechaContrato());
                    auxBorrar=null;
                    
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
     public void agregarCiudad(String nombre,int x,int y,String otraCiudad,int x1,int y1,double t){
        NodoCiudad consulta=consultarCiudad(nombre);
        NodoCiudad miNodo=new NodoCiudad(nombre, x, y, otraCiudad,x1,y1,t);
        if(consulta==null){
             
                if(miListaCiudades.getHeadNodo()==null){
                    miListaCiudades.setHeadNodo(miNodo);
                    miListaCiudades.setTailNodo(miNodo);

                }else{
                    miListaCiudades.getTailNodo().setSigNodo(miNodo);


                    //si es diferente de null  quiere decir que se trata de un grafo
                    miListaCiudades.setTailNodo(miNodo);
                }
                
                
        }else{//si ya esta agregado solo conecto
            
          
        } 
       
        if(miListaCiudades.getTailNodo()!=null&&otraCiudad!=null){
               // ConectarCiudades(miNodo);
                agregarCiudadesConectadas(miNodo.getMiListaConectada(), miNodo.getDistanciaEnlace().getNodoCiudad());
                
         }
        
    }
     
     public ListaCiudadConectadas agregarCiudadesConectadas(ListaCiudadConectadas lista,NodoCiudad miNodo){
       
        NodoCiudad aux=new NodoCiudad();
        aux=lista.getHeadVetice();
         if(lista.getHeadVetice()==null){
             
             lista.setHeadVetice(miNodo);
             lista.setTailVertice(miNodo);
             //conecttamos la cabeza con la distancia ,eso quiere decir
             //que la raiz ssabe cuanto tiempo tendrá con el siguiente nodo
             //mirar dibujo 
             
            
         }else{
            
             lista.getTailVertice().setSigVertice(miNodo);
             lista.setTailVertice(miNodo);
             
         }
         lista.setTam(lista.getTam() +1);
         return lista;
     }
     
     
     
     
     public void imprimir(){
         NodoCiudad nod=miListaCiudades.getHeadNodo();
         NodoCiudad aux;
         while(nod!=null){
             aux=nod.getMiListaConectada().getHeadVetice();
            
             if(aux!=null){
                 while(aux!=null){
                 System.out.print(" "+aux.getNombre());
                 System.out.print("-->"+aux.getNombre());
                 aux=aux.getSigVertice();
                 }
             }
             
             
             nod=nod.getSigNodo();
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
         //String ciudadEnlace=miNodo.getDistanciaEnlace().getNodoCiudad().getNombre();
         NodoCiudad nodAux=new NodoCiudad();
         nodAux=miNodo;
         String ciudadEnlace=miNodo.getDistanciaEnlace().getNodoCiudad().getNombre();
         System.out.println("ciudad: "+ciudadEnlace);
         
         ListaCiudadConectadas miListaConectada=new ListaCiudadConectadas();
         //miListaConectada=miNodo.getMiListaConectada();
         if(ciudadEnlace!=null){
             nodAux=consultarCiudad(ciudadEnlace);


            if(nodAux!=null){
                   //llamar a una funcion que me consulte el nodo , y en ese momento me conecte

                   //este me va a devolver el nodo consultado

                   //esta añade las listas horizontales
                   //ListaCiudadConectadas miLista=new ListaCiudadConectadas();
                   //miLista=miNodo.getMiListaConectada();
                  

                 // miNodo.getMiListaConectada().agregarCiudadesConectadas(miNodo.getMiListaConectada(),miNodo.getDistanciaEnlace().getNodoCiudad());
                  
                  miListaConectada=miNodo.getMiListaConectada();
                  ListaCiudadConectadas auxLista=new ListaCiudadConectadas();
                  auxLista=agregarCiudadesConectadas(miListaConectada, miNodo.getDistanciaEnlace().getNodoCiudad());
                  miNodo.setMiListaConectada(miListaConectada);
// System.out.println(nodAux.getMiListaConectada().getHeadVetice().getNombre()+" ::"+nodAux.getMiListaConectada().getHeadVetice().getCoordX());
                  ///miNodo.getMiListaConectada().agregarCiudadesConectadas(nodAux, tiempo);
                  // nodAux.getMiListaConectada().agregarCiudadesConectadas(miNodo, tiempo);
                   //agregarCiudadesConectadas(nodAux, tiempo);
               }else{
                System.out.println("aquiiiii");
                agregarCiudad(miNodo.getDistanciaEnlace().getNodoCiudad().getNombre(),miNodo.getDistanciaEnlace().getNodoCiudad().getCoordX(),
                miNodo.getDistanciaEnlace().getNodoCiudad().getCoordY(),null,0,0, miNodo.getDistanciaEnlace().getTiempo());
               
                //miNodo.getMiListaConectada().agregarCiudadesConectadas(miNodo.getMiListaConectada(),miNodo.getDistanciaEnlace().getNodoCiudad());
                miListaConectada=miNodo.getMiListaConectada();
                ListaCiudadConectadas auxLista=new ListaCiudadConectadas();
                auxLista=agregarCiudadesConectadas(miListaConectada, miNodo.getDistanciaEnlace().getNodoCiudad());
               
                 
                 miNodo.setMiListaConectada(miListaConectada);
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
     
     //*********************************
    
     
     
     
     
     
     
     
     
}
