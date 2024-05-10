package Apoyo;

import java.util.ArrayList;


public class Menu {
    
    
    private String titulo;
    
    private ArrayList<Opcion> ops;
    //private Opcion ops2[];

    public Menu(String titulo, Opcion []ops2) 
    {
        this.titulo = titulo;
        ops=new ArrayList();
        
        for (int i = 0; i < ops2.length; i++) {
            ops.add(ops2[i]);
        }
    }
    
    
    public String getTitulo() {
        return this.titulo;
    }

    public void addOpcion(Opcion op) 
    {
        ops.add(op);
    }

    @Override
    public String toString() {
        
        String cad="";
        
        for (Opcion op : ops) {
            cad+=op.toString()+"\n";
        }
        
        return "--------------------\n" + 
                "# " + titulo + "#\n"+
                "--------------------\n" + 
                cad;
    }

    public void pintaPorConsola() {
        System.out.println(""+this);
    }
    
    
    
    
}
