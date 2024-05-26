package org.oop.oanquan.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label s1;
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
    private Label s10;
    @FXML
    private Label s11;
    @FXML
    private Label s12;
    @FXML
    private Label d1;
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
    private Label d10;
    @FXML
    private Label d11;
    @FXML
    private Circle tron1;
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
    @FXML
    private Circle tron10;
    @FXML
    private Circle tron11;
    public static class OVuong{
        private int soDan;
        private int soQuan;
        public OVuong(int soDan, int soQuan){
            this.soDan = soDan;
            this.soQuan = soQuan;
        }
        public int getSoDan() {
            return soDan;
        }
        public void setSoDan(int soDan) {
            this.soDan = soDan;
        }
        public int getSoQuan() {
            return soQuan;
        }
        public void setSoQuan(int soQuan) {
            this.soQuan = soQuan;
        }
    }
    OVuong[] banCo=new OVuong[12];

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
    Circle[] circleManagement=new Circle[10];
    public void initialize(){
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
        circleManagement[0]=tron1;
        circleManagement[1]=tron2;
        circleManagement[2]=tron3;
        circleManagement[3]=tron4;
        circleManagement[4]=tron5;
        circleManagement[5]=tron7;
        circleManagement[6]=tron8;
        circleManagement[7]=tron9;
        circleManagement[8]=tron10;
        circleManagement[9]=tron11;
        banCo[0]=new OVuong(5,0);
        banCo[1]=new OVuong(5,0);
        banCo[2]=new OVuong(5,0);
        banCo[3]=new OVuong(5,0);
        banCo[4]=new OVuong(5,0);
        banCo[5]=new OVuong(0,1);
        banCo[6]=new OVuong(5,0);
        banCo[7]=new OVuong(5,0);
        banCo[8]=new OVuong(5,0);
        banCo[9]=new OVuong(5,0);
        banCo[10]=new OVuong(5,0);
        banCo[11]=new OVuong(0,1);
        s1.setText(showQuan(banCo[0]));
        d1.setText(showDan(banCo[0]));
        s2.setText(showQuan(banCo[1]));
        d2.setText(showDan(banCo[1]));
        s12.setText(showQuan(banCo[11]));
        d12.setText(showDan(banCo[11]));
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
    }
    public String showQuan(OVuong o){
        return "Quan: "+o.getSoQuan();
    }
    public String showDan(OVuong o){
        return "Dan: "+o.getSoDan();
    }
    public ImageView getBox(String id){
        return switch (id) {
            case "o1" -> o1;
            case "o2" -> o2;
            case "o3" -> o3;
            case "o4" -> o4;
            case "o5" -> o5;
            case "o6" -> o6;
            case "o7" -> o7;
            case "o8" -> o8;
            case "o9" -> o9;
            case "o10" -> o10;
            case "o11" -> o11;
            case "o12" -> o12;
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
    public void shownSelectedBox(ImageView selectedBox) {
        for (Circle c: circleManagement){
            c.setVisible(c.equals(getSelectedBoxCircle(selectedBox.getId())));
        }
    }
}
