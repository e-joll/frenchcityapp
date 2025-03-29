package me.example.cityapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class HomeController {
    @FXML
    public Label homeTitle;
    
    @FXML
    public Button showButton;

    public HomeController() { }

    @FXML
    protected void onShowButtonClick() {
        System.out.println("Hello World!");
    }
}