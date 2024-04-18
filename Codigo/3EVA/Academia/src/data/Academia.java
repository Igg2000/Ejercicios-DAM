package data;

import java.util.ArrayList;
import java.util.List;






public class Academia {
    
    List<Asignatura> AsignaturasAcademia = new ArrayList<>();
    List<Aula> AulasAcademia = new ArrayList<>();
    List<Alumno> AlmunosAcademia = new ArrayList<>();

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
    
}
