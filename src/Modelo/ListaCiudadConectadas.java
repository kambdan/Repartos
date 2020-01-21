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
public class ListaCiudadConectadas {
    private NodoCiudad headVetice;
    private NodoCiudad tailVertice;
    public NodoCiudad getHeadVetice() {
        return headVetice;
    }

    public void setHeadVetice(NodoCiudad headVetice) {
        this.headVetice = headVetice;
    }

    public NodoCiudad getTailVertice() {
        return tailVertice;
    }

    public void setTailVertice(NodoCiudad tailVertice) {
        this.tailVertice = tailVertice;
    }
    
    
    public void agregarCiudadesConectadas(NodoCiudad miNodo){
         
         if(headVetice==null){
             headVetice=miNodo;
             tailVertice=miNodo;
             
             //conecttamos la cabeza con la distancia ,eso quiere decir
             //que la raiz ssabe cuanto tiempo tendrá con el siguiente nodo
             //mirar dibujo 
             
            
         }else{
             tailVertice.setSigVertice(miNodo);
             tailVertice=miNodo;
             
             
         }
         
     
     }
}
