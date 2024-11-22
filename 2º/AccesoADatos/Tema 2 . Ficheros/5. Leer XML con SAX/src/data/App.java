/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import PanelesGUI.PanelPaginaDeTexto;
import Ventana.Vppal;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase para procesar un archivo XML usando SAX.
 * 
 * @author Nacho
 */
class App extends DefaultHandler implements Runnable {

    private File archivoXML = new File("src//res//Europa.xml");
    private List<Pais> paises;

    // Variables para almacenar temporalmente los datos
    private StringBuilder texto;
    private String nombre;
    private String habitantes;
    private String unidadHabitantes;
    private String capital;
    private String sigla;
    private String prefijo;
    
    
    

    @Override
    public void run() {
        try {
            paises = new ArrayList();
            
            // Crear un SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Parsear el archivo XML
            saxParser.parse(archivoXML, this);
            
            pintarPaisesEnVentana();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Evento cuando se encuentra el inicio de un elemento
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        texto = new StringBuilder(); // Reiniciar el contenido del texto para cada nuevo elemento

        if (qName.equals("habitantes")) {
            unidadHabitantes = attributes.getValue("unidad"); // Leer atributo "unidad"
        }
    }

    // Evento para manejar contenido de texto entre etiquetas
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        texto.append(new String(ch, start, length));
    }

    // Evento cuando se encuentra el final de un elemento
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "nombre":
                nombre = texto.toString().trim();
                break;
            case "habitantes":
                habitantes = texto.toString().trim();
                break;
            case "capital":
                capital = texto.toString().trim();
                break;
            case "sigla-pais":
                sigla = texto.toString().trim();
                break;
            case "prefijo":
                prefijo = texto.toString().trim();
                break;
            case "pais":
                /*
                    // Al final de un país, imprimir la información recopilada
                    System.out.println("País: " + nombre);
                    System.out.println("  Habitantes: " + habitantes + " " + unidadHabitantes);
                    System.out.println("  Capital: " + capital);
                    System.out.println("  Sigla: " + sigla);
                    System.out.println("  Prefijo: " + prefijo);
                    System.out.println();
                */
                Pais nuevoPais = new Pais(nombre, Double.valueOf(habitantes) ,unidadHabitantes, capital, sigla.charAt(0), Integer.parseInt(prefijo));
                paises.add(nuevoPais);
                break;
        }
    }

    private void pintarPaisesEnVentana() {
        
        String cad="";
        for (Pais p : paises) {
            cad+=p+"\n\n";
        }
        
        Vppal v = new Vppal();
        PanelesGUI.PanelPaginaDeTexto p = new PanelPaginaDeTexto("Leer de Europa.xml", cad);
        v.ponPanel(p);
    }
}
