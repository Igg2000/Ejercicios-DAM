/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

/**
 *
 * @author Nacho
 */
class App implements Runnable{

    private File fileXML= new File("src//res//empleados.xml"); //tengo que cambiar la ruta

    @Override
    public void run() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory. newInstance();
            DocumentBuilder dBuilder = dbFactory. newDocumentBuilder();
            Document doc = dBuilder.parse(fileXML);
            
            NodeList empleados=doc.getElementsByTagName("employee");
            
            String cad="";
            
            // Recorro como si fuera un array
            for (int i = 0; i < empleados.getLength(); i++) {
                
                Node nodoempleado=empleados.item(i);
                Element elemento = (Element) nodoempleado;
                
                cad+= elemento.getElementsByTagName("firstName").item(i).getNodeValue();
                
            }
            System.out.println(cad);
            
            
        } catch (SAXException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
