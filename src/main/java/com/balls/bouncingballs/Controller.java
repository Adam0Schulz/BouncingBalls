package com.balls.bouncingballs;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Controller {

    @FXML
    protected AnchorPane scene;

    @FXML
    public void initialize() {

        // Creating set number of balls and adding them to arraylist for later use
        ArrayList<Ball> balls = new ArrayList<Ball>();
        int numberOfBalls = 10;
        for (int i = 0; i < numberOfBalls; i++) {
            Ball ball = new Ball();
            balls.add(ball);

        }

        // Using the arraylist to loop through and set balls to each ball, draw it on scene and start it
        for (Ball ball : balls) {
            ball.setBalls(balls);
            scene.getChildren().add(ball.getCircle());
            ball.start();
        }

    }


}
