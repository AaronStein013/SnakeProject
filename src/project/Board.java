package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Board {

    public Board(){

    }


    public void draw(){
        StdDraw.setPenColor(Color.GRAY);
        for(double i = -1.5; i < 21.5; i++){
            StdDraw.line(-1.5,i,21.5,i);
            StdDraw.line(i,-1.5,i,21.5);

        }
    }



}
