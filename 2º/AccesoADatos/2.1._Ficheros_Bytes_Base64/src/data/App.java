/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;
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

        try{
           // Serializar el objeto a un arreglo de bytes
           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
           ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
           
           // Pedir datos al usuario con JOptionPane
            String dni = JOptionPane.showInputDialog("Introduce el DNI del empleado:");
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del empleado:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad del empleado:"));
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el sueldo del empleado:"));
            
            Empleado nuevoEmpleado = new Empleado(dni, nombre, edad, sueldo);
            oos.writeObject(nuevoEmpleado);
            oos.flush();  // Asegura que todos los datos se escriban

            byte[] objetoBytes = byteArrayOutputStream.toByteArray(); // Obtenemos el arreglo de bytes

            // Codificar el arreglo de bytes en Base64
            String objetoBase64 = Base64.getEncoder().encodeToString(objetoBytes);

            // Escribir la cadena Base64 en un archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero,true))) {
                writer.write(objetoBase64); // Escribe la cadena Base64 en el archivo
                writer.newLine();
            }

            System.out.println("Objeto serializado, codificado en Base64 y guardado en 'objeto_base64.txt'.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
        // Método para leer y deserializar el objeto desde el fichero
    private void leerFichero() {
       try {
            // Abrir el archivo para leer las cadenas Base64
            try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                String linea;
                
                // Leer cada línea del archivo (cada línea contiene un objeto codificado en Base64)
                while ((linea = reader.readLine()) != null) {
                    // Decodificar la cadena Base64 a un arreglo de bytes
                    byte[] objetoBytes = Base64.getDecoder().decode(linea);

                    // Deserializar el objeto desde los bytes
                    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(objetoBytes);
                         ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
                        Empleado empleadoLeido = (Empleado) objectInputStream.readObject();

                        // Mostrar los datos del empleado deserializado
                        System.out.println("Empleado deserializado: ");
                        System.out.println("DNI: " + empleadoLeido.getDni());
                        System.out.println("Nombre: " + empleadoLeido.getNombre());
                        System.out.println("Edad: " + empleadoLeido.getEdad());
                        System.out.println("Sueldo: " + empleadoLeido.getSueldo());
                        System.out.println(); // Línea en blanco para separar los empleados
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}