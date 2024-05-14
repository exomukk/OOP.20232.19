package view;

import javax.swing.*;
import java.awt.*;

public class gamepaneView extends JFrame {
    public gamepaneView() {
        this.setTitle("Gamepane");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        //Board panel setup
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(2, 5));
        ImageIcon danIcon = new ImageIcon("resources/Dan.ico");
        ImageIcon quanIcon = new ImageIcon("resources/Quan.ico");

    }
}
