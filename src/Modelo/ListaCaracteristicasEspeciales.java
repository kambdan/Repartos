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
public class ListaCaracteristicasEspeciales {
    
    private CaracteristicasEspeciales headCaracteristica;
    private CaracteristicasEspeciales tailCaracteristica;
    
    
    public CaracteristicasEspeciales getHeadCaracteristica() {
        return headCaracteristica;
    }

    public void setHeadCaracteristica(CaracteristicasEspeciales headCaracteristica) {
        this.headCaracteristica = headCaracteristica;
    }

    public CaracteristicasEspeciales getTailCaracterisitca() {
        return tailCaracteristica;
    }

    public void setTailCaracterisitca(CaracteristicasEspeciales tailCaracterisitca) {
        this.tailCaracteristica = tailCaracterisitca;
    }
    
    public ListaCaracteristicasEspeciales agregarCaracteristica(ListaCaracteristicasEspeciales miListaCarac,String caracteristica,String descripcion){
        
        CaracteristicasEspeciales nuevaCaracteristica=new CaracteristicasEspeciales(caracteristica,descripcion);
        if(miListaCarac.getHeadCaracteristica()==null){
            miListaCarac.setHeadCaracteristica(nuevaCaracteristica);
            miListaCarac.setTailCaracterisitca(nuevaCaracteristica);
        }else{
            miListaCarac.getTailCaracterisitca().setSiguienteCaracteristica(nuevaCaracteristica);
            
            miListaCarac.setTailCaracterisitca(nuevaCaracteristica);
        } 
        return miListaCarac;
    }
    
      
}
