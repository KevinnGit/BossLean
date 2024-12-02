package Controller;

import Implementation.Cart;
import Implementation.DBConnector;
import Implementation.Food;
import Implementation.Product;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

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
    private TextField tabf1;

    @FXML
    private TextField tabf2;

    @FXML
    private TextField tabf3;

    @FXML
    private TextField tacf1;

    @FXML
    private TextField tacf2;

    @FXML
    private TextField tacf3;

    @FXML
    private TextField tadf1;

    @FXML
    private TextField tadf2;

    @FXML
    private TextField tadf3;

    @FXML
    public void initialize() {
        // Set Label for Bird Food
        BfoodName1.setText("Brand: " + Birdfood1.getName());
        BfoodDes1.setText(Birdfood1.getDescription());
        BfoodPrice1.setText("Price: " + Birdfood1.getPrice());
        tabf1.setText("Stock: " + Birdfood1.getStockQuantity());

        BfoodName2.setText("Brand: " + Birdfood2.getName());
        BfoodDes2.setText(Birdfood2.getDescription());
        BfoodPrice2.setText("Price: " + Birdfood2.getPrice());
        tabf2.setText("Stock: " + Birdfood2.getStockQuantity());

        BfoodName3.setText("Brand: " + Birdfood3.getName());
        BfoodDes3.setText(Birdfood3.getDescription());
        BfoodPrice3.setText("Price: " + Birdfood3.getPrice());
        tabf3.setText("Stock: " + Birdfood3.getStockQuantity());

        // Set Label for Dog Food
        DfoodName1.setText("Brand: " + Dogfood1.getName());
        DfoodDes1.setText(Dogfood1.getDescription());
        DfoodPrice1.setText("Price: " + Dogfood1.getPrice());
        tadf1.setText("Stock: " + Dogfood1.getStockQuantity());

        DfoodName2.setText("Brand: " + Dogfood2.getName());
        DfoodDes2.setText(Dogfood2.getDescription());
        DfoodPrice2.setText("Price: " + Dogfood2.getPrice());
        tadf2.setText("Stock: " + Dogfood2.getStockQuantity());

        DfoodName3.setText("Brand: " + Dogfood3.getName());
        DfoodDes3.setText(Dogfood3.getDescription());
        DfoodPrice3.setText("Price: " + Dogfood3.getPrice());
        tadf3.setText("Stock: " + Dogfood3.getStockQuantity());

        // Set Label for Cat Food
        CfoodName1.setText("Brand: " + Catfood1.getName());
        CfoodDes1.setText(Catfood1.getDescription());
        CfoodPrice1.setText("Price: " + Catfood1.getPrice());
        tacf1.setText("Stock: " + Catfood1.getStockQuantity());

        CfoodName2.setText("Brand: " + Catfood2.getName());
        CfoodDes2.setText(Catfood2.getDescription());
        CfoodPrice2.setText("Price: " + Catfood2.getPrice());
        tacf2.setText("Stock: " + Catfood2.getStockQuantity());

        CfoodName3.setText("Brand: " + Catfood3.getName());
        CfoodDes3.setText(Catfood3.getDescription());
        CfoodPrice3.setText("Price: " + Catfood3.getPrice());
        tacf3.setText("Stock: " + Catfood3.getStockQuantity());
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
    }

    @FXML
    void AddToCartVitacraft(ActionEvent event) {
        handleAddToCart(Birdfood1, "Birdfood1");
    }

    @FXML
    void addToCartBossDogs(ActionEvent event) {
        handleAddToCart(Dogfood3, "Dogfood3");
    }

    @FXML
    void addToCartGoodest(ActionEvent event) {
        handleAddToCart(Catfood1, "Catfood1");
    }

    @FXML
    void addToCartKaytee(ActionEvent event) {
        handleAddToCart(Birdfood2, "Birdfood2");
    }

    @FXML
    void addToCartKibbl(ActionEvent event) {
        handleAddToCart(Dogfood2, "Dogfood2");
    }

    @FXML
    void addToCartProPlan(ActionEvent event) {
        handleAddToCart(Catfood3, "Catfood3");
    }

    @FXML
    void addToCartWhiskas(ActionEvent event) {
        handleAddToCart(Catfood2, "Catfood2");
    }

    @FXML
    void addtoCartNut(ActionEvent event) {
        handleAddToCart(Birdfood3, "Birdfood3");
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

