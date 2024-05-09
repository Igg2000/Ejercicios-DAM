/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author grovy
 */
public class Usuario {
    
    private String nombreUsuario;
    
    private String password;

    //constructor
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.password = contraseña;
    }

    @Override
    public String toString() {
        return "Nombre de Usuario=" + nombreUsuario + " password= " + password;
    }
    
    
    
    //de aqui hacia abajo getters and setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }
    
    
    
    
}
