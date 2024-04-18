package data;






public class Curso {
    
    String Nombre;
    
    Asignatura AsignaturaCurso= new Asignatura();
    
        public Curso(String Nombre, Asignatura AsignaturaCurso) {
        this.Nombre = Nombre;
        this.AsignaturaCurso = AsignaturaCurso;
    }

    Curso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
