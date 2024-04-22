package data;

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
