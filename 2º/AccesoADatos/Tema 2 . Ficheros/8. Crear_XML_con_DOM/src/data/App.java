package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class App implements Runnable {

    private File archivoXML = new File("src/res/empleados.xml");
    private List<Empleado> empleados;

    @Override
    public void run() {
        try {
            // Crear una lista de empleados con datos de prueba
            empleados = new ArrayList<>();
            empleados.add(new Empleado("111", "Lokesh", "Gupta", "India"));
            empleados.add(new Empleado("222", "Alex", "Gussin", "Russia"));
            empleados.add(new Empleado("333", "David", "Feezor", "USA"));

            // Crear el XML con los empleados
            crearXML();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para crear el archivo XML
    private void crearXML() {
        try {
            // Crear un DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear el nodo raíz <empleados>
            Element rootElement = document.createElement("empleados");
            document.appendChild(rootElement);

            // Crear los elementos <employee> para cada empleado
            for (Empleado e : empleados) {
                // Crear el nodo <employee>
                Element employeeElement = document.createElement("employee");
                employeeElement.setAttribute("id", e.getId());

                // Crear los elementos dentro de <employee>
                Element firstNameElement = document.createElement("firstName");
                firstNameElement.appendChild(document.createTextNode(e.getFirstName()));
                employeeElement.appendChild(firstNameElement);

                Element lastNameElement = document.createElement("lastName");
                lastNameElement.appendChild(document.createTextNode(e.getLastName()));
                employeeElement.appendChild(lastNameElement);

                Element locationElement = document.createElement("location");
                locationElement.appendChild(document.createTextNode(e.getLocation()));
                employeeElement.appendChild(locationElement);

                // Añadir el nodo <employee> al nodo raíz <empleados>
                rootElement.appendChild(employeeElement);
            }

            // Escribir el documento en un archivo XML con indentación
            FileWriter writer = new FileWriter(archivoXML);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write(domToString(document)); // Convertir el documento a String con indentación
            writer.close();

            System.out.println("XML generado correctamente en: " + archivoXML.getAbsolutePath());

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

    public static void main(String[] args) {
        App app = new App();
        app.run(); // Llamar al método run para generar el XML
    }
}
