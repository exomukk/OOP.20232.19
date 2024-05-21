package org.oop.oanquan.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class gameScene extends Scene {
    public gameScene() throws IOException {
        super(FXMLLoader.load(gameScene.class.getResource("C:\\Users\\minhk\\OneDrive - sh3h\\Project\\IntelliJ IDEA\\Asus new\\OOP Final\\src\\main\\java\\org\\oop\\oanquan\\view\\gameScene.fxml")));
    }
}
