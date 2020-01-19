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
    public Dibujos(){
        setBackground(Color.CYAN);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int anch=40;
        int alto=40;
        g.drawOval(0, 0, anch, alto);
    
    }
}
