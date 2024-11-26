package Controller;

import Implementation.Cart;
import Implementation.Services;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class GroomingFrameController {

    Services earCare = new Services("Ear Care", 2500, "");
    Services petWash = new Services("Pet Wash", 3000, "");
    Services nailCutting = new Services("Nail Cutting", 1500, "");

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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Information type alert
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(message);
        alert.showAndWait(); // Show the alert and wait for user acknowledgment
    }

    @FXML
    public void initialize() {
        ServicesName1.setText(nailCutting.getName());
        ServicesName2.setText(earCare.getName());
        ServicesName3.setText(petWash.getName());

        ServicesPrice1.setText("Price: ₱" + nailCutting.getPrice());
        ServicesPrice2.setText("Price: ₱" + earCare.getPrice());
        ServicesPrice3.setText("Price: ₱" + petWash.getPrice());
    }


    @FXML
    void addToCartRyle(ActionEvent event) {

    }

    @FXML
    void availEarCare(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter Quantity");
        dialog.setHeaderText("Enter the quantity of the product you want to add to the cart:");
        dialog.setContentText("Quantity:");

        // Show the dialog and wait for user input
        Optional<String> result = dialog.showAndWait();

        // Check if the user entered something and parse it to an integer
        result.ifPresent(quantityString -> {
            try {
                int quantity = Integer.parseInt(quantityString);

                if (quantity > 0) {
                    // Add the product to the cart with the given quantity
                    Cart cart = Cart.getInstance();
                    cart.addProduct(earCare, quantity);
                    System.out.println("Product added to cart: Bird1, Quantity: " + quantity);

                    // Show success message
                    showAlert("Success", "Item successfully added to the cart!");
                } else {
                    showAlert("Error", "Please enter a positive quantity.");
                }
            } catch (NumberFormatException e) {
                // Handle case when the input is not a valid number
                showAlert("Error", "Please enter a valid quantity.");
            }
        });
    }

    @FXML
    void availNailCutting(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter Quantity");
        dialog.setHeaderText("Enter the quantity of the product you want to add to the cart:");
        dialog.setContentText("Quantity:");

        // Show the dialog and wait for user input
        Optional<String> result = dialog.showAndWait();

        // Check if the user entered something and parse it to an integer
        result.ifPresent(quantityString -> {
            try {
                int quantity = Integer.parseInt(quantityString);

                if (quantity > 0) {
                    // Add the product to the cart with the given quantity
                    Cart cart = Cart.getInstance();
                    cart.addProduct(nailCutting, quantity);
                    System.out.println("Product added to cart: Bird1, Quantity: " + quantity);

                    // Show success message
                    showAlert("Success", "Item successfully added to the cart!");
                } else {
                    showAlert("Error", "Please enter a positive quantity.");
                }
            } catch (NumberFormatException e) {
                // Handle case when the input is not a valid number
                showAlert("Error", "Please enter a valid quantity.");
            }
        });
    }

    @FXML
    void availPetWash(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter Quantity");
        dialog.setHeaderText("Enter the quantity of the product you want to add to the cart:");
        dialog.setContentText("Quantity:");

        // Show the dialog and wait for user input
        Optional<String> result = dialog.showAndWait();

        // Check if the user entered something and parse it to an integer
        result.ifPresent(quantityString -> {
            try {
                int quantity = Integer.parseInt(quantityString);

                if (quantity > 0) {
                    // Add the product to the cart with the given quantity
                    Cart cart = Cart.getInstance();
                    cart.addProduct(petWash, quantity);
                    System.out.println("Product added to cart: Bird1, Quantity: " + quantity);

                    // Show success message
                    showAlert("Success", "Item successfully added to the cart!");
                } else {
                    showAlert("Error", "Please enter a positive quantity.");
                }
            } catch (NumberFormatException e) {
                // Handle case when the input is not a valid number
                showAlert("Error", "Please enter a valid quantity.");
            }
        });
    }


    @FXML
    void goToCart(ActionEvent event) {
        try {
            // Switch to the CartFrame scene and track the navigation
            new SceneSwitch(GroomingPane, "CartFrame.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(GroomingPane, "mainFrame.fxml");
    }

}
