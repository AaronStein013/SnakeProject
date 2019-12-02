package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.List;

public class Body implements Part{


    private int x,y;

    public Body(int x, int y){
        //constructor
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(){
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(this.x,this.y,0.5);
    }

    public void update(Part p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public void update(int xMove,int yMove){
        this.x += xMove;
        this.y += yMove;
    }

    public String toString(){
        return "[ " + this.x + ", " + this.y + "] ";
    }






}
