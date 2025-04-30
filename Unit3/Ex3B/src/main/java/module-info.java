module edu.southeast.ex3b {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.southeast.ex3b to javafx.fxml;
    exports edu.southeast.ex3b;
}