/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad16;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

//Un JList usando Key Bindings.

public class KeyCaptureExample extends JFrame {

    private JList<String> itemList;
    private DefaultListModel<String> listModel;

    public KeyCaptureExample() {
        // Configuración de la Ventana 
        setTitle("Captura de Tecla 'C' ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Componentes 
        listModel = new DefaultListModel<>();
        listModel.addElement("Elemento 1-0: Presiona 'C' para alternar selección");
        listModel.addElement("Elemento 2-1");
        listModel.addElement("Elemento 3-2");
        listModel.addElement("Elemento 4-3");
        
        itemList = new JList<>(listModel);
        
        itemList.setFocusable(true); 

        JButton dummyButton = new JButton("Key Bindings");

        // Añadir componentes al JFrame
        add(new JScrollPane(itemList), BorderLayout.CENTER);
        add(dummyButton, BorderLayout.SOUTH);

    

        // Definir el KeyStroke a capturar (Tecla 'C')
        KeyStroke keyC = KeyStroke.getKeyStroke("C");
        
        // Nombre de la acción
        String actionName = "alternarSeleccionC";

        // Se Crea la Acción
        Action alternateSelectionAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica a ejecutar al presionar 'C'
                 int selectedIndex = itemList.getSelectedIndex();
        
        // Verificar si hay algún elemento seleccionado
        if (selectedIndex != -1) {
            System.out.println("--- Tecla 'C' Capturada en JList ---");
            
            // Si el elemento ya está seleccionado, lo deseleccionamos (toggle)
            // Nota: Usaremos isSelected() para verificar si está seleccionado, aunque
            // con getSelectedIndex() != -1 ya sabemos que hay uno.
            // Para 'toggle' (alternar) en un JList, simplemente usamos los métodos
            // de adición y remoción.
            
            if (itemList.isSelectedIndex(selectedIndex)) {
                // Deseleccionar
                itemList.removeSelectionInterval(selectedIndex, selectedIndex);
                System.out.println("-> Deseleccionado el elemento en el índice: " + selectedIndex);
            } else {
                // Seleccionar (esto es redundante si selectedIndex != -1, pero seguro)
                itemList.setSelectedIndex(selectedIndex);
                System.out.println("-> Seleccionado el elemento en el índice: " + selectedIndex);
            }
        } else {
            // Mensaje si no hay nada seleccionado (aunque el foco esté en la lista)
            System.out.println("--- Tecla 'C' Capturada en JList ---");
            System.out.println("-> No hay elemento seleccionado para alternar.");
                    }
                }
        };

        // Vincular el KeyStroke con la Acción
        
        // Obtenemos el InputMap para la condición WHEN_FOCUSED
        // Esto significa que la acción se ejecutará solo cuando el JList tenga el foco.
        InputMap inputMap = itemList.getInputMap(JComponent.WHEN_FOCUSED);
        inputMap.put(keyC, actionName);

        // Obtenemos el ActionMap y asociamos el nombre de la acción con la clase Action
        ActionMap actionMap = itemList.getActionMap();
        actionMap.put(actionName, alternateSelectionAction);

        // Hacer visible la ventana
        setVisible(true);
        
        // Opcional: Asegurar que el JList tenga foco inicial para probar.
        itemList.requestFocusInWindow();
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new KeyCaptureExample());
    }
}
