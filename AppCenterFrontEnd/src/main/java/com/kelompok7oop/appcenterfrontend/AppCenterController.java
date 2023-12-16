package com.kelompok7oop.appcenterfrontend;


public class AppCenterController {
    public AppCenterModel model;
    public AppCenterView view;


    public AppCenterController(AppCenterModel model, AppCenterView view) {
        this.model = model;
        this.view = view;
        // view.incrementButton.setOnAction(event -> handleIncrementButtonClick());

    }

    private void setupEventHandlers() {
            /*
            model.incrementCount();
            view.update(model.getCount());
             */
    }

    private void handleIncrementButtonClick() {
            /*
            model.incrementCount();
            view.update(model.getCount());
             */
    }

}

