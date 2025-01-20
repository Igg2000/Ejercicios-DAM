/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Nacho
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter {
    private Player player;

    public GameKeyListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //para SS.JPEG
        //player.gestionarMovimiento(e.getKeyCode(),1,3,0,2);
        //para SS1.png
        //player.gestionarMovimiento(e.getKeyCode(),0,1,2,3);
        //para SS2.png
        player.gestionarMovimiento(e.getKeyCode(),3,0,2,1);
    }
}
