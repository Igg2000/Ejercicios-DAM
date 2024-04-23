/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Calendar fechaNacimiento= new GregorianCalendar(2000,5,25);
        int dia= fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        int mes= fechaNacimiento.get(Calendar.MONTH);
        
        
        ValidarConEntradaDeUsuario(dia,mes);
        
        //ValidarConDatoDePrueba(dia,mes);
       
    }

    private static void ValidarConEntradaDeUsuario(int dia, int mes) {
         boolean coincideFecha=false;
        
        int diaprueba= Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia")) ;
        int mesprueba= Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes")) ;
           
         if(dia==diaprueba && mesprueba==mes)
            coincideFecha=true;
        
        if(coincideFecha)
            JOptionPane.showMessageDialog(null, "Es tu cumple");
        else
            JOptionPane.showMessageDialog(null, "No es tu cumple");
    }

    private static void ValidarConDatoDePrueba(int dia, int mes) {
        
        boolean coincideFecha=false;
        
        Calendar fechaPrueba= new GregorianCalendar(1998,5,25);
        int diaprueba= fechaPrueba.get(Calendar.DAY_OF_MONTH);
        int mesprueba= fechaPrueba.get(Calendar.MONTH);
        
        if(dia==diaprueba && mesprueba==mes)
            coincideFecha=true;
        
        if(coincideFecha)
            JOptionPane.showMessageDialog(null, "El dia es valido");
        else
            JOptionPane.showMessageDialog(null, "El dia no es valido");
        
    }
    
}
