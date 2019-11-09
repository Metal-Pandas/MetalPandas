package MetalPandasCarApp;

import java.io.IOException;
import java.sql.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.h2.command.Prepared;

public class loginController {
  /*----------------------------------------------------------*/
  /* LOGIN PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public Pane loginBackground;

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
  /* LOGIN PAGE */
  /*----------------------------------------------------------*/
  public void handleLoginAction(MouseEvent mouseEvent) throws SQLException {
    /*----------------------------------------------------------*/
    /* Database */
    /*----------------------------------------------------------*/
    Connection conn = DatabaseDriver.initializeDB();
    String getEmail = UsernameField.getText();
    String getPassword = PasswordField.getText();
    String sql = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?";

    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, getEmail);
    pstmt.setString(2, getPassword);
    ResultSet rs = pstmt.executeQuery();

    String dbEmail = "";
    String dbPassword = "";

    while (rs.next()) {
      dbEmail = rs.getString("Email");
      dbPassword = rs.getString("Password");
    }

    if ((getEmail.equals(dbEmail)) && (getPassword.equals(dbPassword))) {
      System.out.println(
          "GetEmail ="
              + getEmail
              + " DB Email  ="
              + dbEmail
              + "  getPass ="
              + getPassword
              + "  dbPass="
              + dbPassword);
      try {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        homeStage.setScene(homePageScene);
        homeStage.show();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Welcome Back!");
    } else {
      Statustxt.setText("Incorrect Email or Password!");
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

  public void initialize() {
    DatabaseDriver.initializeDB();
  }

  /* public void handleDarkThemeAction(MouseEvent mouseEvent) throws IOException {
    Parent darkParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene darkScene = new Scene(darkParent);
    String darkTheme = "darkTheme.css";
    darkScene.getStylesheets().add(darkTheme);
    Stage darkStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    darkStage.setScene(darkScene);
    darkStage.show();
  }
  */
}
