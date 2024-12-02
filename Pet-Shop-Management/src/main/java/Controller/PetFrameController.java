package Controller;

import Implementation.Animals;
import Implementation.Cart;
import Implementation.DBConnector;
import Implementation.Product;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

public class PetFrameController {

    Animals bird1 = new Animals("Parakeet", 100000, DBConnector.getStockByBreedName("Parakeet"), "green with yellow, with black stripes", 2, "Ryle");
    Animals bird2 = new Animals("Canary", 500000, DBConnector.getStockByBreedName("Canary"), "Yellow with a touch of black", 5, "Lloyd");
    Animals bird3 = new Animals("Macaw", 1000000, DBConnector.getStockByBreedName("Macaw"), "green forehead, fading into a teal blue", 1, "Ken");

    Animals dog1 = new Animals("Golden Retriever", 15000, DBConnector.getStockByBreedName("Golden Retriever"), "Light golden", 11, "Ryan" );
    Animals dog2 = new Animals("Chihuahua", 20000, DBConnector.getStockByBreedName("Chichuchua"), "Brownish Cream", 1, "Jonathan");
    Animals dog3 = new Animals("Chow Chow", 300000, DBConnector.getStockByBreedName("Chow Chow"), "White Cream", 6, "Troy");

    Animals cat1 = new Animals("Scottish Fold", 1000000, DBConnector.getStockByBreedName("Scottish Fold"), "Orange", 6, "Fletcher");
    Animals cat2 = new Animals("British Long Hair", 150000, DBConnector.getStockByBreedName("British Long Hair"), "Grey", 1, "Yosh");
    Animals cat3 = new Animals("Sokoke", 50000, DBConnector.getStockByBreedName("Sokoke"), "Orange with red stripes", 8, "Mheil");


    @FXML
    private AnchorPane PetPane;

    @FXML
    private Label bird1Age;

    @FXML
    private Label bird1Breed;

    @FXML
    private Label bird1Color;

    @FXML
    private Label bird1Name;

    @FXML
    private Label bird1Price;

    @FXML
    private Label bird2Age;

    @FXML
    private Label bird2Breed;

    @FXML
    private Label bird2Color;

    @FXML
    private Label bird2Name;

    @FXML
    private Label bird2Price;

    @FXML
    private Label bird3Age;

    @FXML
    private Label bird3Breed;

    @FXML
    private Label bird3Color;

    @FXML
    private Label bird3Name;

    @FXML
    private Label bird3Price;

    @FXML
    private Label cat1Age;

    @FXML
    private Label cat1Breed;

    @FXML
    private Label cat1Color;

    @FXML
    private Label cat1Name;

    @FXML
    private Label cat1Price;

    @FXML
    private Label cat2Age;

    @FXML
    private Label cat2Breed;

    @FXML
    private Label cat2Color;

    @FXML
    private Label cat2Name;

    @FXML
    private Label cat2Price;

    @FXML
    private Label cat3Age;

    @FXML
    private Label cat3Breed;

    @FXML
    private Label cat3Color;

    @FXML
    private Label cat3Name;

    @FXML
    private Label cat3Price;

    @FXML
    private Label dog1Age;

    @FXML
    private Label dog1Breed;

    @FXML
    private Label dog1Color;

    @FXML
    private Label dog1Name;

    @FXML
    private Label dog1Price;

    @FXML
    private Label dog2Age;

    @FXML
    private Label dog2Breed;

    @FXML
    private Label dog2Color;

    @FXML
    private Label dog2Name;

    @FXML
    private Label dog2Price;

    @FXML
    private Label dog3Age;

    @FXML
    private Label dog3Breed;

    @FXML
    private Label dog3Color;

    @FXML
    private Label dog3Name;

    @FXML
    private Label dog3Price;



