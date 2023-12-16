module com.kelompok7oop.appcenterfrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kelompok7oop.appcenterfrontend to javafx.fxml;
    exports com.kelompok7oop.appcenterfrontend;
}