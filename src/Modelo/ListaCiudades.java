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
public class ListaCiudades {
    private NodoCiudad headNodo;

    public NodoCiudad getHeadNodo() {
        return headNodo;
    }

    public void setHeadNodo(NodoCiudad headNodo) {
        this.headNodo = headNodo;
    }

    public NodoCiudad getTailNodo() {
        return tailNodo;
    }

    public void setTailNodo(NodoCiudad tailNodo) {
        this.tailNodo = tailNodo;
    }
    private NodoCiudad tailNodo;
  
    
   //este agregas la columna vertical de la lista de adayancencia
    public void agregarCiudad(NodoCiudad miNodo){
        
        if(headNodo==null){
            headNodo=miNodo;
            tailNodo=miNodo;
        }else{
            tailNodo.setSigNodo(miNodo);
            //si es diferente de null  quiere decir que se trata de un grafo
            
            tailNodo=miNodo;
        
        }
    }
    
     public NodoCiudad consultarCiudad(String nombreCiudad){
        
       
        NodoCiudad miNodo;
        miNodo=headNodo;
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
     public void ConectarCiudades(NodoCiudad miNodo,double tiempo){
         String ciudadEnlace=miNodo.getCiudadEnlace();
         if(ciudadEnlace!=null){
                //llamar a una funcion que me consulte el nodo , y en ese momento me conecte
                NodoCiudad nodAux;
                //este me va a devolver el nodo consultado
                nodAux=consultarCiudad(ciudadEnlace);
                //esta añade las listas horizontales
                //ListaCiudadConectadas miLista=new ListaCiudadConectadas();
                //miLista=miNodo.getMiListaConectada();
                
               nodAux.getMiListaConectada().agregarCiudadesConectadas(miNodo,tiempo);
               ///miNodo.getMiListaConectada().agregarCiudadesConectadas(nodAux, tiempo);
               // nodAux.getMiListaConectada().agregarCiudadesConectadas(miNodo, tiempo);
                //agregarCiudadesConectadas(nodAux, tiempo);
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
                 System.out.print("-->"+aux.getNombre()+"("+aux.getDistancia().getTiempo()+")");
                 //System.out.println("tiempo: "+aux.getDistancia().getTiempo());
                 aux=aux.getSigVertice();
             }
             System.out.println(" ");
             nodAux=nodAux.getSigNodo();
         
         }
     
     }
     
     
     //AHORA VAMOS A añadir las ciudades a las que esta conectada una ciuad
     
     
     
    
}
