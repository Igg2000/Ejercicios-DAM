/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelElegirObjeto;
import data.Modelo.Moto;
import data.Modelo.Piloto;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class PanelAsignarMotoAPiloto2 extends PanelElegirObjeto {

    private final Ventana v;
    private final JPanel panelAnterior;
    private final Piloto piloto;

    public PanelAsignarMotoAPiloto2(Ventana v, JPanel panelAnterior, Piloto piloto, ArrayList<Object> objetos, String titulo) {
        super(objetos, titulo, v.colorFondo, v.color2, v.fuenteTitulo, v.fuenteBotones, v.colorLetraTitulo, v.colorLetraBotones);
        this.v = v;
        this.panelAnterior = panelAnterior;
        
        setBotonVolver(new NBoton("Volver", v.color1, v.color2));
        getBotonVolver().setFont(v.fuenteBotones);
        setBotonConfirmar(new NBoton("Elegir Moto", v.color1, v.color2));
        getBotonConfirmar().setFont(v.fuenteBotones);
        this.piloto = piloto;
    }

    @Override
    public void accionConfirmar() {
        String stringMoto;
        try {
            stringMoto = getObjetoSeleccionado().toString();
            
            Set<Moto> motos = v.mundial.getMotos();
            
            Moto motoElegida=null;
            
            for (Moto m : motos) {
                if(m.toString().equals(stringMoto))
                    motoElegida=m;
            }
            
            v.mundial.asignarMotoAPiloto(piloto, motoElegida);
            JOptionPane.showMessageDialog(v, "Ahora "+ piloto.getNombre()+" tiene la moto: \n"+motoElegida.getModelo());
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "No has seleccionado ningun Piloto");
        }
    }

    @Override
    public void accionVolver() {
        v.ponPanel(panelAnterior);
    }
    
}