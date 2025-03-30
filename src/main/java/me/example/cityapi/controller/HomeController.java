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
            
            Stage stage = (Stage) showButton.getScene().getWindow();
            stage.setTitle("Parking Infos");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}