/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionesPropias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PrecioException extends Exception {
    //@Nacho
    //es una clase de tipo excepcion para tratar los login fallidos
    public PrecioException(String mensaje) {
        super(mensaje);
    }
    
     // Método para validar y convertir un precio a float
    public static float validarYConvertirPrecio(String precioStr) throws PrecioException {
        // Reemplazar las comas por puntos para evitar problemas con el formato
        precioStr = precioStr.replace(',', '.');
        
        // Patrón para validar un precio con dos decimales
        String patron = "\\d+(\\.\\d{2})?"; // Dígitos opcionales seguidos por punto y exactamente dos dígitos decimales
        
        // Compilar el patrón en una expresión regular
        Pattern pattern = Pattern.compile(patron);
        
        // Crear un objeto Matcher para la cadena del precio
        Matcher matcher = pattern.matcher(precioStr);
        
        // Verificar si el precio cumple con el formato esperado
        if (!matcher.matches()) {
            throw new PrecioException("El formato del precio es inválido.");
        }
        
        
        
        try {
            // Intentar convertir la cadena a un número decimal
            float precio = Float.parseFloat(precioStr);
            
            // Verificar si el precio es válido (mayor que cero)
            if (precio <= 0) {
                throw new PrecioException("El precio debe ser mayor que cero.");
            }
            
            // Devolver el precio convertido
            return precio;
        } catch (NumberFormatException e) {
            // Lanzar la excepción si la cadena no puede ser convertida a un número decimal
            throw new PrecioException("El formato del precio es inválido.");
        }
    }
}