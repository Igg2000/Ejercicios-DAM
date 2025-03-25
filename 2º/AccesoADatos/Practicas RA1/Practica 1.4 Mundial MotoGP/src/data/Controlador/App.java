/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Controlador;

import GUI.Ventana;
import data.Modelo.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class App implements Runnable{

    private Mundial mundial;
    private Ventana vista;
    
    private Boolean modoDebug=false;
    
    
    public App(Mundial modelo, Ventana vista) {
        this.mundial=modelo;
        this.vista=vista;
    }

    @Override
    public void run() {
        vista.setVisible(true);
        
        if(modoDebug)
            cargarDatosDePrueba();
        
        mundial.generarPuntos();
    }
    
    public void cargarDatosDePrueba() {
        // Agregar Escuderías
        agregarEscuderias();

        // Agregar Circuitos
        agregarCircuitos();

        // Agregar Pilotos y Motos
        agregarPilotosYMotos();
    }

    // Método para agregar las escuderías
    private void agregarEscuderias() {
        // Escuderías del MotoGP 2023
        mundial.agregarEscuderia("Ducati Lenovo Team");
        mundial.agregarEscuderia("Aprilia Racing");
        mundial.agregarEscuderia("Red Bull KTM Factory Racing");
        mundial.agregarEscuderia("Repsol Honda Team");
        mundial.agregarEscuderia("Monster Energy Yamaha MotoGP");
        mundial.agregarEscuderia("Prima Pramac Racing");
        mundial.agregarEscuderia("Gresini Racing MotoGP");
        mundial.agregarEscuderia("LCR Honda");
        mundial.agregarEscuderia("Mooney VR46 Racing Team");
        mundial.agregarEscuderia("Tech3 GASGAS Factory Racing");
    }
    // Método para agregar los circuitos
    private void agregarCircuitos() {
        // Circuitos del MotoGP 2023
        mundial.agregarCircuito(new Circuito("Losail International Circuit", "Catar", 5.380));
        mundial.agregarCircuito(new Circuito("Autodromo Internacional do Algarve", "Portugal", 4.684));
        mundial.agregarCircuito(new Circuito("Termas de Río Hondo", "Argentina", 4.806));
        mundial.agregarCircuito(new Circuito("Circuit of the Americas", "EE.UU.", 5.513));
        mundial.agregarCircuito(new Circuito("Autodromo Internazionale del Mugello", "Italia", 5.245));
        mundial.agregarCircuito(new Circuito("Sachsenring", "Alemania", 3.671));
        mundial.agregarCircuito(new Circuito("Silverstone", "Reino Unido", 5.891));
        mundial.agregarCircuito(new Circuito("Red Bull Ring", "Austria", 4.318));
        mundial.agregarCircuito(new Circuito("Misano World Circuit Marco Simoncelli", "San Marino", 4.226));
        mundial.agregarCircuito(new Circuito("Motegi", "Japón", 4.801));
        mundial.agregarCircuito(new Circuito("Phillip Island", "Australia", 4.448));
        mundial.agregarCircuito(new Circuito("Sepang International Circuit", "Malasia", 5.543));
        mundial.agregarCircuito(new Circuito("Circuit Ricardo Tormo", "España", 4.005));
    }

    // Método para agregar los pilotos y motos
    private void agregarPilotosYMotos() {
        // Pilotos con sus respectivas escuderías
        Piloto bagnaia = new Piloto("Francesco Bagnaia", "Italia", "Ducati Lenovo Team");
        Piloto bastianini = new Piloto("Enea Bastianini", "Italia", "Ducati Lenovo Team");
        Piloto aleixEspargaro = new Piloto("Aleix Espargaró", "España", "Aprilia Racing");
        Piloto maverickVinales = new Piloto("Maverick Viñales", "España", "Aprilia Racing");
        Piloto bradBinder = new Piloto("Brad Binder", "Sudáfrica", "Red Bull KTM Factory Racing");
        Piloto jackMiller = new Piloto("Jack Miller", "Australia", "Red Bull KTM Factory Racing");
        Piloto marcMarquez = new Piloto("Marc Márquez", "España", "Repsol Honda Team");
        Piloto joanMir = new Piloto("Joan Mir", "España", "Repsol Honda Team");
        Piloto fabioQuartararo = new Piloto("Fabio Quartararo", "Francia", "Monster Energy Yamaha MotoGP");
        Piloto francoMorbidelli = new Piloto("Franco Morbidelli", "Italia", "Monster Energy Yamaha MotoGP");
        Piloto jorgeMartin = new Piloto("Jorge Martín", "España", "Prima Pramac Racing");
        Piloto johannZarco = new Piloto("Johann Zarco", "Francia", "Prima Pramac Racing");
        Piloto alexMarquez = new Piloto("Alex Márquez", "España", "Gresini Racing MotoGP");
        Piloto fabioDiGiannantonio = new Piloto("Fabio Di Giannantonio", "Italia", "Gresini Racing MotoGP");
        Piloto takaakiNakagami = new Piloto("Takaaki Nakagami", "Japón", "LCR Honda");
        Piloto alexRins = new Piloto("Álex Rins", "España", "LCR Honda");
        Piloto lucaMarini = new Piloto("Luca Marini", "Italia", "Mooney VR46 Racing Team");
        Piloto marcoBezzecchi = new Piloto("Marco Bezzecchi", "Italia", "Mooney VR46 Racing Team");
        Piloto polEspargaro = new Piloto("Pol Espargaró", "España", "Tech3 GASGAS Factory Racing");
        Piloto augustoFernandez = new Piloto("Augusto Fernández", "España", "Tech3 GASGAS Factory Racing");

        // Lista de pilotos
        List<Piloto> listaPilotos = Arrays.asList(
            bagnaia, bastianini, aleixEspargaro, maverickVinales, bradBinder, jackMiller,
            marcMarquez, joanMir, fabioQuartararo, francoMorbidelli, jorgeMartin,
            johannZarco, alexMarquez, fabioDiGiannantonio, takaakiNakagami, alexRins,
            lucaMarini, marcoBezzecchi, polEspargaro, augustoFernandez
        );

        // Crear motos con números únicos y asignarlas a los pilotos
        int numeroMoto = 1;
        for (Piloto piloto : listaPilotos) {
            String marca = determinarMarcaPorEscuderia(piloto.getEscuderia());
            String modelo = generarModeloAleatorio(marca);
            Moto moto = new Moto(numeroMoto++, marca, modelo);

            mundial.agregarPiloto(piloto);
            mundial.agregarMoto(moto);
            mundial.asignarMotoAPiloto(piloto, moto);
        }
    }

    // Método para determinar la marca de moto según la escudería
    private String determinarMarcaPorEscuderia(String escuderia) {
        switch (escuderia) {
            case "Ducati Lenovo Team":
            case "Prima Pramac Racing":
            case "Gresini Racing MotoGP":
            case "Mooney VR46 Racing Team":
                return "Ducati";
            case "Aprilia Racing":
                return "Aprilia";
            case "Red Bull KTM Factory Racing":
            case "Tech3 GASGAS Factory Racing":
                return "KTM";
            case "Repsol Honda Team":
            case "LCR Honda":
                return "Honda";
            case "Monster Energy Yamaha MotoGP":
                return "Yamaha";
            default:
                throw new IllegalArgumentException("Escudería desconocida: " + escuderia);
        }
    }
    
    // Método auxiliar para generar un modelo aleatorio basado en la marca
    private String generarModeloAleatorio(String marca) {
        List<String> modelos = new ArrayList<>();
        switch (marca) {
            case "Ducati":
                modelos = Arrays.asList("Desmosedici GP22", "Desmosedici GP23", "Desmosedici GP21", "Desmosedici GP19");
                break;
            case "Aprilia":
                modelos = Arrays.asList("RS-GP20", "RS-GP21", "RS-GP22", "RS-GP23", "RS-GP18");
                break;
            case "KTM":
                modelos = Arrays.asList("RC16 2020", "RC16 2021", "RC16 2022", "RC16 2023", "RC16 Prototype");
                break;
            case "Honda":
                modelos = Arrays.asList("RC213V 2020", "RC213V 2021", "RC213V 2022", "RC213V 2023", "RC213V-S");
                break;
            case "Yamaha":
                modelos = Arrays.asList("YZR-M1 2020", "YZR-M1 2021", "YZR-M1 2022", "YZR-M1 2023", "YZR-M1 Prototype");
                break;
            case "Pramac Racing":
                modelos = Arrays.asList("Desmosedici GP21 Pramac", "Desmosedici GP22 Pramac", "Desmosedici GP23 Pramac");
                break;
            case "Gresini Racing":
                modelos = Arrays.asList("Desmosedici GP21 Gresini", "Desmosedici GP22 Gresini", "Desmosedici GP23 Gresini");
                break;
            case "LCR Honda":
                modelos = Arrays.asList("RC213V LCR 2020", "RC213V LCR 2021", "RC213V LCR 2022", "RC213V LCR 2023");
                break;
            case "VR46 Racing":
                modelos = Arrays.asList("Desmosedici GP21 VR46", "Desmosedici GP22 VR46", "Desmosedici GP23 VR46");
                break;
            case "Tech3 GASGAS":
                modelos = Arrays.asList("RC16 GASGAS 2021", "RC16 GASGAS 2022", "RC16 GASGAS 2023");
                break;
            default:
                throw new IllegalArgumentException("Marca desconocida: " + marca);
        }

        // Seleccionar aleatoriamente un modelo de la lista
        int randomIndex = (int) (Math.random() * modelos.size());
        return modelos.get(randomIndex);
    }

    public Mundial getMundial() {
        return mundial;
    }

    public void setMundial(Mundial mundial) {
        this.mundial = mundial;
    }

    public Ventana getVista() {
        return vista;
    }

    public void setVista(Ventana vista) {
        this.vista = vista;
    }

    
    
}
