/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.App;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class Panel1 extends JPanel{

    App a;
    
    public Panel1(App a) {
        this.a= a;
        iniciarComponentes();
        
    }

    private void iniciarComponentes() {
        
        int numCuadros=9;
        ArrayList<CuadroTablero> tablero = new ArrayList(numCuadros);
        
        
        for (int i = 0; i < numCuadros; i++) {
            tablero.add(new CuadroTablero("Cuadro "+(i+1))); //añado un nuevo cuadro al tablero
            this.add(tablero.get(i)); //añado el tablero al panel
        
       
         final int index = i; //esto no entendi muy bien por que era necesario hacerlo final
        
        tablero.get(i).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //evento de hacer click con raton
                a.setTurnoJ1(!a.getTurnoJ1());
                if (a.getTurnoJ1()){
                    apuntarCuadro(index,1);
                    tablero.get(index).setEstado(1); //esto cambia el estado del panel, por lo que cambia su contenido
                }else{
                    tablero.get(index).setEstado(2);
                }
                repaint(); //esto vuelve a pintar el panel
            }

                
        });
        }      
        this.setLayout(new GridLayout(3,3));
        

        

    }
    
            
    private void apuntarCuadro(int i,int estadoCuadro) {
        // el estado funciona asi: 0 vacio | 1 J1 | 2 J2
        
        //System.out.println("Has puesto un circulo en "+(i+1));
        
        
        int cont=0;
        //con el contador estamos pasando de matriz a array y estamos poniendo en esa posicion el estado que va a tener
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
               
                if (i==cont){
                    a.getTablero()[j][k]=estadoCuadro;
                    //System.out.println("El valor de esa posicion "+j+" "+k +" es " +a.getTablero()[j][k]);
                }
                cont++;
                
            } 
        }
        
    }
    
    
}
