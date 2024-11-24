/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelElegirObjeto;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class PanelAltaPilotoElegirEscudería extends PanelElegirObjeto {

    private JPanel panelAnterior;
    private Ventana v;


    public PanelAltaPilotoElegirEscudería(Ventana v, JPanel panelAnterior, ArrayList<Object> objetos, String titulo) {
        super(objetos, titulo, v.colorFondo, v.color2, v.fuenteTitulo, v.fuenteBotones, v.colorLetraTitulo, v.colorLetraBotones);
        this.panelAnterior = panelAnterior;      
        this.v=v;
        
        setBotonVolver(new NBoton("Volver", v.color1, v.color2));
        getBotonVolver().setFont(v.fuenteBotones);
        setBotonConfirmar(new NBoton("Elegir Escuderia", v.color1, v.color2));
        getBotonConfirmar().setFont(v.fuenteBotones);
        
    }

    @Override
    public void accionConfirmar() {
        String escuderia;
        try {
            escuderia = getObjetoSeleccionado().toString();
            PanelesGUI.PanelAltas p = new PanelAltaPiloto(v,this,escuderia, "Introduce al nuevo Piloto", List.of("Nombre","Nacionalidad"));
            v.ponPanel(p);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "No has seleccionado ninguna Escudería");
        }
        

    }

    @Override
    public void accionVolver() {
        v.ponPanel(panelAnterior);
    }


    
    

    


    
}
