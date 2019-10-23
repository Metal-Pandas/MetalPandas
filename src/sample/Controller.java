package sample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

// this is a test
public class Controller {
  /*----------------------------------------------------------*/
  /* LOGIN PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public Pane Backdrop;

  @FXML public ImageView Title;

  @FXML public Text Username;

  @FXML public TextField UsernameField;

  @FXML public Text forgotEmail;

  @FXML public Text Password;

  @FXML public TextField PasswordField;

  @FXML public Text forgotPassword;

  @FXML public Button loginButton;

  @FXML public Button signUp;

  @FXML public Text Statustxt;

  /*----------------------------------------------------------*/
  /* Database */
  /*----------------------------------------------------------*/
    private Connection conn;
  /*----------------------------------------------------------*/
  /* LOGIN PAGE */
  /*----------------------------------------------------------*/
  public void handleLoginAction(MouseEvent mouseEvent) throws IOException {
    if (UsernameField.getText().equals("jsmith@abc.com")
        && PasswordField.getText().equals("password")) {

      Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }
    if (!UsernameField.getText().equals("jsmith@abc.com")
        || !PasswordField.getText().equals("password")) {
      Statustxt.setText("Email/Password incorrect. Don't have an account? Sign up now.");
    }
  }

  public void handleSignUpAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("signupPage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleForgotPasswordAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("forgotPasswordPage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleForgotEmailAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("forgotEmailPage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
  public void initialize(){
    DatabaseDriver.initializeDB();
  }

}
