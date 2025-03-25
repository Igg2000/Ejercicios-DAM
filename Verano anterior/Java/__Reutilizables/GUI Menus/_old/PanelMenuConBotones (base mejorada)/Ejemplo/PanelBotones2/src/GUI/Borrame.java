package GUI;

/**
 *
 * @author javier
 */
public class Borrame {

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
        v.ponPanel(new PMenuConBotones(cad));
       // v.ponPanel(new panelPrueba(cad,"titulo"));
    }
    
}
