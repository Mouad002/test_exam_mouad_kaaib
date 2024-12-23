module com.example.test_examen_mouad_kaaib {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.test_examen_mouad_kaaib to javafx.fxml;
    exports com.example.test_examen_mouad_kaaib;
}