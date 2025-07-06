/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class CajaFuerte {
    
    String resistente;
    String seguridad;
    String tamaño;
    private boolean acceso=false;
    public void metercodigo(String codigo){
        if(codigo.equals("54321")){
            acceso=true;
        }
        else{
            acceso=false;
            System.out.println("Codigo incorrecto");
            
        }
    }
    public void digitar(String accion){
        if(acceso==true){
            if(accion.equals("abrir")){
                abrir();
            }
        }
    }
    private void abrir(){
        System.out.println("Abierto a su disposicion");
    }
    public void almacena(){
        System.out.println("Documentos, dinero, joyas");
    }
    public void protege(){
        System.out.println("Amacenamiento seguro");
    }
}
