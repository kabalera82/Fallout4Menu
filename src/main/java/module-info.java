module tech.kabadev.fallout4menuapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens tech.kabadev.fallout4menuapp to javafx.fxml;
    exports tech.kabadev.fallout4menuapp;
}