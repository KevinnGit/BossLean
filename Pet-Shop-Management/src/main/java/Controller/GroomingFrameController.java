package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GroomingFrameController {

    @FXML
    private AnchorPane GroomingPane;

    @FXML
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(GroomingPane, "CartFrame.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(GroomingPane, "mainFrame.fxml");
    }

}
