// THIS IS THE MAIN FILE, RUN THIS FILE TO RUN THE GAME !

package org.oop.oanquan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.oop.oanquan.model.userSetting;

public class Main extends Application {
    public userSetting userSetting = org.oop.oanquan.model.userSetting.getInstance();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("O AN QUAN");
            stage.show();


            userSetting.setMusicSetting("Flashbang Dance");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
