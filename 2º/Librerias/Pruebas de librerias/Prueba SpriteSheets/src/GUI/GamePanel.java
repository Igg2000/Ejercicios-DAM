/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Nacho
 */
import data.Player;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    private Player player;

    public GamePanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.pintar(g);
    }

    public void update() {
        repaint();
    }
}
