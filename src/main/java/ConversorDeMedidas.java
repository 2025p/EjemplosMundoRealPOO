
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
        // Este programa nos va a converciones de pulgadas a centimetros, de yardas a metros y millas a kilometros.
        // las opciones:
        // 1 pulgada equivale a 2.54 milimetros.
        // 1 yarda equivale a 0.91 metros.
        // 1 kilometro equivale a 0.62 millas.
        // 1 kilogramo equivale a 2.2 libra.
   
         Scanner lector = new Scanner(System.in);
    
         int opc;
         double pulgadas, centimetros, yardas, metros, kilometros, millas, kilogramos, libras;
      
         System.out.println("Ingresse la opcion que desea:");
         System.out.println("1. Pulgadas a centimetros.");
         System.out.println("2. Yardas a metros.");
         System.out.println("3. kilometros a Millas.");
         System.out.println("4. kilogramos a Libras.");
    
         opc = lector.nextInt();
         switch  (opc){
             case 1: 
                 System.out.println("Ingrese  la cantidad de pulgadas a convertir:");
                 pulgadas = lector. nextDouble();
                 centimetros = pulgadas * 2.54;
                 System.out.println(pulgadas+"pulgadas equivalen a "+centimetros+"Centimetros");
                 break;
                 
             case 2:
                 System.out.println("Ingrese  la cantidad de yardas a convertir:");
                 yardas = lector. nextDouble();
                 metros = yardas * 0.91;
                 System.out.println(yardas+"yardas equivalen a "+metros+"Metros");
                 break;
                 

             case 3:
                 System.out.println("Ingrese  la cantidad de kilometros a convertir:");
                 kilometros = lector. nextDouble();
                 millas = kilometros * 0.62;
                 System.out.println(kilometros+"Kilometro equivalen a "+millas+"Millas");
                 break;
                 
                 
                 case 4: 
                 System.out.println("Ingrese  la cantidad de kilogramos a convertir:");
                 kilogramos = lector. nextDouble();
                 libras = kilogramos * 2.2;
                 System.out.println(kilogramos+"kilogramos equivalen a "+libras+"Libras");
                 break;
             default:
                 System.out.println("La opcion seleccionada no es valida.");
                 
                 
         }
         
         }
         
}

