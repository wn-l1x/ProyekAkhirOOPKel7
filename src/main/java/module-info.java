module com.kelompok7oop.appcenterfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.kelompok7oop.applicationcenter to javafx.fxml;
    exports com.kelompok7oop.applicationcenter;
}