/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionesPropias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TelefonoException extends Exception {
    //@Nacho
    //es una clase de tipo excepcion para tratar los login fallidos
    public TelefonoException(String mensaje) {
        super(mensaje);
    }
    
      
    public static boolean validarTelefono(String telefono) throws TelefonoException {
        // Patrón para validar cualquier secuencia de 9 dígitos
        String patron = "\\d{9}"; // 9 dígitos
        
        // Compilar el patrón en una expresión regular
        Pattern pattern = Pattern.compile(patron);
        
        // Crear un objeto Matcher para el número de teléfono dado
        Matcher matcher = pattern.matcher(telefono);
        
        if(!matcher.matches())
            throw new TelefonoException("El numero de telefono introducido debe tener 9 digitos");
        
        // Devolver true si el número coincide con el patrón, de lo contrario false
        return matcher.matches();
    }
}