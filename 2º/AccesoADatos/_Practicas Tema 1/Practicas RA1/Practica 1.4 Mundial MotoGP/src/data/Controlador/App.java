/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Controlador;

import GUI.Ventana;
import data.Modelo.*;

/**
 *
 * @author Nacho
 */
public class App implements Runnable{

    Mundial mundial;
    Ventana vista;
    
    Boolean modoDebug=true;
    
    public App(Mundial modelo, Ventana vista) {
        this.mundial=modelo;
        this.vista=vista;
    }

    @Override
    public void run() {
        vista.setVisible(true);
        
        if(modoDebug)
            cargarDatosDePrueba();
        else
            agregarCircuitos();
        
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
        // Motos
        Moto motoDucati = new Moto(1, "Ducati", "Desmosedici GP23");
        Moto motoAprilia = new Moto(2, "Aprilia", "RS-GP");
        Moto motoKTM = new Moto(3, "KTM", "RC16");
        Moto motoHonda = new Moto(4, "Honda", "RC213V");
        Moto motoYamaha = new Moto(5, "Yamaha", "YZR-M1");

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

        // Agregar pilotos
        mundial.agregarPiloto(bagnaia);
        mundial.agregarPiloto(bastianini);
        mundial.agregarPiloto(aleixEspargaro);
        mundial.agregarPiloto(maverickVinales);
        mundial.agregarPiloto(bradBinder);
        mundial.agregarPiloto(jackMiller);
        mundial.agregarPiloto(marcMarquez);
        mundial.agregarPiloto(joanMir);
        mundial.agregarPiloto(fabioQuartararo);
        mundial.agregarPiloto(francoMorbidelli);
        mundial.agregarPiloto(jorgeMartin);
        mundial.agregarPiloto(johannZarco);
        mundial.agregarPiloto(alexMarquez);
        mundial.agregarPiloto(fabioDiGiannantonio);
        mundial.agregarPiloto(takaakiNakagami);
        mundial.agregarPiloto(alexRins);
        mundial.agregarPiloto(lucaMarini);
        mundial.agregarPiloto(marcoBezzecchi);
        mundial.agregarPiloto(polEspargaro);
        mundial.agregarPiloto(augustoFernandez);

        // Agregar motos
        mundial.agregarMoto(motoDucati);
        mundial.agregarMoto(motoAprilia);
        mundial.agregarMoto(motoKTM);
        mundial.agregarMoto(motoHonda);
        mundial.agregarMoto(motoYamaha);

        // Asignar motos a los pilotos
        mundial.asignarMotoAPiloto(bagnaia, motoDucati);
        mundial.asignarMotoAPiloto(bastianini, motoDucati);
        mundial.asignarMotoAPiloto(aleixEspargaro, motoAprilia);
        mundial.asignarMotoAPiloto(maverickVinales, motoAprilia);
        mundial.asignarMotoAPiloto(bradBinder, motoKTM);
        mundial.asignarMotoAPiloto(jackMiller, motoKTM);
        mundial.asignarMotoAPiloto(marcMarquez, motoHonda);
        mundial.asignarMotoAPiloto(joanMir, motoHonda);
        mundial.asignarMotoAPiloto(fabioQuartararo, motoYamaha);
        mundial.asignarMotoAPiloto(francoMorbidelli, motoYamaha);
        mundial.asignarMotoAPiloto(jorgeMartin, motoDucati);
        mundial.asignarMotoAPiloto(johannZarco, motoDucati);
        mundial.asignarMotoAPiloto(alexMarquez, motoDucati);
        mundial.asignarMotoAPiloto(fabioDiGiannantonio, motoDucati);
        mundial.asignarMotoAPiloto(takaakiNakagami, motoHonda);
        mundial.asignarMotoAPiloto(alexRins, motoHonda);
        mundial.asignarMotoAPiloto(lucaMarini, motoDucati);
        mundial.asignarMotoAPiloto(marcoBezzecchi, motoDucati);
        mundial.asignarMotoAPiloto(polEspargaro, motoKTM);
        mundial.asignarMotoAPiloto(augustoFernandez, motoKTM);
    }
}
