package com.kelompok7oop.appcenterfrontend;

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

        controller.view.show();
    }
}
