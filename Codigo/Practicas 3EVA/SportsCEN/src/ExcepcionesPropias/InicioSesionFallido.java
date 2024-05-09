/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExcepcionesPropias;


public class InicioSesionFallido extends Exception {
    //@Nacho
    //es una clase de tipo excepcion para tratar los login fallidos
    public InicioSesionFallido(String mensaje) {
        super(mensaje);
    }
}