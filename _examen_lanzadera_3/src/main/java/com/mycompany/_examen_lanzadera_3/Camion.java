/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._examen_lanzadera_3;

public class Camion extends Terrestre {
    private String color;

    public Camion(String color) {
        this.color = color;
    }
        
        @Override
    public void getInfo()
    {
        System.out.println("Yo para ser feliz quiero un camion");
    }
    
public void getColor(){
    System.out.println("Camion de color "+ color);
}
}
