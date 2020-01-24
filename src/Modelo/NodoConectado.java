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
public class NodoConectado extends NodoCiudad{
    
    NodoConectado sigVertice;

    public NodoConectado(String nombre, int coordX, int coordY, String ciudadEnlace, int x1, int y1, double t) {
        super(nombre, coordX, coordY, ciudadEnlace, x1, y1, t);
        
    }

    public NodoConectado getSigVertice() {
        return sigVertice;
    }

    public void setSigVertice(NodoConectado sigVertice) {
        this.sigVertice = sigVertice;
    }
}
