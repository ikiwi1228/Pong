package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball {

    //instance variables
    private int xSpeed;
    private int ySpeed;
    public SpeedUpBall() {
        super();

    }

    public SpeedUpBall(int x, int y) {
        super(x, y);

    }

    public SpeedUpBall(int x, int y, int xSpd, int ySpd) {
        super(x, y, 30, 10, Color.BLACK, xSpd, ySpd);

    }

    public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd) {
        super(x, y, wid, ht, Color.BLACK, xSpd, ySpd);
    }

    public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
        super(x, y, wid, ht, col, xSpd, ySpd);

    }

    public void setXSpeed(int xSpd) {
        xSpeed = xSpd;
    }

    public void setYSpeed(int ySpd) {
        ySpeed = ySpd;
    }
}
