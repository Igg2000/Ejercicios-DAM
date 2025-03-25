
package data;

/**
 *
 * @author Javier
 */
/**
 * Clase auxiliar a juego q implementa el hecho de jugar dentro de un tiempo
 * Gestiona el paso del tiempo y comprueba si hay ganador/fin del tiempo 
 */
class GestionaTiempo implements Runnable{

    Juego juego;
    
    public GestionaTiempo(Juego j) 
    {
        juego=j;
    }
    
    
    public void run() 
    {   
        do{        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            if(juego.llegaAlaMeta())
                juego.fin=true;
            else
                juego.setTiempo(juego.getTiempo()-1);
            
            juego.getVj().repaint();
            
        }while(juego.getTiempo()>0&&!juego.fin);
    }



}//:~)

