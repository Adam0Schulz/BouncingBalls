package com.balls.bouncingballs;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball extends Thread {

    private int[] direction;
    private Circle circle;
    private Random random = new Random();

    public Ball() {
        circle = new Circle(random.nextInt(300), random.nextInt(300), random.nextInt(10) + 10);
        circle.setFill(Paint.valueOf("#ff0000"));
        direction = new int[]{random.nextInt(10), random.nextInt(10)};
        updateCoords();
    }

    public Ball(int x, int y, int radius) {
        circle = new Circle(x, y, radius);
        direction = new int[]{random.nextInt(10), random.nextInt(10)};
        updateCoords();
    }

    public Ball(int x, int y, int radius, int[] direction) {
        circle = new Circle(x, y, radius);
        this.direction = direction;
        updateCoords();
    }

    public void updateCoords() {
        AnchorPane.setTopAnchor(circle, circle.getCenterY());
        AnchorPane.setLeftAnchor(circle, circle.getCenterX());
    }

    public Circle getCircle() {
        return circle;
    }

    public synchronized void move() {
        if(circle.getCenterX() >= 600 - circle.getRadius() || circle.getCenterX() <= 0) {
            direction[0] *= -1;
        }
        if(circle.getCenterY() >= 400 - circle.getRadius() || circle.getCenterY() <= 0) {
            direction[1] *= -1;
        }
        circle.setCenterX(circle.getCenterX() + direction[0]);
        circle.setCenterY(circle.getCenterY() + direction[1]);
        updateCoords();
    }

    public void run() {
        while(true) {
            move();
            try {
                sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
