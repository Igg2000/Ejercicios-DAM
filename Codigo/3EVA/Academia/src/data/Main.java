/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.Scanner;

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
        Scanner s= new Scanner(System.in);
        Academia a = new Academia();
        String []ops={"Añadir Cursos Manualmente","Ver Aulas","Salir"};
        int op;
            do{
            VisualizarMenu("Menu principal",ops);
            
            op= s.nextInt();
            

            switch(op){
                case 1:
                    a.AddCursosManual(s);
                    break;
                case 2:
                    System.out.println(""+a.getAulasAcademia());
                    break;
                case 3:
                    break;
            }
        }while (op!=3);
            
    s.close();
    }
    
     public static void VisualizarMenu(String titulo, String []opciones){
       
        int cont=0;   
          
        System.out.println("____________________");
        System.out.println(""+titulo);
        System.out.println("____________________");
        
        for (String i : opciones) {
            cont++;
            System.out.println(cont+". "+i);
        }
        System.out.println("____________________");
        System.out.print("Elige una opcion: ");
    }
}
