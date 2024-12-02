package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminStocksController {

    @FXML
    private AnchorPane manageStocksPane;

    @FXML
    void goToMain(ActionEvent event) throws IOException {
        new SceneSwitch(manageStocksPane, "mainFrame.fxml");
    }

    @FXML
    void goToSales(ActionEvent event) throws IOException {
        new SceneSwitch(manageStocksPane,"adminSales.fxml");
    }

    @FXML
    void goToStocks(ActionEvent event) {

    }

}
