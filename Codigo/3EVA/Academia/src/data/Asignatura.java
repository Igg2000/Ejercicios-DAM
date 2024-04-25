package data;






public class Asignatura {
    
    private Asignaturas nombre;

    public Asignatura(Asignaturas nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre+"";
    }

    public void setNombre(Asignaturas nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre+"";
    }
    
    
}
