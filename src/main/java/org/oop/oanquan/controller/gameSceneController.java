package org.oop.oanquan.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class gameSceneController {
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView background;
    @FXML
    private ImageView o1;
    @FXML
    private ImageView o2;
    @FXML
    private ImageView o3;
    @FXML
    private ImageView o4;
    @FXML
    private ImageView o5;
    @FXML
    private ImageView o6;
    @FXML
    private ImageView o7;
    @FXML
    private ImageView o8;
    @FXML
    private ImageView o9;
    @FXML
    private ImageView o10;
    @FXML
    private ImageView o11;
    @FXML
    private ImageView o12;
    @FXML
    private ImageView left;
    @FXML
    private ImageView right;
    @FXML
    private Circle circle;

    public void clickedLeft(MouseEvent event) {
        System.out.println("clickedLeft");
    }

    public void clickedRight(MouseEvent event) {
        System.out.println("clickedRight");
    }

    public void getBoxId(MouseEvent event) {
        ImageView clickedBox = (ImageView) event.getSource();
        String clickedBoxId = clickedBox.getId();
        System.out.println(clickedBoxId);
        shownSelectedBox(getBox(clickedBoxId));
    }
    public ImageView getBox(String id){
        switch (id){
            case "o1":
                return o1;
            case "o2":
                return o2;
            case "o3":
                return o3;
            case "o4":
                return o4;
            case "o5":
                return o5;
            case "o6":
                return o6;
            case "o7":
                return o7;
            case "o8":
                return o8;
            case "o9":
                return o9;
            case "o10":
                return o10;
            case "o11":
                return o11;
            case "o12":
                return o12;
            default:
                return null;
        }
    }
    public void shownSelectedBox(ImageView selectedBox){
        if (selectedBox != null) {
            double x = selectedBox.getLayoutX() + selectedBox.getFitWidth() / 2;
            double y = selectedBox.getLayoutY() + selectedBox.getFitHeight() / 2;
            double circleRadius = circle.getRadius();
            double minX = circleRadius;
            double maxX = selectedBox.getScene().getWidth() - circleRadius;
            double minY = circleRadius;
            double maxY = selectedBox.getScene().getHeight() - circleRadius;
            x = Math.max(minX, Math.min(x, maxX));
            y = Math.max(minY, Math.min(y, maxY));
            circle.setCenterX(x);
            circle.setCenterY(y);
            circle.setVisible(true);
        } else {
            circle.setVisible(false);
        }
    }
}
