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
        Ball nikasBall = new Ball();
        Ball aleksandrasBall = new Ball();



        scene.getChildren().add(adamsBall.getCircle());
        scene.getChildren().add(simonasBall.getCircle());
        scene.getChildren().add(nikasBall.getCircle());
        scene.getChildren().add(aleksandrasBall.getCircle());

        adamsBall.start();
        simonasBall.start();
        nikasBall.start();
        aleksandrasBall.start();
    }


}
