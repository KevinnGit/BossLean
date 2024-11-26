package Controller;

import Implementation.Accessories;
import Implementation.Cart;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class AccessoriesFrameController {

    Accessories dogcollar1 = new Accessories("Collar",500,10,"Collar For Dogs","Small","Black","20-30cm");
    Accessories dogcollar2 = new Accessories("Collar",700,10,"Collar For Dogs","Medium","Black","30-40cm");
    Accessories dogcollar3 = new Accessories("Collar",1000,10,"Collar For Dogs","Large","Grey","50-60cm");

    Accessories dogleash1 = new Accessories("Leash",300,10,"Leash For Dogs","Small","Red","120cm");
    Accessories dogleash2 = new Accessories("Collar",500,10,"Leash For Dogs","Medium","Red","150-180cm");
    Accessories dogleash3 = new Accessories("Collar",800,10,"Leash For Dogs","Large","Brown","180-200cm");

    Accessories catcollar1 = new Accessories("Collar",200,10,"Collar For Cats","Small","Sky Blue","15-20cm");
    Accessories catcollar2 = new Accessories("Collar",500,10,"Collar For Cats","Medium","Dark Green","20-25cm");
    Accessories catcollar3 = new Accessories("Collar",700,10,"Collar For Cats","Large","Navy Blue","25-30cm");

    Accessories catleash1 = new Accessories("Collar",200,10,"Leash For Cats","Small","Black","120cm");
    Accessories catleash2 = new Accessories("Collar",350,10,"Leash For Cats","Medium","Colorful","150-180cm");
    Accessories catleash3 = new Accessories("Collar",500,10,"Leash For Cats","Large","Orange","300-500cm");


    @FXML
    private AnchorPane AccessoriesPane;

    @FXML
    private Label catcollar1color;

    @FXML
    private Label catcollar1length;

    @FXML
    private Label catcollar1price;

    @FXML
    private Label catcollar1type;

    @FXML
    private Label catcollar2color;

    @FXML
    private Label catcollar2length;

    @FXML
    private Label catcollar2price;

    @FXML
    private Label catcollar2type;

    @FXML
    private Label catcollar3color;

    @FXML
    private Label catcollar3length;

    @FXML
    private Label catcollar3price;

    @FXML
    private Label catcollar3type;

    @FXML
    private Label catleash1color;

    @FXML
    private Label catleash1length;

    @FXML
    private Label catleash1price;

    @FXML
    private Label catleash1type;

    @FXML
    private Label catleash2color;

    @FXML
    private Label catleash2length;

    @FXML
    private Label catleash2price;

    @FXML
    private Label catleash2type;

    @FXML
    private Label catleash3color;

    @FXML
    private Label catleash3length;

    @FXML
    private Label catleash3price;

    @FXML
    private Label catleash3type;

    @FXML
    private Label dogcollar1color;

    @FXML
    private Label dogcollar1length;

    @FXML
    private Label dogcollar1price;

    @FXML
    private Label dogcollar1type;

    @FXML
    private Label dogcollar2color;

    @FXML
    private Label dogcollar2length;

    @FXML
    private Label dogcollar2price;

    @FXML
    private Label dogcollar2type;

    @FXML
    private Label dogcollar3color;

    @FXML
    private Label dogcollar3length;

    @FXML
    private Label dogcollar3price;

    @FXML
    private Label dogcollar3type;

    @FXML
    private Label dogleash1color;

    @FXML
    private Label dogleash1length;

    @FXML
    private Label dogleash1price;

    @FXML
    private Label dogleash1type;

    @FXML
    private Label dogleash2color;

    @FXML
    private Label dogleash2length;

    @FXML
    private Label dogleash2price;

    @FXML
    private Label dogleash2type;

    @FXML
    private Label dogleash3color;

    @FXML
    private Label dogleash3length;

    @FXML
    private Label dogleash3price;

    @FXML
    private Label dogleash3type;


    @FXML
    public void initialize(){

        // Set Label for dig collars
        dogcollar1type.setText("Collar " + dogcollar1type.getText());
        dogcollar1color.setText("Collar " + dogcollar1color.getText());
        dogcollar1length.setText("Collar " + dogcollar1length.getText());
        dogcollar1price.setText("Collar " + dogcollar1price.getText());

        dogcollar2type.setText("Collar " + dogcollar2type.getText());
        dogcollar2color.setText("Collar " + dogcollar2color.getText());
        dogcollar2length.setText("Collar " + dogcollar2length.getText());
        dogcollar2price.setText("Collar " + dogcollar2price.getText());

        dogcollar3type.setText("Collar " + dogcollar3type.getText());
        dogcollar3color.setText("Collar " + dogcollar3color.getText());
        dogcollar3length.setText("Collar " + dogcollar3length.getText());
        dogcollar3price.setText("Collar " + dogcollar3price.getText());

        //Set label for dog leash
        dogleash1type.setText("Leash " + dogleash1type.getText());
        dogleash1color.setText("Leash " + dogleash1color.getText());
        dogleash1length.setText("Leash " + dogleash1length.getText());
        dogleash1price.setText("Leash " + dogleash1price.getText());

        dogleash2type.setText("Leash " + dogleash2type.getText());
        dogleash2color.setText("Leash " + dogleash2color.getText());
        dogleash2length.setText("Leash " + dogleash2length.getText());
        dogleash2price.setText("Leash " + dogleash2price.getText());

        dogleash3type.setText("Leash " + dogleash3type.getText());
        dogleash3color.setText("Leash " + dogleash3color.getText());
        dogleash3length.setText("Leash " + dogleash3length.getText());
        dogleash3price.setText("Leash " + dogleash3price.getText());


        // Set Label for cat collars
        catcollar1type.setText("Collar " + catcollar1type.getText());
        catcollar1color.setText("Collar " + catcollar1color.getText());
        catcollar1length.setText("Collar " + catcollar1length.getText());
        catcollar1price.setText("Collar " + catcollar1price.getText());

        catcollar2type.setText("Collar " + catcollar2type.getText());
        catcollar2color.setText("Collar " + catcollar2color.getText());
        catcollar2length.setText("Collar " + catcollar2length.getText());
        catcollar2price.setText("Collar " + catcollar2price.getText());

        catcollar3type.setText("Collar " + catcollar3type.getText());
        catcollar3color.setText("Collar " + catcollar3color.getText());
        catcollar3length.setText("Collar " + catcollar3length.getText());
        catcollar3price.setText("Collar " + catcollar3price.getText());

        // Set Label for cat leash
        catleash1type.setText("Leash " + catleash1type.getText());
        catleash1color.setText("Leash " + catleash1color.getText());
        catleash1length.setText("Leash " + catleash1length.getText());
        catleash1price.setText("Leash " + catleash1price.getText());

        catleash2type.setText("Leash " + catleash2type.getText());
        catleash2color.setText("Leash " + catleash2color.getText());
        catleash2length.setText("Leash " + catleash2length.getText());
        catleash2price.setText("Leash " + catleash2price.getText());

        catleash3type.setText("Leash " + catleash3type.getText());
        catleash3color.setText("Leash " + catleash3color.getText());
        catleash3length.setText("Leash " + catleash3length.getText());
        catleash3price.setText("Leash " + catleash3price.getText());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Information type alert
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(message);
        alert.showAndWait(); // Show the alert and wait for user acknowledgment
    }

    @FXML
    void AddtoCartDCollarS(ActionEvent event) {
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
                    cart.addProduct(dogcollar1, quantity);
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
    void AddtoCartDCollarM(ActionEvent event) {
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
                    cart.addProduct(dogcollar2, quantity);
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
        new SceneSwitch(AccessoriesPane, "CartFrame.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        new SceneSwitch(AccessoriesPane, "mainFrame.fxml");
    }


}
