package data;
/**
 * Es una clase abstracta de la que heredan Humanos y CPU, les obliga a implementar el metodo de elegir mano
 * @author Nacho y Jesus
 */
public abstract class Jugador {
    
    private String nombre;

    public abstract Mano elegirMano();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
