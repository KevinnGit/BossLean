package finalprjct.petshopmanagementsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitch {

    private static String previousScene = null; // Store the previous scene name
    private static String currentScene = null;  // Store the current scene name

    // Constructor to load the scene and switch the current scene
    public SceneSwitch(AnchorPane rootPane, String fxml) throws IOException {
        // Track the previous and current scene before switching
        previousScene = currentScene;  // Save the current scene as the previous scene
        currentScene = fxml;           // Set the new scene as the current scene

        // Load the new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent newScene = loader.load();

        // Switch the scene on the current stage
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setScene(new Scene(newScene));
        stage.show();
    }

    // Method to go back to the previous scene
    public static void goBackToPreviousScene(AnchorPane rootPane) throws IOException {
        if (previousScene != null && !previousScene.isEmpty()) {
            // Switch to the previous scene
            new SceneSwitch(rootPane, previousScene);
        } else {
            // Default to mainFrame.fxml if no previous scene exists
            new SceneSwitch(rootPane, "mainFrame.fxml");
        }
    }

    // Getter for the current scene (optional)
    public static String getCurrentScene() {
        return currentScene;
    }
}
