package me.example.cityapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeController {
    @FXML
    public Label homeTitle;
    
    @FXML
    public Button showButton;

    public HomeController() { }

    @FXML
    protected void onShowButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/example/cityapi/view/parking-infos.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Définir la couleur de fond de la scène
//            scene.getRoot().setStyle("-fx-background-color: -fx-primary-color;");

            Stage stage = (Stage) showButton.getScene().getWindow();
            double width = stage.getWidth();
            double height = stage.getHeight();
            stage.setTitle("Parking Infos");
            stage.setWidth(width);
            stage.setHeight(height);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}