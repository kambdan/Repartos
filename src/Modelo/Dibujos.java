/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author STRIX
 */
public class Dibujos extends JPanel{
 private int diametro = 50;
 private String ciudad;
 private int x,y;
 private ListaCiudades miLista;
//Dibujar un óvalo del diámetro especificado

    public ListaCiudades getMiLista() {
        return miLista;
    }

    public void setMiLista(ListaCiudades miLista) {
        this.miLista = miLista;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getX() {
        return x;
    }
   

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        NodoCiudad nodAux=new NodoCiudad();
        nodAux=miLista.getHeadNodo();
        while(nodAux!=null){
            g.setColor(Color.red);
            
            g.drawString(nodAux.getNombre(),nodAux.getCoordX(),nodAux.getCoordY());
            g.setColor(Color.BLACK);
            g.fillOval(nodAux.getCoordX(),nodAux.getCoordY(), diametro, diametro);
            if(nodAux.getCiudadEnlace().equals("cuenca")){
                
              g.drawLine (10+diametro/2, 10+diametro/2, nodAux.getCoordX()+diametro/2, nodAux.getCoordY()+diametro/2);
              int x1,x0,y0,y1;
              int k=20;
              x0=(int) (nodAux.getCoordX());
              x1=10+diametro;
              y0=(int) (nodAux.getCoordY());
              y1=10+diametro;
              double alfa=Math.atan2(y1-y0,x1-x0);
              int xa=(int)(x1-k*Math.cos(alfa+1));
              int ya=(int)(y1-k*Math.sin(alfa+1));
                // Se dibuja un extremo de la dirección de la flecha.
                int raiz=(int) (Math.pow(1/2*diametro*diametro,1/2)-diametro/2);
              g.drawLine(xa,ya,x1,y1);
              xa=(int)(x1-k*Math.cos(alfa-1));
              ya=(int)(y1-k*Math.sin(alfa-1));
                // Se dibuja el otro extremo de la dirección de la flecha.
                
              g.drawLine(xa,ya,x1,y1);
              //+Math.pow(1/2*diametro*diametro,1/2)-diametro/2
              //+Math.pow(1/2*diametro*diametro,1/2)-diametro/2
            }
            nodAux=nodAux.getSigNodo();
        }
        
    }

    
    
    
    
    
    
//Validar y establecer el diámetro, después pintar nuevamente

    public void setDiametro(int nuevoDiametro) {
//Si el diámetro es inválido, usar valor predeterminado
        this.diametro = nuevoDiametro >= 0 ? nuevoDiametro : 10;
        repaint();
    }
//Utilizado por el administrador de esquema para determinar el tamaño preferido

    
    
}
