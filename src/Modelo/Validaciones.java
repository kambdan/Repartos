/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS ARMIJOS
 */
public class Validaciones {
    private int numero;
    private String cadena;
    
    public Validaciones(String cadena){
    this.cadena=cadena;
    }
    
    public int getValor(){
        int n=1;//bandera de validacion
        do{  //repite hasta que el valor ingresado sea correcto      
        /*try y catch no permite que el programa se detnega cuando una
        linea de codigo presenta un error*/
            try {   //codigo propenso a fallos
                // Convierte un valor de tipo String a int
                numero = Integer.parseInt(cadena);
                n=1;
            }catch(NumberFormatException e) {       //en caso de fallar lo de try muestra mensaje de error 
            n=0;
            JOptionPane.showMessageDialog(null, "Valor incorrecto");
            }
        }while(n==0);   //condicion de error con n=0
        return numero;          //retorno de valor validado
   }
    
    
    
    
}
