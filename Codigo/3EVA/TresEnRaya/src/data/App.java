/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author grovy
 */
public class App {
    
    
    Boolean turnoJ1=true;
    int[][] tablero={{0,0,0},{0,0,0},{0,0,0}};

    public Boolean getTurnoJ1() {
        return turnoJ1;
    }

    public void setTurnoJ1(Boolean turnoJ1) {
        this.turnoJ1 = turnoJ1;
    }

    //constructor
    public App() {
        
        
    } 

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    
    

    public int verificarGanador() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != 0 && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                return tablero[i][0];
            }
        }

        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != 0 && tablero[0][j] == tablero[1][j] && tablero[0][j] == tablero[2][j]) {
                return tablero[0][j];
            }
        }

        // Comprobar diagonales
        if (tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return tablero[0][0];
        }
        if (tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return tablero[0][2];
        }

        // Si no hay ganador
        return 0;
    
    }
    
}
