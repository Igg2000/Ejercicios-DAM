package data;

import GUI.*;

/**
 *
 * @author javier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       VPpal v=new VPpal("Ej2");
       v.setVisible(true);     
        //new V2(v,"Hasta Pronto").setVisible(true);

        
        V3 v3=new V3();
        v.add(v3);
        v.revalidate();
    }
    
}
