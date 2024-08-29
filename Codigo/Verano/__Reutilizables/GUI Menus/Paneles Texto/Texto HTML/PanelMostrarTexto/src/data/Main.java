package data;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import GUI.PanelPaginaDeTextoHTML;
import GUI.Vppal;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Vppal v= new Vppal();
        String cadena = "<html>"+
                "<h1>Buenos dias</h1>"
                + "<p>dshfjcdsnzjvbsjdbvjbjvbdncv ndmc vnerdshjvdfvjndf vndjb vnjdfb vjndfb vjskb vjksv bkla,vn a.x,zm cklvniscuincsdklcnisuacnxzjkbcvusodvcu bzjx</p>"
                + "</html>";
                PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML("La pagina de texto",cadena);        
        v.ponPanel(p);
        
    }

    
}
