
package Modelo;

public class Ordenamientos {
    private ListaVehiculos miListaOrdenadaVehiculos;
    private ListaContratos miListaViajesContratados;

    //Metodos contrsuctor
    public Ordenamientos(ListaVehiculos miListaOrdenadaVehiculos){
        this.miListaOrdenadaVehiculos=miListaOrdenadaVehiculos;
    }
    
    public Ordenamientos(ListaContratos miListaViajesContratos){
        this.miListaViajesContratados=miListaViajesContratos;
    }
    
    public ListaVehiculos getMiListaOrdenadaVehiculos() {
        return miListaOrdenadaVehiculos;
    }

    public void setMiListaOrdenadaVehiculos(ListaVehiculos miListaOrdenadaVehiculos) {
        this.miListaOrdenadaVehiculos = miListaOrdenadaVehiculos;
    }
    
    
    public ListaContratos getMiListaViajesContratados() {
        return miListaViajesContratados;
    }

    public void setMiListaViajesContratados(ListaContratos miListaViajesContratados) {
        this.miListaViajesContratados = miListaViajesContratados;
    }
    
    
    //Funciones de metodos para ordenamientos de Vehiculos
    public void heapVehiculos(){
       int posPadre;
       Vehiculos nodoPosPadre=new Vehiculos();
       int posHijoIzquierdo;
       Vehiculos nodoPosHijoIzquierdo=new Vehiculos();
       int posHijoDrecho;
       Vehiculos nodoPosHijoderecho=new Vehiculos();
       int n;
       n=miListaOrdenadaVehiculos.getTamListaVehiculos()-1;
       
       do{
       posPadre=n/2;
       posHijoIzquierdo=2*posPadre+1;
       posHijoDrecho=2*posPadre+2;
       //Se debe obtener cada Nodo
       
          while(posPadre>=0){
          if(posHijoIzquierdo>n &&posHijoDrecho>n){
              //No tiene hijo izquierdo ni hijo derecho se debe pasar a otro  padre
              //No debe comparar con nada porque no tiene hijos
              posPadre=posPadre-1;
              posHijoIzquierdo=2*posPadre+1;
              posHijoDrecho=2*posPadre+2;
              
          }else if(posHijoIzquierdo<=n && posHijoDrecho>n){//quiere decir que solo tiene hijo izquierdo
              nodoPosPadre=devolverNodo(miListaOrdenadaVehiculos,posPadre);
              nodoPosHijoIzquierdo=devolverNodo(miListaOrdenadaVehiculos, posHijoIzquierdo);
              //Debe hacer una comparacion con el hijo izquierdo
              if(nodoPosPadre.getPlaca().compareTo(nodoPosHijoIzquierdo.getPlaca())<0){
                  //Se deben intercambiarVehiculos
                  intercambiarVehiculos(posPadre, posHijoIzquierdo);
                  posPadre=posPadre-1;
                  posHijoIzquierdo=2*posPadre+1;
                  posHijoDrecho=2*posPadre+2;
                  
              }else{//Aqui no deberia hacer nada de intercambios
                  posPadre=posPadre-1;
                  posHijoIzquierdo=2*posPadre+1;
                  posHijoDrecho=2*posPadre+2;
                  
              }
          }else{//Quiere decir que tiene hijo izquierdo y hijo derecho
                //Debe hacer una comparacion con ambos hijos
                //Aqui se debe encontrar el mayor de tres valores(padre,hijoIzquierdo y hijo derecho)
                //Luego intercambiarVehiculos
                nodoPosPadre=devolverNodo(miListaOrdenadaVehiculos,posPadre);
                nodoPosHijoIzquierdo=devolverNodo(miListaOrdenadaVehiculos, posHijoIzquierdo);
                nodoPosHijoderecho=devolverNodo(miListaOrdenadaVehiculos, posHijoDrecho);
                if(nodoPosPadre.getPlaca().compareTo(nodoPosHijoIzquierdo.getPlaca())<0){//Se pregunta si el padre es menor que el hijo izquierdo
                    //Quiere decir que el hijo izquiero es mayor que el padre
                    if(nodoPosHijoIzquierdo.getPlaca().compareTo(nodoPosHijoderecho.getPlaca())>0){
                        //Esto quiere decir que el mayor de los 3 es el hijo izquierdo
                        //Se debe intercambiarVehiculos el padre por el hijo izquierdo
                        intercambiarVehiculos(posPadre, posHijoIzquierdo);
                        posPadre=posPadre-1;
                        posHijoIzquierdo=2*posPadre+1;
                        posHijoDrecho=2*posPadre+2;
                        
                    }else{//Quiere decir que el mayor de los 3 es el hijo derecho
                            //Se debe intercambiarVehiculos el padre por el hijo derecho
                            intercambiarVehiculos(posPadre, posHijoDrecho);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2;
                            
                    }
                    
                }else if(nodoPosPadre.getPlaca().compareTo(nodoPosHijoderecho.getPlaca())<0){//Se pregunta si el padre es menor que el hijo derecho
                    if(nodoPosHijoderecho.getPlaca().compareTo(nodoPosHijoIzquierdo.getPlaca())>0){//Quiere decir que el hijo derecho es el mayor de los 3
                        //Se debe intercambiarVehiculos el padre por el hijo derecho
                            intercambiarVehiculos(posPadre, posHijoDrecho);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2;
                            
                    }else{
                        //Quiere decir que el mayor de los 3 es el hijo Izquierdo
                        //Se debe intercambiarVehiculos el padre por el hijo Izquierdo
                            intercambiarVehiculos(posPadre, posHijoIzquierdo);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2; 
                            
                    }
                    
                }else{//Quiere decir que el padre no es menor que ninguno de sus hijos
                   posPadre=posPadre-1;
                   posHijoIzquierdo=2*posPadre+1;
                   posHijoDrecho=2*posPadre+2;
                   
                }
                
            }//Fin del primer If
          
          }//Fin del While
          //Hay que intercambiarVehiculos el primer elemento del arreglo con el ultimo
           intercambiarVehiculos(0, n);
           n=n-1;
       }while(n!=0);
   }

