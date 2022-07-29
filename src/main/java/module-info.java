module com.example.main_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.main_project to javafx.fxml;
    exports com.example.main_project;
    exports com.example.main_project.controller;
    opens com.example.main_project.controller to javafx.fxml;
}