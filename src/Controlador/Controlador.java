
package CONTROLADOR;

import Modelo.CaracteristicasEspeciales;
import Modelo.Clientes;
import Modelo.Conductores;
import Modelo.Empresas;
import Modelo.ListaClientes;
import Modelo.ListaProductos;
import Modelo.Productos;
import Modelo.Vehiculos;
import Vista.VentanaEntradaCaracteristicas;
import Vista.VentanaEntradaConductores;
import Vista.VentanaEntradaProductos;
import Vista.VentanaEntradaVehiculos;
import Vista.ventanaCRUD;
import Vista.VentanaPrincipal;
import Vista.ventanaEntradaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    //Para poder controlar el otro paquete de vista
    
    //

    //Variables del tipo de cada una de las ventanas
    private ventanaCRUD viewCrud;//Esta ventana es donde se encuentran los botones para las operaciones CRUD
    private ventanaEntradaClientes miVentanaIngresoClientes;
    private VentanaPrincipal miViewPrincipal;
    private VentanaEntradaProductos miViewIngresoProd;
    private VentanaEntradaCaracteristicas miViewCaracteristicas;
    private VentanaEntradaConductores miViewIngresoConductores;
    private VentanaEntradaVehiculos miViewVehiculos;
    //Fin de las variables para las ventanas
    
    private Empresas miEmpresas;//Variable para acceder a los metodos y listas que se encuentran en la clase Empresas
    
    private int casoB,casoModificar;
    
    public Controlador(VentanaPrincipal miViewPrincipal,Empresas miEmpresas) {
        
        this.miViewPrincipal=miViewPrincipal;
        viewCrud=new ventanaCRUD();
        miVentanaIngresoClientes =new ventanaEntradaClientes();
        miViewIngresoProd=new VentanaEntradaProductos();
        miViewCaracteristicas=new VentanaEntradaCaracteristicas();
        miViewIngresoConductores=new VentanaEntradaConductores();
        miViewVehiculos=new VentanaEntradaVehiculos();
        this.miEmpresas=miEmpresas;
        init();
       
             
    }
    private void init(){

        //Aqui son los action listener de todos los botones de la Ventana Principal
        miViewPrincipal.btnClientes.addActionListener(this);
        miViewPrincipal.btnCaracteristicas.addActionListener(this);
        miViewPrincipal.btnCiudad.addActionListener(this);
        miViewPrincipal.btnConductores.addActionListener(this);
        miViewPrincipal.btnContratos.addActionListener(this);
        miViewPrincipal.btnEmpresa.addActionListener(this);
        miViewPrincipal.btnProducto.addActionListener(this);
        miViewPrincipal.btnVehiculos.addActionListener(this);
        miViewPrincipal.btnViajar.addActionListener(this);
        //Fin de los botones de la VENTANA principal
        
        //****Action listener para los botones de la ventana viewCRUD
        viewCrud.btnCrear.addActionListener(this);
        viewCrud.btnCrear.setActionCommand("Crear");
        viewCrud.btnBuscar.addActionListener(this);
        viewCrud.btnModificar.addActionListener(this);
        viewCrud.btnEliminar.addActionListener(this);
        viewCrud.btnAtras.addActionListener(this);
        viewCrud.btnConsultar.addActionListener(this);
        //Fin de los botones de viewCRUD
        
        //ActionListener para la Ventana de ingreso de datos de la Ciudad
        
        //Fin Ciudad
        
        //ActionListener para la Ventana de ingreso de datos de los Vehiculos
        miViewVehiculos.btnAceptarVehiculo.addActionListener(this);
        miViewVehiculos.btnOkVehiculo.addActionListener(this);
        miViewVehiculos.btnOkVehiculo.setVisible(false);
        miViewVehiculos.btnCancelarVehiculo.addActionListener(this);
        //Fin Vehiculos
        
        //ActionListener para la Ventana de ingreso de datos de los Conductores
        miViewIngresoConductores.btnAceptarConductor.addActionListener(this);
        //Fin Conductores
        
        //ActionListener para la Ventana de ingreso de datos de las caracteristicas especiales
        miViewCaracteristicas.btnAceptarCaract.addActionListener(this);
        miViewCaracteristicas.btnOkCE.addActionListener(this);
        miViewCaracteristicas.btnOkCE.setVisible(false);
        miViewCaracteristicas.btnCancelarCaracteristica.addActionListener(this);
        //Fin Caracteristicas Especiales
        
        //ActionListener para la Ventana de ingreso de datos de los Productos
        miViewIngresoProd.btnIngresarProd.addActionListener(this);
        miViewIngresoProd.btnOkProd.addActionListener(this);
        miViewIngresoProd.btnOkProd.setVisible(false);
        miViewIngresoProd.btnCancelarProd.addActionListener(this);
        
        //Fin Productos
        
        //ActionListener para la Ventana de ingreso de datos de los Contratos
        
        //Fin contratos
        
        //ActionListener para la Ventana de ingreso de datos de los clientes
        miVentanaIngresoClientes.btnIngresarCliente.addActionListener(this);
        miVentanaIngresoClientes.btnOkCliente.addActionListener(this);
        miVentanaIngresoClientes.btnOkCliente.setVisible(false);
        miVentanaIngresoClientes.btnCancelarCliente.addActionListener(this);
        
        //Fin clientes

    }
    
   
        
    public void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println("Holala");
    
    }                                           

    //Metodo para las acciones(Depende del boton Seleccionado)
            @Override
 public void actionPerformed(ActionEvent e) {
        
        //********************boton atras 
            if(viewCrud.btnAtras==e.getSource()){
                miViewPrincipal.setVisible(true);
                viewCrud.setVisible(false);
            }
        
        //****** fin btnAtras
     
     
     
     
        //*********Solo para Empresa
        if(e.getSource()==miViewPrincipal.btnEmpresa){
                viewCrud.setVisible(true);
              
                miViewPrincipal.setVisible(false);
               casoB=1;
            
            }
        //Fin empresa
     
     
        //*********Solo para Ciudad
        if(e.getSource()==miViewPrincipal.btnCiudad){
                viewCrud.setVisible(true);
              
                miViewPrincipal.setVisible(false);
               casoB=2;
            
            }
        //Fin Ciudad
        
        //*********Solo para Vehiculos(Segun el Texto solo tiene crear y consultar)
            if(e.getSource()==miViewPrincipal.btnVehiculos){
               viewCrud.setVisible(true);
               miViewPrincipal.setVisible(false);
               viewCrud.btnModificar.setVisible(false);
               viewCrud.btnEliminar.setVisible(false);
               casoB=3;
               
            }
            if(viewCrud.btnAtras==e.getSource()&&casoB==3){
               viewCrud.btnModificar.setVisible(true);
               viewCrud.btnEliminar.setVisible(true);
            }
            
            if(viewCrud.btnCrear==e.getSource() && casoB==3){
                miViewVehiculos.setVisible(true);
                viewCrud.setVisible(false);
            }
     
            if(miViewVehiculos.btnAceptarVehiculo==e.getSource()){
                miEmpresas.agregarVehiculo(miViewVehiculos.txtPlacaVehiculo.getText(), miViewVehiculos.txtMarcaVehiculo.getText(), miViewVehiculos.txtModeloVehiculo.getText(),Double.parseDouble(miViewVehiculos.txtPesoMaximoVehiculo.getText()), Double.parseDouble(miViewVehiculos.txtVolumneMaximoVehiculo.getText()));
                mostrarVehiculos();
                viewCrud.setVisible(true);
                miViewVehiculos.setVisible(false);
            }else{
               if(miViewVehiculos.btnCancelarVehiculo==e.getSource()){
                   miViewVehiculos.setVisible(false);
                   viewCrud.setVisible(true);
                } 
            }   
           
            if(viewCrud.btnBuscar==e.getSource() && casoB==3){
                Vehiculos miVehiculo=new Vehiculos();
                miVehiculo=miEmpresas.consultarVehiculos(viewCrud.txtBuscar.getText());
                DefaultListModel modelo = new DefaultListModel();
                if(miVehiculo!=null){
                    modelo.addElement(miVehiculo.getPlaca());
                    viewCrud.listCrud.setModel(modelo);
                }else{
                   //vemtana mergente no esta el producto
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado");
                }
            }
             //Consultar
            if(viewCrud.btnConsultar==e.getSource()&& casoB==3){
                String value =(String) viewCrud.listCrud.getSelectedValue();//para obntener el string Sleleccionado
                actualizarEnVentanaVehiculos(value);
                
                miViewVehiculos.btnOkVehiculo.setVisible(true);
                miViewVehiculos.btnAceptarVehiculo.setVisible(false);
                miViewVehiculos.btnCancelarVehiculo.setVisible(false);
                miViewVehiculos.setVisible(true);
                inahbiltarTextVehiculos();
            }

            if(miViewVehiculos.btnOkVehiculo==e.getSource()&&casoB==3){
               viewCrud.setVisible(true);
               miViewVehiculos.setVisible(false);
               miViewVehiculos.btnOkVehiculo.setVisible(false);
               habilitarTextVehiculos();
               miViewVehiculos.btnAceptarVehiculo.setVisible(true);
               miViewVehiculos.btnCancelarVehiculo.setVisible(true);
            }
            
            if(miViewVehiculos.btnCancelarVehiculo==e.getSource()&&casoB==3){
               viewCrud.setVisible(true);
               miViewVehiculos.setVisible(false);
               habilitarTextVehiculos();
               miViewVehiculos.btnOkVehiculo.setVisible(false);
            }
            
            
        //Fin Vehiculos
        
        //*********Solo Conductores
        if(e.getSource()==miViewPrincipal.btnConductores){
               viewCrud.setVisible(true);
               ocultar();
               viewCrud.btnConsultar.setVisible(false);
               mostrarConductores();
               miViewPrincipal.setVisible(false);
               casoB=4;
            }
        if(viewCrud.btnAtras==e.getSource()&&casoB==4){
               viewCrud.btnConsultar.setVisible(true);
            }
        
        if(viewCrud.btnCrear==e.getSource() && casoB==4){
            miViewIngresoConductores.setVisible(true);
            viewCrud.setVisible(false);
        }
        if(miViewIngresoConductores.btnAceptarConductor==e.getSource() && casoB==4){
            miEmpresas.agregarConductor(miViewIngresoConductores.TxtNombreConductor.getText(),Long.parseLong(miViewIngresoConductores.txtCedulaConductor.getText()),miViewIngresoConductores.txtCiudadReside.getText());
            viewCrud.setVisible(true);
            mostrarConductores();
            miViewIngresoConductores.setVisible(false);
        }
            
        //Fin Conductores
        
        //*********Solo caracteristicas especiales
        if(e.getSource()==miViewPrincipal.btnCaracteristicas){
               viewCrud.setVisible(true);
               hacerVisible();
               mostrarCaracteristicas();
               miViewPrincipal.setVisible(false);
               casoB=5;
            
            }
        if(viewCrud.btnCrear==e.getSource()&& casoB==5){
                miViewCaracteristicas.setVisible(true);
                viewCrud.setVisible(false);
            
            }
           if(miViewCaracteristicas.btnAceptarCaract==e.getSource() &&casoB==5 &&casoModificar!=5){
               miEmpresas.agregarCaracteristica(miViewCaracteristicas.txtNombreCaracterisitca.getText(), miViewCaracteristicas.txtDescripcionCaract.getText());
               mostrarCaracteristicas();
               viewCrud.setVisible(true);
               miViewCaracteristicas.setVisible(false);
           }
           if(viewCrud.btnBuscar==e.getSource() && casoB==5){
               
              CaracteristicasEspeciales miCaract=new CaracteristicasEspeciales();
              miCaract=miEmpresas.consultarCaracteristica(viewCrud.txtBuscar.getText());
              DefaultListModel modelo = new DefaultListModel();
              if(miCaract!=null){
                   modelo.addElement(miCaract.getCaracteristicas());
                   viewCrud.listCrud.setModel(modelo);
               }else{
                   //vemtana mergente no esta el producto
                   JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
           
           }
           //Modificar
           if(viewCrud.btnModificar==e.getSource()&& casoB==5){
               miViewCaracteristicas.setVisible(true);
               String value =(String) viewCrud.listCrud.getSelectedValue();
               actualizarEnVentanaCaracteristicas(value);
               miViewCaracteristicas.setVisible(true);
               viewCrud.setVisible(false);
               casoModificar=5;   
            }
           if(miViewCaracteristicas.btnAceptarCaract==e.getSource() && casoModificar==5){
                miEmpresas.modificarCaracteristica(viewCrud.listCrud.getSelectedValue().toString(),miViewCaracteristicas.txtNombreCaracterisitca.getText(),miViewCaracteristicas.txtDescripcionCaract.getText());
                viewCrud.setVisible(true);
                mostrarCaracteristicas();
                casoModificar=0;
            } 
           //Consultar
           if(viewCrud.btnConsultar==e.getSource() && casoB==5){
                String value =(String) viewCrud.listCrud.getSelectedValue();
                actualizarEnVentanaCaracteristicas(value);
                miViewCaracteristicas.btnOkCE.setVisible(true);
                miViewCaracteristicas.setVisible(true);
                inahbiltarTextCaracteristicas();
            
            }
            if(miViewCaracteristicas.btnOkCE==e.getSource()&&casoB==5){
               viewCrud.setVisible(true);
               miViewCaracteristicas.setVisible(false);
               miViewCaracteristicas.btnOkCE.setVisible(false);
               habilitarTextCaracteristicas();
            }
            
            if(miViewCaracteristicas.btnCancelarCaracteristica==e.getSource()&&casoB==5){
               viewCrud.setVisible(true);
               miViewCaracteristicas.setVisible(false);
               habilitarTextCaracteristicas();
               miViewCaracteristicas.btnOkCE.setVisible(false);
            }
           
          //Eliminar
           if(viewCrud.btnEliminar==e.getSource() && casoB==5){
                miEmpresas.eliminarCaracteristica(viewCrud.listCrud.getSelectedValue());
                viewCrud.setVisible(true);
                mostrarCaracteristicas();    
            }
        //Fin Caracteristicas Especiales
        
        //*********Solo Productos
        if(e.getSource()==miViewPrincipal.btnProducto){
             viewCrud.setVisible(true);
             hacerVisible();
             mostrarProductos();
             miViewPrincipal.setVisible(false);
             casoB=6;
            
            }
            if(viewCrud.btnCrear==e.getSource()&&casoB==6){
                miViewIngresoProd.setVisible(true);
                viewCrud.setVisible(false);
                     
            }
            if(miViewIngresoProd.btnIngresarProd==e.getSource() && casoB==6 && casoModificar!=6){
              miEmpresas.agregarProducto(miViewIngresoProd.txtNombProd.getText(), miViewIngresoProd.txtUnidad.getText(), Double.parseDouble(miViewIngresoProd.txtPeso.getText()),Double.parseDouble(miViewIngresoProd.txtVolum.getText()));
              mostrarProductos();
              
              miViewIngresoProd.setVisible(false);
              viewCrud.setVisible(true);
            }

            if(viewCrud.btnBuscar==e.getSource()&&casoB==6){
              Productos miProducto=new Productos();
              miProducto=miEmpresas.consultarProducto(viewCrud.txtBuscar.getText());
              DefaultListModel modelo = new DefaultListModel();
              if(miProducto!=null){
                   modelo.addElement(miProducto.getNombreProducto());
                   viewCrud.listCrud.setModel(modelo);
               }else{
                   //vemtana mergente no esta el producto
                   JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
            }
            
            if(viewCrud.btnModificar==e.getSource()&& casoB==6){
              
               miViewIngresoProd.setVisible(true);
               String value =(String) viewCrud.listCrud.getSelectedValue();
               actualizarEnVentanaProductos(value);
               
               miViewIngresoProd.setVisible(true);
               viewCrud.setVisible(false);
               casoModificar=6; 
            }
            
            if(miViewIngresoProd.btnIngresarProd==e.getSource() && casoModificar==6){
                miEmpresas.modificarProducto(viewCrud.listCrud.getSelectedValue().toString(),miViewIngresoProd.txtNombProd.getText(), miViewIngresoProd.txtUnidad.getText(),Double.parseDouble(miViewIngresoProd.txtPeso.getText()), Double.parseDouble(miViewIngresoProd.txtVolum.getText()));
                viewCrud.setVisible(true);
                mostrarProductos();
                casoModificar=0;
            }
            if(viewCrud.btnEliminar==e.getSource() && casoB==6){
                miEmpresas.eliminarProducto(viewCrud.listCrud.getSelectedValue().toString());
                viewCrud.setVisible(true);
                mostrarProductos();    
            }
            //consultar
            if(viewCrud.btnConsultar==e.getSource() && casoB==6){
                String value =(String) viewCrud.listCrud.getSelectedValue();
                actualizarEnVentanaProductos(value);
                miViewIngresoProd.btnOkProd.setVisible(true);
                miViewIngresoProd.setVisible(true);
                inahbiltarTextProductos();
            
            }
            if(miViewIngresoProd.btnOkProd==e.getSource()&&casoB==6){
               viewCrud.setVisible(true);
               miViewIngresoProd.setVisible(false);
               miViewIngresoProd.btnOkProd.setVisible(false);
               habilitarTextProducto();
            }
            
            if(miViewIngresoProd.btnCancelarProd==e.getSource()&&casoB==6){
               viewCrud.setVisible(true);
               miViewIngresoProd.setVisible(false);
               habilitarTextProducto();
               miViewIngresoProd.btnOkProd.setVisible(false);
            }
    //Fin Productos
        
        //*********Solo Contratos
        if(e.getSource()==miViewPrincipal.btnContratos){
               viewCrud.setVisible(true);
              
               miViewPrincipal.setVisible(false);
               casoB=7;
        }
        //Fin contratos
        
        //*********Solo clientes
        if(e.getSource()==miViewPrincipal.btnClientes){
               viewCrud.setVisible(true);
               hacerVisible();
               mostrarClientes();
               miViewPrincipal.setVisible(false);
               casoB=8;
                
            }
            String comando = e.getActionCommand();
            if(viewCrud.btnCrear==e.getSource()&&casoB==8){
                miVentanaIngresoClientes.setVisible(true);
                viewCrud.setVisible(false);
            }
            
            if(miVentanaIngresoClientes.btnIngresarCliente==e.getSource() && casoB==8 && casoModificar!=8){
              miEmpresas.agregarCliente(miVentanaIngresoClientes.txtNombreCliente.getText(),Long.parseLong(miVentanaIngresoClientes.txtTelefonoCliente.getText()),miVentanaIngresoClientes.txtCorreoCliente.getText(),miVentanaIngresoClientes.txtDireccionCliente.getText());
              miVentanaIngresoClientes.setVisible(false);
              mostrarClientes();
              System.out.println("**");
              viewCrud.setVisible(true);
            }
            
            if(viewCrud.btnBuscar==e.getSource()&&casoB==8){
               Clientes miCliente=new Clientes();
               miCliente=miEmpresas.consultarCliente(viewCrud.txtBuscar.getText());
               DefaultListModel modelo = new DefaultListModel();
               if(miCliente!=null){
                   modelo.addElement(miCliente.getNombre());
                   viewCrud.listCrud.setModel(modelo);
               }else{
                   //vemtana mergente no esta el producto
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
            }
            if(viewCrud.btnModificar==e.getSource()&& casoB==8){
               miVentanaIngresoClientes.setVisible(true);
               String value =(String) viewCrud.listCrud.getSelectedValue();//Toma el valor de lo que selecciono dando click en la ventana CRUD
               actualizarEnVentanaClientes(value);
               miVentanaIngresoClientes.setVisible(true);
               viewCrud.setVisible(false);
               casoModificar=8;   
            }
            
           if(miVentanaIngresoClientes.btnIngresarCliente==e.getSource() && casoModificar==8){
                miEmpresas.modificarCliente(viewCrud.listCrud.getSelectedValue().toString(),miVentanaIngresoClientes.txtNombreCliente.getText(), Long.parseLong(miVentanaIngresoClientes.txtTelefonoCliente.getText()), miVentanaIngresoClientes.txtCorreoCliente.getText(),miVentanaIngresoClientes.txtDireccionCliente.getText());
                viewCrud.setVisible(true);
                mostrarClientes();
                casoModificar=0;
            }
           
           if(viewCrud.btnEliminar==e.getSource() && casoB==8){
                miEmpresas.eliminarCliente(viewCrud.listCrud.getSelectedValue().toString());
                viewCrud.setVisible(true);
                mostrarClientes();    
            }
           
            //consultar
            if(viewCrud.btnConsultar==e.getSource()&& casoB==8){
                String value =(String) viewCrud.listCrud.getSelectedValue();
                actualizarEnVentanaClientes(value);
                miVentanaIngresoClientes.btnOkCliente.setVisible(true);
                miVentanaIngresoClientes.setVisible(true);
                inahbiltarTextClientess();
            
            }
            if(miVentanaIngresoClientes.btnOkCliente==e.getSource()&&casoB==8){
               viewCrud.setVisible(true);
               miVentanaIngresoClientes.setVisible(false);
               miVentanaIngresoClientes.btnOkCliente.setVisible(false);
               habilitarTextClientes();
            }
            
            if(miVentanaIngresoClientes.btnCancelarCliente==e.getSource()&&casoB==8){
               viewCrud.setVisible(true);
               miVentanaIngresoClientes.setVisible(false);
               habilitarTextClientes();
               miVentanaIngresoClientes.btnOkCliente.setVisible(false);
            }
        //Fin clientes
         
}
 
 
 //Funciones para Mostrar
  private void mostrarProductos(){
      DefaultListModel modelo = new DefaultListModel();
      Productos miProducto=new Productos();
      miProducto=miEmpresas.getMiListaProduc().getHeadProducto();
      
     while(miProducto!=null){
          modelo.addElement(miProducto.getNombreProducto());
          miProducto=miProducto.getSiguienteProducto();
          
         
     }
     viewCrud.listCrud.setModel(modelo);
    }
  
  private void mostrarClientes(){
      
     Clientes miCliente=new Clientes();
     miCliente=miEmpresas.getMiListaClientes().getHeadCliente();
     DefaultListModel modelo = new DefaultListModel();
     int i=0;
     while(miCliente!=null){
          modelo.addElement(miCliente.getNombre());
          miCliente=miCliente.getSiguienteCliente();
          System.out.println(": "+i+" ");
          i++;
     }
     viewCrud.listCrud.setModel(modelo);
    }

    private void mostrarCaracteristicas() {
      
     CaracteristicasEspeciales miCar=new CaracteristicasEspeciales();
   
     miCar=miEmpresas.getMiListaCarac().getHeadCaracteristica();
     DefaultListModel modelo = new DefaultListModel();
     int i=0;
     while(miCar!=null){
          modelo.addElement(miCar.getCaracteristicas());
          miCar=miCar.getSiguienteCaracteristica();
          
         
     }
     viewCrud.listCrud.setModel(modelo);
    }
    private void mostrarConductores(){
      
        Conductores miConductor=new Conductores();
        miConductor=miEmpresas.getMiListaconductores().getHeadConductor();
        DefaultListModel modelo = new DefaultListModel();
        while(miConductor!=null){
             modelo.addElement(miConductor.getNombre());
             miConductor=miConductor.getSiguienteConductor();
        }
        viewCrud.listCrud.setModel(modelo);
    }
    
    private void mostrarVehiculos() {
        
        Vehiculos miVehiculo=new Vehiculos();
        miVehiculo=miEmpresas.getMiListaVehic().getHeadVehiculos();
        DefaultListModel modelo = new DefaultListModel();
        while(miVehiculo!=null){
            modelo.addElement(miVehiculo.getPlaca());
            miVehiculo=miVehiculo.getSiguienteVehiculo(); 
        }
        viewCrud.listCrud.setModel(modelo);
    }
 
 //Fin Funciones para mostrar
    
    
//Funciones para Ocultar o hacer visibles uns Botones
     private void ocultar(){
    viewCrud.btnEliminar.setVisible(false);
    viewCrud.btnModificar.setVisible(false);
    viewCrud.btnBuscar.setVisible(false);
    viewCrud.txtBuscar.setVisible(false);
    }
     
    private void hacerVisible(){
    viewCrud.btnEliminar.setVisible(true);
    viewCrud.btnModificar.setVisible(true);
    viewCrud.btnBuscar.setVisible(true);
    viewCrud.txtBuscar.setVisible(true);
 
    }
//Fin de las funciones para hacer o no Visibles los Botones dependiendo de la opcion escogida
    
    //poner los datos recuperados en las ventanas para modificar
    private void actualizarEnVentanaProductos(String value){
        Productos miProd=new Productos();
        miProd=miEmpresas.consultarProducto(value);
        miViewIngresoProd.txtNombProd.setText(miProd.getNombreProducto());
        miViewIngresoProd.txtUnidad.setText(miProd.getUnidad());
        miViewIngresoProd.txtVolum.setText(String.valueOf(miProd.getVolumen()));
        miViewIngresoProd.txtPeso.setText(String.valueOf(miProd.getPeso()));
        
    }
    private void actualizarEnVentanaClientes(String value){
        Clientes miClient=new Clientes();
        miClient=miEmpresas.consultarCliente(value);
        miVentanaIngresoClientes.txtNombreCliente.setText(miClient.getNombre());
        miVentanaIngresoClientes.txtTelefonoCliente.setText(String.valueOf(miClient.getTelefono()));
        miVentanaIngresoClientes.txtCorreoCliente.setText(miClient.getCorreoElectronico());
        miVentanaIngresoClientes.txtDireccionCliente.setText(miClient.getDireccion());
    }
    
    private void actualizarEnVentanaCaracteristicas(String value){
        CaracteristicasEspeciales miCaract=new CaracteristicasEspeciales();
        miCaract=miEmpresas.consultarCaracteristica(value);       
        miViewCaracteristicas.txtNombreCaracterisitca.setText(miCaract.getCaracteristicas());
        miViewCaracteristicas.txtDescripcionCaract.setText(miCaract.getDescripcion());
    }
    private void actualizarEnVentanaVehiculos(String value){
        Vehiculos miVehiculo=new Vehiculos();
        miVehiculo=miEmpresas.consultarVehiculos(value);
        miViewVehiculos.txtPlacaVehiculo.setText(miVehiculo.getPlaca());
        miViewVehiculos.txtMarcaVehiculo.setText(miVehiculo.getMarca());
        miViewVehiculos.txtModeloVehiculo.setText(miVehiculo.getModelo());
        miViewVehiculos.txtPesoMaximoVehiculo.setText(String.valueOf(miVehiculo.getPesoMaximo()));
        miViewVehiculos.txtVolumneMaximoVehiculo.setText(String.valueOf(miVehiculo.getVolumenMaximo()));
        System.out.println("Modelo"+miVehiculo.getModelo());
    }
    //Fin poner los datos recuperados en las Ventanas
    
    //hacer que las ventnas de ingreso no sean editables
     private void inahbiltarTextProductos(){
        miViewIngresoProd.txtNombProd.setEditable(false);
        miViewIngresoProd.txtNombProd.setEnabled(false);
        miViewIngresoProd.txtUnidad.setEditable(false);
        miViewIngresoProd.txtUnidad.setEnabled(false);
        miViewIngresoProd.txtVolum.setEditable(false);
        miViewIngresoProd.txtVolum.setEnabled(false);
        miViewIngresoProd.txtPeso.setEditable(false);
        miViewIngresoProd.txtPeso.setEnabled(false);
        
     }
     
     private void inahbiltarTextClientess(){
        miVentanaIngresoClientes.txtNombreCliente.setEditable(false);
        miVentanaIngresoClientes.txtNombreCliente.setEnabled(false);
        miVentanaIngresoClientes.txtTelefonoCliente.setEditable(false);
        miVentanaIngresoClientes.txtTelefonoCliente.setEnabled(false);
        miVentanaIngresoClientes.txtCorreoCliente.setEditable(false);
        miVentanaIngresoClientes.txtCorreoCliente.setEnabled(false);
        miVentanaIngresoClientes.txtDireccionCliente.setEditable(false);
        miVentanaIngresoClientes.txtDireccionCliente.setEnabled(false);
     }
     
     private void inahbiltarTextCaracteristicas(){
        miViewCaracteristicas.txtNombreCaracterisitca.setEditable(false);
        miViewCaracteristicas.txtNombreCaracterisitca.setEnabled(false);
        miViewCaracteristicas.txtDescripcionCaract.setEditable(false);
        miViewCaracteristicas.txtDescripcionCaract.setEnabled(false);
     }
     private void inahbiltarTextVehiculos(){
        miViewVehiculos.txtPlacaVehiculo.setEditable(false);
        miViewVehiculos.txtPlacaVehiculo.setEnabled(false);
        miViewVehiculos.txtMarcaVehiculo.setEditable(false);
        miViewVehiculos.txtMarcaVehiculo.setEnabled(false);
        miViewVehiculos.txtModeloVehiculo.setEditable(false);
        miViewVehiculos.txtModeloVehiculo.setEnabled(false);
        miViewVehiculos.txtPesoMaximoVehiculo.setEditable(false);
        miViewVehiculos.txtPesoMaximoVehiculo.setEnabled(false);
        miViewVehiculos.txtVolumneMaximoVehiculo.setEditable(false); 
        miViewVehiculos.txtVolumneMaximoVehiculo.setEnabled(false); 
     }
    //Fin funciones para inhabilitar
    
    //funciones para habilitar ya que se desabilitaron y al momento que de la opcion
    //modificar van a estar desabilitadas
     private void habilitarTextProducto(){
        miViewIngresoProd.txtNombProd.setEditable(true);
        miViewIngresoProd.txtNombProd.setEnabled(true);
        miViewIngresoProd.txtUnidad.setEditable(true);
        miViewIngresoProd.txtUnidad.setEnabled(true);
        miViewIngresoProd.txtVolum.setEditable(true);
        miViewIngresoProd.txtVolum.setEnabled(true);
        miViewIngresoProd.txtPeso.setEditable(true);
        miViewIngresoProd.txtPeso.setEnabled(true);
     }
     private void habilitarTextClientes(){
        miVentanaIngresoClientes.txtNombreCliente.setEditable(true);
        miVentanaIngresoClientes.txtNombreCliente.setEnabled(true);
        miVentanaIngresoClientes.txtTelefonoCliente.setEditable(true);
        miVentanaIngresoClientes.txtTelefonoCliente.setEnabled(true);
        miVentanaIngresoClientes.txtCorreoCliente.setEditable(true);
        miVentanaIngresoClientes.txtCorreoCliente.setEnabled(true);
        miVentanaIngresoClientes.txtDireccionCliente.setEditable(true);
        miVentanaIngresoClientes.txtDireccionCliente.setEnabled(true);
     }
     
     private void habilitarTextCaracteristicas(){
        miViewCaracteristicas.txtNombreCaracterisitca.setEditable(true);
        miViewCaracteristicas.txtNombreCaracterisitca.setEnabled(true);
        miViewCaracteristicas.txtDescripcionCaract.setEditable(true);
        miViewCaracteristicas.txtDescripcionCaract.setEnabled(true);
     }
     
     private void habilitarTextVehiculos(){
        miViewVehiculos.txtPlacaVehiculo.setEditable(true);
        miViewVehiculos.txtPlacaVehiculo.setEnabled(true);
        miViewVehiculos.txtMarcaVehiculo.setEditable(true);
        miViewVehiculos.txtMarcaVehiculo.setEnabled(true);
        miViewVehiculos.txtModeloVehiculo.setEditable(true);
        miViewVehiculos.txtModeloVehiculo.setEnabled(true);
        miViewVehiculos.txtPesoMaximoVehiculo.setEditable(true);
        miViewVehiculos.txtPesoMaximoVehiculo.setEnabled(true);
        miViewVehiculos.txtVolumneMaximoVehiculo.setEditable(true); 
        miViewVehiculos.txtVolumneMaximoVehiculo.setEnabled(true); 
     }
     //Fin de las funciones para Habilitar
    
 }

    

