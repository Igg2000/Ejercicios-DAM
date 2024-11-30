/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import java.util.List;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 *
 * @author Nacho
 */
public class PanelAltaPlanta extends PanelAltas {

    private final Ventana v;
    private final JPanel panelAnterior;

    public PanelAltaPlanta(Ventana v, JPanel panelAnterior, String titulo, List<String> atributos) {
        super(titulo, atributos);
        this.v = v;
        this.panelAnterior = panelAnterior;

        // Configurar estética del panel
        ponerImagenDeFondo("src//res//fondoFloristeria.jpg");

        JPanel panelCentral = getInputPanel();
        panelCentral.setOpaque(true);
        panelCentral.setBackground(v.colorFondo);
        getTitleLabel().setForeground(v.colorLetraTitulo);
        getTitleLabel().setFont(v.fuenteTitulo);
        setAttributeLabelColor(v.color1);
        setAttributeLabelFont(v.fuenteBotones);
        setFieldColor(v.color2);
        panelCentral.setBorder(new CompoundBorder(new LineBorder(v.color2, 3), new EmptyBorder(5, 5, 5, 5)));

        setBtnVolver(new NBoton("Volver", v.color1, v.color2));
        getBtnVolver().setFont(v.fuenteBotones);
        setBtnDarAlta(new NBoton("Dar Planta de Alta", v.color1, v.color2));
        getBtnDarAlta().setFont(v.fuenteBotones);
    }

    @Override
    protected void onVolver() {
        v.ponPanel(panelAnterior);
    }

    @Override
    protected void onDarAlta() {
        try {
            // Obtener los valores de los campos
            String nombre = getFieldValues().get("Nombre");
            String tamañoTexto = getFieldValues().get("Tamaño");
            String cantidadTexto = getFieldValues().get("Cantidad");

            // Validar campos
            if (nombre.isEmpty() || tamañoTexto.isEmpty() || cantidadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar tamaño
            if (!esTamañoValido(tamañoTexto.toLowerCase())) {
                JOptionPane.showMessageDialog(this, "El tamaño debe ser 'pequeño', 'mediano' o 'grande'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar y convertir cantidad
            int cantidad;
            try {
                cantidad = Integer.parseInt(cantidadTexto);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Usar el método de Floristeria para agregar la planta
            v.getFloristeria().agregarPlanta(nombre, tamañoTexto.toLowerCase(), cantidad);
            JOptionPane.showMessageDialog(this, "Planta añadida correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos tras un alta exitosa
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al añadir la planta.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Limpia los campos de entrada después de una operación exitosa.
     */
    private void limpiarCampos() {
        getFields().forEach((key, field) -> field.setText(""));
    }

    /**
     * Comprueba si un tamaño ingresado es válido.
     * 
     * @param tamaño Texto del tamaño ingresado.
     * @return true si es válido, false en caso contrario.
     */
    private boolean esTamañoValido(String tamaño) {
        return tamaño.equals("pequeño") || tamaño.equals("mediano") || tamaño.equals("grande");
    }
}
