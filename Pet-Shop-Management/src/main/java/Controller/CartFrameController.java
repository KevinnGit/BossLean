package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CartFrameController {

    @FXML
    private AnchorPane CartPane;


    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(CartPane, "mainFrame.fxml");
    }
}