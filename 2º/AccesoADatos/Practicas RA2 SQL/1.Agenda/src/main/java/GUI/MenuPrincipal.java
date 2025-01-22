/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PMenuV2;
import Ventana.Vppal;
import data.App;
import data.Contacto;
import data.GestorBD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class MenuPrincipal extends PMenuV2{

    private final Vppal v;
    
    public MenuPrincipal(Vppal v, String[] opciones, String nombreTitulo) {
        super(opciones, nombreTitulo);
        this.v = v;
        //ponerImagenDeFondo(".//res//agenda.png");
        
        
        funcionalidadBotones(opciones);
        
        UtilTema.aplicarTema(this, App.TEMA);
        getTitulo().setFont(App.TEMA.getFuenteTitulo());
    }

    private void funcionalidadBotones(String[] opciones) {
        JButton[] botones;
        botones = super.getBotones();
        
        //poner panel altas
        botones[0].addActionListener(e -> {
           PanelesGUI.PanelAltas p= new AgregarAmigo(v,this,"Introduce los datos de tu amigo",List.of("Nombre", "Telefono","Direccion", "Aficiones", "Pandilla","Sitio de Veraneo"));
           v.ponPanel(p);
        });
        
        //poner panel de listas
        botones[1].addActionListener(e -> {
            List<Contacto> contactos = GestorBD.recibirListaDeContactos();
            JPanel p = new ListasContactos(v,this,contactos);
            
            //esto lo que hace es añadirle el boton de volver de forma personalizada
            JButton btn = new JButton("Volver");
            btn.setPreferredSize(new Dimension(120, 35)); // Tamaño uniforme
            UtilTema.aplicarTema(btn, App.TEMA);
            Metodos.MetodosGUI.agregarBotonDeVolverAUnPanel(v, p, this,btn);
            v.ponPanel(p);
        });
        
        elUltimoBotonCierraLaVentana(opciones);
        
    }
}
