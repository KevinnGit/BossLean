package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccessoriesFrameController {

    @FXML
    private AnchorPane AccessoriesPane;

    @FXML
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(AccessoriesPane, "CartFrame.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(AccessoriesPane, "mainFrame.fxml");
    }


}
