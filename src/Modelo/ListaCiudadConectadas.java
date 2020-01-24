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
public class ListaCiudadConectadas extends NodoCiudad {
    private NodoCiudad headVetice;
    private NodoCiudad tailVertice;
    private int tam;

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
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
    
    
    public void agregarCiudadesConectadas(ListaCiudadConectadas lista,NodoCiudad miNodo){
         
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
         tam++;
     
     }
}
