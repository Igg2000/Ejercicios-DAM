/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ListaObjetos.PanelElegirObjeto;
import data.App;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author grovy
 */
public class PanelCalcularElegirOrigen extends PanelElegirObjeto{

    App a;
    List<Object> objetos;
    
    public PanelCalcularElegirOrigen(App a,List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo, Font fuenteLista, Color colorTitulo, Color colorLista) {
        super(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
        this.objetos=objetos;
        this.a=a;
    }

    @Override
    public void accionConfirmar() {
    
        Object objetoSeleccionado=null;
        try {
            objetoSeleccionado=getObjetoSeleccionado();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(a.getV(), "Debes elegir una opcion de la lista");
        }
       
        List<Object> nodos = new ArrayList<>(a.getGrafo().getNodos());

        ListaObjetos.PanelElegirObjeto p = new PanelCalcularElegirDestino(objetoSeleccionado,a,objetos,"¿A donde le gustaría ir?",
                Color.decode("#6EACDA"), Color.decode("#03346E"),new Font("Segoe UI",1,36),new Font("Segoe UI",1,36),Color.decode("#03346E"),Color.decode("#E2E2B6"));
        a.getV().ponPanel(p);
        
    }

    @Override
    public void accionVolver() {
        a.getV().ponPanel(a.getMenuPrincipal());
    }
    
}
