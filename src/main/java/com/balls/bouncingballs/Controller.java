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
        Ball adamsBallOne = new Ball();
        /*Ball simonasBallTwo = new Ball();
        Ball nikasBall = new Ball();*/

        adamsBall.setBalls(new Ball[]{simonasBall, adamsBallOne});
        simonasBall.setBalls(new Ball[]{adamsBall, adamsBallOne});
        adamsBallOne.setBalls(new Ball[]{simonasBall, adamsBall});
        /*simonasBallTwo.setBalls(new Ball[]{adamsBall, simonasBall, adamsBallOne});*/

        scene.getChildren().add(adamsBall.getCircle());
        scene.getChildren().add(simonasBall.getCircle());
        scene.getChildren().add(adamsBallOne.getCircle());
        /*scene.getChildren().add(simonasBallTwo.getCircle());
        scene.getChildren().add(nikasBall.getCircle());*/


        adamsBall.start();
        simonasBall.start();
        adamsBallOne.start();
        /*simonasBallTwo.start();
        nikasBall.start();*/

    }


}
