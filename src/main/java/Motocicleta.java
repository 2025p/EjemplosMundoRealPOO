/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
 public class Motocicleta {
    // Atributos
    String marca;
    String modelo;
    
  
    public Motocicleta(){
        this.marca = null;
        this.modelo = null;
        System.out.println("Creando una motocicleta por defecto.");
    }
    
    public Motocicleta(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
        System.out.println("Creando una motocicleta" + marca + " " + modelo + ".");
    }
    
    public Motocicleta(String nombreCompleto){
        
        if (nombreCompleto. toLowerCase(). contains("kawasaki")){
            this.marca = "Kawasaki";
            if (nombreCompleto. toLowerCase(). contains("ninja")){
                this.modelo = "Ninja";
            }
               else if (nombreCompleto.toLowerCase(). contains("h2r")){
                this.modelo = "H2R";
            }
            else{
                this.modelo = nombreCompleto;
            }
        }
        else{
          this.marca = "Dinamica";
          this.modelo = nombreCompleto; 
         
        }
       System.out.println("Creando una motocicleta" + this.marca +" "+ this.modelo + "(constructor sobrecargado).");
    }
    
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;

  }   
    
    public void acelerar(){
        if (this.marca != null && this.modelo != null){
          System.out.println("Tu ninja" + this.marca + " " + this.modelo + " esta acelerando.");
        }
        else{
           System.out.println("Una motocicleta sin identificar esta acelerando.");
   
        }
    }  
    
     public void acelerar(int kmh){
        if (this.marca != null && this.modelo != null){
                System.out.println("Tu ninja" + this.marca + " " + this.modelo + " esta acelerando a" + kmh +"km/h.");
                
        }
        else {
                System.out.println("Una motocicleta sin identificar esta acelerando a " + kmh + "km/h.");
        }
    }

 }

