module finalprjct.petshopmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens finalprjct.petshopmanagementsystem to javafx.fxml;
    exports finalprjct.petshopmanagementsystem;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Implementation;
    opens Implementation to javafx.fxml;
}