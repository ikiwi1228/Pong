package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
  public Ball(int x,int y){
    super(x,y);
    xSpeed = 3;
    ySpeed = 1;
  }
  public Ball(int x, int y, int w){
    super(x,y,w);
    xSpeed = 3;
    ySpeed = 1;
  }
  public Ball(int x, int y, int w, int h){
    super(x,y,w,h);
    xSpeed = 3;
    ySpeed = 1;
  }
  public Ball(int x, int y, int w, int h, Color c){
    super(x,y,w,h,c);
    xSpeed = 3;
    ySpeed = 1;
  }
  public Ball(int x, int y, int w, int h, Color c, int xs){
    super(x,y,w,h,c);
    xSpeed = xs;
    ySpeed = 1;
  }

	public Ball(int x, int y,int w, int h, Color c, int xs, int ys){
    super(x,y,w,h,c);
    xSpeed = xs;
    ySpeed = ys;
  }
 
   //add the set methods
   public void setXSpeed(int x){
     xSpeed = x;
   }
   public void setYSpeed(int y){
     ySpeed = y;
   }

   public int getXSpeed(){
     return xSpeed;
   }
   public int getYSpeed(){
     return ySpeed;
   }
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
    draw(window,Color.white);
    setX(getX()+xSpeed);
		//setY
    setY(getY()+ySpeed);
		//draw the ball at its new location
    draw(window);
   }
   
	public boolean equals(Object obj)
	{
    Ball s = (Ball) obj;
    if (this.getXSpeed()!=s.getXSpeed()){
      return false;
    }
    else if (this.getYSpeed()!=s.getYSpeed()){
      return false;
    }
    else if (!super.equals(s)){
      return false;
    }
		return true;
	}   

   //add the get methods

   //add a toString() method
   public String toString(){
     return super.toString()+ "X speed is " + this.getXSpeed() +" and y speed is "+ this.getYSpeed() + "." ;
   }
}