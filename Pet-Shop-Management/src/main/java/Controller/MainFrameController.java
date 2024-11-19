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
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "CartFrame.fxml");
    }

    @FXML
    void goToAccessories(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "PetFoodFrame.fxml");
    }

    @FXML
    void goToFood(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "PetFoodFrame.fxml");
    }

    @FXML
    void goToGrooming(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "GroomingFrame.fxml");
    }

    @FXML
    void goToPets(ActionEvent event) throws IOException {
            new SceneSwitch(mainFrame, "PetFrame.fxml");
        }
}
