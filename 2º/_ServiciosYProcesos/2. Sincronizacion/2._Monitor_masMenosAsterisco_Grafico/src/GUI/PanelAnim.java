/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class PanelAnim extends PanelesGUI.PanelPaginaDeTexto implements Runnable{

    private final String cad;

    public PanelAnim(String cad) {
        super("Animacion sincronizada", "");
        this.cad = cad;
    }

    @Override
    public void run() {
        
        getCuadroTexto().setFont(new Font("Segoe Ui",1,20));
        
        char[] chars = cad.toCharArray();
        
        
        for (char c : chars) {
            getCuadroTexto().append(c+"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelAnim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
}
