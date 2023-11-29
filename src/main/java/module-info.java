module com.example.bankingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.bankingsystem to javafx.fxml;
    exports com.example.bankingsystem;
}