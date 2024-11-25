package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class GroomingFrameController {

    @FXML
    private AnchorPane GroomingPane;

    @FXML
    private Label ServicesName1;

    @FXML
    private Label ServicesName2;

    @FXML
    private Label ServicesName3;

    @FXML
    private Label ServicesPrice1;

    @FXML
    private Label ServicesPrice2;

    @FXML
    private Label ServicesPrice3;

    @FXML
    void addToCartRyle(ActionEvent event) {

    }

    @FXML
    void availEarCare(ActionEvent event) {

    }

    @FXML
    void availNailCutting(MouseEvent event) {

    }

    @FXML
    void availPetWash(ActionEvent event) {

    }


    @FXML
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(GroomingPane, "CartFrame.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(GroomingPane, "mainFrame.fxml");
    }

}
