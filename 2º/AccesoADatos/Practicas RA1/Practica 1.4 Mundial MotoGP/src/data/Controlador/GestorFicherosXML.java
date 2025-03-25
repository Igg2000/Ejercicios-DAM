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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

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

    public String recibirConsultasXPath() {
        String cadenaHtml = "";

        try {
            // Incluir estilo CSS en el encabezado
            cadenaHtml += "<head>";
            cadenaHtml += "<style>";
            cadenaHtml += "body { background-color: rgb(13, 16, 35); color: white; font-family: 'Segoe UI', sans-serif; }";
            cadenaHtml += ".consulta { margin-top: 20px; }";
            cadenaHtml += ".consulta h2 { margin-left: 20px; color: #FFD700; font-size: 24px; border-bottom: 2px solid #FFD700; padding-bottom: 5px; }";
            cadenaHtml += "ul { list-style-type: none; padding-left: 0; }";
            cadenaHtml += "ul li { background-color: rgb(49, 19, 20); color: white; font-size: 16px; padding: 10px; margin: 10px; border-radius: 5px; }";
            cadenaHtml += "</style>";
            cadenaHtml += "</head>";
            cadenaHtml += "<body>";

            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/res/ridersMotoGP.xml");

            // Crear un objeto XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            // Consulta 1: Muestra los 5 primeros pilotos clasificados en el mundial
            cadenaHtml += "<div class='consulta'>";
            cadenaHtml += "<h2>1. Los 5 primeros pilotos clasificados en el mundial</h2>";
            cadenaHtml += "<ul>\n"; // Abre la lista desordenada
            String consulta1 = "//row[position() <= 5]/data1/text()";
            NodeList resultado1 = (NodeList) xPath.evaluate(consulta1, doc, XPathConstants.NODESET);
            for (int i = 0; i < resultado1.getLength(); i++) {
                cadenaHtml += "<li>" + (i + 1) + ". " + resultado1.item(i).getTextContent() + "</li>\n";
            }
            cadenaHtml += "</ul>\n"; // Cierra la lista desordenada
            cadenaHtml += "</div>";

            // Consulta 2: Muestra el número y nombre de los pilotos de Yamaha
            cadenaHtml += "<div class='consulta'>";
            cadenaHtml += "<h2>2. Número y nombre de los pilotos de Yamaha</h2>";
            cadenaHtml += "<ul>\n"; // Abre la lista desordenada
            String consulta2 = "//row[data3='Yamaha']";
            NodeList resultado2 = (NodeList) xPath.evaluate(consulta2, doc, XPathConstants.NODESET);
            for (int i = 0; i < resultado2.getLength(); i++) {
                // Obtener el número del piloto
                String numero = xPath.evaluate("data0", resultado2.item(i));
                // Obtener el nombre del piloto
                String nombre = xPath.evaluate("data1", resultado2.item(i));
                cadenaHtml += "<li>Número: " + numero + ", Nombre: " + nombre + "</li>\n";
            }
            cadenaHtml += "</ul>\n"; // Cierra la lista desordenada
            cadenaHtml += "</div>";

            // Consulta 3: Muestra el nombre de los pilotos españoles
            cadenaHtml += "<div class='consulta'>";
            cadenaHtml += "<h2>3. Nombre de los pilotos españoles</h2>";
            cadenaHtml += "<ul>\n"; // Abre la lista desordenada
            String consulta3 = "//row[data1[contains(., 'ESP')]]/data1/text()";
            NodeList resultado3 = (NodeList) xPath.evaluate(consulta3, doc, XPathConstants.NODESET);
            for (int i = 0; i < resultado3.getLength(); i++) {
                cadenaHtml += "<li>- " + resultado3.item(i).getTextContent() + "</li>\n";
            }
            cadenaHtml += "</ul>\n"; // Cierra la lista desordenada
            cadenaHtml += "</div>";
            cadenaHtml += "</body>";

        } catch (Exception e) {
            cadenaHtml = "Ocurrió un error: " + e.getMessage();
        }

        return cadenaHtml;
    }

    //row[position() <= 5]/data1/text()
    //row[data2='Yamaha']/concat(data0, ' - ', data1)/text()
    //row[data1[contains(., 'ESP')]]/data1/text()

    
}

