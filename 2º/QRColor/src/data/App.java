/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.PGenqrc;
import GUI.PInstis;
import GUI.PMenuConNBotones;
import GUI.PVisqrc;
import GUI.Vppal;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Nacho
 */
public class App {
    
    Vppal v=new Vppal();
    List<Instituto> instis= new ArrayList();
    QRC qrc;

    public App() {
    }

    public void addInstis(Instituto ins) {
        instis.add(ins);
    }

    public void visInstisEnVentana() {
        
        PInstis p= new PInstis(this);
        v.ponPanel(p);
    }
    
    public void borrarTodosLosCiclosDeLosInstis(){
        
        for (Instituto ins : instis) {
            ins.getCiclos().clear();
        }
    }
            
    public void visQRC(TamQRC t,Boolean random){
        qrc= new QRC(t);
        if(random)
            rellenarQRC(qrc);
        //PVisqrc p= new PVisqrc(this.qrc);

        if(random){
            PVisqrc p= new PVisqrc(this.qrc);
            v.ponPanel(p);
        }else{
            PGenqrc p= new PGenqrc(this.qrc,this);
            v.ponPanel(p);
        }    
            

    }

    private void rellenarQRC(QRC qr) {
        qr.rellenarQRCRandom();
    }
    
    public void sacarMenuQRC(Boolean random){
        //String ops[]={"Pequeño","Mediano","Grande","Salir"};
        //Esto coge los valores del enumerado de forma automatica y le añade un boton de salir
        String ops[]= new String[TamQRC.values().length+1];
        for (int i = 0; i < TamQRC.values().length; i++) {
            ops[i]=TamQRC.values()[i].name();
        }
        ops[ops.length-1]="Salir";
        
        PMenuConNBotones menu= new PMenuConNBotones(ops, "Escoge el tamaño del qr", Color.blue, Color.cyan);
        hacerQueFuncioneElMenuQRC(menu,ops,random);
        v.ponPanel(menu);
    }
    
    private void hacerQueFuncioneElMenuQRC(PMenuConNBotones menu, String[] ops, Boolean random) {
        JButton b[]=menu.getBotones();
        
        int tam= ops.length-1;
        final boolean r= random;
        //rellena todas los botones menos el ultimo
        for (int i = 0; i < tam; i++) {
            final int index = i; 
            b[i].addActionListener(e -> {
                visQRC(TamQRC.values()[index],r); // No entiendo por que tengo que usar la variable 'index' en lugar de 'i'
            });
        }
        menu.elUltimoBotonCierraLaVentana(ops);
    }
    
    public Vppal getV() {
        return v;
    }

    public void setV(Vppal v) {
        this.v = v;
    }

    public List<Instituto> getInstis() {
        return instis;
    }

    public void setInstis(List<Instituto> instis) {
        this.instis = instis;
    }

    void sacarMenuPrincipal() {
        String[] ops= {"Ver lista de institutos", "Generar qrc automatico", "Generar qrc manual"," Salir"};
        PMenuConNBotones menuPpal= new PMenuConNBotones(ops, "Escoge una opcion", Color.blue, Color.cyan);
        hacerQueFuncioneElMenuPpal(menuPpal,ops);
        v.ponPanel(menuPpal);
    }

    private void hacerQueFuncioneElMenuPpal(PMenuConNBotones menu, String[] ops) {
        JButton b[]=menu.getBotones();

            b[0].addActionListener(e -> {
               visInstisEnVentana();
            });
            b[1].addActionListener(e -> {
                sacarMenuQRC(true);
            });
            b[2].addActionListener(e -> {
                sacarMenuQRC(false);
            });
            
        menu.elUltimoBotonCierraLaVentana(ops);
    }


    
    
    
    
}
