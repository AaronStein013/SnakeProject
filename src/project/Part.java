package project;

import java.util.List;

public interface Part {


    void draw();

    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    String toString();

    void update(int x,int y);
    void update(Part p);



}
