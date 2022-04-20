package com.balls.bouncingballs;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    protected AnchorPane scene;

    @FXML
    public void initialize() {
        Ball adamsBall = new Ball();
        Ball simonasBall = new Ball();



        scene.getChildren().add(adamsBall.getCircle());
        scene.getChildren().add(simonasBall.getCircle());


        adamsBall.start();
        simonasBall.start();

    }


}
