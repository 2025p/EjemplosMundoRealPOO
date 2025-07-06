/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author USER
 */
public class Clase6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CajaFuerte caja=new CajaFuerte();
        caja.resistente="apertura forzada";
        caja.seguridad="biometrica";
        caja.tamaño="adecuado";
        
        //Aqui digitar el codigo establecido para abrir la caja fuerte
        caja.metercodigo("54321");
        caja.digitar("abrir");
    }
    
}
