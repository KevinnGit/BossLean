package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminLogInController {

    @FXML
    private AnchorPane logInPane;

    @FXML
    private TextField passwordShowField;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField userField;

    @FXML
    private CheckBox showPassword;


    //Ano rani placeholder

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "admin";

    @FXML
    void goToAdmin(ActionEvent event) throws IOException {
        if (userField.getText().equals(CORRECT_USERNAME) && passField.getText().equals(CORRECT_PASSWORD)) {
            new SceneSwitch(logInPane, "adminMenu.fxml",true);
        } else {
            showErrorAlert("Invalid username or password. Please try again.");
        }
    }

    @FXML
    void showPass(ActionEvent event) {
        if (showPassword.isSelected()) {
            passwordShowField.setText(passField.getText());
            passwordShowField.setVisible(true);
            passField.setVisible(false);
        } else {
            passField.setText(passwordShowField.getText());
            passField.setVisible(true);
            passwordShowField.setVisible(false);
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText("Incorrect Login Information");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
