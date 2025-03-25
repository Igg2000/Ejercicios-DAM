package data;

import java.util.ArrayList;
import java.util.List;






public class Curso {
    
    String nombre;
    Asignatura asignaturaCurso;
    Aula aulacurso;
    List <Alumno> alumnoscurso = new ArrayList<>();

    //constructor
    
    public Curso(String nombre, Asignatura asignaturaCurso, Aula aulacurso) {
        this.nombre = nombre;
        this.asignaturaCurso = asignaturaCurso;
        this.aulacurso = aulacurso;
        
    }
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public Asignatura getAsignaturaCurso() {
        return asignaturaCurso;
    }

    public Aula getAulacurso() {
        return aulacurso;
    }

    public List<Alumno> getAlumnoscurso() {
        return alumnoscurso;
    }

    public String toString() {
        return nombre;
    }
    
    
}
