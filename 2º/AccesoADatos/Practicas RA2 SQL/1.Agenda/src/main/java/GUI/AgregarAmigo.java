/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import Ventana.Vppal;
import data.Contacto;
import data.GestorBD;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author grovy
 */
public class AgregarAmigo extends PanelAltas {

    private final Vppal v;
    private final MenuPrincipal panelAnterior;


    public AgregarAmigo(Vppal v, MenuPrincipal panelAnterior, String titulo, List<String> opciones) {
        super(titulo, opciones);
        this.v = v;
        this.panelAnterior = panelAnterior;
        /*
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

        */
        
        //pruebas
        HashMap<String, JTextField> f = getFields();
        f.get("Nombre").setText("Pepe");
        f.get("Telefono").setText("123456789");
        f.get("Direccion").setText("Calle de ejemplo");
        f.get("Aficiones").setText("Furbo y Baloncesto");
        f.get("Pandilla").setText("La banda del patio");
        //f.get("Sitio de Veraneo").setText("Murcia");
        
    }
    
    

    @Override
    protected void onVolver() {
        v.ponPanel(panelAnterior);
    }

    @Override
    protected void onDarAlta() {
        HashMap<String, String> valores = getFieldValues();
        String nombre = valores.get("Nombre");
        String telefono = valores.get("Telefono");
        String direccion = valores.get("Direccion");
        String aficiones = valores.get("Aficiones");
        String pandilla = valores.get("Pandilla");
        String veraneo = valores.get("Sitio de Veraneo");
        
        
        //manejo de errores
        try {
            if (!hayErrores(nombre, telefono, direccion, aficiones)) {
                System.out.println("Todos los valores son correctos.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(v,e.getMessage());
            return;
        }
        
        Contacto nc = new Contacto(nombre, telefono, direccion, aficiones, pandilla, veraneo);

        
        
        System.out.println("El nuevo contacto es: \n"+ nc);
        
        String[] campos = {"Nombre", "Telefono", "Direccion", "Pandilla", "\"Lugar De Veraneo\""};
        Object[] valoresContacto = {
            nc.getNombre(),
            Integer.parseInt(nc.getTelefono()), // Convertir a número
            nc.getDireccion(),
            nc.getPandilla(),
            nc.getSitioVeraneo()
        };
        
        try {
            GestorBD.insertarDatos(GestorBD.getConexion(), "Contactos", valoresContacto, campos);
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos en la base de datos:\n"+ex.getMessage());
        }
                
    }

    private boolean hayErrores(String nombre, String telefono, String direccion, String aficiones) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono debe contener 9 dígitos.");
        }
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o vacía.");
        }
        if (aficiones == null || aficiones.isBlank()) {
            throw new IllegalArgumentException("Las aficiones no pueden ser nulas o vacías.");
        }
        return false; // Si no hay errores, devuelve false
    }

    
}
