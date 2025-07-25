/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dashboard;

/**
 *
 * @author USER
 */
public class Clase8 {

    public static void main(String[] args) {
        Restaurante restaurante =new Restaurante();
        Menu menu=new Menu();
        Caja caja= new Caja();
        Servicios servicios=new Servicios();
        
        String BienvenidoAlRestaurante = restaurante.Bienvenido_al_restaurante();
        
        System.out.println("Mensaje de entrada:" + BienvenidoAlRestaurante);
        
        String resultadoMenu = menu.MenuPrincipal();
        
        System.out.println("Resultado del menu:" + resultadoMenu);
        
        String detalleDelConsumoParaCaja = "Arroz marinero, rollitos de pavo al ajillo y bebidas";
        String facturaGenerada = caja. Generarfactura(detalleDelConsumoParaCaja);
        
        System.out.println("Arroz marinero, rollitos de pavo al ajillo y bebidas:" + facturaGenerada);
        
        String resultadoDelivery = servicios.Serviciodelivery();
        
        System.out.println("Resultado del servicio:" + resultadoDelivery);
      
        

        
    }
}
