package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class PetFrameController {

    @FXML
    private AnchorPane PetPane;


    @FXML
    void goToCart(ActionEvent event) throws IOException  {
        new SceneSwitch(PetPane, "CartFrame.fxml");
    }

    @FXML
        void goToHome(ActionEvent event) throws IOException {
            new SceneSwitch(PetPane, "mainFrame.fxml");
        }
}
