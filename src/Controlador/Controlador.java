
package CONTROLADOR;

import Modelo.CaracteristicasEspeciales;
import Modelo.Clientes;
import Modelo.Conductores;
import Modelo.Dibujos;
import Modelo.Empresas;
import Modelo.ListaClientes;
import Modelo.ListaProductos;
import Modelo.NodoCiudad;
import Modelo.Productos;
import Modelo.Vehiculos;
import Vista.VentanaDibujo;
import Vista.VentanaEntradaCaracteristicas;
import Vista.VentanaEntradaCiudades;
import Vista.VentanaEntradaConductores;
import Vista.VentanaEntradaProductos;
import Vista.VentanaEntradaVehiculos;
import Vista.VentanaEntradaViajes;
import Vista.ventanaCRUD;
import Vista.VentanaPrincipal;
import Vista.ventanaEntradaClientes;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import sun.tools.jar.resources.jar;

public class Controlador implements ActionListener, KeyListener{
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
    private VentanaEntradaCiudades miViewCiudades;

    private VentanaDibujo miViewDibujo;
    

    private VentanaEntradaViajes miViewViajes;

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
        miViewCiudades=new VentanaEntradaCiudades();
        miViewDibujo=new VentanaDibujo();
        miViewViajes=new VentanaEntradaViajes();

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
        miViewPrincipal.btnMapa.addActionListener(this);
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
        
        //ActionListener  y KeyListener para la Ventana de ingreso de datos de la Ciudad
        
        miViewCiudades.btnAceptarCiudad.addActionListener(this);
        miViewCiudades.btnCancelarCiudad.addActionListener(this);
        miViewCiudades.ButtonSICiudad.addActionListener(this);
        miViewCiudades.ButtonNoCiudad.addActionListener(this);
        miViewCiudades.btnOkCiudad.addActionListener(this);
        miViewCiudades.txtCordenadaX.addKeyListener(this);
        miViewCiudades.txtCordenadaY.addKeyListener(this );
        miViewCiudades.txtTiempo.addKeyListener(this);
        //Fin Ciudad
        
        //ActionListener y KeyListener para la Ventana de ingreso de datos de los Vehiculos
        miViewVehiculos.btnAceptarVehiculo.addActionListener(this);
        miViewVehiculos.btnOkVehiculo.addActionListener(this);
        miViewVehiculos.btnOkVehiculo.setVisible(false);
        miViewVehiculos.btnCancelarVehiculo.addActionListener(this);
        miViewVehiculos.txtPesoMaximoVehiculo.addKeyListener(this);
        miViewVehiculos.txtVolumneMaximoVehiculo.addKeyListener(this);
        //Fin Vehiculos
        
        //ActionListener y KeyListener para la Ventana de ingreso de datos de los Conductores
        miViewIngresoConductores.btnAceptarConductor.addActionListener(this);
        miViewIngresoConductores.btnCancelarConductor.addActionListener(this);
        miViewIngresoConductores.txtCedulaConductor.addKeyListener(this);
        //Fin Conductores
        
        //ActionListener para la Ventana de ingreso de datos de las caracteristicas especiales
        miViewCaracteristicas.btnAceptarCaract.addActionListener(this);
        miViewCaracteristicas.btnOkCE.addActionListener(this);
        miViewCaracteristicas.btnOkCE.setVisible(false);
        miViewCaracteristicas.btnCancelarCaracteristica.addActionListener(this);
        //Fin Caracteristicas Especiales
        
        //ActionListener y KeyListener para la Ventana de ingreso de datos de los Productos
        miViewIngresoProd.btnIngresarProd.addActionListener(this);
        miViewIngresoProd.btnOkProd.addActionListener(this);
        miViewIngresoProd.btnOkProd.setVisible(false);
        miViewIngresoProd.btnCancelarProd.addActionListener(this);
        miViewIngresoProd.txtPeso.addKeyListener(this);
        miViewIngresoProd.txtVolum.addKeyListener(this);
        //Fin Productos
        
        //ActionListener y KeyListener para la Ventana de ingreso de datos de los Contratos
        miViewViajes.btnAceptarViaje.addActionListener(this);
        miViewViajes.btnCancelarViaje.addActionListener(this);
        miViewViajes.rbtnNoProducto.addKeyListener(this);
        miViewViajes.rbtnSIProducto.addKeyListener(this);
        //Fin contratos
        
