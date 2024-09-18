/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.*;
import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vppal v= new Vppal();
        String cadena =
                "La educación es uno de los pilares fundamentales para el desarrollo personal y social de los individuos. A lo largo de la historia, se ha demostrado que las sociedades más avanzadas son aquellas que invierten en la educación de sus ciudadanos. La educación no solo proporciona conocimientos académicos, sino que también fomenta valores, habilidades y competencias que son esenciales para la vida en sociedad.\n" +
                        "\n" +
                        "Desde una perspectiva personal, la educación es una herramienta poderosa para la realización individual. Permite a las personas desarrollar sus talentos, intereses y habilidades, y les brinda la oportunidad de perseguir sus sueños y aspiraciones. A través de la educación, los individuos pueden descubrir sus pasiones y potencialidades, lo que les permite tomar decisiones informadas sobre sus carreras y vidas personales. Además, la educación fomenta la autoestima y la confianza en uno mismo, ya que el conocimiento y la comprensión proporcionan una base sólida para enfrentar los desafíos de la vida.\n" +
                        "\n" +
                        "La educación también desempeña un papel crucial en la promoción de la igualdad y la justicia social. En muchas sociedades, la educación ha sido una herramienta para superar barreras sociales y económicas, proporcionando a todos los individuos, independientemente de su origen, la oportunidad de mejorar sus circunstancias. Al garantizar el acceso equitativo a la educación, se pueden reducir las disparidades sociales y económicas, y se puede promover una sociedad más justa e inclusiva. Esto es particularmente importante en contextos donde las desigualdades han sido históricamente pronunciadas.\n" +
                        "\n";
        PanelPaginaDeTexto p = new PanelPaginaDeTexto("La pagina de texto",cadena);
        
        v.ponPanel(p);
        
    }


    
}
