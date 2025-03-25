package data;

import ExcepcionesPropias.LoginException;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * 
 */
public class Tienda {

    /**
     * Default constructor
     */
    public Tienda(String nombre) {
        this.nombre = nombre;
    }



    private String nombre;

    private Gerente gerenteTienda;

    private List<Dependiente> dependientesTienda = new ArrayList<>();
    
    private List<Articulo> articulosTienda= new ArrayList<>();

    private List<Cliente> clientesTienda= new ArrayList<>();
    
    
    
    
    // de aqui hacia abajo getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gerente getGerenteTienda() {
        return gerenteTienda;
    }

    public void setGerenteTienda(Gerente gerenteTienda) {
        this.gerenteTienda = gerenteTienda;
    }

    public List<Dependiente> getDependientesTienda() {
        return dependientesTienda;
    }

    public void setDependientesTienda(List<Dependiente> dependientesTienda) {
        this.dependientesTienda = dependientesTienda;
    }

    public List<Articulo> getArticulosTienda() {
        return articulosTienda;
    }

    public void setArticulosTienda(List<Articulo> articulosTienda) {
        this.articulosTienda = articulosTienda;
    }

    public List<Cliente> getClientesTienda() {
        return clientesTienda;
    }

    public void setClientesTienda(List<Cliente> clientesTienda) {
        this.clientesTienda = clientesTienda;
    }

    public PersonalTienda dameElEmpleadoLogueado(String user, String pass) throws LoginException {
       
    //@Nacho
        
      //esto compara si el usuario y contraseña introducidos coincide con los del gerente y lo devuelve
        if(user.equals(this.getGerenteTienda().getCredenciales().getNombreUsuario()) && pass.equals(this.getGerenteTienda().getCredenciales().getContraseña()))
            return this.getGerenteTienda();
        
      //esto compara si el usuario y contraseña introducidos coincide con los de algun empleado y lo devuelve
        for (int i = 0; i < this.getDependientesTienda().size(); i++) {
            if(user.equals(this.getDependientesTienda().get(i).getCredenciales().getNombreUsuario()) && 
                    pass.equals(this.getDependientesTienda().get(i).getCredenciales().getContraseña()) )
                return this.getDependientesTienda().get(i);
     
        }
 
        //en caso de no haberlo encontrado lanza una excepcion propia
        throw new LoginException("El usuario y contraseña no coincide con ningun empleado");
    }
}
