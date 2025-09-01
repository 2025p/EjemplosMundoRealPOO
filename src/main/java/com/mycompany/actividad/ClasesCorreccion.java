/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClasesCorreccion {

    public void manejarColecciones() {
        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Sandra", "0993333333");

        //  Corrección: obtener clave con validación
        String telefonoBea = telefonos.get("Bea");
        if (telefonoBea != null) {
            System.out.println("Teléfono de Bea: " + telefonoBea);
        } else {
            System.out.println("No se encontró el teléfono de Bea.");
        }

        //  Corrección: SET de inscritos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(3, "Sandra")); 

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

    
    

