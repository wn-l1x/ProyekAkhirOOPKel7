module com.kelompok7oop.appcenterfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.kelompok7oop.applicationcenter to javafx.fxml;
    exports com.kelompok7oop.applicationcenter;
    exports com.kelompok7oop.applicationcenter.model;
    opens com.kelompok7oop.applicationcenter.model to javafx.fxml;
    exports com.kelompok7oop.applicationcenter.handler;
    opens com.kelompok7oop.applicationcenter.handler to javafx.fxml;
}