package data;

import PanelesGUI.PanelPaginaDeTexto;
import Ventana.Vppal;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clase para procesar un archivo XML de empleados usando DOM.
 * 
 * @author Nacho
 */
class App implements Runnable {

    private File archivoXML = new File("src//res//empleados.xml");
    private List<Empleado> empleados;

    @Override
    public void run() {
        try {
            empleados = new ArrayList<>();

            // Crear un DocumentBuilder para procesar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML y obtener el documento
            Document document = builder.parse(archivoXML);
            document.getDocumentElement().normalize();  // Normalizar el documento

            // Obtener todos los elementos "employee" del archivo XML
            NodeList nodeList = document.getElementsByTagName("employee");

            // Recorrer los nodos de los empleados
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Extraer la información de cada empleado
                    String id = element.getAttribute("id");
                    String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                    String location = element.getElementsByTagName("location").item(0).getTextContent();

                    // Crear un nuevo objeto Empleado y añadirlo a la lista
                    Empleado nuevoEmpleado = new Empleado(id, firstName, lastName, location);
                    empleados.add(nuevoEmpleado);
                }
            }
            

            pintarEmpleadosEnVentana();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pintarEmpleadosEnVentana() {
        StringBuilder cad = new StringBuilder();
        for (Empleado e : empleados) {
            cad.append(e).append("\n\n");
        }

        // Mostrar la lista de empleados en la ventana
        Vppal v = new Vppal();
        PanelPaginaDeTexto p = new PanelPaginaDeTexto("Leer de empleados.xml", cad.toString());
        v.ponPanel(p);
    }
}