        //ActionListener y KeyListener para la Ventana de ingreso de datos de los clientes
        miVentanaIngresoClientes.btnIngresarCliente.addActionListener(this);
        miVentanaIngresoClientes.btnOkCliente.addActionListener(this);
        miVentanaIngresoClientes.btnOkCliente.setVisible(false);
        miVentanaIngresoClientes.btnCancelarCliente.addActionListener(this);
        miVentanaIngresoClientes.txtTelefonoCliente.addKeyListener(this);
        //Fin clientes

    }       
    public void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
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

        if(e.getSource()==viewCrud.btnCrear && casoB==2){
            viewCrud.setVisible(false);
            miViewCiudades.setVisible(true);
            miViewCiudades.txtCiudadAEnlazar.setEnabled(false);
            miViewCiudades.txtTiempo.setEnabled(false); 
            miViewCiudades.txtNombreCiudad.setEnabled(true);
            limpiarTextoCiudades();
        }
        
        ButtonGroup grupo=new ButtonGroup();
        grupo.add(miViewCiudades.ButtonSICiudad);
        grupo.add(miViewCiudades.ButtonNoCiudad);
        if(miViewCiudades.ButtonNoCiudad.isSelected()){
            miViewCiudades.txtCiudadAEnlazar.setEnabled(false);
            miViewCiudades.txtTiempo.setEnabled(false); 
        }else{
            if(miViewCiudades.ButtonSICiudad.isSelected()){
                miViewCiudades.txtCiudadAEnlazar.setEnabled(true);
                miViewCiudades.txtTiempo.setEnabled(true);
            }
        }
        
       if(miViewCiudades.btnAceptarCiudad==e.getSource()){
            if(miViewCiudades.txtNombreCiudad.getText().length()==0 || miViewCiudades.txtTiempo.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Campos incompletos");
                miViewCiudades.setVisible(true);
                viewCrud.setVisible(false);
            } 
            validarVacioCiudades(miViewCiudades.txtNombreCiudad.getText(),miViewCiudades.txtCordenadaX.getText(),miViewCiudades.txtCordenadaY.getText(),
                    miViewCiudades.txtCiudadAEnlazar.getText(),miViewCiudades.txtTiempo.getText());
        }else{
            if(miViewCiudades.btnCancelarCiudad==e.getSource()){
                miViewCiudades.setVisible(false);
                viewCrud.setVisible(true);
            }
        }
        
       if(miViewCiudades.ButtonNoCiudad.isSelected()){
            miViewCiudades.txtCiudadAEnlazar.setEnabled(false);
            miViewCiudades.txtTiempo.setEnabled(false);
            miViewCiudades.txtTiempo.setText(String.valueOf(0));
        }else{
            if(miViewCiudades.ButtonSICiudad==e.getSource()){
            miViewCiudades.txtCiudadAEnlazar.setEnabled(true);
            miViewCiudades.txtTiempo.setEnabled(true);       
            }
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
                limpiarTextoVehiculos();               
            }
            
            if(miViewVehiculos.btnAceptarVehiculo==e.getSource()){
                validarVacioVehiculos(miViewVehiculos.txtPlacaVehiculo.getText(), miViewVehiculos.txtMarcaVehiculo.getText(), miViewVehiculos.txtModeloVehiculo.getText(),miViewVehiculos.txtPesoMaximoVehiculo.getText(),miViewVehiculos.txtVolumneMaximoVehiculo.getText());              
            }else{
               if(miViewVehiculos.btnCancelarVehiculo==e.getSource()){
                   miViewVehiculos.setVisible(false);
                   viewCrud.setVisible(true);
                } 
            }   
           
            if(viewCrud.btnBuscar==e.getSource() && casoB==3){
                Vehiculos miVehiculo=new Vehiculos();
                miVehiculo=miEmpresas.consultarVehiculos(viewCrud.txtBuscar.getText());
                DefaultTableModel modelo = new DefaultTableModel();
                if(miVehiculo!=null){
                    
                    
                     String []info=new String[7];
                     info[0]=miVehiculo.getPlaca();
                     info[1]=miVehiculo.getMarca();
                     info[2]=miVehiculo.getModelo();
                     info[3]=String.valueOf(miVehiculo.getPesoMaximo());
                     info[4]=String.valueOf(miVehiculo.getVolumenMaximo());
                     info[5]=String.valueOf(miVehiculo.getCiudad().getNombre());
                     info[6]="caracteristicas";

                     modelo.addRow(info);
                    //viewCrud.listCrud.setModel(modelo);
                    
                }else{
                   //vemtana mergente no esta el producto
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado");
                }
            }
             //Consultar
            if(viewCrud.btnConsultar==e.getSource()&& casoB==3){
                DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
                String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
                //String value =(String) viewCrud.listCrud.getSelectedValue();//para obntener el string Sleleccionado
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
            limpiarTextoConductores();
        }
        if(miViewIngresoConductores.btnAceptarConductor==e.getSource() && casoB==4){
            validarVacioConductores(miViewIngresoConductores.TxtNombreConductor.getText(), miViewIngresoConductores.txtCedulaConductor.getText(), miViewIngresoConductores.txtCiudadReside.getText());
        }
        else{
            if(miViewIngresoConductores.btnCancelarConductor==e.getSource() && casoB==4){
                viewCrud.setVisible(true);
                miViewIngresoConductores.setVisible(false);          
            }
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
            limpiarTextoCaracteristicas();
        }
        
        if(miViewCaracteristicas.btnAceptarCaract==e.getSource() &&casoB==5 &&casoModificar!=5){
            validarVacioCaracteristicas(miViewCaracteristicas.txtNombreCaracterisitca.getText(), miViewCaracteristicas.txtDescripcionCaract.getText());
        }
        
        if(viewCrud.btnBuscar==e.getSource() && casoB==5){
               

              CaracteristicasEspeciales miCaract=new CaracteristicasEspeciales();
              miCaract=miEmpresas.consultarCaracteristica(viewCrud.txtBuscar.getText());
              DefaultListModel modelo = new DefaultListModel();
              if(miCaract!=null){
                   modelo.addElement(miCaract.getCaracteristicas());
                  // viewCrud.listCrud.setModel(modelo);
               }else{
                   //vemtana mergente no esta el producto
                   JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
           
           }

           
           //Modificar
           if(viewCrud.btnModificar==e.getSource()&& casoB==5){
               miViewCaracteristicas.setVisible(true);
               //String value =(String) viewCrud.listCrud.getSelectedValue();
              // actualizarEnVentanaCaracteristicas(value);
               miViewCaracteristicas.setVisible(true);
               viewCrud.setVisible(false);
               casoModificar=5;   
            }
           if(miViewCaracteristicas.btnAceptarCaract==e.getSource() && casoModificar==5){
                //miEmpresas.modificarCaracteristica(viewCrud.listCrud.getSelectedValue().toString(),miViewCaracteristicas.txtNombreCaracterisitca.getText(),miViewCaracteristicas.txtDescripcionCaract.getText());
                viewCrud.setVisible(true);
                mostrarCaracteristicas();
                casoModificar=0;
            } 
           //Consultar
           if(viewCrud.btnConsultar==e.getSource() && casoB==5){
                //String value =(String) viewCrud.listCrud.getSelectedValue();
               // actualizarEnVentanaCaracteristicas(value);
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
                //miEmpresas.eliminarCaracteristica(viewCrud.listCrud.getSelectedValue());
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
                limpiarTextoProductos();
            }
            if(miViewIngresoProd.btnIngresarProd==e.getSource()  && casoModificar!=6){
                validarVacioProductos(miViewIngresoProd.txtNombProd.getText(), miViewIngresoProd.txtUnidad.getText(), miViewIngresoProd.txtPeso.getText(), miViewIngresoProd.txtVolum.getText());
                mostrarProductos();
            }

            if(viewCrud.btnBuscar==e.getSource()&&casoB==6){
              Productos miProducto=new Productos();
              miProducto=miEmpresas.consultarProducto(viewCrud.txtBuscar.getText());
                System.out.println("Feliz");
              DefaultTableModel modelo=new DefaultTableModel();
               modelo.addColumn("Nombre");
                modelo.addColumn("Coordenada en X");
                modelo.addColumn("Coordenada en Y");
                modelo.addColumn("Conectada con");
                modelo.addColumn("Tiempo");
                this.viewCrud.table.setModel(modelo);
              if(miProducto!=null){
                 
                 String []info=new String[5];
                 info[0]=miProducto.getNombreProducto();
                 info[1]="caract";
                 info[2]=miProducto.getUnidad();
                 info[3]=String.valueOf(miProducto.getPeso());
                 info[4]=String.valueOf(miProducto.getVolumen());
                 modelo.addRow(info);
                 
                   //viewCrud.listCrud.setModel(modelo);
               }else{
                   //vemtana mergente no esta el producto
                   JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
            }
            
            if(viewCrud.btnModificar==e.getSource()&& casoB==6){
              
               miViewIngresoProd.setVisible(true);
               DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
               String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
               //System.out.println("values"+value);
               actualizarEnVentanaProductos(value);
               
               miViewIngresoProd.setVisible(true);
               viewCrud.setVisible(false);
               casoModificar=6; 
            }
            
            if(miViewIngresoProd.btnIngresarProd==e.getSource() && casoModificar==6){
                DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
                String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
                miEmpresas.modificarProducto(value,miViewIngresoProd.txtNombProd.getText(), miViewIngresoProd.txtUnidad.getText(),Double.parseDouble(miViewIngresoProd.txtPeso.getText()), Double.parseDouble(miViewIngresoProd.txtVolum.getText()));
                viewCrud.setVisible(true);
                mostrarProductos();
                casoModificar=0;
            }
            if(viewCrud.btnEliminar==e.getSource() && casoB==6){
                DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
                String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
                miEmpresas.eliminarProducto(value);
                viewCrud.setVisible(true);
                mostrarProductos();    
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
        if(viewCrud.btnCrear==e.getSource() && casoB==7){
            viewCrud.setVisible(false);
            miViewViajes.setVisible(true);
            limpiarTextoContratos();
        }
        
        
        
        
        
        
        if(miViewViajes.btnAceptarViaje==e.getSource()){
            validarVacioViajes(miViewViajes.txtClienteConViaje.getText(),miViewViajes.txtCiudadOrigen.getText(),miViewViajes.txtCiudadDestino.getText());
        }else{
            if(miViewViajes.btnCancelarViaje==e.getSource()){
                miViewViajes.setVisible(false);
                viewCrud.setVisible(true);
            }
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
                limpiarTextoClientes();
            }
            
            if(miVentanaIngresoClientes.btnIngresarCliente==e.getSource() && casoB==8 && casoModificar!=8){
                validarVacioClientes(miVentanaIngresoClientes.txtNombreCliente.getText(), miVentanaIngresoClientes.txtTelefonoCliente.getText(), miVentanaIngresoClientes.txtCorreoCliente.getText(), miVentanaIngresoClientes.txtDireccionCliente.getText());
            }
            
            if(viewCrud.btnBuscar==e.getSource()&&casoB==8){
               Clientes miCliente=new Clientes();
               miCliente=miEmpresas.consultarCliente(viewCrud.txtBuscar.getText());
               DefaultTableModel modelo=new DefaultTableModel();
               if(miCliente!=null){
                    String []info=new String[4];
                    info[0]=miCliente.getNombre();
                    info[1]=Long.toString(miCliente.getTelefono());
                    info[2]=miCliente.getCorreoElectronico();
                    info[3]=miCliente.getDireccion();

                    modelo.addRow(info);
               }else{
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado");
               }
            }
            if(viewCrud.btnModificar==e.getSource()&& casoB==8){
               miVentanaIngresoClientes.setVisible(true);
               DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
               String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
               actualizarEnVentanaClientes(value);
               miVentanaIngresoClientes.setVisible(true);
               viewCrud.setVisible(false);
               casoModificar=8;   
            }
            
           if(miVentanaIngresoClientes.btnIngresarCliente==e.getSource() && casoModificar==8){
               DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
               String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
                miEmpresas.modificarCliente(value,miVentanaIngresoClientes.txtNombreCliente.getText(), Long.parseLong(miVentanaIngresoClientes.txtTelefonoCliente.getText()), miVentanaIngresoClientes.txtCorreoCliente.getText(),miVentanaIngresoClientes.txtDireccionCliente.getText());
                viewCrud.setVisible(true);
                mostrarClientes();
                casoModificar=0;
            }
           
           if(viewCrud.btnEliminar==e.getSource() && casoB==8){
               DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
                String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
               miEmpresas.eliminarCliente(value);
                viewCrud.setVisible(true);
                mostrarClientes();    
            }
           
            //consultar
            if(viewCrud.btnConsultar==e.getSource()&& casoB==8){
                DefaultTableModel tm = (DefaultTableModel) viewCrud.table.getModel();
                String value =(String) tm.getValueAt(viewCrud.table.getSelectedRow(), 0);
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
        
        // *************************solo mapas
        if(miViewPrincipal.btnMapa==e.getSource()){
            dibujar();
        
        }
        
        
        
         
}
 
 
 //Funciones para Mostrar
 
 
 private void mostrarProductos(){
     DefaultTableModel modelo=new DefaultTableModel();
     modelo.addColumn("Nombre");
     modelo.addColumn("Caracteristicas Especiales");
     modelo.addColumn("Unidad");
     modelo.addColumn("Peso");
     modelo.addColumn("Volumen");
     this.viewCrud.table.setModel(modelo);
     Productos miProducto=new Productos();
      miProducto=miEmpresas.getMiListaProduc().getHeadProducto();
     while(miProducto!=null){
         String []info=new String[5];
         info[0]=miProducto.getNombreProducto();
         info[1]="caracteristic";
         info[2]=miProducto.getUnidad();
         info[3]=String.valueOf(miProducto.getPeso());
         info[4]=String.valueOf(miProducto.getVolumen());
         modelo.addRow(info);
         miProducto=miProducto.getSiguienteProducto();
     }
 
 }
  
  private void mostrarClientes(){
      DefaultTableModel modelo=new DefaultTableModel();
     modelo.addColumn("Nombre");
     modelo.addColumn("Telefono");
     modelo.addColumn("Correo");
     modelo.addColumn("Direccion");
     
     this.viewCrud.table.setModel(modelo);
     Clientes miCliente=new Clientes();
     miCliente=miEmpresas.getMiListaClientes().getHeadCliente();
     while(miCliente!=null){
         String []info=new String[4];
         info[0]=miCliente.getNombre();
         info[1]=Long.toString(miCliente.getTelefono());
         info[2]=miCliente.getCorreoElectronico();
         info[3]=miCliente.getDireccion();
        
         modelo.addRow(info);
         miCliente=miCliente.getSiguienteCliente();
     }
     
  
  
  
  }
  

    
  
private void mostrarCaracteristicas(){
      DefaultTableModel modelo=new DefaultTableModel();
     modelo.addColumn("Nombre");
     modelo.addColumn("Descripcion");
     
     this.viewCrud.table.setModel(modelo);
     CaracteristicasEspeciales miCar=new CaracteristicasEspeciales();
     miCar=miEmpresas.getMiListaCarac().getHeadCaracteristica();
    
     while(miCar!=null){
         String []info=new String[2];
         info[0]=miCar.getCaracteristicas();
         info[1]=miCar.getDescripcion();
          modelo.addRow(info);
          miCar=miCar.getSiguienteCaracteristica();
     }
}

private void mostrarConductores(){
      DefaultTableModel modelo=new DefaultTableModel();
     modelo.addColumn("Nombre");
     modelo.addColumn("Cedula");
     modelo.addColumn("Ciudad Residencia");
    
     this.viewCrud.table.setModel(modelo);
      Conductores miConductor=new Conductores();
    miConductor=miEmpresas.getMiListaconductores().getHeadConductor();
     while(miConductor!=null){
         String []info=new String[3];
         info[0]=miConductor.getNombre();
         info[1]=Long.toString(miConductor.getCedula());
         
         info[2]=miConductor.getCiudadReside();
        
         modelo.addRow(info);
        miConductor= miConductor.getSiguienteConductor();
     }
   }
   



private void mostrarVehiculos(){
    DefaultTableModel modelo=new DefaultTableModel();
    modelo.addColumn("Placa");
    modelo.addColumn("Marca");
    modelo.addColumn("Modelo");
    modelo.addColumn("Peso max.");
    modelo.addColumn("Volumen max.");
    modelo.addColumn("Ciudad Residencia");
    modelo.addColumn("Caracteristicas");
    this.viewCrud.table.setModel(modelo);
    Vehiculos miVehiculo=new Vehiculos();
    miVehiculo=miEmpresas.getMiListaVehic().getHeadVehiculos();
     while(miVehiculo!=null){
         String []info=new String[7];
         info[0]=miVehiculo.getPlaca();
         info[1]=miVehiculo.getMarca();
         info[2]=miVehiculo.getModelo();
         info[3]=String.valueOf(miVehiculo.getPesoMaximo());
         info[4]=String.valueOf(miVehiculo.getVolumenMaximo());
         info[5]=String.valueOf(miVehiculo.getCiudad().getNombre());
         info[6]="caracteristicas";
        
         modelo.addRow(info);
         miVehiculo=miVehiculo.getSiguienteVehiculo();
     }
   }


private void mostrarCiudades(){
    DefaultTableModel modelo=new DefaultTableModel();
    modelo.addColumn("Nombre");
    modelo.addColumn("Coordenada en X");
    modelo.addColumn("Coordenada en Y");
    modelo.addColumn("Conectada con");
    modelo.addColumn("Tiempo");
    this.viewCrud.table.setModel(modelo);
    NodoCiudad miCiudad=new NodoCiudad();
    miCiudad=miEmpresas.getMiListaCiudades().getHeadNodo();
     while(miCiudad!=null){
         String []info=new String[7];
         info[0]=miCiudad.getNombre();
         info[1]=String.valueOf(miCiudad.getCoordX());
         info[2]=String.valueOf(miCiudad.getCoordY());
         info[3]=miCiudad.getCiudadEnlace();
         info[4]=String.valueOf(miCiudad.getDistanciaEnlace().getTiempo());
         
        
         modelo.addRow(info);
         miCiudad=miCiudad.getSigNodo();
     }
   }


 //Fin Funciones para mostrar
// Funciones para añadir items al JCombo
    private void addCombo(){
       
       CaracteristicasEspeciales miCarac=new CaracteristicasEspeciales();
       miCarac=miEmpresas.getMiListaCarac().getHeadCaracteristica();
       while(miCarac!=null){
           miViewVehiculos.itemCaract.addItem("");
           miCarac=miCarac.getSiguienteCaracteristica();
       }
    
    }





    
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
    
    //Funcion que valida que solo se ingrese numeros
     

     
     
    //Funcion que valida que se llenen todos los campos
    public void validarVacioVehiculos(String placa, String marca, String modelo, String pesoMax, String volMaximo){
        
        placa=miViewVehiculos.txtPlacaVehiculo.getText();
        marca=miViewVehiculos.txtMarcaVehiculo.getText();
        modelo=miViewVehiculos.txtModeloVehiculo.getText();
        pesoMax=miViewVehiculos.txtPesoMaximoVehiculo.getText();
        volMaximo=miViewVehiculos.txtVolumneMaximoVehiculo.getText();
        
            if(placa.length()==0 || marca.length()==0 || modelo.length()==0 || pesoMax.length()==0 || volMaximo.length()==0){
                JOptionPane.showMessageDialog(null, "Campos incompletos");
                miViewVehiculos.setVisible(true);
                viewCrud.setVisible(false);
            }else{
                miEmpresas.agregarVehiculo(miViewVehiculos.txtPlacaVehiculo.getText(), miViewVehiculos.txtMarcaVehiculo.getText(), miViewVehiculos.txtModeloVehiculo.getText(),Double.parseDouble(miViewVehiculos.txtPesoMaximoVehiculo.getText()), Double.parseDouble(miViewVehiculos.txtVolumneMaximoVehiculo.getText()));
                miViewVehiculos.setVisible(false);
                viewCrud.setVisible(true);
                mostrarVehiculos();
            }    
    }  
    
    public void validarVacioConductores(String nombre, String cedula, String ciudad){
        nombre=miViewIngresoConductores.TxtNombreConductor.getText();
        cedula=miViewIngresoConductores.txtCedulaConductor.getText();
        ciudad=miViewIngresoConductores.txtCiudadReside.getText();
        if(nombre.length()==0||cedula.length()==0||ciudad.length()==0){
                JOptionPane.showMessageDialog(null, "Campos incompletos");
                miViewIngresoConductores.setVisible(true);
                viewCrud.setVisible(false);
        }else{
                miEmpresas.agregarConductor(miViewIngresoConductores.TxtNombreConductor.getText(),Long.parseLong(miViewIngresoConductores.txtCedulaConductor.getText()),miViewIngresoConductores.txtCiudadReside.getText());
                miViewIngresoConductores.setVisible(false);
                viewCrud.setVisible(true);
                mostrarConductores();
        
        }
    }
    
    public void validarVacioClientes(String nombre, String telefono, String correo, String direccion){
        
        nombre=miVentanaIngresoClientes.txtNombreCliente.getText();
        telefono=miVentanaIngresoClientes.txtTelefonoCliente.getText();
        correo=miVentanaIngresoClientes.txtCorreoCliente.getText();
        direccion=miVentanaIngresoClientes.txtDireccionCliente.getText();
        if(nombre.length()==0 || telefono.length()==0 || correo.length()==0 || direccion.length()==0){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
            miVentanaIngresoClientes.setVisible(true);
            viewCrud.setVisible(false);
        }else{
            miEmpresas.agregarCliente(miVentanaIngresoClientes.txtNombreCliente.getText(),Long.parseLong(miVentanaIngresoClientes.txtTelefonoCliente.getText()),miVentanaIngresoClientes.txtCorreoCliente.getText(),miVentanaIngresoClientes.txtDireccionCliente.getText());
            miVentanaIngresoClientes.setVisible(false);
            viewCrud.setVisible(true);
            mostrarClientes();
        } 
    } 

    public void validarVacioCaracteristicas(String nombre, String descripcion){
      
        nombre=miViewCaracteristicas.txtNombreCaracterisitca.getText();
        descripcion=miViewCaracteristicas.txtDescripcionCaract.getText();
        if(nombre.length()==0 || descripcion.length()==0){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
            miViewCaracteristicas.setVisible(true);
            viewCrud.setVisible(false);
        }else{
            miEmpresas.agregarCaracteristica(miViewCaracteristicas.txtNombreCaracterisitca.getText(),miViewCaracteristicas.txtDescripcionCaract.getText());
            miViewCaracteristicas.setVisible(false);
            viewCrud.setVisible(true);
            mostrarCaracteristicas();
        } 
    }
    
    public void validarVacioProductos(String nombre, String unidad, String peso, String volumen){
        
        nombre=miViewIngresoProd.txtNombProd.getText();
        unidad=miViewIngresoProd.txtUnidad.getText();
        peso=miViewIngresoProd.txtPeso.getText();
        volumen=miViewIngresoProd.txtVolum.getText();
        if(nombre.length()==0 || unidad.length()==0 || peso.length()==0 || volumen.length()==0){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
            miViewIngresoProd.setVisible(true);
            viewCrud.setVisible(false);
        }else{
            miEmpresas.agregarProducto(miViewIngresoProd.txtNombProd.getText(),miViewIngresoProd.txtUnidad.getText(), Double.parseDouble(miViewIngresoProd.txtPeso.getText()),Double.parseDouble(miViewIngresoProd.txtVolum.getText()));
            miViewIngresoProd.setVisible(false);
            viewCrud.setVisible(true);
            mostrarCaracteristicas();
        }
    }
    
    //Anadir el evento para las ciudades y los pedidos
    
    public void validarVacioCiudades(String ciudad,String coorX, String coorY,String nombreCiudad,String Tiempo){
        ciudad=miViewCiudades.txtNombreCiudad.getText();
        coorX=miViewCiudades.txtCordenadaX.getText();
        coorY=miViewCiudades.txtCordenadaY.getText();
        nombreCiudad=miViewCiudades.txtCiudadAEnlazar.getText();
        Tiempo=miViewCiudades.txtTiempo.getText();
        
            if(miViewCiudades.ButtonNoCiudad.isSelected()){
                miViewCiudades.txtNombreCiudad.setEnabled(false);
                miViewCiudades.txtTiempo.setEnabled(false); 
            }
        
        
        if(ciudad.length()==0 || coorX.length()==0 || coorY.length()==0){   
            JOptionPane.showMessageDialog(null, "Campos incompletos");
            miViewCiudades.setVisible(true);
            viewCrud.setVisible(false);   
        }else{
            //AQUI VA AGREGAR CIUDAD
            miEmpresas.agregarCiudad(miViewCiudades.txtNombreCiudad.getText(),Integer.parseInt(miViewCiudades.txtCordenadaX.getText()),Integer.parseInt(miViewCiudades.txtCordenadaY.getText()),miViewCiudades.txtCiudadAEnlazar.getText(), Double.parseDouble(miViewCiudades.txtTiempo.getText()),
                    Integer.parseInt(miViewCiudades.txtCoordX.getText()),Integer.parseInt(miViewCiudades.txtCoordY.getText()));
            
            miViewCiudades.setVisible(false);
            viewCrud.setVisible(true);
            //AQUI VA MOSTRAR CIUDADES
            mostrarCiudades();
            
        }
    }
  
    public void dibujar(){
        
        Dibujos elemento = new Dibujos();
        elemento.setMiLista(miEmpresas.getMiListaCiudades());
        elemento.setPreferredSize(miViewDibujo.getSize());
        JPanel panel = new JPanel();  
        
        miViewDibujo.getContentPane().setLayout(new FlowLayout());

       // panel.add(elemento);
       // panel.add(miViewDibujo.btnAtrasDib);
       // miViewDibujo.setContentPane(panel);
        miViewDibujo.getContentPane().add(miViewDibujo.btnAtrasDib);
        miViewDibujo.getContentPane().add(elemento);
        
        miViewDibujo.setVisible(true);
    
    
    }
    public void validarVacioViajes(String cliente, String ciudadO, String ciudadD){
        cliente=miViewViajes.txtClienteConViaje.getText();
        ciudadO=miViewViajes.txtClienteConViaje.getText();
        ciudadD=miViewViajes.txtCiudadDestino.getText();
        
        if(cliente.length()==0 || ciudadO.length()==0 || ciudadD.length()==0){
            JOptionPane.showMessageDialog(null, "Campos incompletos");
            miViewViajes.setVisible(true);
            viewCrud.setVisible(false);
        }else{
            //AQUI VA AGREGAR VIAJE
            miViewViajes.setVisible(false);
            viewCrud.setVisible(true);
            //AQUI VA MOSTRAR VIAJE
        }
    }
    
    //Funciones para limpiar texto en cada ventana
    
    //******CIUDADES
    public void limpiarTextoCiudades(){
        miViewCiudades.txtNombreCiudad.setText("");
        miViewCiudades.txtCordenadaX.setText("");
        miViewCiudades.txtCordenadaY.setText("");
        miViewCiudades.txtCiudadAEnlazar.setText("");
        miViewCiudades.txtTiempo.setText("");
    }
    
    //******VEHICULOS
    public void limpiarTextoVehiculos(){
        miViewVehiculos.txtPlacaVehiculo.setText("");
        miViewVehiculos.txtMarcaVehiculo.setText("");
        miViewVehiculos.txtModeloVehiculo.setText("");
        miViewVehiculos.txtPesoMaximoVehiculo.setText("");
        miViewVehiculos.txtVolumneMaximoVehiculo.setText("");
    }
    
    //******CONDUCTORES
    public void limpiarTextoConductores(){
        miViewIngresoConductores.TxtNombreConductor.setText("");
        miViewIngresoConductores.txtCedulaConductor.setText("");
        miViewIngresoConductores.txtCiudadReside.setText("");
    }
    
    //******CARACTERISTICAS
    public void limpiarTextoCaracteristicas(){
        miViewCaracteristicas.txtNombreCaracterisitca.setText("");
        miViewCaracteristicas.txtDescripcionCaract.setText("");
    }
    
    //******PRODUCTOS
    public void limpiarTextoProductos(){
        miViewIngresoProd.txtNombProd.setText("");
        miViewIngresoProd.txtCaract.setText("");
        miViewIngresoProd.txtPeso.setText("");
        miViewIngresoProd.txtUnidad.setText("");
        miViewIngresoProd.txtVolum.setText("");
    }
    
    //******CONTRATOS
    public void limpiarTextoContratos(){
        miViewViajes.txtCantidadProductosViajes.setText("");
        miViewViajes.txtCiudadDestino.setText("");
        miViewViajes.txtCiudadOrigen.setText("");
        miViewViajes.txtClienteConViaje.setText("");
        miViewViajes.txtDiaViaje.setText("");
        miViewViajes.txtMesViaje.setText("");
        miViewViajes.txtAnioViaje.setText("");
    }

    //******CLIENTES
    public void limpiarTextoClientes(){
        miVentanaIngresoClientes.txtCorreoCliente.setText("");
        miVentanaIngresoClientes.txtDireccionCliente.setText("");
        miVentanaIngresoClientes.txtNombreCliente.setText("");
        miVentanaIngresoClientes.txtTelefonoCliente.setText("");
    }
    
    //Fin de funciones de limpiar texto
    
    
    @Override
    public void keyTyped(KeyEvent e) {   
        char tecla;
        if(miViewVehiculos.txtPesoMaximoVehiculo==e.getSource()|| miViewVehiculos.txtVolumneMaximoVehiculo==e.getSource() || miViewIngresoConductores.txtCedulaConductor==e.getSource() || miViewIngresoProd.txtPeso==e.getSource() || 
            miViewIngresoProd.txtVolum==e.getSource() || miVentanaIngresoClientes.txtTelefonoCliente==e.getSource() || miViewCiudades.txtCordenadaX==e.getSource() || miViewCiudades.txtCordenadaY==e.getSource() || miViewCiudades.txtTiempo==e.getSource() || 
                miViewViajes.txtDiaViaje==e.getSource() || miViewViajes.txtMesViaje==e.getSource() || miViewViajes.txtAnioViaje==e.getSource()){
            tecla=e.getKeyChar();
            if(!Character.isDigit(tecla) && tecla!=KeyEvent.VK_BACK_SPACE){     
            e.consume();
            JOptionPane.showMessageDialog(null,"Caracter no permitido");
            }
        }    
    }    

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {   
    }

 }

    

