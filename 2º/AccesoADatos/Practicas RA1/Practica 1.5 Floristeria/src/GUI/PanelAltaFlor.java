package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import data.Modelo.Flor;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.util.List;
import java.util.Map;

public class PanelAltaFlor extends PanelAltas {

    private final Ventana v;
    private final JPanel panelAnterior;

    public PanelAltaFlor(Ventana v, JPanel panelAnterior, String titulo, List<String> atributos) {
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
        setBtnDarAlta(new NBoton("Dar Flor de Alta", v.color1, v.color2));
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
            String colorTexto = getFieldValues().get("Color");
            String cantidadTexto = getFieldValues().get("Cantidad");
            String precioTexto = getFieldValues().get("Precio");

            
            if(precioTexto.contains(","))
                precioTexto = precioTexto.replace(",",".");
                        
            // Validar campos
            if (nombre.isEmpty() || colorTexto.isEmpty() || cantidadTexto.isEmpty() || precioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir color de texto a objeto Color
            Color color = obtenerColor(colorTexto.toLowerCase());
            if (color == null) {
                String cadErrorColor = "El color ingresado no es válido. Use uno de la siguiente lista:\n";

                // Recorremos las claves del mapa y las añadimos al StringBuilder
                for (String c : coloresPredefinidos.keySet()) {
                    cadErrorColor += c + "\n";
                }

                JOptionPane.showMessageDialog(this, cadErrorColor, "Error", JOptionPane.ERROR_MESSAGE);
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

            // Validar y convertir precio
            double precio;
            try {
                precio = Double.parseDouble(precioTexto);
                if (precio <= 0) {
                    JOptionPane.showMessageDialog(this, "El precio debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número decimal.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Usar el método de Floristeria para agregar la flor
            v.getFloristeria().agregarFlor(nombre, colorTexto, cantidad, precio);
            JOptionPane.showMessageDialog(this, "Flor añadida correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos tras un alta exitosa
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al añadir la flor.", "Error", JOptionPane.ERROR_MESSAGE);
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
     * Convierte un nombre de color en texto a un objeto Color.
     * 
     * @param colorTexto Nombre del color en español.
     * @return Objeto Color correspondiente o null si no existe.
     */
    private Color obtenerColor(String colorTexto) {
        return coloresPredefinidos.get(colorTexto);
    }

    // Mapa de colores predefinidos
    private static final Map<String, Color> coloresPredefinidos = new HashMap<>();

    static {
        coloresPredefinidos.put("rojo", Color.RED);
        coloresPredefinidos.put("verde", Color.GREEN);
        coloresPredefinidos.put("azul", Color.BLUE);
        coloresPredefinidos.put("amarillo", Color.YELLOW);
        coloresPredefinidos.put("naranja", new Color(255, 165, 0));
        coloresPredefinidos.put("morado", new Color(128, 0, 128));
        coloresPredefinidos.put("rosa", new Color(255, 105, 180));
        coloresPredefinidos.put("blanco", Color.WHITE);
        coloresPredefinidos.put("negro", Color.BLACK);
        coloresPredefinidos.put("gris", Color.GRAY);
    }
}
