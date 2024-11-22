/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class PanelPruebaAltas extends PanelAltas {

    public PanelPruebaAltas(List<String> atributos) {
        super("Panel de prueba",atributos);
        
        //setBackgroundColor(new Color(140, 140, 240));
        setTitleFont(new Font("Serif", Font.BOLD, 42));
        setFieldFont(new Font("SansSerif", Font.PLAIN, 14));
        setFieldColor(Color.white);
        setAttributeLabelFont(new Font("Arial", Font.ITALIC, 14));
        setAttributeLabelColor(Color.DARK_GRAY);
        
        
        //ponerImagenDeFondo("C://Users//Nacho//OneDrive//Imágenes//wallpaperbetter.com_1920x1080.jpg");
    }

    @Override
    protected void onVolver() {
        JOptionPane.showMessageDialog(this, "Volviendo al menú anterior.");
        // Lógica para volver atrás
    }

    @Override
    protected void onDarAlta() {

        var valores = getFieldValues();

        // Obtener los valores necesarios
        String nombre = valores.get("Nombre");
        String apellido = valores.get("Apellido");
        String correoElectronico = valores.get("Correo Electrónico");

        // Crear el objeto Empleado
        Empleado empleado = new Empleado(nombre, apellido, correoElectronico);

        // Mostrar el empleado creado
        JOptionPane.showMessageDialog(this, "Empleado creado:\n" + empleado);

        // Lógica adicional, como agregar el empleado a una lista o base de datos
        System.out.println("Empleado creado: " + empleado);

    }

    
}
