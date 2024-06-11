// Made by Kim Duy Minh - 20225578

package org.oop.oanquan.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.oop.oanquan.model.OVuong;
import org.oop.oanquan.music.musicController;
import org.oop.oanquan.model.userSetting;

import java.io.IOException;

public class gameSceneController {
    public LogicGame logicGame = new LogicGame();
    public musicController musicController = new musicController();
    public userSetting userSetting = org.oop.oanquan.model.userSetting.getInstance();

    // FXML Skeletons:
    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView background;

    @FXML
    private Label d1;

    @FXML
    private Label d10;

    @FXML
    private Label d11;

    @FXML
    private Label d12;

    @FXML
    private Label d2;

    @FXML
    private Label d3;

    @FXML
    private Label d4;

    @FXML
    private Label d5;

    @FXML
    private Label d6;

    @FXML
    private Label d7;

    @FXML
    private Label d8;

    @FXML
    private Label d9;

    @FXML
    private ImageView left;

    @FXML
    private Rectangle o1;

    @FXML
    private Rectangle o10;

    @FXML
    private Rectangle o11;

    @FXML
    private ImageView o12;

    @FXML
    private Rectangle o2;

    @FXML
    private Rectangle o3;

    @FXML
    private Rectangle o4;

    @FXML
    private Rectangle o5;

    @FXML
    private ImageView o6;

    @FXML
    private Rectangle o7;

    @FXML
    private Rectangle o8;

    @FXML
    private Rectangle o9;

    @FXML
    private ImageView right;

    @FXML
    private Label s1;

    @FXML
    private Label s10;

    @FXML
    private Rectangle exitRectangle;

    @FXML
    private Label point1;

    @FXML
    private Label point2;

    @FXML
    private Label console;

    @FXML
    private Label s11;

    @FXML
    private Label s12;

    @FXML
    private Label s2;

    @FXML
    private Label s3;

    @FXML
    private Label s4;

    @FXML
    private Label s5;

    @FXML
    private Label s6;

    @FXML
    private Label s7;

    @FXML
    private Label s8;

    @FXML
    private Label s9;

    @FXML
    private Circle tron1;

    @FXML
    private Circle tron10;

    @FXML
    private Circle tron11;

    @FXML
    private Circle tron2;

    @FXML
    private Circle tron3;

    @FXML
    private Circle tron4;

    @FXML
    private Circle tron5;

    @FXML
    private Circle tron7;

    @FXML
    private Circle tron8;

    @FXML
    private Circle tron9;


    public OVuong[] banCo = new OVuong[12];
    Circle[] circleManagement = new Circle[10];
    public static int currentSelection;

    // Move left function:
    @FXML
    public void clickedLeft(MouseEvent event) {
        System.out.println("clickedLeft");
        logicGame.move(currentSelection, false);

        // Check win conditions
        if (logicGame.checkWin() == 1) {
            console.setText("Người chơi 1 chiến thắng");
            musicController.play(userSetting.getMusicSetting());
        } else if (logicGame.checkWin() == 2) {
            console.setText("Người chơi 2 chiến thắng");
            musicController.play(userSetting.getMusicSetting());
        } else if (logicGame.checkWin() == 3) {
            console.setText("Hoà");
        } else {
            console.setText("Lượt người chơi "+logicGame.getCurrentPlayer());
        }

        // Check for valid movements
        if (logicGame.checkValidityOfMoves() == 0) {
            banCo = logicGame.exportBoardStateAsOVuongArray();
            point1.setText(logicGame.getPlayer1Score());
            point2.setText(logicGame.getPlayer2Score());

            updateBoxes();
            left.setVisible(false);
            right.setVisible(false);

            for (Circle c: circleManagement){
                c.setVisible(false);
            }
        } else if (logicGame.checkValidityOfMoves() == 1) {
            console.setText("Người chơi " + logicGame.getCurrentPlayer()+ " chỉ được chọn ô tương ứng.");
        } else if (logicGame.checkValidityOfMoves() == 2) {
            console.setText("Không được chọn ô quan. Chọn lại.");
        } else if (logicGame.checkValidityOfMoves() == 3) {
            console.setText("Ô chọn không có quân. Chọn lại.");
        }
    }

    // Move right function:
    @FXML
    public void clickedRight(MouseEvent event) {
        System.out.println("clickedRight");
        logicGame.move(currentSelection, true);

        // Do the same as above
        if (logicGame.checkWin() == 1) {
            console.setText("Người chơi 1 chiến thắng");
            System.out.println(userSetting.getMusicSetting());
            musicController.play(userSetting.getMusicSetting());
        } else if (logicGame.checkWin() == 2) {
            console.setText("Người chơi 2 chiến thắng");
            System.out.println(userSetting.getMusicSetting());
            musicController.play(userSetting.getMusicSetting());
        } else if (logicGame.checkWin() == 3) {
            console.setText("Hoà");
        } else {
            console.setText("Lượt người chơi "+logicGame.getCurrentPlayer());
        }

        if ( logicGame.checkValidityOfMoves() == 0 ) {
            banCo = logicGame.exportBoardStateAsOVuongArray();
            point1.setText(logicGame.getPlayer1Score());
            point2.setText(logicGame.getPlayer2Score());

            updateBoxes();
            left.setVisible(false);
            right.setVisible(false);

            for (Circle c: circleManagement){
                c.setVisible(false);
            }
        } else if (logicGame.checkValidityOfMoves() == 1 ) {
            console.setText("Người chơi " + logicGame.getCurrentPlayer()+ " chỉ được chọn ô tương ứng.");
        } else if (logicGame.checkValidityOfMoves() == 2 ) {
            console.setText("Không được chọn ô quan. Chọn lại.");
        } else if (logicGame.checkValidityOfMoves() == 3 ) {
            console.setText("Ô chọn không có quân. Chọn lại.");
        }
    }

