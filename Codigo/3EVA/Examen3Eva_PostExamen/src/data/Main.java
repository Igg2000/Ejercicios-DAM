/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import GUI.PanelPrincipal;
import GUI.Vpp;
import static data.Paises.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static boolean modoTexto= true;
    
    public static void main(String[] args) {
        Empresa e = new Empresa("TenisDAM");
        
        
        cargarDatosDePrueba(e);
        
        if (modoTexto)
            iniciarAppModoTexto(e);
        else{
            Vpp v = new Vpp();
            v.ponPanel(new PanelPrincipal(v));
        }
        

        //System.out.println(e.getTorneos().get(0).getRondas());
        
    }

    private static void cargarDatosDePrueba(Empresa e) {
        
        //creamos los 4 torneos
        e.getTorneos().add(new Torneo(Italia,3));
        e.getTorneos().add(new Torneo(Francia,4));
        e.getTorneos().add(new Torneo(España,6));
        e.getTorneos().add(new Torneo(Alemania,5));
        
        
        //lo llenamos de participantes con nombres autogenerados
        List<Torneo> lt= e.getTorneos();
        for (Torneo t : lt) {
          int maxPT=t.getnMaxParticipantes();
            for (int i = 0; i < maxPT; i++) {
               t.AgregarParticipantes();
            }
        }
        
        
        
        
    }

    private static void iniciarAppModoTexto(Empresa e) {
    
         Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa("Nombre de tu empresa");

        boolean salir = false;
        while (!salir) {
            System.out.println("---- Menu Principal ----");
            System.out.println("1. Torneo de Italia");
            System.out.println("2. Torneo de Francia");
            System.out.println("3. Torneo de España");
            System.out.println("4. Torneo de Alemania");
            System.out.println("5. Volver Atras");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                     menuTorneo(Paises.Italia, e.getTorneos().get(0));
                    break;
                case 2:
                     menuTorneo(Paises.Francia, e.getTorneos().get(1));
                    break;
                case 3:
                     menuTorneo(Paises.España, e.getTorneos().get(2));
                    break;
                case 4:
                     menuTorneo(Paises.Alemania, e.getTorneos().get(3));
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
            }
        }
    }

    private static void menuTorneo(Paises pais, Torneo torneo) {
        
         Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("---- Menu Torneo de " + pais + " ----");
            System.out.println("1. Ver lista de participantes");
            System.out.println("2. Agregar participante");
            System.out.println("3. Eliminar participante");
            System.out.println("4. Iniciar sorteo del torneo");
            System.out.println("5. Ver emparejamiento del torneo");
            System.out.println("6. Simular torneo");
            System.out.println("7. Volver atras");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    torneo.visualizarParticipanteModoTexto();
                    break;
                case 2:
                    torneo.AgregarParticipantesModoTexto();
                    break;
                case 3:
                    torneo.EliminarParticipantesModoTexto();
                    break;
                case 4:
                    torneo.realizarSorteo();
                    break;
                case 5:
                    torneo.verEmparejamiento();
                    break;
                case 6:
                    torneo.Simular();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
            }
        }
    }
        
    
       
}
