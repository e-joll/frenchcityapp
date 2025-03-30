module me.example.cityapi {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens me.example.cityapi to javafx.fxml;
    opens me.example.cityapi.controller to javafx.fxml;
    exports me.example.cityapi;
    exports me.example.cityapi.controller;
    exports me.example.cityapi.model;
    exports me.example.cityapi.data;
}