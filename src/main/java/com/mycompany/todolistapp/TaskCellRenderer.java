/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

public class TaskCellRenderer extends JLabel implements ListCellRenderer<Task> {

    public TaskCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Task> list,
            Task value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        // 1. Establecer el texto
        setText(value.getName());

        // 2. Manejar la selección y el foco
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        // 3. Establecer el estilo basado en el estado (Completada o Pendiente)
        if (value.isCompleted()) {
            // Tarea completada: color gris y fuente tachada (StrikeThrough)
            setForeground(Color.GRAY);
            setFont(getFont().deriveFont(Font.ITALIC)); // Se usará para diferenciación visual
        } else {
            // Tarea pendiente: color por defecto y fuente normal
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            setFont(getFont().deriveFont(Font.PLAIN));
        }

        return this;
    }

    // Pintar el texto tachado si la tarea está completada
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getForeground() == Color.GRAY && getFont().isItalic()) { // Condición para completada
            // Calcula la posición del tachado
            int y = getHeight() / 2 + 1; // Un poco más abajo del centro
            // Dibuja la línea que tacha el texto
            g.drawLine(0, y, getWidth(), y);
        }
    }
}