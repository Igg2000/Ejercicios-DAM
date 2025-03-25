/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionesPropias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NombreException extends Exception {
    //@Nacho
    //es una clase de tipo excepcion para tratar los login fallidos
    public NombreException(String mensaje) {
        super(mensaje);
    }
    
            
     // Método para validar un nombre con espacios opcionales
    public static boolean validarNombre(String nombre) throws NombreException {
        // Patrón para validar nombres que contengan solo letras y espacios opcionales
        String patron = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+(\\s?[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)*$";
        
        // Compilar el patrón en una expresión regular
        Pattern pattern = Pattern.compile(patron);
        
        // Crear un objeto Matcher para el nombre dado
        Matcher matcher = pattern.matcher(nombre);
        
        // Devolver true si el nombre coincide con el patrón, de lo contrario false
        if(!matcher.matches())
            throw new NombreException("Lo que has introducido no parece un nombre real");
        return matcher.matches();
    }
}