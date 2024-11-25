package data;

import PanelesGUI.PanelPaginaDeTexto;
import Ventana.Vppal;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Clase para procesar un archivo XML de empleados usando XStream.
 * 
 * @author Nacho
 */
class App implements Runnable {

    private File archivoXML = new File("src//res//empleados.xml");
    private List<Empleado> empleados;

    public App() {
    }

    
    
    @Override
    public void run() {
        try {
            // Crear una instancia de XStream
            XStream xstream = new XStream();
            //xstream.addPermission(AnyTypePermission.ANY);
            
            // Configuración de permisos
            xstream.addPermission(NoTypePermission.NONE); // Bloquea todo
            xstream.allowTypes(new Class[]{Empleado.class}); // Permite la clase Empleado
            xstream.allowTypes(new Class[]{List.class}); // Permite la clase Empleado
            xstream.alias("empleados", List.class); // Alias para la lista raíz
            xstream.alias("employee", Empleado.class); // Alias para cada empleado

            // Configuración para mapear atributos
            xstream.useAttributeFor(Empleado.class, "id"); // Indica que 'id' es un atributo
            xstream.aliasField("firstName", Empleado.class, "firstName"); // Mapea etiquetas
            xstream.aliasField("lastName", Empleado.class, "lastName");
            xstream.aliasField("location", Empleado.class, "location");


            // Deserialización desde el archivo
            empleados = (List<Empleado>) xstream.fromXML(new FileInputStream(archivoXML));

            // Mostrar resultados
            empleados.forEach(System.out::println);

            

            Metodos.MetodosGUI.pintaArchivo(archivoXML);

        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error exacto
        }
    }

}
