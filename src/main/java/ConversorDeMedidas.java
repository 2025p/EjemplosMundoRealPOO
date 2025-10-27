
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class ConversorDeMedidas {
    public static void main(String[]args){
        // Este programa nos va a converciones de pulgadas a milimetros, de yardas a metros y millas a kilometros.
        // las opciones:
        // 1 pulgada equivale a 25.40 milimetros.
        // 1 yarda equivale a 0.91 metros.
        // 1 kilometro equivale a 0.62 millas.
   
         Scanner lector = new Scanner(System.in);
    
         int opc;
         double pulgadas, milimetros, yardas, metros, kilometros, millas;
      
         System.out.println("Ingresse la opcion que desea:");
         System.out.println("1. Pulgadas a milimetros.");
         System.out.println("2. Yardas a metros.");
         System.out.println("3. kilometros a Millas.");
    
         opc = lector.nextInt();
         switch  (opc){
             case 1: 
                 System.out.println("Ingrese  la cantidad de pulgadas a convertir:");
                 pulgadas = lector. nextDouble();
                 milimetros = pulgadas * 25.40;
                 System.out.println(pulgadas+"pulgadas equivalen a "+milimetros+"milimetros");
                 break;
                 
             case 2:
                 System.out.println("Ingrese  la cantidad de yardas a convertir:");
                 yardas = lector. nextDouble();
                 metros = yardas * 0.91;
                 System.out.println(yardas+"yardas equivalen a "+metros+"metros");
                 break;
                 

             case 3:
                 System.out.println("Ingrese  la cantidad de kilometros a convertir:");
                 millas = lector. nextDouble();
                 kilometros = millas * 0.62;
                 System.out.println(millas+"Kilometro equivalen a "+Millas+"Millas");
                 break;
                 
             default:
                 System.out.println("La opcion seleccionada no es valida.");
                 
                 
         }
         
         }
         
}

