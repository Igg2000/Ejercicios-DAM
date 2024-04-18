/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

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
            
        //System.out.println("Fibonacci de 8:" +fibo(8));
        
        //fiboNormal(8);
        
        dividir(9,3);
        
    }

    private static int fibo(int n) {
        //String cad;
        int res=n-1;
        if(n<=1)return 1;
        
        res=res+n;
        n=res-n;
        
        
        
        System.out.println(fibo(n-1));
        return n;
    }



    static void fiboNormal(int i) {
    
        int a,b,c;
        
        a=0;
        b=1;
        
        for (int j = 0; j < i; j++) {
        
        b=b+a;
        a=b-a;
        
        System.out.println(a+"+"+(b-a)+": "+b);
            
        }
        
    }

    private static int dividir(int a, int b) {
        
        int cont=0;
        
        //a-b
        
        
        return cont;
/*
    dividir 9-3
    
                6-3
                        3-3
                        
        if return 0;

*/
    }
