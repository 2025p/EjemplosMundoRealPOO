/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionDatos extends JFrame {

    private JTextField campoNombre;
    private JTextField campoApellido;
    private JButton botonAgregar;
    private JButton botonLimpiar;
    private JButton botonEliminar;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaDatos;

    public GestionDatos() {
        // Configuración de la ventana principal
        setTitle("Gestión de Datos ");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setLayout(new BorderLayout(10, 10)); // Usar BorderLayout

        // --- Panel Superior (Entrada de datos) ---
        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        panelEntrada.add(new JLabel("Nombre:"));
        campoNombre = new JTextField(15);
        panelEntrada.add(campoNombre);

        panelEntrada.add(new JLabel("Apellido:"));
        campoApellido = new JTextField(15);
        panelEntrada.add(campoApellido);

        // --- Panel Central (Lista de datos) ---
        modeloLista = new DefaultListModel<>();
        listaDatos = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaDatos); // Para permitir el scroll si hay muchos elementos

        // --- Panel Inferior (Botones) ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        botonAgregar = new JButton("Agregar");
        botonLimpiar = new JButton("Limpiar");
        botonEliminar = new JButton("Eliminar");
        
        panelBotones.add(botonAgregar);
        panelBotones.add(botonLimpiar);
        panelBotones.add(botonEliminar);

        // --- Agregar paneles a la ventana principal ---
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // --- Manejo de eventos (ActionListeners) ---
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDatos();
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        // Obtenemos el índice del elemento seleccionado en la lista
            int selectedIndex = listaDatos.getSelectedIndex();
        // Si hay un elemento seleccionado (el índice no es -1)
            if (selectedIndex != -1) {
            // Removemos el elemento del modelo de la lista
            modeloLista.remove(selectedIndex);
        }
    }
});

// Opcional: Deshabilita el botón de eliminar si no hay selección
        listaDatos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
        botonEliminar.setEnabled(listaDatos.getSelectedIndex() != -1);
    }
});
    }

      // Método para agregar datos a la lista
    private void agregarDatos() {
        String nombre = campoNombre.getText().trim();
        String apellido = campoApellido.getText().trim();

        if (!nombre.isEmpty() && !apellido.isEmpty()) {
            modeloLista.addElement(nombre + " " + apellido);
            
            limpiarCampos(); // Limpiar los campos después de agregar
            
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete ambos campos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoApellido.setText("");
      
    }

    public static void main(String[] args) {
        // Usar SwingUtilities.invokeLater para asegurar que la GUI se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionDatos().setVisible(true);
            }
        });
    }
}