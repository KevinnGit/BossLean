package Controller;
import javafx.print.*;
import Implementation.*;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import java.io.*;
import java.text.DecimalFormat;

import static Implementation.DBConnector.AddSales;


public class CustomerFrameController {

    @FXML
    private TextField Address;

    @FXML
    private TextField ConNum;

    @FXML
    private AnchorPane CustomerPane;

    @FXML
    private TextField Fname;

    @FXML
    private TextField Lname;

    @FXML
    private TextField Mname;

    @FXML
    private AnchorPane Receipt;

    @FXML
    private TextArea TextReceipt;

    @FXML
    private RadioButton radioB;

    @FXML
    private RadioButton radioC;

    @FXML
    private RadioButton radioCOD;

    private ToggleGroup paymentGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        radioB.setToggleGroup(paymentGroup);
        radioC.setToggleGroup(paymentGroup);
        radioCOD.setToggleGroup(paymentGroup);
    }

    @FXML
    void PrintReceipt(ActionEvent event) {
        Cart cart = Cart.getInstance();
        String firstName = Fname.getText(), lastName = Lname.getText(),
                middleName = Mname.getText(), address = Address.getText(),
                contactNumber = ConNum.getText();

        if (!validateCustomerDetails(firstName, lastName, middleName, contactNumber, address)) return;


        StringBuilder receiptText = generateReceiptText(firstName, lastName, middleName, address, contactNumber);


        TextReceipt.setText(receiptText.toString());

        // Printing
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(null)) {
            WritableImage snapshot = Receipt.snapshot(null, null);
            double scale = Math.min(printerJob.getJobSettings().getPageLayout().getPrintableWidth() / snapshot.getWidth(),
                    printerJob.getJobSettings().getPageLayout().getPrintableHeight() / snapshot.getHeight());

            ImageView imageView = new ImageView(snapshot);
            imageView.setFitWidth(snapshot.getWidth() * scale);
            imageView.setFitHeight(snapshot.getHeight() * scale);
            imageView.setPreserveRatio(true);

            if (printerJob.printPage(imageView)) {
                printerJob.endJob();
            } else {
                System.out.println("Failed to print the receipt.");
            }
        }
        cart.getCartItems().forEach(cartItem -> {
            String product = cartItem.getProduct().getName();
            int quantity = cartItem.getQuantity();
            double price = cartItem.getTotalPrice();
            double grossIncome = quantity * price;
            String saleDate = java.time.LocalDate.now().toString();


            boolean result = AddSales(product, quantity, grossIncome, saleDate);

            if (result) {
                System.out.println("Successfully added to sales: " + product);
            } else {
                System.out.println("Failed to add to sales: " + product);
            }
        });
        CartFrameController cartController = new CartFrameController();
        cartController.clearCartData();
    }

    @FXML
    void ViewReceipt(ActionEvent event) {
        String firstName = Fname.getText();
        String lastName = Lname.getText();
        String middleName = Mname.getText();
        String address = Address.getText();
        String contactNumber = ConNum.getText();

        if (!validateCustomerDetails(firstName, lastName, middleName, contactNumber, address)) {
            return;
        }

        // Generate receipt text
        StringBuilder receiptText = generateReceiptText(firstName, lastName, middleName, address, contactNumber);


        TextReceipt.setText(receiptText.toString());
    }

    @FXML
    private void goToHome(ActionEvent event) {
        try {
            new SceneSwitch(CustomerPane, "CartFrame.fxml",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean validateCustomerDetails(String firstName, String lastName, String middleName, String contactNumber, String address) {
        String nameRegex = "^[a-zA-Z]+( [a-zA-Z]+)*$";
        String phoneRegex = "^[0-9]+$";

        if (firstName.isEmpty() || lastName.isEmpty() || middleName.isEmpty()) {
            showError("Error", "First Name, Last Name, and Middle Name cannot be empty!");
            return false;
        }

        if (!firstName.matches(nameRegex) || !lastName.matches(nameRegex) || !middleName.matches(nameRegex)) {
            showError("Error", "Names must contain only letters!");
            return false;
        }

        if (!contactNumber.matches(phoneRegex)) {
            showError("Error", "Contact number must contain only numbers!");
            return false;
        }

        if (address.isEmpty()) {
            showError("Error", "Address cannot be empty!");
            return false;
        }

        return true;
    }

    private StringBuilder generateReceiptText(String firstName, String lastName, String middleName, String address, String contactNumber) {
        StringBuilder receiptText = new StringBuilder();


        Cart cart = Cart.getInstance();
        double totalPrice = cart.calculateTotal();


        DecimalFormat df = new DecimalFormat("#.00");
        String formattedTotalPrice = df.format(totalPrice);


        receiptText.append("Customer Details:\n")
                .append("Name: ").append(firstName).append(" ").append(middleName).append(" ").append(lastName).append("\n")
                .append("Address: ").append(address).append("\n")
                .append("Contact: ").append(contactNumber).append("\n\n");


        receiptText.append("Payment Method: ")
                .append(radioB.isSelected() ? "Credit" : radioC.isSelected() ? "Cash" : "Cash on Delivery")
                .append("\n\nProducts Purchased:\n");


        cart.getCartItems().forEach(cartItem -> receiptText.append(cartItem.getProduct().getName())
                .append(" - Quantity: ").append(cartItem.getQuantity())
                .append(" - Price: $").append(cartItem.getProduct().getPrice())
                .append("\n"));


        receiptText.append("\nTotal Price: $").append(formattedTotalPrice);

        return receiptText;
    }

}
