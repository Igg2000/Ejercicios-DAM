package PanelesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class PanelAltas extends JPanel {

    private final JLabel titleLabel;
    private final JPanel inputPanel;
    private final JPanel inputPanelWrapper;
    private final JPanel buttonPanel;
    private final HashMap<String, JTextField> fields;
    private Image imagenFondo;

    public PanelAltas(String titulo, List<String> atributos) {
        this.fields = new HashMap<>();
        setLayout(new BorderLayout(10, 10)); // Margen entre secciones

        // Panel superior para el título
        titleLabel = new JLabel(titulo, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Panel central para los campos de entrada
        
        inputPanelWrapper = new JPanel(new GridBagLayout());
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(atributos.size(), 2, 10, 10));
        inputPanel.setPreferredSize(new Dimension(400, atributos.size() * 35)); // Dimensiones ajustadas

        for (String atributo : atributos) {
            JLabel label = new JLabel(atributo + ":");
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(200, 25)); // Altura adecuada
            fields.put(atributo, textField);
            inputPanel.add(label);
            inputPanel.add(textField);
        }
        inputPanelWrapper.add(inputPanel); // Centrar en el wrapper
        add(inputPanelWrapper, BorderLayout.CENTER);

        // Panel inferior para los botones
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton btnVolver = new JButton("Volver");
        btnVolver.setPreferredSize(new Dimension(120, 35)); // Tamaño uniforme
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onVolver();
            }
        });

        JButton btnDarAlta = new JButton("Dar de Alta");
        btnDarAlta.setPreferredSize(new Dimension(120, 35)); // Tamaño uniforme
        btnDarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDarAlta();
            }
        });

        buttonPanel.add(btnVolver);
        buttonPanel.add(btnDarAlta);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters
    /**
     * Te devuelve el Label del titulo
     * @return 
     */
    public JLabel getTitleLabel() {
        return titleLabel;
    }
    /**
     * Te devuelve el panel del medio, el que tiene los campos
     * @return 
     */
    public JPanel getInputPanel() {
        return inputPanel;
    }

    /**
     * Te devuelve el panel de abajo, el que contiene los botones
     * @return 
     */
    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * Te devuelve un HashMap con los campos
     * @return 
     */
    public HashMap<String, JTextField> getFields() {
        return fields;
    }

    // Setters
    /**
     * Cambia el titulo del panel
     * @param title 
     */
    public void setTitle(String title) {
        titleLabel.setText(title);
    }

    /**
     * Cambia el valor del campo que le digas
     * @param fieldName nombre del campo
     * @param value valor que quieres poner
     */
    public void setFieldValue(String fieldName, String value) {
        if (fields.containsKey(fieldName)) {
            fields.get(fieldName).setText(value);
        }
    }

    /**
     * Cambia el color de fondo de todos los paneles
     * @param color 
     */
    public void setBackgroundColor(Color color) {
        setBackground(color);
        inputPanel.setBackground(color);
        buttonPanel.setBackground(color);
        inputPanelWrapper.setBackground(color);
    }

    /**
     * Cambia la fuente del titulo
     * @param font 
     */
    public void setTitleFont(Font font) {
        titleLabel.setFont(font);
    }

    /**
     * Cambia la fuente de los campos
     * @param font 
     */
    public void setFieldFont(Font font) {
        for (JTextField field : fields.values()) {
            field.setFont(font);
        }
    }
    
    
    /**
     * Cambia la fuente de los Atributos
     * @param font 
     */
    public void setAttributeLabelFont(Font font) {
        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JLabel) {
                component.setFont(font);
            }
        }
    }

    /**
     * Cambia el color de los campos
     * @param color 
     */
    public void setFieldColor(Color color) {
        for (JTextField field : fields.values()) {
            field.setBackground(color);
        }
    }

    /**
     * Cambia el color de los atributos
     * @param color 
     */
    public void setAttributeLabelColor(Color color) {
        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JLabel) {
                component.setForeground(color);
            }
        }
    }

    /**
     * Devuelve un mapa con los atributos y los campos
     * @return 
     */
    public HashMap<String, String> getFieldValues() {
        HashMap<String, String> values = new HashMap<>();
        for (String key : fields.keySet()) {
            values.put(key, fields.get(key).getText());
        }
        return values;
    }

    // Método para leer y redimensionar la imagen
    public void ponerImagenDeFondo(String rutaImagen) {
        try {
            Image imagenBase = Metodos.MetodosGUI.leerImagen(rutaImagen);
            if (imagenBase != null) {
                imagenFondo = imagenBase; // Guardamos la imagen sin redimensionar por ahora
                ponerTodosLosPanelesSinOpacidad();
                repaint();  // Redibujamos el panel para aplicar la imagen redimensionada
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Métodos abstractos
    protected abstract void onVolver();

    protected abstract void onDarAlta();
    
    
       // Método para dibujar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);  // Dibujamos la imagen redimensionada
        }
        
    }

    private void ponerTodosLosPanelesSinOpacidad() {
        
        inputPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        inputPanelWrapper.setOpaque(false);
    }
}
