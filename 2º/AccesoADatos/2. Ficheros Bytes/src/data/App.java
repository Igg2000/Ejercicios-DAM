/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
class App {
    File fichero;
    
    public App() {
        fichero= new File(".//src//res//fichero.txt");
        
        escribirEnFichero();
        leerFichero();
    
    }
    
    private void escribirEnFichero() {        
        try {    
            FileOutputStream fos = new FileOutputStream(fichero,true);
            ObjectOutputStream oos;
            if (fichero.exists() && fichero.length() == 0)
                oos = new ObjectOutputStream(fos);
            else{
                oos = new MiObjectOutputStream(fos);
            }
            
            
            // Pedir datos al usuario con JOptionPane
            String dni = JOptionPane.showInputDialog("Introduce el DNI del empleado:");
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del empleado:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad del empleado:"));
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el sueldo del empleado:"));
            
            Empleado nuevoEmpleado = new Empleado(dni, nombre, edad, sueldo);
            oos.writeObject(nuevoEmpleado);
            
            oos.close();
            fos.close();
            
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo en el output");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear el ObjectOutputStream");
        }
    }


    private void leerFichero() {
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Crear una lista para almacenar los empleados leídos
            List<Empleado> empleados = new ArrayList<>();

            // Leer objetos hasta llegar al final del archivo
            while (true) {
                try {
                    Empleado empleado = (Empleado) ois.readObject();  // Leer un objeto
                    empleados.add(empleado);  // Agregarlo a la lista
                } catch (EOFException e) {
                    // Cuando lleguemos al final del archivo, salimos del bucle
                    break;
                }
            }

            // Mostrar todos los empleados leídos
            for (Empleado emp : empleados) {
                System.out.println(emp);  // Puedes personalizar lo que se imprime aquí
            }

            ois.close();  // Cerrar el ObjectInputStream
            fis.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class MiObjectOutputStream extends ObjectOutputStream {

        public MiObjectOutputStream(FileOutputStream fos) throws IOException {
            super(fos);
        }

        @Override
        protected void writeStreamHeader() throws IOException {

        }
    }

}
