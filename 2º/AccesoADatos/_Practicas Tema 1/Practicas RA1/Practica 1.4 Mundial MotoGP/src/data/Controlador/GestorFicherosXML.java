/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Controlador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import data.Modelo.Circuito;
import data.Modelo.Moto;
import data.Modelo.Mundial;
import data.Modelo.Piloto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JOptionPane;

/**
 * Clase para gestionar la exportación e importación de datos del Mundial en formato XML.
 *
 * @author Nacho
 */
public class GestorFicherosXML {

    private Mundial mundial;
    private final File fichXML;

    public GestorFicherosXML(Mundial mundial) {
        this.mundial = mundial;
        this.fichXML = new File("src/res/mundial.xml"); // Ruta del archivo XML
    }

    /**
     * Exporta el objeto Mundial a un archivo XML.
     */
    public void exportarXML() {
        XStream xstream = new XStream(new DomDriver());
   
        //pongo los alias para que quede mejor el xml
        xstream.alias("Mundial", Mundial.class);
        xstream.alias("Circuito", Circuito.class);
        xstream.alias("Moto", Moto.class);
        xstream.alias("Piloto", Piloto.class);

        
        if(mundial.getCircuitos().isEmpty() && mundial.getEscuderias().isEmpty() && mundial.getMotos().isEmpty() && mundial.getPilotos().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ahora mismo el programa no tiene datos, no tiene sentido exportar");
            return;
        }
            
        
        try (FileWriter writer = new FileWriter(fichXML)) {
            String xml = xstream.toXML(mundial); // Convertir el objeto Mundial a XML
            writer.write(xml); // Escribir en el archivo
            JOptionPane.showMessageDialog(null, "Se ha exportado con exito en: "+fichXML.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al exportar el XML: " + e.getMessage());
        }
    }

    /**
     * Importa los datos desde un archivo XML al objeto Mundial.
     */
    public Mundial importarXML() {
        if (!fichXML.exists()) {
            System.err.println("El archivo XML no existe: " + fichXML.getAbsolutePath());
            return null;
        }

        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        //pongo los alias para que quede mejor el xml
        xstream.alias("Mundial", Mundial.class);
        xstream.alias("Circuito", Circuito.class);
        xstream.alias("Moto", Moto.class);
        xstream.alias("Piloto", Piloto.class);

        try {
            String xml = Files.readString(fichXML.toPath()); // Leer contenido del archivo
            //System.out.println(((Mundial) xstream.fromXML(xml)));
            JOptionPane.showMessageDialog(null, "El XML se ha importado con exito");
            return ((Mundial) xstream.fromXML(xml)); // Convertir XML a objeto Mundial
        } catch (IOException e) {
            System.err.println("Error al importar el XML: " + e.getMessage());
            return null;
        }
    }
    
}

