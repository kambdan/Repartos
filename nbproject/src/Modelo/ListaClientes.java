
package Modelo;

public class ListaClientes{
    private Clientes headCliente;
    private Clientes tailCliente;

        
   
    //Constructor
    public ListaClientes(){
        this.headCliente=null;
        this.tailCliente=null;
    }
    
    public Clientes getHeadCliente() {
        return headCliente;
    }

    public void setHeadCliente(Clientes headCliente) {
        this.headCliente = headCliente;
    }

    public Clientes getTailCliente() {
        return tailCliente;
    }

    public void setTailCliente(Clientes tailCliente) {
        this.tailCliente = tailCliente;
    }
    
public void agregarCliente(String Nombre, long telefono,String correo, String direccion){
        Clientes nuevoCliente=new Clientes(Nombre,telefono,correo,direccion);
        if(headCliente==null){
            headCliente=nuevoCliente;
            tailCliente=nuevoCliente;
        }else{
            tailCliente.setSiguienteCliente(nuevoCliente);
            tailCliente=nuevoCliente;
        }
        System.out.println(""+tailCliente.getNombre());
    }
    
    public Clientes consultarCliente (ListaClientes miLista, String NombreCliente){
        
        Clientes miCliente;
        miCliente=miLista.headCliente;
        while(miCliente!=null && !miCliente.getNombre().equals(NombreCliente)){
          miCliente=miCliente.getSiguienteCliente();
        }
        if(miCliente==null){
            return miCliente;
        }else{
            return miCliente;
        }
    }
    
}
