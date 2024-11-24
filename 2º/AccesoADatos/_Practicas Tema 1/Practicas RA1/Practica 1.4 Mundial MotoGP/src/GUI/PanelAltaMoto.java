package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import data.Modelo.Moto;
import data.Modelo.Mundial;

import javax.swing.*;
import java.util.List;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nacho
 */
public class PanelAltaMoto extends PanelAltas {

    private final Ventana v;
    private final JPanel panelAnterior;



    public PanelAltaMoto(Ventana v, JPanel panelAnterior, String titulo, List<String> atributos) {
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
        setBtnDarAlta(new NBoton("Dar Moto de Alta", v.color1, v.color2));
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
            String numeroStr = getFieldValues().get("Número");
            String marca = getFieldValues().get("Marca");
            String modelo = getFieldValues().get("Modelo");

            // Validar campos obligatorios
            if (numeroStr.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir el número a un entero
            int numero;
            try {
                numero = Integer.parseInt(numeroStr);
                if (numero <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El número debe ser un entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si ya existe una moto con el mismo número
            boolean motoExiste = v.mundial.getMotos().stream()
                .anyMatch(moto -> moto.getNumero() == numero);

            if (motoExiste) {
                JOptionPane.showMessageDialog(this, "Ya existe una moto con ese número.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el objeto Moto
            Moto nuevaMoto = new Moto(numero, marca, modelo);

            // Agregar la moto al Mundial
            v.mundial.agregarMoto(nuevaMoto);
            JOptionPane.showMessageDialog(this, "Moto añadida correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar campos tras alta exitosa
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al añadir la moto.", "Error", JOptionPane.ERROR_MESSAGE);
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
