module org.oop.oanquan {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.oop.oanquan to javafx.fxml;
    exports org.oop.oanquan;
    exports org.oop.oanquan.controller;
    opens org.oop.oanquan.controller to javafx.fxml;
}