    @FXML
    public void initialize() {
        // Set labels for bird1

        bird1Age.setText("Age: " + bird1.getAge() + " years old");
        bird1Color.setText("Color: " + bird1.getDescription());
        bird1Breed.setText("Breed: " + bird1.getBreed());
        bird1Price.setText("Price: " + bird1.getPrice());

        // Set labels for bird2

        bird2Age.setText("Age: " +  bird2.getAge()+ " Months old");
        bird2Color.setText("Color: " + bird2.getDescription());
        bird2Breed.setText("Breed: " + bird2.getBreed());
        bird2Price.setText("Price: " + bird2.getPrice());

        // Set labels for bird3

        bird3Age.setText("Age: " + bird3.getAge()+ " years old");
        bird3Color.setText("Color: " + bird3.getDescription());
        bird3Breed.setText("Breed: " + bird3.getBreed());
        bird3Price.setText("Price: " + bird3.getPrice());

        // Set labels for dog1

        dog1Age.setText("Age: " + dog1.getAge()+ " Months old");
        dog1Color.setText("Color: " + dog1.getDescription());
        dog1Breed.setText("Breed: " + dog1.getBreed());
        dog1Price.setText("Price: " + dog1.getPrice());

        // Set labels for dog2

        dog2Age.setText("Age: " + dog2.getAge()+ " years old");
        dog2Color.setText("Color: " + dog2.getDescription());
        dog2Breed.setText("Breed: " + dog2.getBreed());
        dog2Price.setText("Price: " + dog2.getPrice());

        // Set labels for dog3

        dog3Age.setText("Age: " + dog3.getAge()+ " Months old");
        dog3Color.setText("Color: " + dog3.getDescription());
        dog3Breed.setText("Breed: " + dog3.getBreed());
        dog3Price.setText("Price: " + dog3.getPrice());

        // Set labels for cat1

        cat1Age.setText("Age: " + cat1.getAge()+ " Months old");
        cat1Color.setText("Color: " + cat1.getDescription());
        cat1Breed.setText("Breed: " + cat1.getBreed());
        cat1Price.setText("Price: " + cat1.getPrice());

        // Set labels for cat2

        cat2Age.setText("Age: " + cat2.getAge()+ " years old");
        cat2Color.setText("Color: " + cat2.getDescription());
        cat2Breed.setText("Breed: " + cat2.getBreed());
        cat2Price.setText("Price: " + cat2.getPrice());

        // Set labels for cat3

        cat3Age.setText("Age: " + cat3.getAge());
        cat3Color.setText("Color: " + cat3.getDescription()+ " Months old");
        cat3Breed.setText("Breed: " + cat3.getBreed());
        cat3Price.setText("Price: " + cat3.getPrice());
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
    void addToCartRyle(ActionEvent event) {
        handleAddToCart(bird1, "Parakeet");
    }

    @FXML
    void addToCartLloyd(ActionEvent event) {
        handleAddToCart(bird2, "Canary");
    }

    @FXML
    void addToCartKen(ActionEvent event) {
        handleAddToCart(bird3, "Macaw");
    }

    @FXML
    void addToCartGolden(ActionEvent event) {
        handleAddToCart(dog1, "Golden Retriever");
    }

    @FXML
    void addToCartChihuahua(ActionEvent event) {
        handleAddToCart(dog2, "Chihuahua");
    }

    @FXML
    void addToCartChow(ActionEvent event) {
        handleAddToCart(dog3, "Chow Chow");
    }

    @FXML
    void addToCartScottish(ActionEvent event) {
        handleAddToCart(cat1, "Scottish");
    }

    @FXML
    void addToCartBritish(ActionEvent event) {
        handleAddToCart(cat2, "British Long Hair");
    }

    @FXML
    void addToCartSokoke(ActionEvent event) {
        handleAddToCart(cat3, "Sokoke");
    }


    @FXML
    void goToCart(ActionEvent event) {
        try {
            // Switch to the CartFrame scene and track the navigation
            new SceneSwitch(PetPane, "CartFrame.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
        void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(PetPane, "mainFrame.fxml");
        }

}
