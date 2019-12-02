package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Apple {

    private int x,y;

    public Apple(){
        this.x = (int)(Math.random() * 20) + 1;
        this.y = (int)(Math.random() * 20) + 1;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void drawApple(){
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(this.x,this.y,0.5);
    }





}
