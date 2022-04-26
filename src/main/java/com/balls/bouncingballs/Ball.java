package com.balls.bouncingballs;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball extends Thread {

    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private int[] direction;
    private Circle circle;
    private Random random = new Random();

    public Ball() {
        circle = new Circle(random.nextInt(300), random.nextInt(300), random.nextInt(10) + 10);
        circle.setFill(Paint.valueOf("#ff0000"));
        direction = new int[]{random.nextInt(10), random.nextInt(10)};
        updateCoords();
    }

    public Ball(int radius) {
        circle = new Circle(random.nextInt(300), random.nextInt(300), radius);
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

    public void setBalls(Ball[] balls) {
        this.balls.addAll(List.of(balls));
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public int[] getDirection() {
        return direction;
    }

    public void setDirection(int[] direction) {
        this.direction = direction;
    }

    public synchronized void move() {
        for(Ball ball : balls) {

            if(ball.getCircle().intersects(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius())) {

                double sizeDiff = ball.getCircle().getRadius() / circle.getRadius();

                int[] newDirection = new int[2];
                newDirection = ball.getDirection();
                for (int i : newDirection) {
                    i *= sizeDiff;
                }
                ball.setDirection(getDirection());
                setDirection(newDirection);
            }
        }
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
        //
        //noinspection InfiniteLoopStatement
        while(true) {

            try {
                move();
                sleep(50);
                System.out.println("this is just a random text");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
