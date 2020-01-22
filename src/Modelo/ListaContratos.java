/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author CARLOS ARMIJOS
 */
public class ListaContratos {
    
    private Contratos headContratos;
    private Contratos tailContratos;
    private int tamlistaContratos;

    public int getTamlistaContratos() {
        return tamlistaContratos;
    }

    public void setTamlistaContratos(int tamlistaContratos) {
        this.tamlistaContratos = tamlistaContratos;
    }
    public Contratos getHeadContratos() {
        return headContratos;
    }

    public void setHeadContratos(Contratos headContratos) {
        this.headContratos = headContratos;
    }

    public Contratos getTailContratos() {
        return tailContratos;
    }

    public void setTailContratos(Contratos tailContratos) {
        this.tailContratos = tailContratos;
    }
    
    
    
    
    
    
}
