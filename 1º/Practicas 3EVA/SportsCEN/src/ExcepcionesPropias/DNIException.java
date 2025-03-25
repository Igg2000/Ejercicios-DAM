/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionesPropias;


public class DNIException extends Exception {
    //@Nacho
    //es una clase de tipo excepcion para tratar los login fallidos
    public DNIException(String mensaje) {
        super(mensaje);
    }
    
     
      // Método para validar un DNI
    public static boolean validarDNI(String dni) throws DNIException {

        // Comprobar que el DNI tiene la longitud adecuada
        if (dni.length() != 9) {
            throw new DNIException("El dni debe tener 8 digitos y una letra");
        }
        
        // Verificar que los primeros 7 caracteres son dígitos
        for (int i = 0; i < 7; i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                throw new DNIException("El dni debe tener 8 digitos y una letra");
            }
        }
        
        // Verificar que el último caracter es una letra
        char lastChar = Character.toUpperCase(dni.charAt(8));
        
        if(!Character.isLetter(lastChar))
            throw new DNIException("Lo ultimo debe ser una letra");
        return Character.isLetter(lastChar);
    }
}