package Controller;

import Implementation.Cart;
import Implementation.DBConnector;
import Implementation.Food;
import Implementation.Product;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

import static Implementation.DBConnector.*;

public class PetFoodFrameController {

    Food Birdfood1 = new Food("VitaCraft", 700, DBConnector.getStockByPetFoodName("VitaCraft"), "1000 Grams", "Seed");
    Food Birdfood2 = new Food("Kaytee", 999, DBConnector.getStockByPetFoodName("Kaytee"), "1000 Grams", "Seed");
    Food Birdfood3 = new Food("Nut N' Berry", 700, DBConnector.getStockByPetFoodName("Nut N' Berry"), "1000 Grams", "Seed");

    Food Dogfood1 = new Food("Pedigree", 1500, DBConnector.getStockByPetFoodName("Pedigree"), "1000 Grams", "Dry Food");
    Food Dogfood2 = new Food("Kibble n' Bits", 600, DBConnector.getStockByPetFoodName("Boss Dogs"), "500 Grams", "Dry Food");
    Food Dogfood3 = new Food("Boss Dogs", 700, DBConnector.getStockByPetFoodName("Goodest"), "500 Grams", "Dry Food");

    Food Catfood1 = new Food("Goodest", 300, DBConnector.getStockByPetFoodName("Goodest"), "250 Grams", "Treats");
    Food Catfood2 = new Food("Whiskas", 800, DBConnector.getStockByPetFoodName("Whiskas"), "500 Grams", "Treats");
    Food Catfood3 = new Food("Pro Plan", 1000, DBConnector.getStockByPetFoodName("Pro Plan"), "1000 Grams", "Treats");


    private int lastAddedQuantity;

    @FXML
    private Label BfoodName2;

    @FXML
    private Label BfoodName3;

    @FXML
    private Label BfoodDes1;

    @FXML
    private Label BfoodDes2;

    @FXML
    private Label BfoodDes3;

    @FXML
    private Label BfoodName1;

    @FXML
    private Label BfoodPrice1;

    @FXML
    private Label BfoodPrice2;

    @FXML
    private Label BfoodPrice3;

    @FXML
    private Label CfoodDes1;

    @FXML
    private Label CfoodDes2;

    @FXML
    private Label CfoodDes3;

    @FXML
    private Label CfoodName1;

    @FXML
    private Label CfoodName2;

    @FXML
    private Label CfoodName3;

    @FXML
    private Label CfoodPrice1;

    @FXML
    private Label CfoodPrice2;

    @FXML
    private Label CfoodPrice3;

    @FXML
    private Label DfoodDes1;

    @FXML
    private Label DfoodDes2;

    @FXML
    private Label DfoodDes3;

    @FXML
    private Label DfoodName1;

    @FXML
    private Label DfoodName2;

    @FXML
    private Label DfoodName3;

    @FXML
    private Label DfoodPrice1;

    @FXML
    private Label DfoodPrice2;

    @FXML
    private Label DfoodPrice3;

    @FXML
    private AnchorPane PetFoodPane;


    @FXML
    private Label lbf1;

    @FXML
    private Label lbf2;

    @FXML
    private Label lbf3;

    @FXML
    private Label lcf1;

    @FXML
    private Label lcf2;

    @FXML
    private Label lcf3;

    @FXML
    private Label ldf1;

    @FXML
    private Label ldf2;

    @FXML
    private Label ldf3;

    @FXML
    public void initialize() {
        // Set Label for Bird Food
        BfoodName1.setText("Brand: " + Birdfood1.getName());
        BfoodDes1.setText(Birdfood1.getDescription());
        BfoodPrice1.setText("Price: " + Birdfood1.getPrice());
        lbf1.setText("Stock: " + Birdfood1.getStockQuantity());

        BfoodName2.setText("Brand: " + Birdfood2.getName());
        BfoodDes2.setText(Birdfood2.getDescription());
        BfoodPrice2.setText("Price: " + Birdfood2.getPrice());
        lbf2.setText("Stock: " + Birdfood2.getStockQuantity());

        BfoodName3.setText("Brand: " + Birdfood3.getName());
        BfoodDes3.setText(Birdfood3.getDescription());
        BfoodPrice3.setText("Price: " + Birdfood3.getPrice());
        lbf3.setText("Stock: " + Birdfood3.getStockQuantity());

        // Set Label for Dog Food
        DfoodName1.setText("Brand: " + Dogfood1.getName());
        DfoodDes1.setText(Dogfood1.getDescription());
        DfoodPrice1.setText("Price: " + Dogfood1.getPrice());
        ldf1.setText("Stock: " + Dogfood1.getStockQuantity());

        DfoodName2.setText("Brand: " + Dogfood2.getName());
        DfoodDes2.setText(Dogfood2.getDescription());
        DfoodPrice2.setText("Price: " + Dogfood2.getPrice());
        ldf2.setText("Stock: " + Dogfood2.getStockQuantity());

        DfoodName3.setText("Brand: " + Dogfood3.getName());
        DfoodDes3.setText(Dogfood3.getDescription());
        DfoodPrice3.setText("Price: " + Dogfood3.getPrice());
        ldf3.setText("Stock: " + Dogfood3.getStockQuantity());

        // Set Label for Cat Food
        CfoodName1.setText("Brand: " + Catfood1.getName());
        CfoodDes1.setText(Catfood1.getDescription());
        CfoodPrice1.setText("Price: " + Catfood1.getPrice());
        lcf1.setText("Stock: " + Catfood1.getStockQuantity());

        CfoodName2.setText("Brand: " + Catfood2.getName());
        CfoodDes2.setText(Catfood2.getDescription());
        CfoodPrice2.setText("Price: " + Catfood2.getPrice());
        lcf2.setText("Stock: " + Catfood2.getStockQuantity());

        CfoodName3.setText("Brand: " + Catfood3.getName());
        CfoodDes3.setText(Catfood3.getDescription());
        CfoodPrice3.setText("Price: " + Catfood3.getPrice());
        lcf3.setText("Stock: " + Catfood3.getStockQuantity());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Information type alert
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(message);
        alert.showAndWait(); // Show the alert and wait for user acknowledgment
    }

