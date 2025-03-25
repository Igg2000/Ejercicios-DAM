/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.TreeSet;

public class Curso implements Comparable<Curso> {
    private String nombre;
    private TreeSet<Asignatura> asignaturas = new TreeSet<>();
    private TreeSet<Alumno> alumnos = new TreeSet<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public void matricularAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public Alumno buscarAlumno(String matricula) {
        for (Alumno alumno : alumnos) {
            if (alumno.getMatricula().equals(matricula)) return alumno;
        }
        return null;
    }

    public Asignatura buscarAsignatura(String nombre) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre().equals(nombre)) return asignatura;
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public TreeSet<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public TreeSet<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Curso otroCurso) {
        return this.nombre.compareTo(otroCurso.nombre);
    }
}
