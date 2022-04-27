package com.balls.bouncingballs;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball extends Thread {

    private static final Object lock = new Object();

    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private int[] direction;
    private Circle circle;
    private Random random = new Random();
    private String[] possibleColors = new String[]{"#ff0000", "#00ff00", "#000000", "#00ffff", "#ff00ff"};

    public Ball() {
        int radius = random.nextInt(50) + 50;
        int x = random.nextInt(1920);
        int y = random.nextInt(1080);
        circle = new Circle(x, y, radius);

        circle.setFill(Paint.valueOf(possibleColors[random.nextInt(5)]));
        direction = new int[]{random.nextInt(20), random.nextInt(20)};
        updateCoords();
    }

    /*public Ball(int radius) {
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
    }*/

    public void updateCoords() {
        AnchorPane.setTopAnchor(circle, circle.getCenterY());
        AnchorPane.setLeftAnchor(circle, circle.getCenterX());
    }

    public Circle getCircle() {
        return circle;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls.addAll(balls);
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

    public boolean checkColision(Ball ballOne, Ball ballTwo) {
        double deltaX = Math.abs(ballOne.getCircle().getCenterX() - ballTwo.getCircle().getCenterX());
        double deltaY = Math.abs(ballOne.getCircle().getCenterY() - ballTwo.getCircle().getCenterY());

        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        double radiusSum = ballOne.getCircle().getRadius() + ballTwo.getCircle().getRadius();

        if(distance < radiusSum) {
            return true;
        }

        return false;
    }

    public synchronized void move() {
        for(Ball ball : balls) {

            if(checkColision(ball, this)) {
                int[] newDirection = new int[2];
                newDirection = ball.getDirection();
                ball.setDirection(getDirection());
                setDirection(newDirection);
            }
        }
        if(circle.getCenterX() >= 1920 - circle.getRadius() || circle.getCenterX() <= 0) {
            direction[0] *= -1;
        }
        if(circle.getCenterY() >= 1080 - circle.getRadius() || circle.getCenterY() <= 0) {
            direction[1] *= -1;
        }
        circle.setCenterX(circle.getCenterX() + direction[0]);
        circle.setCenterY(circle.getCenterY() + direction[1]);
        updateCoords();
    }

    public void run() {
        Platform.runLater(() -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    move();
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });


    }
}
