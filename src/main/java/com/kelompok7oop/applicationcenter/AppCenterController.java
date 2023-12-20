package com.kelompok7oop.applicationcenter;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AppCenterController {
    public AppCenterModel model;
    public AppCenterView view;
    private List<CardView> appList;

    public AppCenterController(AppCenterModel model, AppCenterView view) {
        this.model = model;
        this.view = view;
        appList = model.getAppList();
    }

    public void onLaunch(){
        int size = appList.size();
        view.setSize(size);
        view.setStageMaximized();
        view.initialize(model.getName(this.appList),model.getIcon(this.appList));
        setupEventHandlers();
    }

    private void setupEventHandlers() {
        List<String> filePaths = model.getPath(this.appList); // Assuming you have a method to get file paths in your model

        for (int i = 0; i < filePaths.size(); i++) {
            final int index = i;

            view.buttonList.get(i).setOnAction(event -> handleOpen(filePaths.get(index)));
        }
        view.addButton.setOnAction(event -> {
            Optional<CardView> cardOptional = view.showAddAppDialog();
            cardOptional.ifPresent(card -> model.addAppList(card));
            onLaunch();
        });
        view.removeButton.setOnAction(actionEvent -> {
           List<CardView> appList =  model.getAppList();
           List<String> nameList;
           Optional<CardView> removeCard = view.showAppRemoveDialog(appList, model.getName(appList));
           removeCard.ifPresent(cardView -> {
                model.removeFromList(cardView);
                onLaunch();
            });
        });

        view.filterButton.setOnAction(actionEvent -> {
            Optional<Category> filterCategory = view.showFilterDialog();
            filterCategory.ifPresent(category -> this.appList = model.filterList(category));
            onLaunch();
        });

    }
   private void handleOpen(String filePath){
       try {
           java.awt.Desktop.getDesktop().open(new java.io.File(filePath));
       } catch (IOException e) {
           e.printStackTrace(); // Handle the exception appropriately
       }
    }
}

