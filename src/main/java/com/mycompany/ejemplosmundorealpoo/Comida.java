/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplosmundorealpoo;

/**
 *
 * @author USER
 */
public class Comida {
    String mixto;
    String sencillo;
    boolean tieneconcha;
    String Ceviche;
    ;
    public Comida () {
        this.Ceviche = "tiene concha + no tiene concha";
        this.tieneconcha = true;
        
        this. mixto = "con mariscos variados";
        this. sencillo = "sin aderesos picantes";
        
        System.out.println("Preparando ceviche mixto" + this.mixto + this.sencillo);
        System.out.println(this.tieneconcha ? "con concha." : "sin concha.");
        System.out.println("Tiene concha? " + (this.tieneconcha ?"Si" : "No"));
        System.out.println("Preparando ceviche mixto" + this.mixto + " + " + this.sencillo);
  } 
             

    public void mostrarinfoCeviche(){
        System.out.println("SI quieres mixto o sencillo : " + this.Ceviche);
        System.out.println("Tiene concha? " + (this.tieneconcha ?"Si" : "No"));
        
    }
            
}  

   
