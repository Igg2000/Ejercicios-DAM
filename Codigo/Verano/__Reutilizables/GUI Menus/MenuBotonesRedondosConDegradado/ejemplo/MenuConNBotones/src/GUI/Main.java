package GUI;

import java.awt.Color;

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
        
        VP v=new VP();
        v.setSize(300,400);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        
        String[] cad={"Opcion 1","Opcion 2","Opcion 3","Salir"};
        pm p1= new pm (cad,"Prueba menu con botones",new Color(13, 65, 225),new Color(88, 239, 236 ));
        PMenuConNBotones p2= new PMenuConNBotones(cad,"Prueba menu con botones",Color.red,Color.orange);
        v.ponPanel(p1);
    }
    
}
