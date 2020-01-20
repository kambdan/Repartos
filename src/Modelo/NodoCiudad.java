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
public class NodoCiudad {
  private NodoCiudad sigVertice;
   private NodoCiudad sigNodo;
   private Enlaces distancia;
   private String nombre;
   private int coordX;
   private int coordY;
   private String ciudadEnlace;
   private ListaCiudadConectadas miListaConectada;

    public ListaCiudadConectadas getMiListaConectada() {
        return miListaConectada;
    }

    public void setMiListaConectada(ListaCiudadConectadas miListaConectada) {
        this.miListaConectada = miListaConectada;
    }

    public NodoCiudad(String nombre, int coordX, int coordY, String ciudadEnlace) {
        this.nombre = nombre;
        this.coordX = coordX;
        this.coordY = coordY;
        this.ciudadEnlace = ciudadEnlace;
        miListaConectada=new ListaCiudadConectadas();
    }
    public NodoCiudad(){
    
    }

    public Enlaces getDistancia() {
        return distancia;
    }

    public void setDistancia(Enlaces distancia) {
        this.distancia = distancia;
    }
  
    public NodoCiudad getSigVertice() {
        return sigVertice;
    }

    public void setSigVertice(NodoCiudad sigVertice) {
        this.sigVertice = sigVertice;
    }

    public NodoCiudad getSigNodo() {
        return sigNodo;
    }

    public void setSigNodo(NodoCiudad sigNodo) {
        this.sigNodo = sigNodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getCiudadEnlace() {
        return ciudadEnlace;
    }

    public void setCiudadEnlace(String ciudadEnlace) {
        this.ciudadEnlace = ciudadEnlace;
    }
   
   
}
