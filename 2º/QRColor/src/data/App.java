/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.Vppal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class App {
    
    Vppal v=new Vppal();
    List<Instituto> instis= new ArrayList();

    public App() {
    }

    void addInstis(Instituto ins) {
        instis.add(ins);
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
    
    
    
    
    
}
