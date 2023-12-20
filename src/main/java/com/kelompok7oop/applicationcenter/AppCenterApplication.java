package com.kelompok7oop.applicationcenter;

import com.kelompok7oop.applicationcenter.handler.CSVHandler;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppCenterApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppCenterModel model = new AppCenterModel();
        AppCenterView view = new AppCenterView(primaryStage);
        AppCenterController controller = new AppCenterController(model, view);
        controller.onLaunch();
        controller.view.show();
        primaryStage.getIcons().add(new Image("file:resources/icon/ico.jpg"));
        primaryStage.setOnCloseRequest(event -> CSVHandler.writeCSV("cards.csv", model.getAppList()));
    }
}
