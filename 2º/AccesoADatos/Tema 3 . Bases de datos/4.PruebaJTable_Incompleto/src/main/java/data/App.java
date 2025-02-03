/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data;

import GUI.PruebaJTable;
import Ventana.Vppal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nacho
 */
public class App {

    public static void main(String[] args) {
        Vppal v = new Vppal();
        
        
        TreeMap<String,TreeMap> cursos = new TreeMap<>();
        TreeMap<String, List<String>> asignaturas = new TreeMap<>();

        // Añadir asignaturas y listas de alumnos
        asignaturas.put("Matemáticas", new ArrayList<>(List.of("Juan", "María", "Carlos")));
        asignaturas.put("Historia", new ArrayList<>(List.of("Ana", "Pedro", "Lucía")));
        asignaturas.put("Ciencias", new ArrayList<>(List.of("Miguel", "Sofía", "Elena")));

        cursos.put("DAM2", asignaturas);
        cursos.put("DAM1", asignaturas);
        
        MiTabla tabla = new MiTabla(cursos,"Curso","Asignaturas");
        PruebaJTable panel = new PruebaJTable(tabla);
        
        v.ponPanel(panel);
    }
}
