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
public class Enlaces {
    private double tiempo;
    private NodoCiudad nodoCiudad;
    
    
    public Enlaces(){
    
    }
    public Enlaces(String name,int x,int y,double tiempo){
        nodoCiudad=new NodoCiudad();
        nodoCiudad.setNombre(name);
        nodoCiudad.setCoordX(x);
        nodoCiudad.setCoordY(y);
        this.tiempo=tiempo;
    }
    
    public NodoCiudad getNodoCiudad() {
        return nodoCiudad;
    }

    public void setNodoCiudad(NodoCiudad nodoCiudad) {
        this.nodoCiudad = nodoCiudad;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
}
