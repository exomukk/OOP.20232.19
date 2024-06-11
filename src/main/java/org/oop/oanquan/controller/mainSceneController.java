package org.oop.oanquan.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.oop.oanquan.model.userSetting;

import java.io.IOException;

public class mainSceneController {
    public userSetting userSetting = org.oop.oanquan.model.userSetting.getInstance();

    @FXML
    private ImageView luatchoi;

    @FXML
    private ImageView batdau;

    private Stage stage;
    private Scene scene;

    private Parent root;

    public void openRules(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/oop/oanquan/settingScene.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void openGame(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/oop/oanquan/gameScene.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println(userSetting.getMusicSetting() + " main");
    }
}