    // Get ID of boxes function
    @FXML
    public void getBoxId(MouseEvent event) {
        Rectangle clickedBox = (Rectangle) event.getSource();
        String clickedBoxId = clickedBox.getId();
        shownSelectedBox(getBox(clickedBoxId));

        switch (clickedBoxId) {
            case "o1":
                currentSelection = 0;
                break;
            case "o2":
                currentSelection = 1;
                break;
            case "o3":
                currentSelection = 2;
                break;
            case "o4":
                currentSelection = 3;
                break;
            case "o5":
                currentSelection = 4;
                break;
            case "o7":
                currentSelection = 6;
                break;
            case "o8":
                currentSelection = 7;
                break;
            case "o9":
                currentSelection = 8;
                break;
            case "o10":
                currentSelection = 9;
                break;
            case "o11":
                currentSelection = 10;
                break;
            default:
                currentSelection = -1; // Or any other value indicating an invalid selection
                break;
        }
    }

    // Update Boxes function
    public void updateBoxes() {
        banCo = logicGame.exportBoardStateAsOVuongArray();
        s1.setText(showQuan(banCo[0]));
        d1.setText(showDan(banCo[0]));
        s2.setText(showQuan(banCo[1]));
        d2.setText(showDan(banCo[1]));
        s3.setText(showQuan(banCo[2]));
        d3.setText(showDan(banCo[2]));
        s4.setText(showQuan(banCo[3]));
        d4.setText(showDan(banCo[3]));
        s5.setText(showQuan(banCo[4]));
        d5.setText(showDan(banCo[4]));
        s6.setText(showQuan(banCo[5]));
        d6.setText(showDan(banCo[5]));
        s7.setText(showQuan(banCo[6]));
        d7.setText(showDan(banCo[6]));
        s8.setText(showQuan(banCo[7]));
        d8.setText(showDan(banCo[7]));
        s9.setText(showQuan(banCo[8]));
        d9.setText(showDan(banCo[8]));
        s10.setText(showQuan(banCo[9]));
        d10.setText(showDan(banCo[9]));
        s11.setText(showQuan(banCo[10]));
        d11.setText(showDan(banCo[10]));
        s12.setText(showQuan(banCo[11]));
        d12.setText(showDan(banCo[11]));
    }

    // Initialize function:
    @FXML
    public void initialize() {
        // UI set visible codes
        tron1.setVisible(false);
        tron2.setVisible(false);
        tron3.setVisible(false);
        tron4.setVisible(false);
        tron5.setVisible(false);
        tron7.setVisible(false);
        tron8.setVisible(false);
        tron9.setVisible(false);
        tron10.setVisible(false);
        tron11.setVisible(false);
        left.setVisible(false);
        right.setVisible(false);

        circleManagement[0] = tron1;
        circleManagement[1] = tron2;
        circleManagement[2] = tron3;
        circleManagement[3] = tron4;
        circleManagement[4] = tron5;
        circleManagement[5] = tron7;
        circleManagement[6] = tron8;
        circleManagement[7] = tron9;
        circleManagement[8] = tron10;
        circleManagement[9] = tron11;

        // Print out game's board
        logicGame.printBoard();
        updateBoxes();

        console.setText("Lượt người chơi " + logicGame.getCurrentPlayer());
        point1.setText(logicGame.getPlayer1Score());
        point2.setText(logicGame.getPlayer2Score());
    }

    // Showing the numbers of Quan and Dan in boxes
    public String showQuan(OVuong o) {
        return "Quan: " + o.getSoQuan();
    }

    public String showDan(OVuong o) {
        return "Dan: " + o.getSoDan();
    }


    // Exit to main menu function
    public void exit(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/oop/oanquan/mainScene.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Get the "Box ID" and "the small green circle on the box ID"
    public Rectangle getBox(String id) {
        return switch (id) {
            case "o1" -> o1;
            case "o2" -> o2;
            case "o3" -> o3;
            case "o4" -> o4;
            case "o5" -> o5;
            case "o7" -> o7;
            case "o8" -> o8;
            case "o9" -> o9;
            case "o10" -> o10;
            case "o11" -> o11;
            default -> null;
        };
    }

    public Circle getSelectedBoxCircle(String id){
        return switch (id) {
            case "o1" -> tron1;
            case "o2" -> tron2;
            case "o3" -> tron3;
            case "o4" -> tron4;
            case "o5" -> tron5;
            case "o7" -> tron7;
            case "o8" -> tron8;
            case "o9" -> tron9;
            case "o10" -> tron10;
            case "o11" -> tron11;
            default -> null;
        };
    }

    // Show selected box by visible the small green circle and 2 arrow to true
    public void shownSelectedBox(Rectangle selectedBox) {
        for (Circle c: circleManagement){
            c.setVisible(c.equals(getSelectedBoxCircle(selectedBox.getId())));
        }
        left.setVisible(true);
        right.setVisible(true);
    }
}

// Exomuk: As refactoring the codes, I don't know why there are some warning on class OVuong :) But without it, the code
// gonna break down, the "root" in mainSceneController too, don't know what it for, but I think it's important :)
