package com.kelompok7oop.applicationcenter;


import com.kelompok7oop.applicationcenter.model.CardView;
import com.kelompok7oop.applicationcenter.model.Category;

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
        view.initialize(model.getName(this.appList), model.getIcon(this.appList), model.getPath(this.appList));
        setupEventHandlers();
    }

    private void setupEventHandlers() {
        view.addButton.setOnAction(event -> {
            Optional<CardView> cardOptional = view.showAddAppDialog();
            cardOptional.ifPresent(card -> model.addAppList(card));
            onLaunch();
        });

        view.removeButton.setOnAction(actionEvent -> {
           List<CardView> appList =  model.getAppList();
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

}

