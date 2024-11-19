module finalprjct.petshopmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens finalprjct.petshopmanagementsystem to javafx.fxml;
    exports finalprjct.petshopmanagementsystem;
    exports Controller;
    opens Controller to javafx.fxml;
}