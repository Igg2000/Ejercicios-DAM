package data;

import PanelesGUI.PanelPaginaDeTexto;
import Ventana.Vppal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App implements Runnable{

    private File archivoEntrada = new File("src/res/personas.xml");
    private File archivoSalida = new File("src/res/personas2040.xml");
    private List<Persona> personas;

    @Override
    public void run() {
        App app = new App();
        app.leerXML(); // Leer el archivo personas.xml
        app.crearXML(); // Crear el archivo personas2040.xml con la edad calculada para 2040
        pintaArchivo(archivoEntrada);
        pintaArchivo(archivoSalida);
    }

    // Método para leer el archivo XML de entrada y generar la lista de personas
    public void leerXML() {
        personas = new ArrayList<>();

        try {
            // Crear un DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML y obtener el documento
            Document document = builder.parse(archivoEntrada);
            document.getDocumentElement().normalize();

            // Obtener todos los elementos "person" del archivo XML
            NodeList nodeList = document.getElementsByTagName("person");

            // Recorrer los nodos de las personas
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Extraer la información de cada persona
                    String firstName = element.getElementsByTagName("first").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last").item(0).getTextContent();
                    int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());

                    // Crear un nuevo objeto Persona y añadirlo a la lista
                    Persona nuevaPersona = new Persona(firstName, lastName, age);
                    personas.add(nuevaPersona);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para crear el archivo XML de salida con la edad calculada para 2040
    public void crearXML() {
        try {
            // Crear un DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear el nodo raíz <Personas>
            Element rootElement = document.createElement("Personas");
            document.appendChild(rootElement);

            // Obtener el año actual
            int yearActual = Year.now().getValue();

            // Crear los elementos <person> para cada persona
            for (Persona persona : personas) {
                // Calcular la edad en 2040
                int edadEn2040 = persona.getAge() + (2040 - yearActual);

                // Crear el nodo <Persona>
                Element personElement = document.createElement("Persona");

                // Establecer el atributo EdadEn2040
                personElement.setAttribute("EdadEn2040", String.valueOf(edadEn2040));

                // Crear los elementos dentro de <Persona>
                Element firstNameElement = document.createElement("Nombre");
                firstNameElement.appendChild(document.createTextNode(persona.getFirstName()));
                personElement.appendChild(firstNameElement);

                Element lastNameElement = document.createElement("Apellido");
                lastNameElement.appendChild(document.createTextNode(persona.getLastName()));
                personElement.appendChild(lastNameElement);

                // Añadir el nodo <Persona> al nodo raíz <Personas>
                rootElement.appendChild(personElement);
            }

            // Escribir el documento en un archivo XML con indentación
            FileWriter writer = new FileWriter(archivoSalida);
            writer.write(domToString(document)); // Convertir el documento a String con indentación
            writer.close();

            System.out.println("XML generado correctamente en: " + archivoSalida.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para convertir el objeto Document en un String con indentación
    private String domToString(Document document) throws IOException {
        try {
            java.io.StringWriter sw = new java.io.StringWriter();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();

            // Configurar el transformer para agregar indentación
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // 4 espacios de indentación

            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(sw);
            transformer.transform(source, result);
            return sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

   private void pintaArchivo(File archivo) {
        String cad = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            cad = contenido.toString(); // Convertir el contenido a cadena
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            cad = "Error al leer el archivo: " + e.getMessage();
        }

        // Crear el objeto PanelPaginaDeTexto con el contenido del archivo
        Vppal v = new Vppal();
        PanelPaginaDeTexto p = new PanelPaginaDeTexto("Contenido de " + archivo.getName(), cad);

        // Agregar el panel a la ventana o mostrarlo según corresponda
        v.ponPanel(p); // Supuesto método para agregar el panel (ajustar según tu implementación)
    }


}