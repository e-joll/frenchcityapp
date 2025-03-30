package me.example.cityapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.example.cityapi.model.Parking;
import me.example.cityapi.data.ParkingApiClient;
import me.example.cityapi.ui.DoubleContainer;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

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
    @FXML
    public ProgressIndicator loadingIndicator;
    @FXML
    public HBox loadingContainer;
    @FXML
    public Label loadingLabel;

    private final ParkingApiClient parkingService;

    public ParkingInfosController() {
        this.parkingService = new ParkingApiClient();
    }

    @FXML
    public void initialize() {
        loadParkings();
    }

    private void loadParkings() {
        loadingContainer.setVisible(true);
        parkingGrid.getChildren().clear();

        new Thread(() -> {
            try {
                List<Parking> parkings = parkingService.getParkings();
                javafx.application.Platform.runLater(() -> {
                    for (Parking parking : parkings) {
                        DoubleContainer doubleContainer = new DoubleContainer();
                        doubleContainer.getTopLabel().setText(parking.getName());
                        doubleContainer.getBottomLabel().setText(String.format("Available spaces: %d\nUser spaces: %d",
                                parking.getAvailableSpaces(),
                                parking.getUserSpaces()));
                        parkingGrid.getChildren().add(doubleContainer.getMainContainer());
                    }
                    loadingContainer.setVisible(false);
                });
            } catch (IOException e) {
                javafx.application.Platform.runLater(() -> {
                    e.printStackTrace();
                    loadingContainer.setVisible(false);
                });
            }
        }).start();
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

    @FXML
    protected void onShowTabWVButtonClick() {
        Stage webStage = new Stage();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://data.nantesmetropole.fr/explore/dataset/244400404_parkings-publics-nantes-disponibilites/custom/?disjunctive.grp_nom&disjunctive.grp_statut");
        
        Scene scene = new Scene(webView, 1024, 768);
        webStage.setScene(scene);
        webStage.setTitle("Parkings Nantes Métropole - Données");
        webStage.show();
    }
} 