/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesTexto.PanelPaginaDeTexto;
import data.App;
import data.Zoo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
public class MenuPrincipal extends Menus.PMenuConNBotones{
    
    App a;
    
    public MenuPrincipal(String[] opciones, String nombreTitulo, Color color1, Color color2, Color colorFondo,App a) {
        super(opciones, nombreTitulo, color1, color2, colorFondo);
        this.a=a;
        funcionalidadBotones();
        
    }

    private void funcionalidadBotones() {
        
        JButton[] bs=super.getBotones();
        
        bs[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcionalidad agregar animales
            }
        });
        bs[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcionalidad eliminar animales
            }
        });
        bs[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String titulo= "Animales del Zoo";
                String texto= a.getZ().getJaulasComoCadena();
                PanelesTexto.PanelPaginaDeTexto p = new PanelesTexto.PanelPaginaDeTexto(titulo, texto);
                a.getV().ponPanel(p);
            }
        });
        //evento de mostrar animales
        bs[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String titulo= "Animales del Zoo";
                String texto= a.getZ().getAnimalesDelZoo();
                PanelesTexto.PanelPaginaDeTexto p = new PanelesTexto.PanelPaginaDeTexto(titulo, texto);
                a.getV().ponPanel(p);
                
            }
        });
        
        
        //añade funcionalidad al boton de salir
        elUltimoBotonCierraLaVentana(super.getOpciones());
        
    }
    
    
    
}
