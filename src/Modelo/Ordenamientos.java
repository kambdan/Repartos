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
    
    
    //********************Funciones de metodos para ordenamientos de Vehiculos
    //InicioHeap
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
    public void intercambiarVehiculos(int posPadre,int posHijoMayor){
        Vehiculos nodoPosPadre=new Vehiculos();
        Vehiculos nodoPoshijoMayor=new Vehiculos();
        nodoPosPadre=devolverNodo(miListaOrdenadaVehiculos, posPadre);
        nodoPoshijoMayor=devolverNodo(miListaOrdenadaVehiculos, posHijoMayor);
        Vehiculos aux=new Vehiculos();
        aux=nodoPosPadre;//Toma el valor del padre
        nodoPosPadre.setPlaca(nodoPoshijoMayor.getPlaca());
        nodoPosPadre.setMarca(nodoPoshijoMayor.getMarca());
        nodoPosPadre.setModelo(nodoPoshijoMayor.getModelo());
        nodoPosPadre.setCiudad(nodoPoshijoMayor.getCiudad());
        nodoPosPadre.setPesoMaximo(nodoPoshijoMayor.getPesoMaximo());
        nodoPosPadre.setVolumenMaximo(nodoPoshijoMayor.getVolumenMaximo());
        nodoPosPadre.setCaracteristicasVehiculo(nodoPoshijoMayor.getCaracteristicasVehiculo());
        nodoPosPadre.setListaFechas(nodoPoshijoMayor.getListaFechas());
        nodoPoshijoMayor.setPlaca(aux.getPlaca());
        nodoPoshijoMayor.setMarca(aux.getMarca());
        nodoPoshijoMayor.setModelo(aux.getModelo());
        nodoPoshijoMayor.setCiudad(aux.getCiudad());
        nodoPoshijoMayor.setPesoMaximo(aux.getPesoMaximo());
        nodoPoshijoMayor.setVolumenMaximo(aux.getVolumenMaximo());
        nodoPoshijoMayor.setCaracteristicasVehiculo(aux.getCaracteristicasVehiculo());
        nodoPoshijoMayor.setListaFechas(aux.getListaFechas());
    }
    //Fin HeapSort
    
    //Metodos para El ordenamiento QuickSort
    public void  ordenarQuickSortVehiculos(ListaVehiculos miLista,int primero, int ultimo) {//Cualquier lista de cualquier tipo, primero igual a cero, ultimo igual a tamano -1
        int pivote;
        if(primero<ultimo){
            pivote=obtener_pivoteVehiculos(miLista, primero, ultimo);
            ordenarQuickSortVehiculos(miLista, primero, pivote-1);
            ordenarQuickSortVehiculos(miLista, pivote+1,ultimo);

        }

    }
    public  int obtener_pivoteVehiculos(ListaVehiculos miLista,int primero, int ultimo){
        Vehiculos aux_intercambio=new Vehiculos();
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
                aux_intercambio=devolverNodo(miLista, i);
                auxNodoi=devolverNodo(miLista, i);
                auxNodoi.setPlaca(auxNodoj.getPlaca());
                auxNodoi.setMarca(auxNodoj.getMarca());
                auxNodoi.setModelo(auxNodoj.getModelo());
                auxNodoi.setCiudad(auxNodoj.getCiudad());
                auxNodoi.setPesoMaximo(auxNodoj.getPesoMaximo());
                auxNodoi.setVolumenMaximo(auxNodoj.getVolumenMaximo());
                auxNodoi.setCaracteristicasVehiculo(auxNodoj.getCaracteristicasVehiculo());
                auxNodoi.setListaFechas(auxNodoj.getListaFechas());
                auxNodoj.setPlaca(aux_intercambio.getPlaca());
                auxNodoj.setMarca(aux_intercambio.getMarca());
                auxNodoj.setModelo(aux_intercambio.getModelo());
                auxNodoj.setCiudad(aux_intercambio.getCiudad());
                auxNodoj.setPesoMaximo(aux_intercambio.getPesoMaximo());
                auxNodoj.setVolumenMaximo(aux_intercambio.getVolumenMaximo());
                auxNodoj.setCaracteristicasVehiculo(aux_intercambio.getCaracteristicasVehiculo());
                auxNodoj.setListaFechas(aux_intercambio.getListaFechas());
             }
        }
        aux_intercambio=devolverNodo(miLista, i+1);
        auxNodoi1=devolverNodo(miLista, i+1);
        auxNodoi1.setPlaca(AuxNodoUltimo.getPlaca());
        auxNodoi1.setMarca(AuxNodoUltimo.getMarca());
        auxNodoi1.setModelo(AuxNodoUltimo.getModelo());
        auxNodoi1.setCiudad(AuxNodoUltimo.getCiudad());
        auxNodoi1.setPesoMaximo(AuxNodoUltimo.getPesoMaximo());
        auxNodoi1.setVolumenMaximo(AuxNodoUltimo.getVolumenMaximo());
        auxNodoi1.setCaracteristicasVehiculo(AuxNodoUltimo.getCaracteristicasVehiculo());
        auxNodoi1.setListaFechas(AuxNodoUltimo.getListaFechas());
        AuxNodoUltimo.setPlaca(aux_intercambio.getPlaca());
        AuxNodoUltimo.setMarca(aux_intercambio.getMarca());
        AuxNodoUltimo.setModelo(aux_intercambio.getModelo());
        AuxNodoUltimo.setCiudad(aux_intercambio.getCiudad());
        AuxNodoUltimo.setPesoMaximo(aux_intercambio.getPesoMaximo());
        AuxNodoUltimo.setVolumenMaximo(aux_intercambio.getVolumenMaximo());
        AuxNodoUltimo.setCaracteristicasVehiculo(aux_intercambio.getCaracteristicasVehiculo());
        AuxNodoUltimo.setListaFechas(aux_intercambio.getListaFechas());
        return(i+1);
    }
    //----------------------------Fin quickSort
    
    //COMIENZO DEL MERGESORT
    public void ordenarMergeSortVehiculos(ListaVehiculos miLista, int inicio, int fin){        

        if (fin <= inicio) return;
        
        int mitad=(inicio+fin)/2;

        ordenarMergeSortVehiculos(miLista, inicio, mitad);
        ordenarMergeSortVehiculos(miLista, mitad+1, fin);
        mergeVehiculos(miLista,inicio,mitad,fin);
        
    }
    public void mergeVehiculos(ListaVehiculos array, int inicio, int mitad, int fin){
    ListaVehiculos leftArray = new ListaVehiculos();//[mitad - inicio + 1];
    ListaVehiculos rightArray = new ListaVehiculos();//[fin - mitad];
    Vehiculos auxiliar=new Vehiculos();
    Vehiculos nodoindiceIzquierdo=new Vehiculos();
    Vehiculos nodoindiceDerecho=new Vehiculos();
    // Copying our subarrays into temporaries
    for (int i = 0; i < mitad - inicio + 1; i++){
        auxiliar=devolverNodo(array, inicio+i);
        leftArray.agregarVehiculo(leftArray,auxiliar);
    }
    for (int i = 0; i < fin - mitad; i++){
        auxiliar=devolverNodo(array, mitad + i + 1);
        rightArray.agregarVehiculo(rightArray,auxiliar);
    }    
    // Iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // Copying from leftArray and rightArray back into array
    for (int i = inicio; i < fin + 1; i++) {
        // If there are still uncopied elements in R and L, copy minimum of the two
            nodoindiceIzquierdo=devolverNodo(leftArray, leftIndex);
            nodoindiceDerecho=devolverNodo(rightArray, rightIndex);
            Vehiculos nodoIntercambio=new Vehiculos();
        if (leftIndex < mitad - inicio + 1 && rightIndex < fin - mitad) {
           
            
            if (nodoindiceIzquierdo.getPlaca().compareTo( nodoindiceDerecho.getPlaca()) < 0) {
                nodoIntercambio=array.getHeadVehiculos();
               for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteVehiculo();
               }
               nodoIntercambio.setPlaca(nodoindiceIzquierdo.getPlaca());
               nodoIntercambio.setMarca(nodoindiceIzquierdo.getMarca());
               nodoIntercambio.setModelo(nodoindiceIzquierdo.getModelo());
               nodoIntercambio.setCiudad(nodoindiceIzquierdo.getCiudad());
               nodoIntercambio.setPesoMaximo(nodoindiceIzquierdo.getPesoMaximo());
               nodoIntercambio.setVolumenMaximo(nodoindiceIzquierdo.getVolumenMaximo());
               nodoIntercambio.setCaracteristicasVehiculo(nodoindiceIzquierdo.getCaracteristicasVehiculo());
               nodoIntercambio.setListaFechas(nodoindiceIzquierdo.getListaFechas());
               leftIndex++;
            } else {
                nodoIntercambio=array.getHeadVehiculos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteVehiculo();
               }
                nodoIntercambio.setPlaca(nodoindiceDerecho.getPlaca());
                nodoIntercambio.setMarca(nodoindiceDerecho.getMarca());
                nodoIntercambio.setModelo(nodoindiceDerecho.getModelo());
                nodoIntercambio.setCiudad(nodoindiceDerecho.getCiudad());
                nodoIntercambio.setPesoMaximo(nodoindiceDerecho.getPesoMaximo());
                nodoIntercambio.setVolumenMaximo(nodoindiceDerecho.getVolumenMaximo());
                nodoIntercambio.setCaracteristicasVehiculo(nodoindiceDerecho.getCaracteristicasVehiculo());
                nodoIntercambio.setListaFechas(nodoindiceDerecho.getListaFechas());
                rightIndex++;
            }
        } else if (leftIndex < mitad - inicio + 1) {
            // If all elements have been copied from rightArray, copy rest of leftArray
                nodoIntercambio=array.getHeadVehiculos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteVehiculo();
               }
                nodoIntercambio.setPlaca(nodoindiceIzquierdo.getPlaca());
                nodoIntercambio.setMarca(nodoindiceIzquierdo.getMarca());
                nodoIntercambio.setModelo(nodoindiceIzquierdo.getModelo());
                nodoIntercambio.setCiudad(nodoindiceIzquierdo.getCiudad());
                nodoIntercambio.setPesoMaximo(nodoindiceIzquierdo.getPesoMaximo());
                nodoIntercambio.setVolumenMaximo(nodoindiceIzquierdo.getVolumenMaximo());
                nodoIntercambio.setCaracteristicasVehiculo(nodoindiceIzquierdo.getCaracteristicasVehiculo());
                nodoIntercambio.setListaFechas(nodoindiceIzquierdo.getListaFechas());
                leftIndex++;
        } else if (rightIndex < fin - mitad) {
            // If all elements have been copied from leftArray, copy rest of rightArray
                nodoIntercambio=array.getHeadVehiculos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteVehiculo();
               }
                nodoIntercambio.setPlaca(nodoindiceDerecho.getPlaca());
                nodoIntercambio.setMarca(nodoindiceDerecho.getMarca());
                nodoIntercambio.setModelo(nodoindiceDerecho.getModelo());
                nodoIntercambio.setCiudad(nodoindiceDerecho.getCiudad());
                nodoIntercambio.setPesoMaximo(nodoindiceDerecho.getPesoMaximo());
                nodoIntercambio.setVolumenMaximo(nodoindiceDerecho.getVolumenMaximo());
                nodoIntercambio.setCaracteristicasVehiculo(nodoindiceDerecho.getCaracteristicasVehiculo());
                nodoIntercambio.setListaFechas(nodoindiceDerecho.getListaFechas());
            rightIndex++;
        }
    }
}
    //Fin MergSort
  //***************************************************************Fin de funciones de Ordenamiento para el vehiculo
    
    //*******************Funciones de Ordenamientos para los contratos segun la ciudad destino
        //Inicio heapSort
    public void heapContratos(){
       int posPadre;
       Contratos nodoPosPadre=new Contratos();
       int posHijoIzquierdo;
       Contratos nodoPosHijoIzquierdo=new Contratos();
       int posHijoDrecho;
       Contratos nodoPosHijoderecho=new Contratos();
       int n;
       n=miListaViajesContratados.getTamlistaContratos()-1;
       
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
              nodoPosPadre=devolverNodoContratos(miListaViajesContratados,posPadre);
              nodoPosHijoIzquierdo=devolverNodoContratos(miListaViajesContratados, posHijoIzquierdo);
              //Debe hacer una comparacion con el hijo izquierdo
              if(nodoPosPadre.getCiudadDestino().getNombre().compareTo(nodoPosHijoIzquierdo.getCiudadDestino().getNombre())<0){
                  //Se deben intercambiarVehiculos
                  intercambiarContratos(posPadre, posHijoIzquierdo);
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
                nodoPosPadre=devolverNodoContratos(miListaViajesContratados,posPadre);
                nodoPosHijoIzquierdo=devolverNodoContratos(miListaViajesContratados, posHijoIzquierdo);
                nodoPosHijoderecho=devolverNodoContratos(miListaViajesContratados, posHijoDrecho);
                if(nodoPosPadre.getCiudadDestino().getNombre().compareTo(nodoPosHijoIzquierdo.getCiudadDestino().getNombre())<0){//Se pregunta si el padre es menor que el hijo izquierdo
                    //Quiere decir que el hijo izquiero es mayor que el padre
                    if(nodoPosHijoIzquierdo.getCiudadDestino().getNombre().compareTo(nodoPosHijoderecho.getCiudadDestino().getNombre())>0){
                        //Esto quiere decir que el mayor de los 3 es el hijo izquierdo
                        //Se debe intercambiarVehiculos el padre por el hijo izquierdo
                        intercambiarContratos(posPadre, posHijoIzquierdo);
                        posPadre=posPadre-1;
                        posHijoIzquierdo=2*posPadre+1;
                        posHijoDrecho=2*posPadre+2;
                        
                    }else{//Quiere decir que el mayor de los 3 es el hijo derecho
                            //Se debe intercambiarVehiculos el padre por el hijo derecho
                            intercambiarContratos(posPadre, posHijoDrecho);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2;
                            
                    }
                    
                }else if(nodoPosPadre.getCiudadDestino().getNombre().compareTo(nodoPosHijoderecho.getCiudadDestino().getNombre())<0){//Se pregunta si el padre es menor que el hijo derecho
                    if(nodoPosHijoderecho.getCiudadDestino().getNombre().compareTo(nodoPosHijoIzquierdo.getCiudadDestino().getNombre())>0){//Quiere decir que el hijo derecho es el mayor de los 3
                        //Se debe intercambiarVehiculos el padre por el hijo derecho
                            intercambiarContratos(posPadre, posHijoDrecho);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2;
                            
                    }else{
                        //Quiere decir que el mayor de los 3 es el hijo Izquierdo
                        //Se debe intercambiarVehiculos el padre por el hijo Izquierdo
                            intercambiarContratos(posPadre, posHijoIzquierdo);
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
    public void intercambiarContratos(int posPadre,int posHijoMayor){
        Contratos nodoPosPadre=new Contratos();
        Contratos nodoPoshijoMayor=new Contratos();
        nodoPosPadre=devolverNodoContratos(miListaViajesContratados, posPadre);
        nodoPoshijoMayor=devolverNodoContratos(miListaViajesContratados, posHijoMayor);
        Contratos aux=new Contratos();
        aux=nodoPosPadre;//Toma el valor del padre
        nodoPosPadre.getFechaContrato().setDia(nodoPoshijoMayor.getFechaContrato().getDia());
        nodoPosPadre.getFechaContrato().setMes(nodoPoshijoMayor.getFechaContrato().getMes());
        nodoPosPadre.getFechaContrato().setAño(nodoPoshijoMayor.getFechaContrato().getAño());
        nodoPosPadre.setCiudadDestino(nodoPoshijoMayor.getCiudadDestino());
        nodoPosPadre.setMiLista(nodoPoshijoMayor.getMiLista());
        nodoPoshijoMayor.getFechaContrato().setDia(aux.getFechaContrato().getDia());
        nodoPoshijoMayor.getFechaContrato().setMes(aux.getFechaContrato().getMes());
        nodoPoshijoMayor.getFechaContrato().setAño(aux.getFechaContrato().getAño());
        nodoPoshijoMayor.setCiudadDestino(aux.getCiudadDestino());
        nodoPoshijoMayor.setMiLista(aux.getMiLista());
    }
            //Fin del metodo heapsort
    
        //****Metodos para El ordenamiento QuickSort para una lista de contratos
    public void  ordenarQuickSortContratos(ListaContratos miLista,int primero, int ultimo) {//Cualquier lista de cualquier tipo, primero igual a cero, ultimo igual a tamano -1
        int pivote;
        if(primero<ultimo){
            pivote=obtener_pivoteContratos(miLista, primero, ultimo);
            ordenarQuickSortContratos(miLista, primero, pivote-1);
            ordenarQuickSortContratos(miLista, pivote+1,ultimo);

        }

    }
    public  int obtener_pivoteContratos(ListaContratos miLista,int primero, int ultimo){
        Contratos aux_intercambio=new Contratos();
        String aux_comparacion;
        int i,j;
        Contratos AuxNodoUltimo=new Contratos();
        Contratos auxNodoi=new Contratos();
        Contratos auxNodoi1=new Contratos();
        Contratos auxNodoj=new Contratos();
        AuxNodoUltimo=devolverNodoContratos(miLista, ultimo);
        aux_comparacion=AuxNodoUltimo.getCiudadDestino().getNombre();
        i=primero-1;
        for(j=primero;j<=ultimo-1;j++){
            auxNodoj=devolverNodoContratos(miLista, j);
            if(auxNodoj.getCiudadDestino().getNombre().compareTo(aux_comparacion)<=0){
                i++;
                aux_intercambio=devolverNodoContratos(miLista, i);
                auxNodoi=devolverNodoContratos(miLista, i);
                auxNodoi.setCiudadDestino(auxNodoj.getCiudadDestino());
                auxNodoi.getFechaContrato().setDia(auxNodoj.getFechaContrato().getDia());
                auxNodoi.getFechaContrato().setMes(auxNodoj.getFechaContrato().getMes());
                auxNodoi.getFechaContrato().setAño(auxNodoj.getFechaContrato().getAño());
                auxNodoi.setMiLista(auxNodoj.getMiLista());
                auxNodoj.setCiudadDestino(aux_intercambio.getCiudadDestino());
                auxNodoj.getFechaContrato().setDia(aux_intercambio.getFechaContrato().getDia());
                auxNodoj.getFechaContrato().setMes(aux_intercambio.getFechaContrato().getMes());
                auxNodoj.getFechaContrato().setAño(aux_intercambio.getFechaContrato().getAño());
                auxNodoj.setMiLista(aux_intercambio.getMiLista());
             }
        }
        aux_intercambio=devolverNodoContratos(miLista, i+1);
        auxNodoi1=devolverNodoContratos(miLista, i+1);
        auxNodoi1.setCiudadDestino(AuxNodoUltimo.getCiudadDestino());
        auxNodoi1.getFechaContrato().setDia(AuxNodoUltimo.getFechaContrato().getDia());
        auxNodoi1.getFechaContrato().setMes(AuxNodoUltimo.getFechaContrato().getMes());
        auxNodoi1.getFechaContrato().setAño(AuxNodoUltimo.getFechaContrato().getAño());
        auxNodoi1.setMiLista(AuxNodoUltimo.getMiLista());
        AuxNodoUltimo.setCiudadDestino(aux_intercambio.getCiudadDestino());
        AuxNodoUltimo.getFechaContrato().setDia(aux_intercambio.getFechaContrato().getDia());
        AuxNodoUltimo.getFechaContrato().setMes(aux_intercambio.getFechaContrato().getMes());
        AuxNodoUltimo.getFechaContrato().setAño(aux_intercambio.getFechaContrato().getAño());
        AuxNodoUltimo.setMiLista(aux_intercambio.getMiLista());      
        return(i+1);
    }
    //-------------Fin quickSort Contratos
    
        //InicioMergsort
    public void ordenarMergeSortContratos(ListaContratos miLista, int inicio, int fin){        

        if (fin <= inicio) return;
        
        int mitad=(inicio+fin)/2;

        ordenarMergeSortContratos(miLista, inicio, mitad);
        ordenarMergeSortContratos(miLista, mitad+1, fin);
        mergeContratos(miLista,inicio,mitad,fin);
        
    } 
    public void mergeContratos(ListaContratos array, int inicio, int mitad, int fin){
    ListaContratos leftArray = new ListaContratos();//[mitad - inicio + 1];
    ListaContratos rightArray = new ListaContratos();//[fin - mitad];
    Contratos auxiliar=new Contratos();
    Contratos nodoindiceIzquierdo=new Contratos();
    Contratos nodoindiceDerecho=new Contratos();
    // Copying our subarrays into temporaries
    for (int i = 0; i < mitad - inicio + 1; i++){
        auxiliar=devolverNodoContratos(array, inicio+i);
        leftArray.agregarContrato(leftArray,auxiliar);
    }
    for (int i = 0; i < fin - mitad; i++){
        auxiliar=devolverNodoContratos(array, mitad + i + 1);
        rightArray.agregarContrato(rightArray,auxiliar);
    }    
    // Iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // Copying from leftArray and rightArray back into array
    for (int i = inicio; i < fin + 1; i++) {
        // If there are still uncopied elements in R and L, copy minimum of the two
            nodoindiceIzquierdo=devolverNodoContratos(leftArray, leftIndex);
            nodoindiceDerecho=devolverNodoContratos(rightArray, rightIndex);
            Contratos nodoIntercambio=new Contratos();
        if (leftIndex < mitad - inicio + 1 && rightIndex < fin - mitad) {
           
            
            if (nodoindiceIzquierdo.getCiudadDestino().getNombre().compareTo( nodoindiceDerecho.getCiudadDestino().getNombre()) < 0) {
                nodoIntercambio=array.getHeadContratos();
               for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
               nodoIntercambio.setCiudadDestino(nodoindiceIzquierdo.getCiudadDestino());
               nodoIntercambio.getFechaContrato().setDia(nodoindiceIzquierdo.getFechaContrato().getDia());
               nodoIntercambio.getFechaContrato().setMes(nodoindiceIzquierdo.getFechaContrato().getMes());
               nodoIntercambio.getFechaContrato().setAño(nodoindiceIzquierdo.getFechaContrato().getAño());
               nodoIntercambio.setMiLista(nodoindiceIzquierdo.getMiLista());
               leftIndex++;
            } else {
                nodoIntercambio=array.getHeadContratos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
                nodoIntercambio.setCiudadDestino(nodoindiceDerecho.getCiudadDestino());
                nodoIntercambio.getFechaContrato().setDia(nodoindiceDerecho.getFechaContrato().getDia());
                nodoIntercambio.getFechaContrato().setMes(nodoindiceDerecho.getFechaContrato().getMes());
                nodoIntercambio.getFechaContrato().setAño(nodoindiceDerecho.getFechaContrato().getAño());
                nodoIntercambio.setMiLista(nodoindiceDerecho.getMiLista());
                rightIndex++;
            }
        } else if (leftIndex < mitad - inicio + 1) {
            // If all elements have been copied from rightArray, copy rest of leftArray
                nodoIntercambio=array.getHeadContratos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
                
                nodoIntercambio.setCiudadDestino(nodoindiceIzquierdo.getCiudadDestino());
                nodoIntercambio.getFechaContrato().setDia(nodoindiceIzquierdo.getFechaContrato().getDia());
                nodoIntercambio.getFechaContrato().setMes(nodoindiceIzquierdo.getFechaContrato().getMes());
                nodoIntercambio.getFechaContrato().setAño(nodoindiceIzquierdo.getFechaContrato().getAño());
                nodoIntercambio.setMiLista(nodoindiceIzquierdo.getMiLista());
                leftIndex++;
        } else if (rightIndex < fin - mitad) {
            // If all elements have been copied from leftArray, copy rest of rightArray
                nodoIntercambio=array.getHeadContratos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
                nodoIntercambio.setCiudadDestino(nodoindiceDerecho.getCiudadDestino());
                nodoIntercambio.getFechaContrato().setDia(nodoindiceDerecho.getFechaContrato().getDia());
                nodoIntercambio.getFechaContrato().setMes(nodoindiceDerecho.getFechaContrato().getMes());
                nodoIntercambio.getFechaContrato().setAño(nodoindiceDerecho.getFechaContrato().getAño());
                nodoIntercambio.setMiLista(nodoindiceDerecho.getMiLista());
            rightIndex++;
        }
    }
}
        //Fin MergSort
    //*******************Fin funciones de ordenamiento para los contratos Segun la ciudad Destino

    //*******************Funciones de Ordenamientos para los contratos segun la fecha
        //InicioHeapSort
       public void heapContratosFechas(){
       int posPadre;
       Contratos nodoPosPadre=new Contratos();
       int posHijoIzquierdo;
       Contratos nodoPosHijoIzquierdo=new Contratos();
       int posHijoDrecho;
       Contratos nodoPosHijoderecho=new Contratos();
       int n;
       n=miListaViajesContratados.getTamlistaContratos()-1;
       
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
              nodoPosPadre=devolverNodoContratos(miListaViajesContratados,posPadre);
              nodoPosHijoIzquierdo=devolverNodoContratos(miListaViajesContratados, posHijoIzquierdo);
              //Debe hacer una comparacion con el hijo izquierdo
              if(nodoPosPadre.getFechaContrato().getTotal()<nodoPosHijoIzquierdo.getFechaContrato().getTotal()){
                  //Se deben intercambiarVehiculos
                  intercambiarContratosFechas(posPadre, posHijoIzquierdo);
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
                nodoPosPadre=devolverNodoContratos(miListaViajesContratados,posPadre);
                nodoPosHijoIzquierdo=devolverNodoContratos(miListaViajesContratados, posHijoIzquierdo);
                nodoPosHijoderecho=devolverNodoContratos(miListaViajesContratados, posHijoDrecho);
                if(nodoPosPadre.getFechaContrato().getTotal()<nodoPosHijoIzquierdo.getFechaContrato().getTotal()){//Se pregunta si el padre es menor que el hijo izquierdo
                    //Quiere decir que el hijo izquiero es mayor que el padre
                    if(nodoPosHijoIzquierdo.getFechaContrato().getTotal()>nodoPosHijoderecho.getFechaContrato().getTotal()){
                        //Esto quiere decir que el mayor de los 3 es el hijo izquierdo
                        //Se debe intercambiarVehiculos el padre por el hijo izquierdo
                        intercambiarContratosFechas(posPadre, posHijoIzquierdo);
                        posPadre=posPadre-1;
                        posHijoIzquierdo=2*posPadre+1;
                        posHijoDrecho=2*posPadre+2;
                        
                    }else{//Quiere decir que el mayor de los 3 es el hijo derecho
                            //Se debe intercambiarVehiculos el padre por el hijo derecho
                            intercambiarContratosFechas(posPadre, posHijoDrecho);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2;
                            
                    }
                    
                }else if(nodoPosPadre.getFechaContrato().getTotal()<nodoPosHijoderecho.getFechaContrato().getTotal()){//Se pregunta si el padre es menor que el hijo derecho
                    if(nodoPosHijoderecho.getFechaContrato().getTotal()>nodoPosHijoIzquierdo.getFechaContrato().getTotal()){//Quiere decir que el hijo derecho es el mayor de los 3
                        //Se debe intercambiarVehiculos el padre por el hijo derecho
                            intercambiarContratosFechas(posPadre, posHijoDrecho);
                            posPadre=posPadre-1;
                            posHijoIzquierdo=2*posPadre+1;
                            posHijoDrecho=2*posPadre+2;
                            
                    }else{
                        //Quiere decir que el mayor de los 3 es el hijo Izquierdo
                        //Se debe intercambiarVehiculos el padre por el hijo Izquierdo
                            intercambiarContratosFechas(posPadre, posHijoIzquierdo);
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
    public void intercambiarContratosFechas(int posPadre,int posHijoMayor){
        Contratos nodoPosPadre=new Contratos();
        Contratos nodoPoshijoMayor=new Contratos();
        nodoPosPadre=devolverNodoContratos(miListaViajesContratados, posPadre);
        nodoPoshijoMayor=devolverNodoContratos(miListaViajesContratados, posHijoMayor);
        Contratos aux=new Contratos();
        aux=nodoPosPadre;//Toma el valor del padre
        nodoPosPadre.getFechaContrato().setDia(nodoPoshijoMayor.getFechaContrato().getDia());
        nodoPosPadre.getFechaContrato().setMes(nodoPoshijoMayor.getFechaContrato().getMes());
        nodoPosPadre.getFechaContrato().setAño(nodoPoshijoMayor.getFechaContrato().getAño());
        nodoPosPadre.setCiudadDestino(nodoPoshijoMayor.getCiudadDestino());
        nodoPosPadre.setMiLista(nodoPoshijoMayor.getMiLista());
        nodoPoshijoMayor.getFechaContrato().setDia(aux.getFechaContrato().getDia());
        nodoPoshijoMayor.getFechaContrato().setMes(aux.getFechaContrato().getMes());
        nodoPoshijoMayor.getFechaContrato().setAño(aux.getFechaContrato().getAño());
        nodoPoshijoMayor.setCiudadDestino(aux.getCiudadDestino());
        nodoPoshijoMayor.setMiLista(aux.getMiLista());
    }
        //Fin heapSort
    
        //Inicio QuickSort
    public void  ordenarQuickSortContratosFechas(ListaContratos miLista,int primero, int ultimo) {//Cualquier lista de cualquier tipo, primero igual a cero, ultimo igual a tamano -1
        int pivote;
        if(primero<ultimo){
            pivote=obtener_pivoteContratosFechas(miLista, primero, ultimo);
            ordenarQuickSortContratosFechas(miLista, primero, pivote-1);
            ordenarQuickSortContratosFechas(miLista, pivote+1,ultimo);

        }

    }
    public  int obtener_pivoteContratosFechas(ListaContratos miLista,int primero, int ultimo){
        Contratos aux_intercambio=new Contratos();
        long aux_comparacion;
        int i,j;
        Contratos AuxNodoUltimo=new Contratos();
        Contratos auxNodoi=new Contratos();
        Contratos auxNodoi1=new Contratos();
        Contratos auxNodoj=new Contratos();
        AuxNodoUltimo=devolverNodoContratos(miLista, ultimo);
        aux_comparacion=AuxNodoUltimo.getFechaContrato().getTotal();
        i=primero-1;
        for(j=primero;j<=ultimo-1;j++){
            auxNodoj=devolverNodoContratos(miLista, j);
            if(auxNodoj.getFechaContrato().getTotal()<=aux_comparacion){
                i++;
                aux_intercambio=devolverNodoContratos(miLista, i);
                auxNodoi=devolverNodoContratos(miLista, i);
                auxNodoi.setCiudadDestino(auxNodoj.getCiudadDestino());
                auxNodoi.getFechaContrato().setDia(auxNodoj.getFechaContrato().getDia());
                auxNodoi.getFechaContrato().setMes(auxNodoj.getFechaContrato().getMes());
                auxNodoi.getFechaContrato().setAño(auxNodoj.getFechaContrato().getAño());
                auxNodoi.setMiLista(auxNodoj.getMiLista());
                auxNodoj.setCiudadDestino(aux_intercambio.getCiudadDestino());
                auxNodoj.getFechaContrato().setDia(aux_intercambio.getFechaContrato().getDia());
                auxNodoj.getFechaContrato().setMes(aux_intercambio.getFechaContrato().getMes());
                auxNodoj.getFechaContrato().setAño(aux_intercambio.getFechaContrato().getAño());
                auxNodoj.setMiLista(aux_intercambio.getMiLista());
             }
        }
        aux_intercambio=devolverNodoContratos(miLista, i+1);
        auxNodoi1=devolverNodoContratos(miLista, i+1);
        auxNodoi1.setCiudadDestino(AuxNodoUltimo.getCiudadDestino());
        auxNodoi1.getFechaContrato().setDia(AuxNodoUltimo.getFechaContrato().getDia());
        auxNodoi1.getFechaContrato().setMes(AuxNodoUltimo.getFechaContrato().getMes());
        auxNodoi1.getFechaContrato().setAño(AuxNodoUltimo.getFechaContrato().getAño());
        auxNodoi1.setMiLista(AuxNodoUltimo.getMiLista());
        AuxNodoUltimo.setCiudadDestino(aux_intercambio.getCiudadDestino());
        AuxNodoUltimo.getFechaContrato().setDia(aux_intercambio.getFechaContrato().getDia());
        AuxNodoUltimo.getFechaContrato().setMes(aux_intercambio.getFechaContrato().getMes());
        AuxNodoUltimo.getFechaContrato().setAño(aux_intercambio.getFechaContrato().getAño());
        AuxNodoUltimo.setMiLista(aux_intercambio.getMiLista());      
        return(i+1);
    }
        //Fin QuickSort
    
        //Inicio MergSort
    public void ordenarMergeSortContratosFechas(ListaContratos miLista, int inicio, int fin){        
        if (fin <= inicio) return;  
        int mitad=(inicio+fin)/2;
        ordenarMergeSortContratosFechas(miLista, inicio, mitad);
        ordenarMergeSortContratosFechas(miLista, mitad+1, fin);
        mergeContratosFechas(miLista,inicio,mitad,fin);
        
    } 
    public void mergeContratosFechas(ListaContratos array, int inicio, int mitad, int fin){
    ListaContratos leftArray = new ListaContratos();//[mitad - inicio + 1];
    ListaContratos rightArray = new ListaContratos();//[fin - mitad];
    Contratos auxiliar=new Contratos();
    Contratos nodoindiceIzquierdo=new Contratos();
    Contratos nodoindiceDerecho=new Contratos();
    // Copying our subarrays into temporaries
    for (int i = 0; i < mitad - inicio + 1; i++){
        auxiliar=devolverNodoContratos(array, inicio+i);
        leftArray.agregarContrato(leftArray,auxiliar);
    }
    for (int i = 0; i < fin - mitad; i++){
        auxiliar=devolverNodoContratos(array, mitad + i + 1);
        rightArray.agregarContrato(rightArray,auxiliar);
    }    
    // Iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // Copying from leftArray and rightArray back into array
    for (int i = inicio; i < fin + 1; i++) {
        // If there are still uncopied elements in R and L, copy minimum of the two
            nodoindiceIzquierdo=devolverNodoContratos(leftArray, leftIndex);
            nodoindiceDerecho=devolverNodoContratos(rightArray, rightIndex);
            Contratos nodoIntercambio=new Contratos();
        if (leftIndex < mitad - inicio + 1 && rightIndex < fin - mitad) {
           
            
            if (nodoindiceIzquierdo.getFechaContrato().getTotal()<nodoindiceDerecho.getFechaContrato().getTotal()) {
                nodoIntercambio=array.getHeadContratos();
               for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
               nodoIntercambio.setCiudadDestino(nodoindiceIzquierdo.getCiudadDestino());
               nodoIntercambio.getFechaContrato().setDia(nodoindiceIzquierdo.getFechaContrato().getDia());
               nodoIntercambio.getFechaContrato().setMes(nodoindiceIzquierdo.getFechaContrato().getMes());
               nodoIntercambio.getFechaContrato().setAño(nodoindiceIzquierdo.getFechaContrato().getAño());
               nodoIntercambio.setMiLista(nodoindiceIzquierdo.getMiLista());
               leftIndex++;
            } else {
                nodoIntercambio=array.getHeadContratos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
                nodoIntercambio.setCiudadDestino(nodoindiceDerecho.getCiudadDestino());
                nodoIntercambio.getFechaContrato().setDia(nodoindiceDerecho.getFechaContrato().getDia());
                nodoIntercambio.getFechaContrato().setMes(nodoindiceDerecho.getFechaContrato().getMes());
                nodoIntercambio.getFechaContrato().setAño(nodoindiceDerecho.getFechaContrato().getAño());
                nodoIntercambio.setMiLista(nodoindiceDerecho.getMiLista());
                rightIndex++;
            }
        } else if (leftIndex < mitad - inicio + 1) {
            // If all elements have been copied from rightArray, copy rest of leftArray
                nodoIntercambio=array.getHeadContratos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
                
                nodoIntercambio.setCiudadDestino(nodoindiceIzquierdo.getCiudadDestino());
                nodoIntercambio.getFechaContrato().setDia(nodoindiceIzquierdo.getFechaContrato().getDia());
                nodoIntercambio.getFechaContrato().setMes(nodoindiceIzquierdo.getFechaContrato().getMes());
                nodoIntercambio.getFechaContrato().setAño(nodoindiceIzquierdo.getFechaContrato().getAño());
                nodoIntercambio.setMiLista(nodoindiceIzquierdo.getMiLista());
                leftIndex++;
        } else if (rightIndex < fin - mitad) {
            // If all elements have been copied from leftArray, copy rest of rightArray
                nodoIntercambio=array.getHeadContratos();
                for(int j=0; j<i; j++){
                   nodoIntercambio=nodoIntercambio.getSiguienteContrato();
               }
                nodoIntercambio.setCiudadDestino(nodoindiceDerecho.getCiudadDestino());
                nodoIntercambio.getFechaContrato().setDia(nodoindiceDerecho.getFechaContrato().getDia());
                nodoIntercambio.getFechaContrato().setMes(nodoindiceDerecho.getFechaContrato().getMes());
                nodoIntercambio.getFechaContrato().setAño(nodoindiceDerecho.getFechaContrato().getAño());
                nodoIntercambio.setMiLista(nodoindiceDerecho.getMiLista());
            rightIndex++;
        }
    }
}
        //Fin MergeSort
    
    //*******************Fin funciones de ordenamiento para los contratos Segun la fecha
    
//Funcion paa devolver un Nodo de tipo vehiculos especifico de una lista
    public Vehiculos devolverNodo(ListaVehiculos miLista,int pos){//Va a recibir lista y la posicion del nodo que desea devolver
      Vehiculos auxNodo=new Vehiculos();
      auxNodo=miLista.getHeadVehiculos();
      for(int i=0; i<pos; i++){
          auxNodo=auxNodo.getSiguienteVehiculo();
      }
      return auxNodo;
    }
    
  //Funcion paa devolver un Nodo de tipo vehiculos especifico de una lista
    public Contratos devolverNodoContratos(ListaContratos miLista,int pos){//Va a recibir lista y la posicion del nodo que desea devolver
      Contratos auxNodo=new Contratos();
      auxNodo=miLista.getHeadContratos();
      for(int i=0; i<pos; i++){
          auxNodo=auxNodo.getSiguienteContrato();
      }
      return auxNodo;
    }
    
    
    
}
