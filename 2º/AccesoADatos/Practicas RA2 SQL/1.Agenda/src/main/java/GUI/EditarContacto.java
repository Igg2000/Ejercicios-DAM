/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Temas.UtilTema;
import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import Ventana.Vppal;
import data.App;
import data.Contacto;
import data.GestorBD;
import static data.GestorBD.modificarDatos;
import java.awt.Dimension;
import java.sql.Connection;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;


/**
 * Panel en el que se puede modificar o eliminar contactos
 * @author Nacho
 */
public class EditarContacto extends PanelAltas {

    private final Vppal ventana;
    private final JPanel menuPrincipal;
    private final JPanel panelAnterior;
    private final Contacto contacto;

    public EditarContacto(Vppal ventana, JPanel menuPrincipal, ListasContactos panelAnterior, Contacto contacto) {
        super("Editar Contacto", List.of("Nombre", "Telefono", "Direccion", "Aficiones", "Pandilla", "Sitio de Veraneo"));
        this.ventana = ventana;
        this.menuPrincipal = menuPrincipal;
        this.panelAnterior = panelAnterior;
        this.contacto = contacto;
        
        // Rellenar los campos con los datos del contacto
        inicializarCampos();

        // Configurar botones
        configurarBotones();
        
        UtilTema.aplicarTema(this, App.TEMA);
        getTitleLabel().setFont(App.TEMA.getFuenteTitulo());
    }

    private void inicializarCampos() {
        HashMap<String, JTextField> fields = getFields();
        fields.get("Nombre").setText(contacto.getNombre());
        fields.get("Telefono").setText(contacto.getTelefono());
        fields.get("Direccion").setText(contacto.getDireccion());
        fields.get("Aficiones").setText(contacto.getAficiones());
        fields.get("Pandilla").setText(contacto.getPandilla());
        fields.get("Sitio de Veraneo").setText(contacto.getSitioVeraneo());
    }

    private void configurarBotones() {
        /*
        // Botón para volver al panel anterior
        setBtnVolver(new NBoton("Volver", ventana.color1, ventana.color2));
        getBtnVolver().setFont(ventana.fuenteBotones);

        // Botón para guardar cambios
        setBtnDarAlta(new NBoton("Guardar Cambios", ventana.color1, ventana.color2));
        getBtnDarAlta().setFont(ventana.fuenteBotones);
        */
        // Botón para eliminar contacto
        JButton btnEliminar = new JButton("Eliminar Contacto");
        setBtnDarAlta(new JButton("Guardar Cambios"));
        //btnEliminar.setFont(ventana.fuenteBotones);
        getBtnDarAlta().setPreferredSize(new Dimension(180, 35)); // Tamaño uniforme
        btnEliminar.setPreferredSize(new Dimension(180, 35)); // Tamaño uniforme
        JPanel buttonPanel = getButtonPanel();
        buttonPanel.add(btnEliminar);

        btnEliminar.addActionListener(e -> eliminarContacto());
    }

    private void eliminarContacto() {
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas eliminar este contacto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                //elimino el contacto
                GestorBD.borrarDatos(GestorBD.getConexion(), "Contactos", "Id", contacto.getId());
                JOptionPane.showMessageDialog(null, "Contacto eliminado exitosamente.");
                //reinicio el panel anterior antes de ponerlo
                ListasContactos p = (ListasContactos)panelAnterior;
                p.removeAll();
                p.minitComponents();
                

                JButton btn = new JButton(" Volver ");
                btn.setPreferredSize(new Dimension(120, 35)); // Tamaño uniforme
                UtilTema.aplicarTema(btn, App.TEMA);
                Metodos.MetodosGUI.agregarBotonDeVolverAUnPanel(ventana, p, menuPrincipal,btn);
                
                ventana.ponPanel(p);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el contacto: " + ex.getMessage());
            }
        }
    }

    @Override
    protected void onVolver() {
        ListasContactos p = (ListasContactos)panelAnterior;
        p.removeAll();
        p.minitComponents();
        
        JButton btn = new JButton("Volver");
        btn.setPreferredSize(new Dimension(120, 35)); // Tamaño uniforme
        UtilTema.aplicarTema(btn, App.TEMA);
        Metodos.MetodosGUI.agregarBotonDeVolverAUnPanel(ventana, p, menuPrincipal ,btn);
        
        ventana.ponPanel(p);
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

        // Validación de campos
        try {
            if (!hayErrores(nombre, telefono, direccion, aficiones)) {
                contacto.setNombre(nombre);
                contacto.setTelefono(telefono);
                contacto.setDireccion(direccion);
                contacto.setAficiones(aficiones);
                contacto.setPandilla(pandilla);
                contacto.setSitioVeraneo(veraneo);

                //actualizo contacto
                actualizarContacto(GestorBD.getConexion(), contacto);
                
                JOptionPane.showMessageDialog(null, "Contacto actualizado correctamente.");
                ventana.ponPanel(panelAnterior);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(ventana, e.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ventana, "Error al actualizar el contacto: " + ex.getMessage());
        }
    }

    private boolean hayErrores(String nombre, String telefono, String direccion, String aficiones) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono debe contener 9 dígitos.");
        }
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        if (aficiones == null || aficiones.isBlank()) {
            throw new IllegalArgumentException("Las aficiones no pueden estar vacías.");
        }
        return false;
    }
    
    public static void actualizarContacto(Connection con, Contacto contacto) throws SQLException {
        String[] campos = {"Nombre", "Telefono", "Direccion", "Aficiones", "Pandilla", "Veraneo"};
        Object[] nuevosValores = {
            contacto.getNombre(),
            contacto.getTelefono(),
            contacto.getDireccion(),
            contacto.getAficiones(),
            contacto.getPandilla(),
            contacto.getSitioVeraneo()
        };

        modificarDatos(con, "Contactos", campos, nuevosValores, "Id", contacto.getId());
    }
}
