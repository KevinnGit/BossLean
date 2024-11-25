package Controller;

import Implementation.Cart;
import Implementation.Food;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class PetFoodFrameController {

    Food Birdfood1 = new Food("VitaCraft", 700, 20, "1000 Grams", "Seed");
    Food Birdfood2 = new Food("Kaytee", 999, 20, "1000 Grams", "Seed");
    Food Birdfood3 = new Food("Nut N' Berry", 700, 20, "1000 Grams", "Seed");

    Food Dogfood1 = new Food("Pedigree", 1500, 20, "1000 Grams", "Dry Food");
    Food Dogfood2 = new Food("Kibble n' Bits", 600, 20, "500 Grams", "Dry Food");
    Food Dogfood3 = new Food("Boss Dogs", 700, 20, "500 Grams", "Dry Food");

    Food Catfood1 = new Food("Goodest", 300, 20, "250 Grams", "Treats");
    Food Catfood2 = new Food("Whiskas", 800, 20, "500 Grams", "Treats");
    Food Catfood3 = new Food("Pro Plan", 1000, 20, "1000 Grams", "Treats");



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
    public void initialize() {
        // Set Label for Bird Food
        BfoodName1.setText("Brand: " + Birdfood1.getName());
        BfoodDes1.setText(Birdfood1.getDescription());
        BfoodPrice1.setText("Price: " + Birdfood1.getPrice());

        BfoodName2.setText("Brand: " + Birdfood2.getName());
        BfoodDes2.setText(Birdfood2.getDescription());
        BfoodPrice2.setText("Price: " + Birdfood2.getPrice());

        BfoodName3.setText("Brand: " + Birdfood3.getName());
        BfoodDes3.setText(Birdfood3.getDescription());
        BfoodPrice3.setText("Price: " + Birdfood3.getPrice());

        // Set Label for Dog Food
        DfoodName1.setText("Brand: " + Dogfood1.getName());
        DfoodDes1.setText(Dogfood1.getDescription());
        DfoodPrice1.setText("Price: " + Dogfood1.getPrice());

        DfoodName2.setText("Brand: " + Dogfood2.getName());
        DfoodDes2.setText(Dogfood2.getDescription());
        DfoodPrice2.setText("Price: " + Dogfood2.getPrice());

        DfoodName3.setText("Brand: " + Dogfood3.getName());
        DfoodDes3.setText(Dogfood3.getDescription());
        DfoodPrice3.setText("Price: " + Dogfood3.getPrice());

        // Set Label for Cat Food
        CfoodName1.setText("Brand: " + Catfood1.getName());
        CfoodDes1.setText(Catfood1.getDescription());
        CfoodPrice1.setText("Price: " + Catfood1.getPrice());

        CfoodName2.setText("Brand: " + Catfood2.getName());
        CfoodDes2.setText(Catfood2.getDescription());
        CfoodPrice2.setText("Price: " + Catfood2.getPrice());

        CfoodName3.setText("Brand: " + Catfood3.getName());
        CfoodDes3.setText(Catfood3.getDescription());
        CfoodPrice3.setText("Price: " + Catfood3.getPrice());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Information type alert
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(message);
        alert.showAndWait(); // Show the alert and wait for user acknowledgment
    }

    @FXML
    void AddToCartPedigree(ActionEvent event) {
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
                    cart.addProduct(Dogfood1, quantity);
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
    void AddToCartVitacraft(ActionEvent event) {
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
                    cart.addProduct(Birdfood1, quantity);
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
    void addToCartBossDogs(ActionEvent event) {
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
                    cart.addProduct(Dogfood3, quantity);
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
    void addToCartGoodest(ActionEvent event) {
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
                    cart.addProduct(Catfood1, quantity);
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
    void addToCartKaytee(ActionEvent event) {
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
                    cart.addProduct(Birdfood2, quantity);
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
    void addToCartKibbl(ActionEvent event) {
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
                    cart.addProduct(Dogfood2, quantity);
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
    void addToCartProPlan(ActionEvent event) {
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
                    cart.addProduct(Catfood3, quantity);
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
    void addToCartWhiskas(ActionEvent event) {
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
                    cart.addProduct(Catfood2, quantity);
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
    void addtoCartNut(ActionEvent event) {
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
                    cart.addProduct(Birdfood3, quantity);
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
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(PetFoodPane, "CartFrame.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(PetFoodPane, "mainFrame.fxml");
    }


}

