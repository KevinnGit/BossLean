package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminSalesController {

    @FXML
    private TableView<?> SalesHIstory;

    @FXML
    private AnchorPane adminSalesPane;

    @FXML
    void goToMain(ActionEvent event) throws IOException {
        new SceneSwitch(adminSalesPane, "mainFrame.fxml");
    }

    @FXML
    void goToStocks(ActionEvent event) throws IOException {
        new SceneSwitch(adminSalesPane, "adminManageStocks.fxml");
    }

}
