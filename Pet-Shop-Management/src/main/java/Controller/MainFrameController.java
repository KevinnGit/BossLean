package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFrameController {

    @FXML
    private AnchorPane mainFrame;

    @FXML
    void goToAccessories(ActionEvent event) {

    }

    @FXML
    void goToFood(ActionEvent event) {

    }

    @FXML
    void goToGrooming(ActionEvent event) {

    }

    @FXML
    void goToPets(ActionEvent event) throws IOException {
            new SceneSwitch(mainFrame, "BirdFrame.fxml");
        }
}
