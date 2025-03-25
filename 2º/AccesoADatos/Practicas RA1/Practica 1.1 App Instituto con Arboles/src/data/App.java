/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import GUI.ElegirCursoAlQueMatricular;
import GUI.MetodosGUI;
import ListaObjetos.PanelElegirObjeto;
import Menus.PMenuConNBotones;
import PanelesTexto.PanelPaginaDeTexto;
import PanelesTexto.PanelPaginaDeTextoHTML;
import Ventana.Vppal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author grovy
 */
public class App {
    Instituto instituto;
    Vppal v;
    PMenuConNBotones menu;
    
    Color colorFondo = new Color(215, 215, 215);       // Gris muy claro para el fondo
    Color colorPrincipal = new Color(52, 152, 219);    // Azul suave como color principal
    Color colorComplementario = new Color(21, 108, 255); // Azul más oscuro como complementario
    Color colorTexto = new Color(33, 33, 33);          // Gris oscuro para el texto


    public App() {
        instituto = new Instituto("Palomeras Vallecas");
        v = new Vppal();
    }

    void run() {
        
        crearCursosAsignaturasYAlumnos();
        construirMenuPrincipal();
    }

    private void crearCursosAsignaturasYAlumnos() {
        
        // Crear cursos de FP
        Curso smir = new Curso("Sistemas Microinformáticos y Redes - Grado Medio");
        Curso gestionAdmin = new Curso("Gestión Administrativa - Grado Medio");
        Curso dam = new Curso("Desarrollo de Aplicaciones Multiplataforma - Grado Superior");
        Curso adminFin = new Curso("Administración y Finanzas - Grado Superior");

        // Crear asignaturas y agregarlas a los cursos
        smir.getAsignaturas().add(new Asignatura("Montaje y Mantenimiento de Equipos"));
        smir.getAsignaturas().add(new Asignatura("Redes Locales"));
        smir.getAsignaturas().add(new Asignatura("Aplicaciones Ofimáticas"));
        smir.getAsignaturas().add(new Asignatura("Sistemas Operativos"));
        smir.getAsignaturas().add(new Asignatura("Seguridad Informática"));

        gestionAdmin.getAsignaturas().add(new Asignatura("Operaciones Administrativas de Compra y Venta"));
        gestionAdmin.getAsignaturas().add(new Asignatura("Comunicación Empresarial y Atención al Cliente"));
        gestionAdmin.getAsignaturas().add(new Asignatura("Empresa y Administración"));
        gestionAdmin.getAsignaturas().add(new Asignatura("Tratamiento Informático de la Información"));
        gestionAdmin.getAsignaturas().add(new Asignatura("Inglés"));

        dam.getAsignaturas().add(new Asignatura("Programación de servicios y procesos"));
        dam.getAsignaturas().add(new Asignatura("Acceso a Datos"));
        dam.getAsignaturas().add(new Asignatura("Lenguajes de Marcas y Sistemas de Gestión de Información"));
        dam.getAsignaturas().add(new Asignatura("Sistemas Informáticos"));
        dam.getAsignaturas().add(new Asignatura("Entornos de Desarrollo"));
        dam.getAsignaturas().add(new Asignatura("Desarrollo de Interfaces"));

        adminFin.getAsignaturas().add(new Asignatura("Gestión de Recursos Humanos"));
        adminFin.getAsignaturas().add(new Asignatura("Gestión Financiera"));
        adminFin.getAsignaturas().add(new Asignatura("Contabilidad y Fiscalidad"));
        adminFin.getAsignaturas().add(new Asignatura("Logística y Aprovisionamiento"));
        adminFin.getAsignaturas().add(new Asignatura("Simulación Empresarial"));
        adminFin.getAsignaturas().add(new Asignatura("Inglés Técnico para la Administración y Finanzas"));
        
        // Crear y añadir alumnos a cada curso
        agregarAlumnos(smir, 15);
        agregarAlumnos(gestionAdmin, 16);
        agregarAlumnos(dam, 18);
        agregarAlumnos(adminFin, 17);


        // Agregar los cursos al instituto
        instituto.getCursos().add(smir);
        instituto.getCursos().add(gestionAdmin);
        instituto.getCursos().add(dam);
        instituto.getCursos().add(adminFin);
    }
    
