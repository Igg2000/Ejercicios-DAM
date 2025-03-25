/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import java.util.List;
import javax.swing.JPanel;
import PanelesGUI.PanelAltas;
import data.Modelo.Piloto;


import javax.swing.*;
import java.util.List;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
/**
 *
 * @author grovy
 */
public class PanelAltaPiloto extends PanelAltas {

    private final Ventana v;
    private final JPanel panelAnterior;
    private final String escuderia;

    public PanelAltaPiloto(Ventana v, JPanel panelAnterior, String escuderia, String titulo, List<String> atributos) {
        super(titulo, atributos);
        this.v = v;
        this.panelAnterior = panelAnterior;
        this.escuderia = escuderia;
        
        //cambiar la estetica del panel
        
        ponerImagenDeFondo("src//res//fondoMotoGP.png");
        
        JPanel panelCentral = getInputPanel();
        panelCentral.setOpaque(true);
        panelCentral.setBackground(v.colorFondo);
        getTitleLabel().setForeground(v.colorLetraTitulo);
        getTitleLabel().setFont(v.fuenteTitulo);
        setAttributeLabelColor(v.colorLetraTitulo);
        setAttributeLabelFont(v.fuenteBotones);
        setFieldColor(v.color2);
        panelCentral.setBorder(new CompoundBorder(new LineBorder(v.color2, 3), new EmptyBorder(5, 5, 5, 5)));
        
        setBtnVolver(new NBoton("Volver", v.color1, v.color2));
        getBtnVolver().setFont(v.fuenteBotones);
        setBtnDarAlta(new NBoton("Dar Piloto de Alta", v.color1, v.color2));
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
            String nacionalidad = getFieldValues().get("Nacionalidad");

            // Validar campos
            if (nombre.isEmpty() || nacionalidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el piloto ya existe
            boolean pilotoExiste = v.mundial.getPilotos().stream()
                .anyMatch(piloto -> piloto.getNombre().equalsIgnoreCase(nombre));

            if (pilotoExiste) {
                JOptionPane.showMessageDialog(this, "Ya existe un piloto con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un nuevo piloto
            Piloto nuevoPiloto = new Piloto(nombre, nacionalidad, escuderia);

            // Agregar el piloto al mundial
            v.mundial.agregarPiloto(nuevoPiloto);
            JOptionPane.showMessageDialog(this, "Piloto añadido correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar campos tras alta exitosa
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al añadir el piloto.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Limpia los campos de entrada después de una operación exitosa.
     */
    private void limpiarCampos() {
        getFields().forEach((key, field) -> field.setText(""));
    }
    
}
