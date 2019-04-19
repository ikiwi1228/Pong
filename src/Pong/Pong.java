package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {

    private BlinkyBall ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;
    /*private Wall leftWall;
    private Wall rightWall;
    private Wall topWall;
    private Wall botWall;
    */
    private int leftScore;
    private int rightScore;

    public Pong() {
        //set up all variables related to the game
        ball = new BlinkyBall(300, 100, 20, 20, Color.BLACK, 1, 1);
        leftPaddle = new Paddle(50, 100, 10, 500, Color.GREEN, 6);
        rightPaddle = new Paddle(550, 100, 10, 500, Color.GREEN, 6);
       /* leftWall = new Wall(0,0,5,getHeight());
        rightWall = new Wall(getWidth(),0,5,getHeight());
        topWall = new Wall(0,0,getWidth(),5);
        botWall = new Wall(0,getHeight(),getWidth(),5); */
        leftScore=0;
        rightScore=0;
        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);		//starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;
        

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);
        /*leftWall.draw(graphToBack);
        rightWall.draw(graphToBack);
        topWall.draw(graphToBack);
        botWall.draw(graphToBack);*/
        //see if the ball hits the left paddle
        if(ball.didCollideLeft(leftPaddle)){
            ball.setXSpeed(-ball.getXSpeed());
        }
        //see if the ball hits the right paddle
        if(ball.didCollideRight(rightPaddle)){
            ball.setXSpeed(-ball.getXSpeed());
        }
        //see if ball hits left wall or right wall
        if ((ball.getX()<0 || ball.getX()>getWidth()-100)) {
            ball.setXSpeed(0);
            ball.setYSpeed(0);
            if (ball.getX()<0){
                rightScore++;
            }
            else if(ball.getX()>getWidth()-100){
                
                leftScore++;
            }
            ball.draw(graphToBack,Color.WHITE);
            ball.setPos(getWidth()/2, getHeight()/2);
            ball.setXSpeed(2);
            ball.setYSpeed(3);
        }
        //see if the ball hits the top or bottom wall 
        if ((ball.getY()<0 || ball.getY()>getHeight())) {
            ball.setYSpeed(-ball.getYSpeed());
        }
        
        //see if the paddles need to be moved
        if (keys[0] == true) {
            //move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[1] == true) {
            //move left paddle down and draw it on the window
            leftPaddle.moveDownAndDraw(graphToBack);
        }
        if (keys[2] == true) {
            rightPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[3] == true) {
            rightPaddle.moveDownAndDraw(graphToBack);
        }
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(600,300,200,200);
        graphToBack.setColor(Color.GREEN);

        graphToBack.drawString("Right Player Scores ="+rightScore, 600,500);
        graphToBack.drawString("Left Player Scores ="+leftScore, 600,400);
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
