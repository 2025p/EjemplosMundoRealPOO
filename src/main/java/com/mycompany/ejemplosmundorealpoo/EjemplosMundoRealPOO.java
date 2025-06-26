/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplosmundorealpoo;

/**
 *
 * @author USER
 */
public class EjemplosMundoRealPOO {

    public static void main(String[] args) {
        Comida ceviche = new Comida ();
        ceviche. mixto = "con concha";
        ceviche. sencillo = "sin concha";
       
        System.out.println("preparando ceviche" + (ceviche.tieneconcha ? "con concha." :"sin concha."));
    }
}
