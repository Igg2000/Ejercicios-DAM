package data;

import java.util.ArrayList;
import java.util.List;






public class Academia {
    
    private List<Asignatura> AsignaturasAcademia = new ArrayList<>();
    private List<Aula> AulasAcademia = new ArrayList<>();
    private List<Alumno> AlmunosAcademia = new ArrayList<>();

    //Constructor
    public Academia() {
        
        this.AulasAcademia.add(new Aula(1));
        this.AulasAcademia.add(new Aula(1));
        this.AulasAcademia.add(new Aula(1));
        this.AulasAcademia.add(new Aula(2));
        this.AulasAcademia.add(new Aula(2));
        this.AulasAcademia.add(new Aula(2));
        this.AulasAcademia.add(new Aula(3));
        this.AulasAcademia.add(new Aula(3));
        this.AulasAcademia.add(new Aula(3));
    }
     public List<Aula> getAulasAcademia() {
        return AulasAcademia;
    }

    public List<Asignatura> getAsignaturasAcademia() {
        return AsignaturasAcademia;
    }

    public List<Alumno> getAlmunosAcademia() {
        return AlmunosAcademia;
    }
     
    
}
