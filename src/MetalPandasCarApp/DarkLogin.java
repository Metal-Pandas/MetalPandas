package MetalPandasCarApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class DarkLogin {
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
    Statement stmt = conn.createStatement();
    String sql = "SELECT * FROM USER";
    ResultSet rs = stmt.executeQuery(sql);
    String Email = "";
    String EnterPass = "";
    while (rs.next()) {
      System.out.println(rs.getString("Email"));
      System.out.println(rs.getString("Password"));
      Email = rs.getString("Email");
      EnterPass = rs.getString("Password");
    }
    String EnterPass1 = PasswordField.getText();
    String Email1 = UsernameField.getText();

    // System.out.println(EnterPass1 + "  - " + Email1);

    if ((Email.equals(Email1)) && (EnterPass.equals(EnterPass1))) {
      try {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("darkHome.fxml"));
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
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkSignUp.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleForgotPasswordAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkForgotPassword.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleForgotEmailAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkForgotEmail.fxml"));
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
