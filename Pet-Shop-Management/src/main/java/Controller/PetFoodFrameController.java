package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PetFoodFrameController {

    @FXML
    private AnchorPane PetFoodPane;

    @FXML
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(PetFoodPane, "CartFrame.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(PetFoodPane, "mainFrame.fxml");
    }

}