    private void handleAddToCart(Product product, String productName) {
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
                    // Check if there's enough stock
                    if (product.decreaseStock(quantity)) {
                        // Add the product to the cart with the given quantity
                        Cart cart = Cart.getInstance();
                        cart.addProduct(product, quantity);
                        System.out.println("Product added to cart: " + productName + ", Quantity: " + quantity);
                        lastAddedQuantity = quantity;

                        // Show success message
                        showAlert("Success", "Item successfully added to the cart!");
                    } else {
                        // Show error message for insufficient stock
                        showAlert("Error", "Insufficient stock. Available stock: " + product.getStockQuantity());
                    }
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
    void AddToCartPedigree(ActionEvent event) {

        handleAddToCart(Dogfood1, "Dogfood1");
        MinusStockByPetFoodName("Pedigree",lastAddedQuantity);
        Platform.runLater(() -> ldf1.setText("Stock: " + Dogfood1.getStockQuantity()));

    }

    @FXML
    void AddToCartVitacraft(ActionEvent event) {
        handleAddToCart(Birdfood1, "Birdfood1");
        MinusStockByPetFoodName("Vitacraft" ,lastAddedQuantity);
        Platform.runLater(() -> lbf1.setText("Stock: " + Birdfood1.getStockQuantity()));

    }

    @FXML
    void addToCartBossDogs(ActionEvent event) {

        handleAddToCart(Dogfood3, "Dogfood3");
        MinusStockByPetFoodName(Dogfood3.getName(),lastAddedQuantity);
        Platform.runLater(() -> ldf3.setText("Stock: " + Dogfood3.getStockQuantity()));

    }

    @FXML
    void addToCartGoodest(ActionEvent event) {

        handleAddToCart(Catfood1, "Catfood1");
        MinusStockByPetFoodName(Catfood1.getName(),lastAddedQuantity);
        Platform.runLater(() -> lcf1.setText("Stock: " + Catfood1.getStockQuantity()));


    }

    @FXML
    void addToCartKaytee(ActionEvent event) {

        handleAddToCart(Birdfood2, "Birdfood2");
        MinusStockByPetFoodName(Birdfood2.getName(),lastAddedQuantity);
        Platform.runLater(() -> lbf2.setText("Stock: " + Catfood2.getStockQuantity()));


    }

    @FXML
    void addToCartKibbl(ActionEvent event) {

        handleAddToCart(Dogfood2, "Dogfood2");
        MinusStockByPetFoodName(Dogfood2.getName(),lastAddedQuantity);
        Platform.runLater(() -> ldf2.setText("Stock: " + Dogfood2.getStockQuantity()));


    }

    @FXML
    void addToCartProPlan(ActionEvent event) {

        handleAddToCart(Catfood3, "Catfood3");
        MinusStockByPetFoodName(Catfood3.getName(),lastAddedQuantity);
        Platform.runLater(() -> lcf3.setText("Stock: " + Catfood3.getStockQuantity()));

    }

    @FXML
    void addToCartWhiskas(ActionEvent event) {

        handleAddToCart(Catfood2, "Catfood2");
        MinusStockByPetFoodName(Catfood2.getName(),lastAddedQuantity);
        Platform.runLater(() -> lcf2.setText("Stock: " + Catfood2.getStockQuantity()));


    }

    @FXML
    void addtoCartNut(ActionEvent event) {

        handleAddToCart(Birdfood3, "Birdfood3");
        MinusStockByPetFoodName(Birdfood3.getName(),lastAddedQuantity);
        Platform.runLater(() -> lbf3.setText("Stock: " + Birdfood3.getStockQuantity()));

    }

    @FXML
    void goToCart(ActionEvent event) {
        try {
            // Switch to the CartFrame scene and track the navigation
            new SceneSwitch (PetFoodPane, "CartFrame.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(PetFoodPane, "mainFrame.fxml");
    }


}

