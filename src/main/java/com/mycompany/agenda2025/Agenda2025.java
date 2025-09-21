/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.agenda2025;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Agenda2025 extends JFrame {

    private DefaultTableModel modeloTabla;
    private JTable tablaEventos;
    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;
    private JTextField txtDescripcion;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnSalir;

    public Agenda2025() {
        setTitle("Mi Agenda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear la tabla y el modelo
        String[] columnas = {"Fecha", "Hora", "Descripción"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaEventos);
        getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Formateadores para los JSpinners
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        // Paneles de la interfaz
        JPanel panelEntrada = crearPanelEntrada(formatoFecha, formatoHora);
        JPanel panelBotones = crearPanelBotones();
        
        // Layout de la ventana principal
        setLayout(new BorderLayout(20, 20));
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Manejadores de eventos para los botones
        agregarManejadoresDeEventos();
    }
    
    
 // Nuevo método para crear el panel de entrada
private JPanel crearPanelEntrada(SimpleDateFormat formatoFecha, SimpleDateFormat formatoHora) {
    JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5)); 

    // Panel para fecha y hora
    JPanel panelFechaHora = new JPanel(new GridLayout(1, 4, 5, 5));
    
    // JSpinner para la fecha
    spinnerFecha = new JSpinner(new SpinnerDateModel());
    JSpinner.DateEditor editorFecha = new JSpinner.DateEditor(spinnerFecha, formatoFecha.toPattern());
    spinnerFecha.setEditor(editorFecha);

    // JSpinner para la hora
    spinnerHora = new JSpinner(new SpinnerDateModel());
    JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spinnerHora, formatoHora.toPattern());
    spinnerHora.setEditor(editorHora);
    
    panelFechaHora.add(new JLabel("Fecha:"));
    panelFechaHora.add(spinnerFecha);
    panelFechaHora.add(new JLabel("Hora:"));
    panelFechaHora.add(spinnerHora);

    // JTextField para la descripción
    txtDescripcion = new JTextField(40); // Aumentamos el tamaño preferido

    // Etiquetas y componentes
    panel.add(panelFechaHora);
    panel.add(new JLabel("Descripción:"));
    panel.add(txtDescripcion);
    
    return panel;
}

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar seleccionado");
        btnSalir = new JButton("Salir");
        
        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnSalir);
        
        return panel;
    }


    private void agregarManejadoresDeEventos() {
        // Manejador para el botón AGREGAR
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEvento();
            }
        });

        // Manejador para el botón ELIMINAR
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEvento();
            }
        });

        // Manejador para el botón SALIR
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void agregarEvento() {
        // Validar que la descripción no esté vacía
        String descripcion = txtDescripcion.getText().trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Formatear fecha y hora
        Date fecha = (Date) spinnerFecha.getValue();
        Date hora = (Date) spinnerHora.getValue();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        
        String fechaFormateada = formatoFecha.format(fecha);
        String horaFormateada = formatoHora.format(hora);

        // Añadir la fila a la tabla
        modeloTabla.addRow(new Object[]{fechaFormateada, horaFormateada, descripcion});

        // Limpiar y dar foco al campo de descripción
        txtDescripcion.setText("");
        txtDescripcion.requestFocusInWindow();
    }
    

    private void eliminarEvento() {
        int filaSeleccionada = tablaEventos.getSelectedRow();
        
        // Precondición: debe haber una fila seleccionada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un evento primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pedir confirmación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Eliminar el evento seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
        }
    }
    

    public static void main(String[] args) {
        // Usar el Event Dispatch Thread para la seguridad del hilo
        SwingUtilities.invokeLater(() -> {
            new Agenda2025().setVisible(true);
        });
    }
}