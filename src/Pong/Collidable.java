package Pong;

//� A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -
import java.awt.Color;
import java.awt.Graphics;

public interface Collidable {

    boolean didCollideLeft(Object obj);

    boolean didCollideRight(Object obj);

    boolean didCollideTop(Object obj);

    boolean didCollideBottom(Object obj);
}
