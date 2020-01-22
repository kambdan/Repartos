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
public class Contratos {
    
    private String ciudadDestino;
    private Fechas fechaContrato;

    public Fechas getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Fechas fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    private Contratos siguienteContrato;
    private ListaProductos miLista;

    public ListaProductos getMiLista() {
        return miLista;
    }

    public void setMiLista(ListaProductos miLista) {
        this.miLista = miLista;
    }
    
    public Contratos(String ciudadDestino, int dia, int mes, int ano,ListaProductos miLista) {
        this.ciudadDestino = ciudadDestino;
        fechaContrato.setAño(ano);
        fechaContrato.setMes(mes);
        fechaContrato.setDia(dia);
        this.miLista=miLista;
        this.siguienteContrato=null;
    }
    
    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    
    
    public Contratos getSiguienteContrato() {
        return siguienteContrato;
    }

    public void setSiguienteContrato(Contratos siguienteContrato) {
        this.siguienteContrato = siguienteContrato;
    }
    
    
    void alquilarViaje(){}
    void transportar(){}
    void solicitarProducto(){}
    void calcular(){}   //calcula el peso y volumentootal del paquete
    
    
}
