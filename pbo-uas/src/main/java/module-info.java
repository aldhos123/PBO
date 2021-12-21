module id.ac.upj.tif.pbouas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens id.ac.upj.tif.pbouas to javafx.fxml;
    exports id.ac.upj.tif.pbouas;
}