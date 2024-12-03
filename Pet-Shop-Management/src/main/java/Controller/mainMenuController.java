package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class mainMenuController {

    @FXML
    private AnchorPane mainMenuPane;

    @FXML
    void goToLogIn(ActionEvent event) throws IOException {
        new SceneSwitch(mainMenuPane, "adminLogIn.fxml",false);
    }

    @FXML
    void goToMainFrame(ActionEvent event) throws IOException {
        new SceneSwitch(mainMenuPane, "mainFrame.fxml",true);
    }

}
