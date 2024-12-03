package Controller;

import Implementation.Cart;
import Implementation.CartItem;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static Implementation.DBConnector.*;

public class CartFrameController {

    @FXML
    private AnchorPane CartPane;

    @FXML
    private TableColumn<CartItem, String> Product;

    @FXML
    private TableColumn<CartItem, Integer> Quantity;

    @FXML
    private TableColumn<CartItem, String> Price; // Change to String for formatted price

    @FXML
    private Label Total;

    @FXML
    private TableView<CartItem> cartTable;

    private ObservableList<CartItem> cartData;

    public void initialize() {
        cartData = FXCollections.observableArrayList();

        // Bind the TableView columns to the appropriate properties in CartItem
        Product.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        Quantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        // Format price as a String and prevent scientific notation
        Price.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(String.format("%.2f", cellData.getValue().getTotalPrice()))
        );

        updateCartTable();
    }

    private void updateCartTable() {
        cartData.clear();
        Cart cart = Cart.getInstance();
        cartData.addAll(cart.getCartItems());
        cartTable.setItems(cartData);

        // Update the total amount label with formatted value
        Total.setText("₱" + String.format("%.2f", cart.calculateTotal()));
    }

    @FXML
    void goToHome(ActionEvent event) {
        try {
            // Go back to the previous scene
            SceneSwitch.goBackToPreviousScene(CartPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goToCustomerDetails(ActionEvent event) {
        Cart cart = Cart.getInstance();
        double total = cart.calculateTotal();


        if (total == 0.0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cannot Checkout");
            alert.setContentText("You cannot checkout since you haven't bought anything.");
            alert.showAndWait();
        } else {
        try {
            new SceneSwitch(CartPane, "CustomerFrame.fxml", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

    @FXML
    void removeItem(ActionEvent event) {
        // Get the selected item from the table
        CartItem selectedItem = cartTable.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // Show a confirmation alert
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirm Deletion");
            confirmationAlert.setHeaderText("Are you sure you want to remove this item?");
            confirmationAlert.setContentText("Product: " + selectedItem.getProduct().getName());

            String productName = selectedItem.getProduct().getName();
            int quantity = selectedItem.getQuantity();

            // Wait for the user's response
            confirmationAlert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    // Remove the item from the Cart singleton
                    Cart cart = Cart.getInstance();
                    cart.removeCartItem(selectedItem);
                    undostock(productName, quantity);


                    updateCartTable();
                }
            });
        } else {
            // Show an alert if no item is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No Item Selected");
            alert.setContentText("Please select an item to remove.");
            alert.showAndWait();
        }
    }


    @FXML
    void clearCart(ActionEvent event) {
        // Show a confirmation alert
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirm Clear Cart");
        confirmationAlert.setHeaderText("Are you sure you want to clear the cart?");
        confirmationAlert.setContentText("This will remove all items from your cart.");

        // Wait for the user's response
        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.OK) {
                // Clear the cart in the Cart singleton
                Cart cart = Cart.getInstance();
                cart.clear();

                ObservableList<CartItem> items = cartTable.getItems();
                for (CartItem item : items) {
                    String productName = item.getProduct().getName();
                    int quantity = item.getQuantity();
                    undostock(productName, quantity);
                }
                cartData.clear();




                // Update the total price display
                Total.setText("₱0.00");
            }
        });
    }
    public void clearCartData() {
        Cart cart = Cart.getInstance();
        cart.clear();
    }
    private void undostock(String product, int quantity) {
        //birds
        if(product.equals("Parakeet")) {
            product = "Parakeet";
            AddStockByBreedName(product, quantity);
        }
        else if(product.equals("Canary")) {
            product = "Canary";
            AddStockByBreedName(product, quantity);
        }
        else if(product.equals("Macaw")) {
            product = "Macaw";
            AddStockByBreedName(product, quantity);
        }

        //dogs
        else if(product.equals("Golden Retriever")) {
            product = "Golden Retriever";
            AddStockByBreedName(product, quantity);
        }
        else if(product.equals("Chihuahua")) {
            product = "Chihuahua";
            AddStockByBreedName(product, quantity);
        }
        else if(product.equals("Chow Chow")) {
            product = "Chow Chow";
            AddStockByBreedName(product, quantity);
        }

        //cats
        else if(product.equals("Scottish Fold")) {
            product = "Scottish Fold";
            AddStockByBreedName(product, quantity);
        }
        else if(product.equals("British Long Hair")) {
            product = "British Long Hair";
            AddStockByBreedName(product, quantity);
        }
        else if(product.equals("Sokoke")) {
            product = "Sokoke";
            AddStockByBreedName(product, quantity);
        }

        //bird food
        else if(product.equals("VitaCraft")) {
            product = "VitaCraft";
            AddStockByPetFoodName(product, quantity);
        }
        else if(product.equals("Kaytee")) {
            product = "Kaytee";
            AddStockByPetFoodName(product, quantity);
        }
        else if(product.equals("Nut N' Berry")) {
            product = "Nut N' Berry";
            AddStockByPetFoodName(product, quantity);
        }

        //dog food
        else if(product.equals("Pedigree")) {
            product = "Pedigree";
            AddStockByPetFoodName(product, quantity);
        }
        else if(product.equals("Kibble n' Bits")) {
            product = "Kibble n' Bits";
            AddStockByPetFoodName(product, quantity);
        }
        else if(product.equals("Boss Dogs")) {
            product = "Boss Dogs";
            AddStockByPetFoodName(product, quantity);
        }

        //cat food
        else if(product.equals("Goodest")) {
            product = "Goodest";
            AddStockByPetFoodName(product, quantity);
        }
        else if(product.equals("Whiskas")) {
            product = "Whiskas";
            AddStockByPetFoodName(product, quantity);
        }
        else if(product.equals("Pro Plan")) {
            product = "Pro Plan";
            AddStockByPetFoodName(product, quantity);
        }

        //dog collar
        else if(product.equals("Dog Collar(S)")) {
            product = "Dog Collar(S)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Dog Collar(M)")) {
            product = "Dog Collar(M)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Dog Collar(L)")) {
            product = "Dog Collar(L)";
            AddStockByAccessoriesName(product, quantity);
        }

        //dog leash
        else if(product.equals("Dog Leash(S)")) {
            product = "Dog Leash(S)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Dog Leash(M)")) {
            product = "Dog Leash(M)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Dog Leash(L)")) {
            product = "Dog Leash(L)";
            AddStockByAccessoriesName(product, quantity);
        }

        //cat collar
        else if(product.equals("Cat Collar(S)")) {
            product = "Cat Collar(S)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Cat Collar(M)")) {
            product = "Cat Collar(M)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Cat Collar(L)")) {
            product = "Cat Collar(L)";
            AddStockByAccessoriesName(product, quantity);
        }

        //cat leash
        else if(product.equals("Cat Leash(S)")) {
            product = "Cat Leash(S)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Cat Leash(M)")) {
            product = "Cat Leash(M)";
            AddStockByAccessoriesName(product, quantity);
        }
        else if(product.equals("Cat Leash(L)")) {
            product = "Cat Leash(L)";
            AddStockByAccessoriesName(product, quantity);
        }

    }
}
