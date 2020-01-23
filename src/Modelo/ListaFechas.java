
package Modelo;

public class ListaFechas {
    private Fechas headFecha;
    private Fechas tailFecha;
    

    
    public Fechas getHeadFecha() {
        return headFecha;
    }

    public void setHeadFecha(Fechas headFecha) {
        this.headFecha = headFecha;
    }

    public Fechas getTailFecha() {
        return tailFecha;
    }

    public void setTailFecha(Fechas tailFecha) {
        this.tailFecha = tailFecha;
    }
    
    
    
    public void agregarFechas(int dia,int mes,int año){
        
        Fechas fecha=new Fechas(dia, mes, año);
        
        if(headFecha==null){
            
            headFecha=fecha;
            tailFecha=fecha;
        }else{
            tailFecha.setSigFecha(fecha);
            tailFecha=fecha;
            
        }
    }
    
     public void eliminarFecha(Fechas fecha){

	if(headFecha!=null){
		Fechas auxBorrar;
		Fechas anterior=null;
		auxBorrar=headFecha;
		while((auxBorrar!=null)&&(auxBorrar!=fecha)){
			anterior=auxBorrar;
			auxBorrar=auxBorrar.getSigFecha();

		}
		if(auxBorrar==null){
                    System.out.println("ELEMENTO NO EXISTE");
		}else{
                    
                    if(anterior==null){//para eliminar el primer elemento de la lista
			
                        
                        headFecha=headFecha.getSigFecha();
			auxBorrar=null;
                    }else{//cualquier elemento que se vaya a borrar
			anterior.setSigFecha(auxBorrar.getSigFecha());
                       
			auxBorrar=null;
                    }
                    System.out.println("ELIMINADO CON EXITO");
		}
	}
    }
    
    
    
}
