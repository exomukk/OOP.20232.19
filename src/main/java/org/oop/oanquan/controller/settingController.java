package org.oop.oanquan.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import org.oop.oanquan.music.musicController;
import org.oop.oanquan.model.userSetting;

public class settingController {
    public String musicChoice;
    public musicController musicController = new musicController();
    public userSetting userSetting = org.oop.oanquan.model.userSetting.getInstance();

    @FXML
    private RadioButton ez;

    @FXML
    private Label btnbackPressed;

    @FXML
    private RadioButton flashbang;

    @FXML
    private Button playTrial;

    @FXML
    private RadioButton ticking;

    @FXML
    private RadioButton umad;

    @FXML
    private ToggleGroup winMusic;

    @FXML
    private RadioButton zedd;

    @FXML
    public void backPressed(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/oop/oanquan/mainScene.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        RadioButton selectedRadioButton = (RadioButton) winMusic.getSelectedToggle();
        System.out.println("chơi nhạc");
        if (selectedRadioButton != null) {
            musicChoice = selectedRadioButton.getText();
            System.out.println(musicChoice + "music choice");
            userSetting.setMusicSetting(musicChoice);
        }
    }

    @FXML
    public void backToMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/oop/oanquan/mainScene.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        RadioButton selectedRadioButton = (RadioButton) winMusic.getSelectedToggle();
        System.out.println("chơi nhạc");
        if (selectedRadioButton != null) {
            musicChoice = selectedRadioButton.getText();
            System.out.println(musicChoice + "music choice");
            userSetting.setMusicSetting(musicChoice);
        }
    }

    @FXML
    public void playMusicTrial(MouseEvent event) {
        RadioButton selectedRadioButton = (RadioButton) winMusic.getSelectedToggle();
        System.out.println("chơi nhạc");
        if (selectedRadioButton != null) {
            musicChoice = selectedRadioButton.getText();
            System.out.println(musicChoice);
            userSetting.setMusicSetting(musicChoice);
            musicController.play(musicChoice);
        }
    }

}
