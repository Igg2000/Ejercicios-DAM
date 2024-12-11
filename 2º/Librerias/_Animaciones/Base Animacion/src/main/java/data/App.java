package data;

import GUI.PanelAnimacion;
import GUI.Ventana;

/**
 *
 * @author Nacho
 */
public class App extends Thread{
    private Ventana v;
    private PanelAnimacion p;

    public static void main(String[] args) {    
        App a = new App("App Animacion");
        a.start();
    }

    public App(String name) {
        super(name);
        v = new Ventana();
        p = new PanelAnimacion(this);
    }

    
    @Override
    public void run() {
        v.ponPanel(p);
        v.setVisible(true);
    }

    public Ventana getV() {
        return v;
    }

    public PanelAnimacion getP() {
        return p;
    }
    
    
}
