/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Map;

/**
 * Clase base para trabajar con jTable
 * @author Nacho
 */
public class MiTabla extends JTable {
    private DefaultTableModel tableModel;

    /**
     * Crea una tabla con el contenido de un mapa
     * @param mapa mapa que quieres meterle a la tabla
     * @param clave nombre de la clave para la cabecera
     * @param valor nombre del valor para la cabecera
     */
    public MiTabla(Map mapa, String clave, String valor) {
        // Inicializamos el modelo de tabla con dos columnas por defecto
        tableModel = new DefaultTableModel(new String[]{clave, valor}, 0);
        setModel(tableModel);
        cargarMapa(mapa);
    }

    public MiTabla(Map mapa) {
        this(mapa,"Clave","Valor");
    }
    
    

    
    public <K, V> void cargarMapa(Map<K, V> mapa) {
        // Limpiar el modelo de tabla
        tableModel.setRowCount(0);

        // Metemos las entradas del mapa al modelo de tabla
        for (Map.Entry<K, V> entry : mapa.entrySet()) {
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
    }

    // Método para cambiar el nombre de las columnas
    public void setColumnNames(String col1, String col2) {
        tableModel.setColumnIdentifiers(new String[]{col1, col2});
    }
    
        // Método para personalizar las cabeceras de la tabla
    public void personalizarCabeceras(Font font, Color background, Color foreground) {
        JTableHeader header = getTableHeader();
        header.setFont(font);
        header.setBackground(background);
        header.setForeground(foreground);
        header.setReorderingAllowed(false); // Evitar mover columnas
    }

    // Método para personalizar las columnas
    public void personalizarColumnas(int columnIndex, Font font, Color background, Color foreground, int alignment) {
        TableColumn columna = getColumnModel().getColumn(columnIndex);
        columna.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(font);
                c.setBackground(background);
                c.setForeground(foreground);
                setHorizontalAlignment(alignment); // Alinear el texto
                return c;
            }
        });
    }

}