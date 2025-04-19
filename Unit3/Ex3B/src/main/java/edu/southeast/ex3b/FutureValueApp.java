package edu.southeast.ex3b;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FutureValueApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FutureValueApp.class.getResource("FutureValueView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 200);
        stage.setTitle("Comc-2740: Future Value App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}