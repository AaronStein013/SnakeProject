package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private static int [] move;
    private static final int X = 0;
    private static final int Y = 1;



    private static boolean ifKey(int key){   //change name
        if(StdDraw.isKeyPressed(key)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void drawAll(List<Part> snake, Apple a,Board b){
        StdDraw.clear();
        StdDraw.pause(80);
        b.draw();
        a.drawApple();

        for (Part p : snake){
            p.draw();
        }
    }


	public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        StdDraw.setXscale(-1.5,21.5);
	    StdDraw.setYscale(-1.5,21.5);


        List<Part> snake = new LinkedList<>();
        snake.add(new Head(8,8));
        snake.add(new Body(7,8));




        move = new int[]{1,0};
        Board board = new Board();
        Apple apple = new Apple();
        boolean stop = false;
        boolean first = true;


        while(!stop){

            StdDraw.show();
            drawAll(snake, apple, board);
            StdDraw.show();

            if(first){
                StdDraw.pause(1000);
                first = false;
            }



            if(ifKey(KeyEvent.VK_RIGHT)){
	            move = new int[]{1,0};
            }
	        if(ifKey(KeyEvent.VK_LEFT)){
	            move = new int[]{-1,0};
            }
            if(ifKey(KeyEvent.VK_UP)){
                move = new int[]{0,1};
            }
            if(ifKey(KeyEvent.VK_DOWN)){
                move = new int[]{0,-1};
            }



            for(int i = snake.size() - 1; i > 0; i--) {

                if(snake.get(i).getX() == snake.get(0).getX() && snake.get(i).getY() == snake.get(0).getY()){
                    stop = true;
                }

                // this moves each body section of the snake to location of the piece that comes before it in the list
                snake.get(i).update(snake.get(i - 1));

            }

            if(snake.get(0).getX() >= 22 || snake.get(0).getY() >= 22 || snake.get(0).getX() <= -2 || snake.get(0).getY() <= -2){
                stop = true;
            }

            // this moves the head in the direction of the vector called "move"
            snake.get(0).update(move[X],move[Y]);



            if(snake.get(0).getX() == apple.getX() && snake.get(0).getY() == apple.getY()){
                apple = new Apple();
                for(Part p : snake) {
                    while(p.getX() == apple.getX() && p.getY() == apple.getY()){
                        apple = new Apple();
                    }
                }
                apple.drawApple();
                snake.add(new Body(snake.get(snake.size() - 1).getX(),snake.get(snake.size() - 1).getY()));
            }




        }


        int score = snake.size() - 1;
        System.out.println("You lose!");
        System.out.print("Your score is: " + score);




    }
	
}