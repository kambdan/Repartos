
package CONTROLADOR;

import Modelo.CaracteristicasEspeciales;
import Modelo.Clientes;
import Modelo.Conductores;
import Modelo.Empresas;
import Modelo.ListaClientes;
import Modelo.ListaProductos;
import Modelo.Productos;
import Vista.VentanaEntradaCaracteristicas;
import Vista.VentanaEntradaConductores;
import Vista.VentanaEntradaProductos;
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
    private ventanaEntradaClientes miVentanaIngreso;
    private VentanaPrincipal miViewPrincipal;
    private VentanaEntradaProductos miViewIngresoProd;
    private VentanaEntradaCaracteristicas miViewCaracteristicas;
    private VentanaEntradaConductores miViewIngresoConductores;
    //Fin de las variables para las ventanas
    
    private Empresas miEmpresas;//Variable para acceder a los metodos y listas que se encuentran en la clase Empresas
    
    private int casoB,casoModificar;
    
    public Controlador(VentanaPrincipal miViewPrincipal,Empresas miEmpresas) {
        
        this.miViewPrincipal=miViewPrincipal;
        viewCrud=new ventanaCRUD();
        miVentanaIngreso =new ventanaEntradaClientes();
        miViewIngresoProd=new VentanaEntradaProductos();
        miViewCaracteristicas=new VentanaEntradaCaracteristicas();
        miViewIngresoConductores=new VentanaEntradaConductores();
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
        //Fin de los botones de viewCRUD
        
        //ActionListener para la Ventana de ingreso de datos de la Ciudad
        
        //Fin Ciudad
        
        //ActionListener para la Ventana de ingreso de datos de los Vehiculos
        
        //Fin Vehiculos
        
        //ActionListener para la Ventana de ingreso de datos de los Conductores
        miViewIngresoConductores.btnAceptarConductor.addActionListener(this);
        //Fin Conductores
        
        //ActionListener para la Ventana de ingreso de datos de las caracteristicas especiales
        miViewCaracteristicas.btnAceptarCaract.addActionListener(this);
        //Fin Caracteristicas Especiales
        
        //ActionListener para la Ventana de ingreso de datos de los Productos
        miViewIngresoProd.btnIngresarProd.addActionListener(this);
        //Fin Productos
        
        //ActionListener para la Ventana de ingreso de datos de los Contratos
        
        //Fin contratos
        
        //ActionListener para la Ventana de ingreso de datos de los clientes
        miVentanaIngreso.btnIngresar.addActionListener(this);
        //Fin clientes

    }
    
   
        
    public void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        System.out.println("Holala");
    
    }                                           

    //Metodo para las acciones(Depende del boton Seleccionado)
            @Override
 public void actionPerformed(ActionEvent e) {
     
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
        
        //*********Solo para Vehiculos
        if(e.getSource()==miViewPrincipal.btnVehiculos){
               viewCrud.setVisible(true);
              
               miViewPrincipal.setVisible(false);
               casoB=3;
            
            }
        //Fin Vehiculos
        
        //*********Solo Conductores
        if(e.getSource()==miViewPrincipal.btnConductores){
               viewCrud.setVisible(true);
               miViewPrincipal.setVisible(false);
               casoB=4;
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
              
               miViewPrincipal.setVisible(false);
               casoB=5;
            
            }
        if(viewCrud.btnCrear==e.getSource()&& casoB==5){
                miViewCaracteristicas.setVisible(true);
                viewCrud.setVisible(false);
            
            }
           if(miViewCaracteristicas.btnAceptarCaract==e.getSource()){
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
        //Fin Caracteristicas Especiales
        
        //*********Solo Productos
        if(e.getSource()==miViewPrincipal.btnProducto){
                viewCrud.setVisible(true);
              
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
              System.out.println("  si otra vez");
              miVentanaIngreso.setVisible(false);
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
               String value =(String) viewCrud.listCrud.getSelectedValue();
               System.out.println("---"+value);
               miViewIngresoProd.setVisible(true);
               Productos miProd=new Productos();
               miProd=miEmpresas.consultarProducto(value);
               miViewIngresoProd.txtNombProd.setText(miProd.getNombreProducto());
               miViewIngresoProd.txtUnidad.setText(miProd.getUnidad());
               miViewIngresoProd.txtVolum.setText(String.valueOf(miProd.getVolumen()));
               miViewIngresoProd.txtPeso.setText(String.valueOf(miProd.getPeso()));
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
                
                miViewPrincipal.setVisible(false);
               casoB=8;
                
            }
            String comando = e.getActionCommand();
            if(viewCrud.btnCrear==e.getSource()&&casoB==8){
                miVentanaIngreso.setVisible(true);
                viewCrud.setVisible(false);
            }
            
            if(miVentanaIngreso.btnIngresar==e.getSource() ){
              miEmpresas.getMiListaClientes().agregarCliente(miVentanaIngreso.jTextFieldNombre.getText(),Long.parseLong(miVentanaIngreso.jTextFieldTelefono.getText()),miVentanaIngreso.jTextFieldCorreo.getText(),miVentanaIngreso.jTextFieldDireccion.getText());
              miVentanaIngreso.setVisible(false);
              mostrarClientes();
              System.out.println("**");
              viewCrud.setVisible(true);
            }
            
            if(viewCrud.btnBuscar==e.getSource()&&casoB==8){
               Clientes miCliente=new Clientes();
               miCliente=miEmpresas.getMiListaClientes().consultarCliente(miEmpresas.getMiListaClientes(),viewCrud.txtBuscar.getText());
               DefaultListModel modelo = new DefaultListModel();
               if(miCliente!=null){
                   modelo.addElement(miCliente.getNombre());
                   viewCrud.listCrud.setModel(modelo);
               }else{
                   //vemtana mergente no esta el producto
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
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
 //Fin Funciones para mostrar
 }

    

