package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomerFrameController {

    @FXML
    private AnchorPane CustomerPane;

    @FXML
    private void goToHome(ActionEvent event) {
        try {
            // Set the previous scene as PetFrame before switching


            // Switch to the CartFrame
            new SceneSwitch(CustomerPane,"CartFrame.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}