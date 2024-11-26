package Controller;

import Implementation.Cart;
import Implementation.CartItem;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
        try {
            new SceneSwitch(CartPane, "CustomerFrame.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
