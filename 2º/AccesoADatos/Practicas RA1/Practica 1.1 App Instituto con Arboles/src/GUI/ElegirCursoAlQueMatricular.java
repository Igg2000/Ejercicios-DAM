/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Ventana.Vppal;
import data.Alumno;
import data.App;
import data.Curso;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class ElegirCursoAlQueMatricular extends ListaObjetos.PanelElegirObjeto{

    JFrame v;
    App a;
    JPanel panelAnterior;
    
    public ElegirCursoAlQueMatricular(App a,List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo, Font fuenteLista, Color colorTitulo, Color colorLista) {
        super(objetos, titulo, colorDeFondo, colorDeFondoLista,fuenteTitulo, fuenteLista, colorTitulo, colorLista);
        this.v=a.getV();
        this.a=a;
        this.panelAnterior=a.getMenu();
        
        getBotonConfirmar().setText("Matricular");
    }

    

    //matricula al alumno
    @Override
    public void accionConfirmar() {
        
        String nombre=null;
        Object seleccionado=null;
        try {
            seleccionado=getObjetoSeleccionado();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(v, "Debes elegir un curso");
           return;
        }
        
        
        nombre=JOptionPane.showInputDialog(v,"Introduce el nombre del nuevo Alumno");

        //si le das a cancelar, o a la x de JOptionPane o lo dejas en blanco, no se añade
        if(nombre==null || "".equals(nombre)){
            return;
        }
        
        TreeSet<Curso> cursos = a.getInstituto().getCursos();
        for (Curso curso : cursos){
                if(curso.equals(seleccionado)){
                    curso.matricularAlumno(new Alumno(nombre));
                    JOptionPane.showMessageDialog(v, "Se ha matriculado correctamente al alumno \""+nombre+"\" en el curso "+curso.getNombre());
                }
        }
    }

    @Override
    public void accionVolver() {
        ((Vppal)v).ponPanel(panelAnterior);
    }
    
    
}
