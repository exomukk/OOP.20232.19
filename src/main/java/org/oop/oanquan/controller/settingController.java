package org.oop.oanquan.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.MediaPlayer;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import org.oop.oanquan.music.musicController;

public class settingController {
    public String musicChoice;
    public musicController musicController = new musicController();
    @FXML
    private RadioButton ez;

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
    void backToMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/oop/oanquan/mainScene.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void playMusicTrial(MouseEvent event) {
        RadioButton selectedRadioButton = (RadioButton) winMusic.getSelectedToggle();
        System.out.println("chơi nhạc");
        if (selectedRadioButton != null) {
            musicChoice = selectedRadioButton.getText();
            System.out.println(musicChoice);
            musicController.play(musicChoice);
        }
    }

}
