/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelElegirObjeto;
import data.Modelo.Piloto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class PanelAsignarMotoAPiloto1 extends PanelElegirObjeto {

    private final Ventana v;
    private final JPanel panelAnterior;

    public PanelAsignarMotoAPiloto1(Ventana v,JPanel panelAnterior, ArrayList<Object> objetos, String titulo) {
        super(objetos, titulo, v.colorFondo, v.color2, v.fuenteTitulo, v.fuenteBotones, v.colorLetraTitulo, v.colorLetraBotones);
        this.v = v;
        this.panelAnterior = panelAnterior;
        
        setBotonVolver(new NBoton("Volver", v.color1, v.color2));
        getBotonVolver().setFont(v.fuenteBotones);
        setBotonConfirmar(new NBoton("Elegir Piloto", v.color1, v.color2));
        getBotonConfirmar().setFont(v.fuenteBotones);
    }

    @Override
    public void accionConfirmar() {
        String stringPiloto;

        try {
            stringPiloto = getObjetoSeleccionado().toString();
            
            Piloto PilotoElegido = null;
            
            //buscamos el piloto que se ha elegido
            List<Piloto> pilotos = v.mundial.getPilotos();
            for (Piloto pil : pilotos) {
                if (pil.toString().equals(stringPiloto)){
                    PilotoElegido=pil;
                }
            }
            
            
            //si ya tiene moto se pregunta si desea reemplazarla
            int respuesta;
            if(v.mundial.obtenerMotoDePiloto(PilotoElegido)!=null){
                respuesta= JOptionPane.showConfirmDialog(v, "Este piloto ya tiene asignado la moto: \n"+v.mundial.obtenerMotoDePiloto(PilotoElegido)
                        +"\n ¿Desea asignar una nueva moto?");
                if (respuesta!=0) //0 significa que el usuario ha dicho que si
                    return;
                    
            }   
            
            PanelesGUI.PanelElegirObjeto p = new PanelAsignarMotoAPiloto2(v,this,PilotoElegido,new ArrayList<>(v.mundial.getMotos()), "Elige la Moto");
            v.ponPanel(p);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "No has seleccionado ningun Piloto");
        }
    }

    @Override
    public void accionVolver() {
        v.ponPanel(panelAnterior);
    }
    
}
