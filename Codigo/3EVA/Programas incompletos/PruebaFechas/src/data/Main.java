/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        
        //prueba1();
        
        prueba2();
    }

    private static void prueba1() {
    
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        
        Date d2= new Date(2000-1900,10,5);
        Calendar c2= new GregorianCalendar(2000,10,05);
        
        
        System.out.println("Fecha actual en formato date: "+d);
        System.out.println("Fecha actual en formato calendar: "+c.getTime());
        
        System.out.println("\n\nFecha inventada en date: "+ d2);
        System.out.println("Fecha inventada en calendar: "+ c2.getTime());
        
        Date d3=new Date(c2.getTimeInMillis());
        System.out.println("\n\nFecha calendar transformada en date: "+d3);
        
        Calendar c3= new GregorianCalendar();
        c3.setTime(d);
        System.out.println("Fecha date transformada en calendar: "+c3.getTime());
        
        System.out.println("hora del dia: "+c.get(Calendar.HOUR_OF_DAY));
        System.out.println("semana del año: "+c.get(Calendar.WEEK_OF_YEAR));
           
    
    }

    private static void prueba2() {
    
        Nota n= new Nota("Hoy va a ser un buen dia");
        
        
        System.out.println("El dia "+convertirFecha(n.getFecha())+" tiene la siguiente nota:\n"+n.getNota());
    }

    private static String convertirFecha(Date d) {
        
        String fecha= (d.getDay()+"/"+d.getMonth()+"/"+(d.getYear()+1900));
        
        return fecha;
        
    }
    
}
