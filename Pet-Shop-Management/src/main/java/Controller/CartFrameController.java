package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CartFrameController {

    @FXML
    private AnchorPane CartPane;

    @FXML
    private TextArea cartTextArea;

    @FXML
    void goToHome(ActionEvent event) {
        try {
            new SceneSwitch(CartPane, "mainFrame.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}