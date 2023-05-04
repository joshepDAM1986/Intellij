package org.example;

public class ClaseGenerica <T>{
    private T elemento;
    public ClaseGenerica(T e){
        elemento=e;
    }

    public T getElemento(){
        return elemento;
    }
}
