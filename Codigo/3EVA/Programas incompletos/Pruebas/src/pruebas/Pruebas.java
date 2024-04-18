/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

/**
 *
 * @author Nacho
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       int rand= dameUnNumeroAleatorio(10);
        System.out.println(""+rand);
       
        String resMayor= (rand > 5) ? "Es mayor que 5": "Es menor que 5";
        
        System.out.println(rand+" "+resMayor);
        
        for (int i = 0; i < 10; i++) {
            if (i==4)
                continue;   //esto se saltaría el 4
            System.out.print(i+" ");
            
        }
        
        /* 
           int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
           for (int i = 0; i < myNumbers.length; ++i) {
             for(int j = 0; j < myNumbers[i].length; ++j) {
               System.out.println(myNumbers[i][j]);
             }
           }
        
        */
       
    }
    
    
    public static int dameUnNumeroAleatorio(int z){
        
        //int rand= (int) (Math.random()* 100);
        
        int res= (int) (Math.random()* z+1);
        
        return res;
    }
    
}
