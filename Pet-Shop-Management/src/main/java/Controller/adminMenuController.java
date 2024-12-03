package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminMenuController {

    @FXML
    private AnchorPane adminMenuPane;

    @FXML
    void goToSales(ActionEvent event) throws IOException {
        new SceneSwitch(adminMenuPane, "adminSales.fxml",true);
    }

    @FXML
    void goToMain(ActionEvent event) throws IOException {
        new SceneSwitch(adminMenuPane, "mainFrame.fxml",true);
    }

    @FXML
    void goToStocks(ActionEvent event) {
        try {
            new SceneSwitch(adminMenuPane, "adminManageStocks.fxml",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
