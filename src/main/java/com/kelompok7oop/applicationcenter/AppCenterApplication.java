package com.kelompok7oop.applicationcenter;

import javafx.application.Application;
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
        primaryStage.setOnCloseRequest(event -> CSVHandler.writeCSV("cards.csv",model.getAppList()));
    }
}
