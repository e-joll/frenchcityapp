package me.example.cityapi.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeLineCap;

/**
 * Class representing a double container composed of two vertically stacked VBoxes.
 * The top container takes up 50% of the height and the bottom container 50%.
 * Each container has a border and centered text.
 */
public class DoubleContainer {
    private final VBox mainContainer;
    private final VBox topContainer;
    private final VBox bottomContainer;
    private final Label topLabel;
    private final Label bottomLabel;
    
    /**
     * Constructor of DoubleContainer.
     * Initializes a 200x200 pixels main container containing two VBoxes.
     * The top container has a black border with a rounded corner at the top right.
     * The bottom container has a black border with a rounded corner at the bottom right.
     */
    public DoubleContainer() {
        // Main container creation
        mainContainer = new VBox();
        mainContainer.setPrefHeight(200.0);
        mainContainer.setPrefWidth(200.0);
        
        // First container (top)
        topContainer = new VBox();
        topContainer.setPrefHeight(100.0);
        topContainer.setPrefWidth(200.0);
        topContainer.setAlignment(javafx.geometry.Pos.CENTER);
        topContainer.getStyleClass().add("parking-box-top");
        
        // Border configuration for the top container
        BorderStroke topBorderStroke = new BorderStroke(
            Color.BLACK,                                    
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.SQUARE, 10, 0, null),  
            new CornerRadii(0, 30, 0, 0, false),                        
            new BorderWidths(5, 5, 0, 5)                                
        );
        Border topBorder = new Border(topBorderStroke);
        topContainer.setBorder(topBorder);
        
        // Add text to the top container
        topLabel = new Label("Bloc Supérieur");
        topLabel.getStyleClass().add("parking-box-text");
        topContainer.getChildren().add(topLabel);
        
        // Second container (bottom)
        bottomContainer = new VBox();
        bottomContainer.setPrefHeight(100.0);
        bottomContainer.setPrefWidth(200.0);
        bottomContainer.setAlignment(javafx.geometry.Pos.CENTER);
        bottomContainer.getStyleClass().add("parking-box-bottom");
        
        BorderStroke bottomBorderStroke = new BorderStroke(
            Color.BLACK,                                    
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.SQUARE, 10, 0, null),  
            new CornerRadii(0, 0, 0, 30, false),                        
            new BorderWidths(0, 5, 5, 5)
        );
        Border bottomBorder = new Border(bottomBorderStroke);
        bottomContainer.setBorder(bottomBorder);

        // Add text to the bottom container
        bottomLabel = new Label("Bloc Inférieur");
        bottomLabel.getStyleClass().add("parking-box-text");
        bottomContainer.getChildren().add(bottomLabel);
        
        // Add containers to the main container
        mainContainer.getChildren().addAll(topContainer, bottomContainer);
    }

    public VBox getMainContainer() {
        return mainContainer;
    }

    public VBox getTopContainer() {
        return topContainer;
    }

    public VBox getBottomContainer() {
        return bottomContainer;
    }

    public Label getTopLabel() {
        return topLabel;
    }

    public Label getBottomLabel() {
        return bottomLabel;
    }
} 