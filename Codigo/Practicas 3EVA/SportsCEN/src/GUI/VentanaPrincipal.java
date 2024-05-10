/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Dependiente;
import data.Gerente;
import data.PersonalTienda;
import data.Tienda;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class VentanaPrincipal extends JFrame{
    
    Tienda t;

    public VentanaPrincipal(Tienda t) throws HeadlessException {
        
        this.t=t;
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setResizable(false);

    }

    public void ponPanel(JPanel p){
        
       this.setContentPane(p);
       this.revalidate();
    }
    
    public void ponPanel(Paneles p, PersonalTienda ptLogueado){
        
        //@Nacho
        //esto es para controlar mejor que panel se le pasa a la ventana
        
        switch(p){
            case p.PLogin:
                this.ponPanel(new PanelLogin(this,t));
                break;
                
            case p.PMenuGerente:
                this.ponPanel(new PanelMenuGerente(this,t,(Gerente)ptLogueado));
                break;
                              
            case p.PMenuDependiente:
                this.ponPanel(new PanelMenuDependiente(this,t,(Dependiente)ptLogueado));
                break;
                              
            case p.PGestionarArticulos:
            
                this.ponPanel(new PanelGestionarArticulos(this,t, ptLogueado));
                break;
                
            case p.PMostrarArticulos:
            
                this.ponPanel(new PanelMostrarArticulos(this,t, ptLogueado));
                break;
                
            case p.PMostrarArticulosPorMarca:
            
                this.ponPanel(new PanelMostrarArticulosPorMarca(this,t, ptLogueado));
                break;
                
            case p.PGestionarDependientes:
            
                this.ponPanel(new PanelGestionarDependientes(this,t, ptLogueado));
                break;
                
            case p.PMostrarDependientes:
                
                this.ponPanel(new PanelMostrarDependientes(this,t, ptLogueado));
                break;
            
            case p.PAgregarDependientes:
                
                this.ponPanel(new PanelAgregarDependientes(this,t, ptLogueado));
                break;
                
            case p.PEliminarDependientes:
                
                this.ponPanel(new PanelEliminarDependientes(this,t, ptLogueado));
                break;
           
            case p.PEliminarArticulos:
                
                this.ponPanel(new PanelEliminarArticulos(this,t, ptLogueado));
                break;
           
            case p.PMostrarTodosLosArticulos:
                
                this.ponPanel(new PanelMostrarTodosLosArticulos(this,t, ptLogueado));
                break;
                
        }
        
       
       
       
       
       
       
       this.revalidate();
    }
    
}
