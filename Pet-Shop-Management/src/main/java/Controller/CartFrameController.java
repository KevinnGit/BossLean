package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import Implementation.Cart;
import java.io.IOException;

public class CartFrameController {

    @FXML
    private AnchorPane CartPane;

    @FXML
    TextArea cartTextArea;

    // This method is automatically called when the FXML is loaded
    @FXML
    public void initialize() {
        // Fetch the cart details from the Cart instance
        Cart cart = Cart.getInstance();
        String cartDetails = cart.getCartDetails();

        // Update the cartTextArea with the fetched cart details
        cartTextArea.setText(cartDetails);
    }

    // Method to update the cart text area
    public void setCartDetails(String cartDetails) {
        cartTextArea.setText(cartDetails);
    }

    @FXML
    void goToHome(ActionEvent event) {
        try {
            new SceneSwitch(CartPane, "mainFrame.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}