package data;

import GUI.VJuego;
import GUI.VPortada;
import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Clase Controladora de la aplicación
 * @author Javier M Criado
 */
public class Juego {
    
    //CTES:
    private final ImageIcon imgMuñeco=new ImageIcon(".//img//pacman.png");
    private final ImageIcon imgObstaculo=new ImageIcon(".//img//ghost1.png");//obstaculo.jpg");
    private final ImageIcon imgMeta=new ImageIcon(".//img//finish1.png");
    
    public final ImageIcon bgImgMeta=new ImageIcon(".//img//bgPacman.jpg");
    
    //Añado esto xq en el caso del obstáculo no usaré su tamaño original, sino 25,25 o lo q me de el user a través del menú
    private Dimension tamañoObstaculo=new Dimension(40,40);
    
    private final int tiempoMAX = 30;//Tiempo max para completar el juego (en s)
    
    //Atributos
    private Figura muñeco,meta;    
    private List <Figura> obstaculos;
    private int tiempo;
    private int dificultad;//1->fácil;2-->medio;3-->difícil
    
    boolean fin;
    
    //Rels de agregación
    private VPortada vp;
    private VJuego vj;

    public Juego() {        
        tiempo=this.tiempoMAX;
        dificultad=1;
        fin=false;
    }

    
  //Accedentes y mutadores generados auto
  //----------------------------------------------
    public Figura getMeta() {
        return meta;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Figura getMuñeco() {
        return muñeco;
    }

    public void setMuñeco(Figura muñeco) {
        this.muñeco = muñeco;
    }

    public List<Figura> getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(List<Figura> obstaculos) {
        this.obstaculos = obstaculos;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public VJuego getVj() {
        return vj;
    }

    public void setVj(VJuego vj) {
        this.vj = vj;
    }

    public VPortada getVp() {
        return vp;
    }

    public void setVp(VPortada vp) {
        this.vp = vp;
    }
  //----------------------------------------------



    
    public void portada(){
        if(vp==null)
            vp=new VPortada(this);
        
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    public void jugar() throws IOException{
        if(vp!=null)
            vp.dispose();
        
        if(vj==null)
            vj=new VJuego(this);

        vj.setVisible(true);
        
        //-------------------------------------
        //Creo los sprites
        //-------------------------------------
        
        //Al pacman le doy un tam entre 25 y 50
        Dimension tamPacman=new Dimension(30,30);
        if(imgMuñeco.getIconWidth()>25 && imgMuñeco.getIconWidth()<50)
            tamPacman=new Dimension(imgMuñeco.getIconWidth(),imgMuñeco.getIconHeight());
        
        muñeco=new Figura(imgMuñeco,new Point(30,30),tamPacman);
        switch(dificultad){
            case 1:generaObstáculos(1);break;
            case 2:generaObstáculos(2);break;
            case 3:generaObstáculos(3);break;
        }
        //Creo la meta
        meta=new Figura(imgMeta,new Point(vj.getWidth()-80,vj.getHeight()-100),new Dimension(60,60));
                                                                            //new Dimension(imgMeta.getIconWidth(),imgMeta.getIconHeight()));

        new Thread(new GestionaTiempo(this)).start();    
    }
    
    /**
     * Determina si el muñeco esta sobre la meta o no
     * @return
     */
    public boolean llegaAlaMeta(){
        if(muñeco.estaDentroFigura(meta))
            return true;
        return false;        
    }
    
    /**
     * Aqui se pondría lo q queremos q ocurra cdo se acaba la partida
     */
    public void gameOver()    
    {
        this.fin=true;
        if(!llegaAlaMeta())
            JOptionPane.showMessageDialog(null, "Fin del tiempo. Has perdido :(");
        else
            JOptionPane.showMessageDialog(null, "Muy bien, has ganado");        
        
        vj.dispose();
        tiempo=this.tiempoMAX;
        dificultad=1;
        this.portada();
    }
    
    
    
    
    private void generaObstáculos(int nivel) throws FileNotFoundException, IOException{
       
        
        int x,y;
        obstaculos=new ArrayList();
        BufferedReader br=null;
        switch (nivel){
            case 1: br=new BufferedReader(new FileReader(".//rsc//lab.txt")); break;
            case 2: br=new BufferedReader(new FileReader(".//rsc//lab2.txt")); break;
            case 3: br=new BufferedReader(new FileReader(".//rsc//lab3.txt")); break;
        }
        String cad = br.readLine();
        //String cad ="100,100;250,250;400,400";
        
        
        String[] cadsplit = cad.split(";");
        
        for (String s : cadsplit) {
           int posComa= s.indexOf(',');
           x= Integer.parseInt(""+s.substring(0,posComa));
           y= Integer.parseInt(""+s.substring(posComa+1,s.length()));
           
           obstaculos.add(new Figura(imgObstaculo,new Point(x,y),tamañoObstaculo));  
        }
        
        /*
        
        for(int i=0;i<numObstaculos;i++){
            do{
                
                x=r.nextInt(vj.getContentPane().getWidth()-50);
                y=r.nextInt(vj.getContentPane().getHeight()-50);
            }while(x<muñeco.getTam().width+25||y<muñeco.getTam().height+25);
            
            
            obstaculos.get(i)=new Figura(imgObstaculo,new Point(x,y),tamañoObstaculo);
        }*/
    }

    public void setTamObstaculo(int tam) {
        if(tam>20 && tam<100)
            tamañoObstaculo=new Dimension(tam,tam);
            
    }

    
    
    
}//:~)


