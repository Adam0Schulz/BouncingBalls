package com.balls.bouncingballs;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball extends Thread {

    private int[] direction;
    private Circle circle;

    public Ball(int x, int y, int radius) {
        circle = new Circle(x, y, radius);
        Random random = new Random();
        direction = new int[]{random.nextInt(5), random.nextInt(5)};

    }

    public Ball(int x, int y, int radius, int[] direction) {
        circle = new Circle(x, y, radius);
        this.direction = direction;
    }

    public void updateCoords() {
        AnchorPane.setTopAnchor(circle, circle.getCenterY());
        AnchorPane.setLeftAnchor(circle, circle.getCenterX());
    }
}
