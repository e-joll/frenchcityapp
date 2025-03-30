package me.example.cityapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.example.cityapi.model.Parking;
import me.example.cityapi.data.ParkingApiClient;
import me.example.cityapi.ui.DoubleContainer;

import java.io.IOException;
import java.util.List;

public class ParkingInfosController {
    @FXML
    public Label parkingTitle;
    @FXML
    public FlowPane parkingGrid;
    @FXML
    public Button backButton;
    @FXML
    public Button showTabWVButton;

    private final ParkingApiClient parkingService;

    public ParkingInfosController() {
        this.parkingService = new ParkingApiClient();
    }

    @FXML
    public void initialize() {
        try {
            List<Parking> parkings = parkingService.getParkings();

            for (Parking parking : parkings) {
                DoubleContainer doubleContainer = new DoubleContainer();
                doubleContainer.getTopLabel().setText(parking.getName());
                doubleContainer.getBottomLabel().setText(String.format("Available spaces: %d\nUser spaces: %d",
                        parking.getAvailableSpaces(),
                        parking.getUserSpaces()));
                parkingGrid.getChildren().add(doubleContainer.getMainContainer());
            }
        } catch (IOException e) {
            e.printStackTrace();
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