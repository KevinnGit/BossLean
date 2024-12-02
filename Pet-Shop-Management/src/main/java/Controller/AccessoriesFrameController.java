package Controller;

import Implementation.Accessories;
import Implementation.Cart;
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

public class AccessoriesFrameController {

    Accessories dogcollar1 = new Accessories("Dog Collar(S)",500,10,"Collar For Dogs","Small","Black","20-30cm");
    Accessories dogcollar2 = new Accessories("Dog Collar(M)",700,10,"Collar For Dogs","Medium","Black","30-40cm");
    Accessories dogcollar3 = new Accessories("Dog Collar(L)",1000,10,"Collar For Dogs","Large","Grey","50-60cm");

    Accessories dogleash1 = new Accessories("Dog Leash(S)",300,10,"Leash For Dogs","Small","Red","120cm");
    Accessories dogleash2 = new Accessories("Dog Leash(M)",500,10,"Leash For Dogs","Medium","Red","150-180cm");
    Accessories dogleash3 = new Accessories("Dog Leash(L)",800,10,"Leash For Dogs","Large","Brown","180-200cm");

    Accessories catcollar1 = new Accessories("Cat Collar(S)",200,10,"Collar For Cats","Small","Sky Blue","15-20cm");
    Accessories catcollar2 = new Accessories("Cat Collar(M)",500,10,"Collar For Cats","Medium","Dark Green","20-25cm");
    Accessories catcollar3 = new Accessories("Cat Collar(L)",700,10,"Collar For Cats","Large","Navy Blue","25-30cm");

    Accessories catleash1 = new Accessories("Cat Leash(S)",200,10,"Leash For Cats","Small","Black","120cm");
    Accessories catleash2 = new Accessories("Cat Leash(M)",350,10,"Leash For Cats","Medium","Colorful","150-180cm");
    Accessories catleash3 = new Accessories("Cat Leash(L)",500,10,"Leash For Cats","Large","Orange","300-500cm");


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
    private TextField ccl;

    @FXML
    private TextField ccm;

    @FXML
    private TextField ccs;

    @FXML
    private TextField cll;

    @FXML
    private TextField clm;

    @FXML
    private TextField cls;

    @FXML
    private TextField dcl;

    @FXML
    private TextField dcm;

    @FXML
    private TextField dcs;

    @FXML
    private TextField dll;

    @FXML
    private TextField dlm;

    @FXML
    private TextField dls;



