package Controller;

import Implementation.Animals;
import Implementation.Cart;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import finalprjct.petshopmanagementsystem.mainFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.util.Optional;

public class PetFrameController {

    Animals bird1 = new Animals("Parakeet", 100000, 5, "green with yellow, with black stripes", 2, "Parakeet");
    Animals bird2 = new Animals("Canary", 500000, 10, "Yellow with a touch of black", 5, "Canary");
    Animals bird3 = new Animals("Macaw", 1000000, 2, "green forehead, fading into a teal blue", 1, "Macaw");

    Animals dog1 = new Animals("Golden Retriever", 15000, 5, "Light golden", 11, "Golden Retriever" );
    Animals dog2 = new Animals("Chihuahua", 20000, 5, "Brownish Cream", 1, "Chihuahua");
    Animals dog3 = new Animals("Chow Chow", 300000, 5, "White Cream", 6, "Chow Chow");

    Animals cat1 = new Animals("Scottish Fold", 1000000, 5, "Orange", 6, "Scottish Fold");
    Animals cat2 = new Animals("British Long Hair", 150000, 4, "Grey", 1, "British Long Hair");
    Animals cat3 = new Animals("Sokoke", 50000, 4, "Orange with red stripes", 8, "Sokoke");


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

    @FXML
    void addToCartRyle(ActionEvent event) {
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
                    cart.addProduct(bird1, quantity);
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
    void addToCartKen(ActionEvent event) {
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
                    cart.addProduct(bird3, quantity);
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
    void addToCartLloyd(ActionEvent event) {
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
                    cart.addProduct(bird2, quantity);
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
    void addToCartGolden(ActionEvent event) {
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
                    cart.addProduct(dog1, quantity);
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
    void addToCartChihuahua(ActionEvent event) {
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
                    cart.addProduct(dog2, quantity);
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
    void addToCartChow(ActionEvent event) {
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
                    cart.addProduct(dog3, quantity);
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
    void addToCartScottish(ActionEvent event) {
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
                    cart.addProduct(cat1, quantity);
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
    void addToCartBritish(ActionEvent event) {
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
                    cart.addProduct(cat2, quantity);
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
    void addToCartSokoke(ActionEvent event) {
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
                    cart.addProduct(cat3, quantity);
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
    void goToCart(ActionEvent event) throws IOException  {
        new SceneSwitch(PetPane, "CartFrame.fxml");

    }

    @FXML
        void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(PetPane, "mainFrame.fxml");
        }
}
