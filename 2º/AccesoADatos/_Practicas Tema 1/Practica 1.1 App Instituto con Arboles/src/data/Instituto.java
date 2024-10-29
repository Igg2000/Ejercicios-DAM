/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.TreeSet;

public class Instituto {
    private String nombre;
    private TreeSet<Curso> cursos = new TreeSet<>();

    public Instituto(String nombre) {
        this.nombre = nombre;
    }

    public void matricularAlumnoEnCurso(Alumno alumno, Curso curso) {
        curso.matricularAlumno(alumno);
        cursos.add(curso);
    }

    public Alumno buscarAlumno(String matricula) {
        for (Curso curso : cursos) {
            Alumno alumno = curso.buscarAlumno(matricula);
            if (alumno != null) return alumno;
        }
        return null;
    }

    public Asignatura buscarAsignatura(String codigo) {
        for (Curso curso : cursos) {
            Asignatura asignatura = curso.buscarAsignatura(codigo);
            if (asignatura != null) return asignatura;
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public TreeSet<Curso> getCursos() {
        return cursos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instituto: ").append(nombre).append("\n\n");

        for (Curso curso : cursos) {
            sb.append("Curso: ").append(curso.getNombre()).append("\n");
            sb.append("Asignaturas:\n");
            for (Asignatura asignatura : curso.getAsignaturas()) {
                sb.append(" - ").append(asignatura).append("\n");
            }
            sb.append("Alumnos:\n");
            for (Alumno alumno : curso.getAlumnos()) {
                sb.append(" - ").append(alumno.getNombre()).append(" (").append(alumno.getMatricula()).append(")\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

   /**
    * Devuelve la lista de cursos en HTML
    * @return lista de cursos en HTML
    */
    public String toHtml() {
        StringBuilder sb = new StringBuilder();

        for (Curso curso : cursos) {
            sb.append("<h2>").append(curso.getNombre()).append("</h2>\n");

            sb.append("<h3>Asignaturas:</h3>\n");
            sb.append("<ul>\n");
            for (Asignatura asignatura : curso.getAsignaturas()) {
                sb.append(" <li>").append(asignatura).append("</li>\n");
            }
            sb.append("</ul>\n");

            sb.append("<h3>Alumnos:</h3>\n");
            sb.append("<ul>\n");
            for (Alumno alumno : curso.getAlumnos()) {
                sb.append(" <li>").append(alumno.getNombre()).append(" (").append(alumno.getMatricula()).append(")</li>\n");
            }
            sb.append("</ul>\n");
        }

        return sb.toString();
    }

}
