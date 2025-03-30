package me.example.cityapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeLineCap;
import me.example.cityapi.ui.DoubleContainer;

public class ParkingInfosController {
    @FXML
    public Label parkingTitle;
    @FXML
    public FlowPane parkingGrid;
    @FXML
    public Button backButton;
    @FXML
    public Button showTabWVButton;

    public ParkingInfosController() { }

    @FXML
    public void initialize() {
        // Add parkingBox test
        for (int i = 0; i < 5; i++) {
            DoubleContainer doubleContainer = new DoubleContainer();
            parkingGrid.getChildren().add(doubleContainer.getMainContainer());
        }
    }

    @FXML
    protected void onBackButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/me/example/cityapi/view/home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) parkingTitle.getScene().getWindow();
            stage.setTitle("Home");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 