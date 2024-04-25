package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class Academia {
    
    private List<Asignatura> AsignaturasAcademia = new ArrayList<>();
    private List<Aula> AulasAcademia = new ArrayList<>();
    private List<Alumno> AlmunosAcademia = new ArrayList<>();

    int cantcursos=0;
    
    public void AddCursosManual(Scanner s){
        int cont=1;
        System.out.println("Selecciona el Aula a la que vas a añadir el curso");
        for (Aula a : AulasAcademia) {
            System.out.println(cont+". "+a);
            cont++;
        }
        
        //Scanner s= new Scanner(System.in);
        int op= s.nextInt();
        
        System.out.println("Selecciona la Asignatura del curso");
        int cont2=1;
        
        for (Asignatura a : AsignaturasAcademia) {
            System.out.println(cont2+". "+a);
            cont2++;
        }
        int op2= s.nextInt();
        
        //s.close();
        
        
        //variables para hacerlo mas limpio
        cantcursos++;
        String nomCurso= cantcursos+"-"+AsignaturasAcademia.get(op2-1).getNombre();
        Asignatura asCurso=AsignaturasAcademia.get(op2-1);
        Aula auCurso=AulasAcademia.get(op-1);
        
        Curso c= new Curso(nomCurso,asCurso,auCurso);
        AulasAcademia.get(op-1).setCursoAula(c);
    }
    
    
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
        
        for (int i = 0; i < Asignaturas.values().length; i++) {
            this.AsignaturasAcademia.add(new Asignatura(Asignaturas.values()[i])) ;  
        }
        
    }
    
    //getters
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
