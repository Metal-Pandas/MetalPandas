package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.event.RowSorterEvent;
import java.io.IOException;

public class SceneViewer extends Controller{
    // Login Page Fields
    public static TextField UsernameField;
    public static TextField PasswordField;
    public static Text Statustxt;
    public static ActionEvent event;

    public static void SwitchView(String name) throws IOException {
        if (UsernameField.getText().equals("jsmith@abc.com")
        && PasswordField.getText().equals("password")) {

      Parent homePageParent = FXMLLoader.load(SceneViewer.class.getResource(name));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }
    if (!UsernameField.getText().equals("jsmith@abc.com")
        || !PasswordField.getText().equals("password")) {
      Statustxt.setText("Email/Password incorrect. Don't have an account? Sign up now.");
    }

    Parent homePageParent = FXMLLoader.load(SceneViewer.class.getResource(name));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
