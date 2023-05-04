
package com.mycompany.ejemplo_unit_3;

/**
 *
 * @author garci
 */

public class Operaciones {
    static final int MENOR = 0;
    static final int MAYOR = 1;   
         
     public int sumaArray(int[] array ){
     int suma=0;
     for (int i=0;i<array.length;i++){
     suma+=array[i];
        }
         return suma;
        }
  
     public int mayorElementoArray(int[] array ){
         int nMayor= array[0];
         for ( int i=0;i<array.length;i++){
             if(array[i]>nMayor){
                 nMayor=array[i];
             }
        }
        return  nMayor;
        }
         
    public int menorElementoArray(int[] array ){
         int nMenor= array[0];
         for ( int i=0;i<array.length;i++){
             if(array[i]<nMenor){
                 nMenor=array[i];
             }
         }
              return  nMenor;
         }
    
    int mayorMenorElementoArray(int[] array, int tipo)
    {      
        if (tipo == Operaciones.MENOR)
            return menorElementoArray(array);
        else return mayorElementoArray(array);
    }
}