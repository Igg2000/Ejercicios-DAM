/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Nacho
 */
import PanelesGUI.NBoton;
import javax.swing.*;
import java.awt.*;

public class UtilTema {

    public static void aplicarTema(Container contenedor, Tema tema) {
        
        if(contenedor instanceof JPanel)
            contenedor.setBackground(tema.getFondo());
        
        //si es el propio elemento tambien lo deberia aplicar
        if (contenedor instanceof JLabel) {
            contenedor.setForeground(tema.getTexto());
            contenedor.setFont(tema.getFuenteTexto());
        } else if (contenedor instanceof NBoton) {
            ((NBoton)contenedor).cambiarColor2(tema.getBoton());
            ((NBoton)contenedor).cambiarColor1(tema.getComplementario());
            ((NBoton)contenedor).cambiarColorTexto(Color.white);
            ((NBoton)contenedor).cambiarFuente(tema.getFuenteBoton());
        } else if (contenedor instanceof JButton) {
            contenedor.setBackground(tema.getBoton());
            contenedor.setForeground(Color.WHITE);
            contenedor.setFont(tema.getFuenteBoton());
            ((JButton)contenedor).setBorder(BorderFactory.createLineBorder(tema.getComplementario()));
        } else if (contenedor instanceof JTextField) {
            contenedor.setBackground(Color.WHITE);
            contenedor.setForeground(Color.black);
            contenedor.setFont(tema.getFuenteTexto());
            ((JTextField)contenedor).setBorder(BorderFactory.createLineBorder(tema.getComplementario()));
        }


        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof Container) 
                aplicarTema((Container) componente, tema);
            
            if (componente instanceof JLabel) {
                componente.setForeground(tema.getTexto());
                componente.setFont(tema.getFuenteTexto());
            } else if (componente instanceof NBoton) {
                ((NBoton)componente).cambiarColor2(tema.getBoton());
                ((NBoton)componente).cambiarColor1(tema.getComplementario());
                ((NBoton)componente).cambiarColorTexto(Color.white);
                ((NBoton)componente).cambiarFuente(tema.getFuenteBoton());
            } else if (componente instanceof JButton) {
                componente.setBackground(tema.getBoton());
                componente.setForeground(Color.WHITE);
                componente.setFont(tema.getFuenteBoton());
                ((JButton)componente).setBorder(BorderFactory.createLineBorder(tema.getComplementario()));
            } else if (componente instanceof JTextField) {
                componente.setBackground(Color.WHITE);
                componente.setForeground(Color.black);
                componente.setFont(tema.getFuenteTexto());
                ((JTextField)componente).setBorder(BorderFactory.createLineBorder(tema.getComplementario()));
            }
        }
        
        /*
        //en caso de que sea de mis librerias
        if (contenedor instanceof MenuPrincipal){
            MenuPrincipal mp = (MenuPrincipal) contenedor;
            NBoton[] nbs = (NBoton[]) mp.getBotones();
            for (NBoton b : nbs) {
                b.cambiarColor2(tema.getBoton());
                b.cambiarColor1(tema.getComplementario());
                b.cambiarColorTexto(Color.white);
                b.cambiarFuente(tema.getFuenteBoton());
            }
        
            mp.getTitulo().setFont(tema.getFuenteTitulo());
            mp.getTitulo().setForeground(tema.getTexto());
        }

        */
    }
}
