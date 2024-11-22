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
    
    public App(Mundial modelo, Ventana vista) {
        this.mundial=modelo;
        this.vista=vista;
        datosDePrueba();
    }

    @Override
    public void run() {
        vista.setVisible(true);
    }
    
    
     // Método para inicializar datos de prueba
    private void datosDePrueba() {
        // Escuderías disponibles en MotoGP 2024
        mundial.agregarEscuderia("Ducati Lenovo Team");
        mundial.agregarEscuderia("Red Bull KTM Factory Racing");
        mundial.agregarEscuderia("Monster Energy Yamaha MotoGP");
        mundial.agregarEscuderia("Repsol Honda Team");
        mundial.agregarEscuderia("Aprilia Racing Team");
        mundial.agregarEscuderia("Gresini Racing MotoGP");
        mundial.agregarEscuderia("Mooney VR46 Racing Team");
        mundial.agregarEscuderia("Prima Pramac Racing");
        mundial.agregarEscuderia("LCR Honda");
        mundial.agregarEscuderia("GasGas Factory Racing Tech3");
        mundial.agregarEscuderia("RNF MotoGP Team");

        // Crear circuitos
        Circuito circuito1 = new Circuito("Circuito de Jerez", "España", 4.428);
        Circuito circuito2 = new Circuito("Mugello", "Italia", 5.245);
        mundial.agregarCircuito(circuito1);
        mundial.agregarCircuito(circuito2);

        // Crear pilotos
        Piloto piloto1 = new Piloto("Marc Márquez", "España", "Repsol Honda Team", 200);
        Piloto piloto2 = new Piloto("Fabio Quartararo", "Francia", "Monster Energy Yamaha MotoGP", 150);
        Piloto piloto3 = new Piloto("Pecco Bagnaia", "Italia", "Ducati Lenovo Team", 250);
        Piloto piloto4 = new Piloto("Jack Miller", "Australia", "Red Bull KTM Factory Racing", 100);
        Piloto piloto5 = new Piloto("Aleix Espargaró", "España", "Aprilia Racing Team", 175);
        Piloto piloto6 = new Piloto("Enea Bastianini", "Italia", "Gresini Racing MotoGP", 90);
        Piloto piloto7 = new Piloto("Luca Marini", "Italia", "Mooney VR46 Racing Team", 130);
        Piloto piloto8 = new Piloto("Johann Zarco", "Francia", "Prima Pramac Racing", 140);
        Piloto piloto9 = new Piloto("Takaaki Nakagami", "Japón", "LCR Honda", 80);
        Piloto piloto10 = new Piloto("Pol Espargaró", "España", "GasGas Factory Racing Tech3", 60);
        Piloto piloto11 = new Piloto("Miguel Oliveira", "Portugal", "RNF MotoGP Team", 90);

        mundial.agregarPiloto(piloto1);
        mundial.agregarPiloto(piloto2);
        mundial.agregarPiloto(piloto3);
        mundial.agregarPiloto(piloto4);
        mundial.agregarPiloto(piloto5);
        mundial.agregarPiloto(piloto6);
        mundial.agregarPiloto(piloto7);
        mundial.agregarPiloto(piloto8);
        mundial.agregarPiloto(piloto9);
        mundial.agregarPiloto(piloto10);
        mundial.agregarPiloto(piloto11);

        // Crear motos
        Moto moto1 = new Moto(93, "Honda", "RC213V");
        Moto moto2 = new Moto(20, "Yamaha", "YZR-M1");
        Moto moto3 = new Moto(63, "Ducati", "Desmosedici GP23");
        Moto moto4 = new Moto(43, "KTM", "RC16");
        Moto moto5 = new Moto(41, "Aprilia", "RS-GP");

        mundial.agregarMoto(moto1);
        mundial.agregarMoto(moto2);
        mundial.agregarMoto(moto3);
        mundial.agregarMoto(moto4);
        mundial.agregarMoto(moto5);

        // Asignar motos a pilotos
        mundial.asignarMotoAPiloto(piloto1, moto1);
        mundial.asignarMotoAPiloto(piloto2, moto2);
        mundial.asignarMotoAPiloto(piloto3, moto3);
        mundial.asignarMotoAPiloto(piloto4, moto4);
        mundial.asignarMotoAPiloto(piloto5, moto5);
        mundial.asignarMotoAPiloto(piloto6, moto3);
        mundial.asignarMotoAPiloto(piloto7, moto2);
        mundial.asignarMotoAPiloto(piloto8, moto3);
        mundial.asignarMotoAPiloto(piloto9, moto1);
        mundial.asignarMotoAPiloto(piloto10, moto4);
        mundial.asignarMotoAPiloto(piloto11, moto5);

        System.out.println("Datos de prueba cargados en el Mundial:");
        System.out.println(mundial);
    }


    
}
