package com.kelompok7oop.appcenterfrontend;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppCenterView {
    private Stage stage;
    private int i,j;
    private int size; // size dari si json

    public AppCenterView(Stage stage) {
        this.stage = stage;
        initialize();
    }

    public void initialize() {
        stage.setTitle("App Center");
        size = 10; //temp
        GridPane gridPane = new GridPane();
        for (i = 0; i < size; i++) {
            for (j = 0; j < 4; j++) {
                Image img = new Image("D://Wendy//AppCenterFrontEnd//resources//icon//2Q.jpg");
                ImageView view = new ImageView(img);
                view.setFitHeight(453);
                view.setFitWidth(300);
                view.setPreserveRatio(true);
                Button button = new Button();
                button.setStyle("-fx-border: null; -fx-background: null;");
                button.setPrefSize(300, 453);
                button.setGraphic(view);
                VBox buttonContainer = new VBox();
                buttonContainer.getChildren().addAll(button,new javafx.scene.control.Label("Buronan Elektro"));
                buttonContainer.setAlignment(Pos.CENTER);
                gridPane.add(buttonContainer, i, j, 1, 1);
            }
        }

        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 595, 170);
        stage.setTitle("Button Graphics");
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