    // Método para agregar varios alumnos a un curso específico
    private void agregarAlumnos(Curso curso, int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            Alumno alumno = new Alumno("Alumno " + i );
            curso.matricularAlumno(alumno);
        }
    }

    private void construirMenuPrincipal() {
        
        Font fuenteTitulo=new Font("Segoe UI",1,42);
        Font fuenteBotones=new Font("Segoe UI",1,20);
        String []ops={"Visualizar Instituto","Matricular Alumnos","Buscar Alumnos","Buscar Asignaturas","Salir"};
        menu= new PMenuConNBotones(ops,instituto.getNombre(), colorComplementario, colorPrincipal, colorFondo, fuenteTitulo, colorTexto, fuenteBotones, colorTexto);
        JButton[] botones = menu.getBotones();
        //Vis insti
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelPaginaDeTextoHTML p = new PanelPaginaDeTextoHTML(instituto.getNombre(),instituto.toHtml());
                
                MetodosGUI.agregarBotonDeVolverAUnPanel(v, p , menu);
                
                v.ponPanel(p);
            }
           
        });
        
        //matricular alumno
        botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                List listaCursos = new ArrayList();
                listaCursos.addAll(instituto.getCursos());
                
                Font fuenteTitulo=new Font("Segoe UI",1,42);
                Font fuenteLista=new Font("Segoe UI",1,20);
                
                ElegirCursoAlQueMatricular panel= new ElegirCursoAlQueMatricular
        (App.this,listaCursos, "Elige el curso al que quieres matricular",colorFondo,colorPrincipal,fuenteTitulo, fuenteLista, colorTexto, colorTexto);
                v.ponPanel(panel);
            }
        });
        
        //buscar alumno
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pedir el código del alumno
                String codigoAlumno = JOptionPane.showInputDialog(v, "Introduce el código del alumno:");

                // Validar entrada
                if (codigoAlumno == null || codigoAlumno.isEmpty()) {
                    JOptionPane.showMessageDialog(v, "El código no puede estar vacío.");
                    return;
                }

                // Buscar el alumno por código
                Alumno alumnoEncontrado = instituto.buscarAlumno(codigoAlumno);

                // Mostrar resultados
                if (alumnoEncontrado != null) {
                   JOptionPane.showMessageDialog(v,"Se ha encontrado el siguiente alumno:\n"+alumnoEncontrado.toString());
                } else {
                   JOptionPane.showMessageDialog(v, "Alumno no encontrado.");
                }
    
            }
        });
        
        //buscar asignatura
        botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pedir el identificador de la asignatura
                String idAsignatura = JOptionPane.showInputDialog(null, "Introduce el ID de la asignatura:");

                // Validar entrada
                if (idAsignatura == null || idAsignatura.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El ID no puede estar vacío.");
                    return;
                }

                // Buscar la asignatura por ID en los cursos
                StringBuilder resultado = new StringBuilder();
                boolean encontrada = false;

                for (Curso curso : instituto.getCursos()) {
                    for (Asignatura asignatura : curso.getAsignaturas()) {
                        if (asignatura.getId().equalsIgnoreCase(idAsignatura)) {
                            resultado.append("Curso: ").append(curso.getNombre()).append("\n");
                            resultado.append("Asignatura: ").append(asignatura.toString()).append("\n\n");
                            encontrada = true;
                        }
                    }
                }

                // Mostrar resultados
                if (encontrada) {
                    JOptionPane.showMessageDialog(v,resultado.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Asignatura no encontrada.");
                }
            }
        });
        
        
        menu.elUltimoBotonCierraLaVentana(ops);
        
        
        v.ponPanel(menu);
    }

    public PMenuConNBotones getMenu() {
        return menu;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public Vppal getV() {
        return v;
    }
    
    
}
