
package Modelo;


public class Fechas {
    private int dia;
    private int mes;
    private int año;
    private Fechas sigFecha;
    //private Vehiculos vehiculo;

    public Fechas getSigFecha() {
        return sigFecha;
    }

    public void setSigFecha(Fechas sigFecha) {
        this.sigFecha = sigFecha;
    }

    public Fechas(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

   
    private long total;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal() {
        
        this.total = año*365+(mes-1)*30+dia;
        
    }
    
}
