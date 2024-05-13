/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionesPropias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CorreoException extends Exception {
    //@Nacho
    //es una clase de tipo excepcion para tratar los login fallidos
    public CorreoException(String mensaje) {
        super(mensaje);
    }
    
    // Método para validar un correo electrónico
    public static boolean validarCorreo(String correo) throws CorreoException {
        // Patrón para validar direcciones de correo electrónico
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        
        // Compilar el patrón en una expresión regular
        Pattern pattern = Pattern.compile(patron);
        
        // Crear un objeto Matcher para la cadena del correo electrónico
        Matcher matcher = pattern.matcher(correo);
        
        if(!matcher.matches())
            throw new CorreoException("Ese correo no parece valido");
            
        // Devolver true si el correo coincide con el patrón, de lo contrario false
        return matcher.matches();
    }
    
}