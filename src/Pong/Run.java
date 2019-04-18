/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pong;

/**
 *
 * @author luj0314
 */
import javax.swing.JFrame;
import java.awt.Component;
public class Run extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public Run(){
        super("PONG TESTER");
        setSize(WIDTH, HEIGHT);
        Pong game = new Pong();
        ((Component)game).setFocusable(true);
        getContentPane().add(game);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
