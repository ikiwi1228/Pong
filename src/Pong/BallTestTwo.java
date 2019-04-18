package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable {

    private Ball ball;

    public BallTestTwo() {
        setBackground(Color.WHITE);
        setVisible(true);

        //instantiate a new Ball
        ball = new Ball(300, 100, 20, 20, Color.BLACK, 5, 8);   //test initialization constructor

        //test all constructors
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        ball.moveAndDraw(window);

        if (!(ball.getX() >= 10 && ball.getX() <= getWidth() - ball.getWidth())) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= getHeight() - ball.getHeight())) {
            ball.setYSpeed(-ball.getYSpeed());
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(19);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
