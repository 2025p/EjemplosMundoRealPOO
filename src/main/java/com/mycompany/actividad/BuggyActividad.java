/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad;
// Se importo las bibliotecas
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuggyActividad {
    public static void main(String[] args) {
        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Sandra");

        // Error: índice fuera de rango
        System.out.println("Elemento en posición 2: " + nombres.get(2)); // correccion del # 3 porque el conteo es de cero

        // Error: comparación de cadenas con == en lugar de equals
        String buscado = new String();// aqui en las llaves se elimino el el nombre Ana 
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Sandra", "0993333333");

        // Error: obtener clave inexistente sin validación
        System.out.println("Bea: " + telefonos.get("Bea"));

        // SET de inscritos (debería no permitir duplicados lógicos)
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(3, "Sandra"));

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}