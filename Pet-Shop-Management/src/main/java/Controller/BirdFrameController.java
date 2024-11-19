package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BirdFrameController {

    @FXML
    private AnchorPane birdPane;

    @FXML
    void goToCart(ActionEvent event) {

    }

    @FXML
    void goToCats(ActionEvent event) {

    }

    @FXML
    void goToDogs(ActionEvent event) {

    }

    @FXML
        void goToHome(ActionEvent event) throws IOException {
            new SceneSwitch(birdPane, "mainFrame.fxml");
        }
}
