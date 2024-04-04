/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Operaciones {

    double num1;
    double num2;
    
    public Operaciones() {
    }
    
    
    /*
    public static double suma (double []num){
        
        double res=0;
        
        for (int i = 0; i < num.length; i++) {
            res += num[i];
            
        }
        
        return res;        
    }
    */
    
    public static double suma (double num1, double num2){
        
        return num1 + num2;        
    }
    
     public static double resta (double num1, double num2){
        
        return num1 - num2;        
    }
    
     public static double multiplicar (double num1, double num2){
        
        return num1 * num2;        
    }
    
      public static double dividir (double num1, double num2){
        
        return num1 / num2;        
    }
}
