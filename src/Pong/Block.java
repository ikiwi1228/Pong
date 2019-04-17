package Pong;


import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block() {
      setX(100);
      setY(150);
      setWidth(10);
      setHeight(10);
      setColor(Color.BLACK);
    }

    //add other Block constructors - x , y , width, height, color
     public Block(int x){
      setX(x);
      setY(150);
      setWidth(10);
      setHeight(10);
      setColor(Color.BLACK);
    }
     public Block(int x,int y){
      setX(x);
      setY(y);
      setWidth(10);
      setHeight(10);
      setColor(Color.BLACK);
    }
     public Block(int x,int y,int w){
      setX(x);
      setY(y);
      setWidth(w);
      setHeight(10);
      setColor(Color.BLACK);
    }

    public Block(int x,int y,int w, int h){
      setX(x);
      setY(y);
      setWidth(w);
      setHeight(h);
      setColor(Color.BLACK);
    }
    public Block(int x, int y, int w, int h, Color c) {
        setX(x);
        setY(y);
        setWidth(w);
        setHeight(h);
        setColor(c);
    }

    //add the other set methods
    public void setPos(int x, int y){
      setX(x);
      setY(y);
    }
    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public void setColor(Color col) {
        color = col;
    }

    public void draw(Graphics window) {
        //uncomment after you write the set and get methods
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
       window.setColor(col);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean equals(Object obj) {
        Block Test = (Block)obj;
        if (this.getColor()!=null && Test.getColor()!=null){
          return (Test.getX()==this.getX() && 
          Test.getY()==this.getY() &&
          Test.getWidth()==this.getWidth()&&
          Test.getHeight()==this.getHeight()&&
          Test.getColor().equals(this.getColor()));
        }
        else if(Test.getX()==this.getX() && 
          Test.getY()==this.getY() &&
          Test.getWidth()==this.getWidth()&&
          Test.getHeight()==this.getHeight()){
            return true;
          }
        return false;

    }

    //add the other get methods
    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    //add a toString() method  - x , y , width, height, color
    public String toString() {
        return ""+getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor();
    }
}
