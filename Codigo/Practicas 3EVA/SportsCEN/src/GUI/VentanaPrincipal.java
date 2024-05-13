/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Articulo;
import data.Cliente;
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
        
            case p.PAgregarArticulos:
            
                this.ponPanel(new PanelAgregarArticulos(this,t, ptLogueado));
                break;
                
            case p.PMostrarEjemplares:
            
                this.ponPanel(new PanelMostrarEjemplares(this,t, ptLogueado));
                break;
                
            case p.PMostrarEjemplaresPorMarca:
            
                this.ponPanel(new PanelMostrarEjemplaresPorMarca(this,t, ptLogueado));
                break;
            
            case p.PMostrarEjemplaresPorPrenda:
            
                this.ponPanel(new PanelMostrarEjemplaresPorTipoPrenda(this,t, ptLogueado));
                break;
                
            case p.PGestionarDependientes:
            
                this.ponPanel(new PanelGestionarDependientes(this,t, ptLogueado));
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

            case p.PEliminarEjemplares:
                
                this.ponPanel(new PanelEliminarEjemplares(this,t, ptLogueado));
                break;

            case p.PGestionarEjemplares:
                
                this.ponPanel(new PanelGestionarEjemplares(this,t, ptLogueado));
                break;

            case p.PMostrarEjemplaresPorArticulo:
                
                this.ponPanel(new PanelMostrarEjemplaresPorArticulo(this,t, ptLogueado));
                break;
      
            case p.PAgregarEJemplares1:
                
                this.ponPanel(new PanelAgregarEjemplares1(this,t, ptLogueado));
                break;
           
            case p.PGestionarClientes:
                
                this.ponPanel(new PanelGestionarClientes(this,t, ptLogueado));
                break;
            
            case p.PAgregarClientes:
                
                this.ponPanel(new PanelAgregarClientes(this,t, ptLogueado));
                break;
            
            case p.PEliminarClientes:
                
                this.ponPanel(new PanelEliminarClientes(this,t, ptLogueado));
                break;
                
            case p.PPreGestionarVentas:
                
                this.ponPanel(new PanelPreGestionarVentas(this,t, ptLogueado));
                break;

                
        }
       
       this.revalidate();
    }
    
    public void ponPanelMostrarLista(Paneles p, PersonalTienda ptLogueado, Paneles panelAnterior, String lista){
        //@Nacho    
        //paneles p es innecesario pero lo puse por si hubiese varios tipos de paneles que muestren listas
 
        this.ponPanel(new PanelMostrarListas(this, t, ptLogueado, panelAnterior,lista));
                
        
    }
       
    public void ponPanelAgregarEjemplares2(PersonalTienda ptLogueado,Articulo articuloElegido){
        
        this.ponPanel(new PanelAgregarEjemplares2(this,t,ptLogueado,articuloElegido));
    }
    
       
    public void ponPanelVentas(Paneles p, PersonalTienda ptLogueado, Cliente clienteElegido){
        
         switch(p){
            case p.PGestionarVentas:
                this.ponPanel(new PanelGestionarVentas(this,t,ptLogueado,clienteElegido));
                break;
            case p.PAgregarVentas:
                this.ponPanel(new PanelAgregarVenta(this,t,ptLogueado,clienteElegido));
                break;
            case p.PMostrarVentas:
                break;
         
         }
    }
    
}
