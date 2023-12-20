package com.kelompok7oop.applicationcenter;

import com.kelompok7oop.applicationcenter.model.CardCreator;
import com.kelompok7oop.applicationcenter.model.CardView;
import com.kelompok7oop.applicationcenter.model.Category;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppCenterView {
    private Stage stage;
    private int size; // size dari si json
    public List<Button> buttonList = new ArrayList<Button>();
    public Button addButton;
    public Button removeButton;
    public Button filterButton;
    private Category filterCategory = Category.NO_CATEGORY;
    public AppCenterView(Stage stage) {
        this.stage = stage;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void initialize(List<String> appName, List<String> iconPath) {
        stage.setMaximized(true);
        stage.setTitle("App Center");
        addButton = new Button("Add an App");
        removeButton = new Button("Remove an App");
        filterButton = new Button ("Filter by Category");
        HBox topButtons = new HBox(addButton, removeButton, filterButton);
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setSpacing(20);

        GridPane gridPane = new GridPane();
        for (int i = 0; i < size; i++) {
            Image img = new Image(iconPath.get(i));
            ImageView view = new ImageView(img);
            view.setFitHeight(453);
            view.setFitWidth(300);
            view.setPreserveRatio(true);
            Button button = new Button();
            button.setPrefSize(300, 453);
            button.setGraphic(view);
            buttonList.add(button);
            VBox buttonContainer = new VBox();
            buttonContainer.getChildren().addAll(button,new javafx.scene.control.Label(appName.get(i)));
            buttonContainer.setAlignment(Pos.CENTER);
            gridPane.add(buttonContainer, i%4, i/4, 1, 1);
        }

        VBox root = new VBox(topButtons, new ScrollPane(gridPane));
        root.setSpacing(10);

        Scene scene = new Scene(root, 595, 170);
        stage.setScene(scene);
    }

    public void setStageMaximized(){
        this.stage.setMaximized(true);
    }
    public Optional<CardView> showAddAppDialog() {
        ChoiceBox<Category> categoryChoiceBox = new ChoiceBox<>();
        categoryChoiceBox.getItems().addAll(Arrays.stream(Category.values())
                .filter(category -> category != Category.NO_CATEGORY)
                .collect(Collectors.toList()));
        categoryChoiceBox.setValue(Category.UTILITIES); // Set a default value

        Dialog<Category> dialog = new Dialog<>();
        dialog.setTitle("Add App");
        dialog.setHeaderText("Select Category");

        VBox content = new VBox(categoryChoiceBox);
        VBox.setMargin(categoryChoiceBox, new Insets(10));
        dialog.getDialogPane().setContent(content);

        ButtonType categoryButtonType = new ButtonType("Choice Category", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(categoryButtonType, ButtonType.CANCEL);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == categoryButtonType) {
                return categoryChoiceBox.getValue();
            }
            return null;
        });

        Optional<Category> selectedCategory = dialog.showAndWait();

        FileChooser appChooser = new FileChooser();
        appChooser.setTitle("Select App Executable");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Executable Files (*.exe)", "*.exe");
        appChooser.getExtensionFilters().add(extFilter);
        File selectedApp = appChooser.showOpenDialog(stage);
        int dotIndex = selectedApp.getName().lastIndexOf(".");
        String appName = selectedApp.getName().substring(0, dotIndex);

        FileChooser iconChooser = new FileChooser();
        iconChooser.setTitle("Select Image App");
        FileChooser.ExtensionFilter iconFilter = new FileChooser.ExtensionFilter("JPEG files (*.jpg)", "*.jpg");
        iconChooser.getExtensionFilters().add(iconFilter);
        File selectedIcon = iconChooser.showOpenDialog(stage);

        return Optional.of(CardCreator.createCard(selectedCategory.get(), appName, selectedApp.getAbsolutePath(), selectedIcon.getAbsolutePath()));
    }

    public Optional<CardView> showAppRemoveDialog(List<CardView> appList, List<String> appNames) {
        // Create a ChoiceBox with the app names
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableList(appNames));
        choiceBox.getSelectionModel().selectFirst();

        // Create a dialog to select and confirm the app to remove
        Dialog<CardView> dialog = new Dialog<>();
        dialog.setTitle("Remove App");
        dialog.setHeaderText("Select and Confirm the app to remove:");

        // Set the content of the dialog
        dialog.getDialogPane().setContent(choiceBox);

        // Add buttons to the dialog
        ButtonType removeButtonType = new ButtonType("Remove", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(removeButtonType, ButtonType.CANCEL);

        // Set the result converter
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == removeButtonType) {
                // Find the selected CardView based on the selected app name
                String selectedAppName = choiceBox.getValue();
                for (CardView cardView : appList) {
                    // Assuming the format is consistent: [AppName ...
                    int startIndex = cardView.toString().indexOf("[") + 1;
                    int endIndex = cardView.toString().indexOf(",");
                    String appName = cardView.toString().substring(startIndex, endIndex).trim();
                    if (appName.equals(selectedAppName)) {
                        return cardView;
                    }
                }
            }
            return null;
        });

        // Show the dialog and process the result
        Optional<CardView> result = dialog.showAndWait();
        if (result.isPresent()) {
            // Confirm removal
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Are you sure you want to remove this app?");
            confirmation.setContentText("Click OK to confirm removal.");
            Optional<ButtonType> confirmationResult = confirmation.showAndWait();

            if (confirmationResult.isPresent() && confirmationResult.get() == ButtonType.OK) {
                return result;
            }
        }

        return Optional.empty();
    }

    public Optional<Category> showFilterDialog() {
        ChoiceBox<Category> categoryChoiceBox = new ChoiceBox<>();
        categoryChoiceBox.getItems().addAll(Category.values());
        categoryChoiceBox.setValue(filterCategory); // Set a default value

        Dialog<Category> dialog = new Dialog<>();
        dialog.setTitle("Filter Apps");
        dialog.setHeaderText("Select a category to filter:");

        VBox content = new VBox(categoryChoiceBox);
        dialog.getDialogPane().setContent(content);

        ButtonType filterButtonType = new ButtonType("Filter", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(filterButtonType, ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == filterButtonType) {
                return categoryChoiceBox.getValue();
            }
            return null;
        });

        Optional<Category> result = dialog.showAndWait();
        filterCategory = result.get();
        return result;
    }

    public void show() {
        stage.show();
    }
}