    //Funcion que intercambia valores en un arreglo
    public void intercambiarVehiculos(int posPadre,int posHijoMayor){
        Vehiculos nodoPosPadre=new Vehiculos();
        Vehiculos nodoPoshijoMayor=new Vehiculos();
        nodoPosPadre=devolverNodo(miListaOrdenadaVehiculos, posPadre);
        nodoPoshijoMayor=devolverNodo(miListaOrdenadaVehiculos, posHijoMayor);
        String aux;
        aux=nodoPosPadre.getPlaca();//Toma el valor del padre
        nodoPosPadre.setPlaca(nodoPoshijoMayor.getPlaca());
        nodoPoshijoMayor.setPlaca(aux);
    }
    
    //Metodos para El ordenamiento QuickSort
    public void  ordenarQuickSortVehiculos(ListaVehiculos miLista,int primero, int ultimo) {//Cualquier lista de cualquier tipo, primero igual a cero, ultimo igual a tamano -1
        int pivote;
        if(primero<ultimo){
            pivote=obtener_pivoteVehiculos(miLista, primero, ultimo);
            ordenarQuickSortVehiculos(miLista, primero, pivote-1);
            ordenarQuickSortVehiculos(miLista, pivote+1,ultimo);

        }

    }
    //no olvidar de Modifciar Todos los datos(ahora se esta ordenando segun la placa pero los datos de cada vehiculo tambien deben cambiar
    public  int obtener_pivoteVehiculos(ListaVehiculos miLista,int primero, int ultimo){
        String aux_intercambio;
        String aux_comparacion;
        int i,j;
        Vehiculos AuxNodoUltimo=new Vehiculos();
        Vehiculos auxNodoi=new Vehiculos();
        Vehiculos auxNodoi1=new Vehiculos();
        Vehiculos auxNodoj=new Vehiculos();
        AuxNodoUltimo=devolverNodo(miLista, ultimo);
        aux_comparacion=AuxNodoUltimo.getPlaca();
        i=primero-1;
        for(j=primero;j<=ultimo-1;j++){
            auxNodoj=devolverNodo(miLista, j);
            if(auxNodoj.getPlaca().compareTo(aux_comparacion)<=0){
                i++;
                aux_intercambio=devolverNodo(miLista, i).getPlaca();
                auxNodoi=devolverNodo(miLista, i);
                auxNodoi.setPlaca(auxNodoj.getPlaca());
                auxNodoj.setPlaca(aux_intercambio);
             }
        }
        aux_intercambio=devolverNodo(miLista, i+1).getPlaca();
        auxNodoi1=devolverNodo(miLista, i+1);
        auxNodoi1.setPlaca(AuxNodoUltimo.getPlaca());
        AuxNodoUltimo.setPlaca(aux_intercambio);
        return(i+1);
    }
    //Fin de funciones de Ordenamiento para el vehiculo
    
    //Funciones para los contratos
    
    
    
    
    //Fin funciones de ordenamiento para los contratos
    //Funcion paa devolver un Nodo de tipo vehiculos especifico de una lista
    public Vehiculos devolverNodo(ListaVehiculos miLista,int pos){//Va a recibir lista y la posicion del nodo que desea devolver
      Vehiculos auxNodo=new Vehiculos();
      auxNodo=miLista.getHeadVehiculos();
      for(int i=0; i<pos; i++){
          auxNodo=auxNodo.getSiguienteVehiculo();
      }
      return auxNodo;
    }
}