    @FXML
    public void initialize(){

        // Set Label for dig collars
        dogcollar1type.setText("Collar:" + dogcollar1type.getText());
        dogcollar1color.setText("Color: " + dogcollar1color.getText());
        dogcollar1length.setText("Length: " + dogcollar1length.getText());
        dogcollar1price.setText("Price: " + dogcollar1price.getText());
        dcs.setText("Stock: " + dogcollar1.getStockQuantity());

        dogcollar2type.setText("Collar " + dogcollar2type.getText());
        dogcollar2color.setText("Color " + dogcollar2color.getText());
        dogcollar2length.setText("Length " + dogcollar2length.getText());
        dogcollar2price.setText("Price " + dogcollar2price.getText());
        dcm.setText("Stock: " + dogcollar2.getStockQuantity());

        dogcollar3type.setText("Collar " + dogcollar3type.getText());
        dogcollar3color.setText("Color " + dogcollar3color.getText());
        dogcollar3length.setText("Length " + dogcollar3length.getText());
        dogcollar3price.setText("Price " + dogcollar3price.getText());
        dcl.setText("Stock: " + dogcollar3.getStockQuantity());

        //Set label for dog leash
        dogleash1type.setText("Leash " + dogleash1type.getText());
        dogleash1color.setText("Color " + dogleash1color.getText());
        dogleash1length.setText("Length " + dogleash1length.getText());
        dogleash1price.setText("Price " + dogleash1price.getText());
        dls.setText("Stock: " + dogleash1.getStockQuantity());


        dogleash2type.setText("Leash " + dogleash2type.getText());
        dogleash2color.setText("Color " + dogleash2color.getText());
        dogleash2length.setText("Length " + dogleash2length.getText());
        dogleash2price.setText("Price " + dogleash2price.getText());
        dlm.setText("Stock: " + dogleash2.getStockQuantity());


        dogleash3type.setText("Leash " + dogleash3type.getText());
        dogleash3color.setText("Color " + dogleash3color.getText());
        dogleash3length.setText("Length " + dogleash3length.getText());
        dogleash3price.setText("Price " + dogleash3price.getText());
        dll.setText("Stock: " + dogleash3.getStockQuantity());



        // Set Label for cat collars
        catcollar1type.setText("Collar " + catcollar1type.getText());
        catcollar1color.setText("Color " + catcollar1color.getText());
        catcollar1length.setText("Length " + catcollar1length.getText());
        catcollar1price.setText("Price " + catcollar1price.getText());
        ccs.setText("Stock: " + catcollar1.getStockQuantity());


        catcollar2type.setText("Collar " + catcollar2type.getText());
        catcollar2color.setText("Color " + catcollar2color.getText());
        catcollar2length.setText("Length " + catcollar2length.getText());
        catcollar2price.setText("Price " + catcollar2price.getText());
        ccm.setText("Stock: " + catcollar2.getStockQuantity());


        catcollar3type.setText("Collar " + catcollar3type.getText());
        catcollar3color.setText("Color " + catcollar3color.getText());
        catcollar3length.setText("Length " + catcollar3length.getText());
        catcollar3price.setText("Price " + catcollar3price.getText());
        ccl.setText("Stock: " + catcollar3.getStockQuantity());


        // Set Label for cat leash
        catleash1type.setText("Leash " + catleash1type.getText());
        catleash1color.setText("Color " + catleash1color.getText());
        catleash1length.setText("Length " + catleash1length.getText());
        catleash1price.setText("Price " + catleash1price.getText());
        cls.setText("Stock: " + catleash1.getStockQuantity());


        catleash2type.setText("Leash " + catleash2type.getText());
        catleash2color.setText("Color " + catleash2color.getText());
        catleash2length.setText("Length " + catleash2length.getText());
        catleash2price.setText("Price " + catleash2price.getText());
        clm.setText("Stock: " + catleash2.getStockQuantity());


        catleash3type.setText("Leash " + catleash3type.getText());
        catleash3color.setText("Color " + catleash3color.getText());
        catleash3length.setText("Length " + catleash3length.getText());
        catleash3price.setText("Price " + catleash3price.getText());
        cll.setText("Stock: " + catleash3.getStockQuantity());

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
    void AddtoCartCCollarL(ActionEvent event) {
        handleAddToCart(catcollar3, "Cat Collar(L)");
    }

    @FXML
    void AddtoCartCCollarM(ActionEvent event) {
        handleAddToCart(catcollar2, "Cat Collar(M)");
    }

    @FXML
    void AddtoCartCCollarS(ActionEvent event) {
        handleAddToCart(catcollar1, "Cat Collar(S)");
    }

    @FXML
    void AddtoCartCLeashL(ActionEvent event) {
        handleAddToCart(catleash3, "Cat Leash(L)");
    }

    @FXML
    void AddtoCartCLeashM(ActionEvent event) {
        handleAddToCart(catleash2, "Cat Leash(M)");
    }

    @FXML
    void AddtoCartCLeashS(ActionEvent event) {
        handleAddToCart(catleash1, "Cat Leash(S)");
    }

    @FXML
    void AddtoCartDCollarL(ActionEvent event) {
        handleAddToCart(dogcollar3, "Dog Collar(L)");
    }

    @FXML
    void AddtoCartDCollarM(ActionEvent event) {
        handleAddToCart(dogcollar2, "Dog Collar(M)");
    }

    @FXML
    void AddtoCartDCollarS(ActionEvent event) {
        handleAddToCart(dogcollar1, "Dog Collar(S)");
    }

    @FXML
    void AddtoCartDLeashL(ActionEvent event) {
        handleAddToCart(dogleash3, "Dog Leash(L)");
    }

    @FXML
    void AddtoCartDLeashM(ActionEvent event) {
        handleAddToCart(dogleash2, "Dog Leash(M)");
    }

    @FXML
    void AddtoCartDLeashS(ActionEvent event) {
        handleAddToCart(dogleash1, "Dog Leash(S)");
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
