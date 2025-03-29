package me.example.cityapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {
    @FXML
    public Label titleText;

    public HomeController() { }

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("Hello World!");
    }
} 