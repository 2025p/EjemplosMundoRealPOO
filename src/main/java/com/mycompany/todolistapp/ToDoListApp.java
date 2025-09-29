/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolistapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToDoListApp extends JFrame {

  
    private JTextField taskInputField;
    private JButton addButton;
    private JButton completeButton;
    private JButton deleteButton;
    private JList<Task> taskList;
    private DefaultListModel<Task> listModel;

    public ToDoListApp() {
        super("Lista de Tareas (To-Do List) ");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskInputField = new JTextField(20);
        addButton = new JButton("Añadir Tarea");
        completeButton = new JButton("Marcar como Completada");
        deleteButton = new JButton("Eliminar Tarea");

        
        // Configurar el renderizador para el texto tachado
        taskList.setCellRenderer(new TaskCellRenderer());
        
        // 1. Panel de entrada (arriba)
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        inputPanel.add(new JLabel("Nueva Tarea:"));
        inputPanel.add(taskInputField);
        inputPanel.add(addButton);

        // 2. Panel de botones de acción (abajo)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        
        // 3. Contenedor principal con BorderLayout
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(taskList), BorderLayout.CENTER); // JList en un JScrollPane
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        // Añadir algo de espacio
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Manejo de Eventos ---
        setupEventHandlers();

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Ajusta el tamaño de la ventana a los componentes
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    // Configura todos los manejadores de eventos (ActionListener, KeyListener, MouseListener).
     
    private void setupEventHandlers() {
        // 1. Evento de botón: Añadir Tarea
        addButton.addActionListener(e -> addTask());

        // 2. Evento de teclado: Enter en el JTextField para Añadir Tarea
        taskInputField.addActionListener(e -> addTask());

        // 3. Evento de botón: Marcar como Completada
        completeButton.addActionListener(e -> toggleCompleteTask());

        // 4. Evento de botón: Eliminar Tarea
        deleteButton.addActionListener(e -> deleteTask());

        // 5. Opcional: Doble clic para Marcar/Desmarcar como Completada (MouseListener)
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    toggleCompleteTask();
                }
            }
        });
    }

   
     // Añade una nueva tarea a la lista.
    
    private void addTask() {
        String taskName = taskInputField.getText().trim();
        if (!taskName.isEmpty()) {
            listModel.addElement(new Task(taskName));
            taskInputField.setText(""); // Limpiar el campo de entrada
            taskInputField.requestFocusInWindow(); // Mantener el foco
            // Opcional: Desplazarse al final
            int lastIndex = listModel.getSize() - 1;
            taskList.ensureIndexIsVisible(lastIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, introduce el nombre de una tarea.", 
                                          "Error de Entrada", JOptionPane.WARNING_MESSAGE);
        }
    }

  
    private void toggleCompleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = listModel.getElementAt(selectedIndex);
            task.setCompleted(!task.isCompleted()); // Cambiar estado
            // Importante: forzar a JList a redibujar el elemento para ver el cambio de estado
            taskList.repaint(); 
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para marcarla.", 
                                          "Ninguna Tarea Seleccionada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Elimina la tarea seleccionada de la lista.
    
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para eliminarla.", 
                                          "Ninguna Tarea Seleccionada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new ToDoListApp());
    }
}