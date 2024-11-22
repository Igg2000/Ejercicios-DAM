package data;

import PanelesGUI.PanelPaginaDeTexto;
import Ventana.Vppal;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.List;

/**
 * Clase para procesar un archivo XML de empleados usando XStream.
 * 
 * @author Nacho
 */
class App implements Runnable {

    private File archivoXML = new File("src//res//empleados.xml");
    private List<Empleado> empleados;

    @Override
    public void run() {
        try {
            // Crear una instancia de XStream
            XStream xstream = new XStream();
            
            // Configuración para que XStream reconozca la clase Empleado
            xstream.alias("employee", Empleado.class);
            
            // Leer y deserializar el archivo XML
            empleados = (List<Empleado>) xstream.fromXML(archivoXML);
            
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
