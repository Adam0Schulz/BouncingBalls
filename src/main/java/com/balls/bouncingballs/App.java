package com.balls.bouncingballs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(null);
        stage.setTitle("Bouncing Balls");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}