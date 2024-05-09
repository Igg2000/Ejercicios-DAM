package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author javier
 */
public class VPpal extends JFrame
{

    public VPpal(String title) 
    {
        super(title);
        this.setSize(800,600);        
        this.setLocationRelativeTo(null);
        this.addWindowListener(
                new WindowAdapter(){
                        @Override
                        public void windowClosing(WindowEvent e) 
                        {
                            VPpal.this.ponV2();
                        }
                }
        );
    }
    
    

    private void acabaApp() 
    {
        if(this!=null)
            this.dispose();   
    }

    private void ponV2() {
        V2 vv=new V2(VPpal.this,"Adios");
        vv.setVisible(true);

       /* 
        try {                            
            Thread.sleep(3000);
        } catch (InterruptedException ex) {}                            
        if(vv!=null)
            vv.dispose();
        acabaApp();
        */
    }

    
    
    
    
}
