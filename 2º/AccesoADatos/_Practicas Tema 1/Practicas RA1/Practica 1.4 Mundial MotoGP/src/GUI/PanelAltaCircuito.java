package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import data.Modelo.Circuito;
import data.Modelo.Mundial;
import java.awt.Color;
import javax.swing.*;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelAltaCircuito extends PanelAltas {

    private final Ventana v;
    private final JPanel panelAnterior;

    public PanelAltaCircuito(Ventana v, JPanel panelAnterior, String titulo, List<String> atributos) {
        super(titulo, atributos);
        this.v = v;
        this.panelAnterior = panelAnterior;
        
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
        setBtnDarAlta(new NBoton("Dar Circuito de Alta", v.color1, v.color2));
        getBtnDarAlta().setFont(v.fuenteBotones);
    }

    @Override
    protected void onVolver() {
        v.ponPanel(panelAnterior);
    }

    @Override
   protected void onDarAlta() {
       try {
           // Obtener valores de los campos
           String nombre = getFieldValues().get("Nombre");
           String pais = getFieldValues().get("País");
           String longitudStr = getFieldValues().get("Longitud");

           // Validar campos obligatorios
           if (nombre.isEmpty() || pais.isEmpty() || longitudStr.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
               return;
           }

            // Reemplazar comas con puntos para soportar ambos formatos
            longitudStr = longitudStr.replace(",", ".");

           // Convertir la longitud a un número
           double longitud;
           try {
               longitud = Double.parseDouble(longitudStr);
               if (longitud <= 0) {
                   throw new NumberFormatException();
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "La longitud debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
               return;
           }

           // Verificar si el circuito ya existe
           boolean circuitoExiste = v.mundial.getCircuitos().stream()
                   .anyMatch(circuito -> circuito.getNombre().equalsIgnoreCase(nombre));

           if (circuitoExiste) {
               JOptionPane.showMessageDialog(this, "El circuito ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
               return;
           }

           // Crear el objeto Circuito y agregarlo al Mundial
           Circuito nuevoCircuito = new Circuito(nombre, pais, longitud);
           v.mundial.agregarCircuito(nuevoCircuito);
           JOptionPane.showMessageDialog(this, "Circuito añadido correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

           // Limpiar campos tras alta exitosa
           limpiarCampos();

       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Ocurrió un error al añadir el circuito.", "Error", JOptionPane.ERROR_MESSAGE);
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
