package org.oop.oanquan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.oop.oanquan.view.gameScene;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        gameScene gameScene=new gameScene();
        stage.setTitle("Hello!");
        stage.setScene(gameScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}