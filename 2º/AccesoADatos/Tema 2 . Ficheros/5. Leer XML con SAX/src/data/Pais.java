/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
public class Pais {
    private String nombre;
    private Double habitantes;
    private String unidadHabitantes;
    private String capital;
    private char sigla;
    private int prefijo;

    public Pais(String nombre, Double habitantes, String unidadHabitantes, String capital, char sigla, int prefijo) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.unidadHabitantes=unidadHabitantes;
        this.capital = capital;
        this.sigla = sigla;
        this.prefijo = prefijo;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Double habitantes) {
        this.habitantes = habitantes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    @Override
    public String toString() {
        return nombre +
           "\n  Habitantes: " + habitantes + " "+ unidadHabitantes+
           "\n  Capital: " + capital +
           "\n  Sigla: " + sigla +
           "\n  Prefijo: " + prefijo +
           "\n";
    }
    
    
    
}
