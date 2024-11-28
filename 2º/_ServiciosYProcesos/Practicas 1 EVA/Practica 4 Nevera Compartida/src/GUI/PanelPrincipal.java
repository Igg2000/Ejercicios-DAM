/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Font;

/**
 *
 * @author Nacho
 */
public class PanelPrincipal extends PanelesGUI.PanelPaginaDeTexto{

    public PanelPrincipal(String titulo, String texto) {
        super(titulo, texto);
        getjScrollPane1().setAutoscrolls(true);      
        getCuadroTexto().setFont(new Font("Segoe Ui",1,16));
    }
    
    public void agregarTexto(String texto){
        getCuadroTexto().append(texto+"\n\n");
        //esto hace que vaya haciendo scroll automatico
        getCuadroTexto().setCaretPosition(getCuadroTexto().getText().length());
    }

}
