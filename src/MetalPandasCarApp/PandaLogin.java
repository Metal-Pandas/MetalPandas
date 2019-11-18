package MetalPandasCarApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PandaLogin {
  @FXML public AnchorPane loginBackground;
  @FXML public ImageView logo;
  @FXML public Label loginEmailLabel;
  @FXML public TextField loginEmail;
  @FXML public Text forgotEmail;
  @FXML public Label loginPasswordLabel;
  @FXML public PasswordField loginPassword;
  @FXML public Text forgotPassword;
  @FXML public Button login;
  @FXML public Button signUp;
  @FXML public Label statusText;
  @FXML public Pane backDrop;

  public void handleForgotEmailAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaForgotEmail.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleForgotPasswordAction(MouseEvent mouseEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaForgotPassword.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLoginAction(ActionEvent actionEvent) throws IOException {

    /*----------------------------------------------------------*/
    /* Database */
    /*---------
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

    ---------*/

    if(loginEmail.getText().equals("jsmith@abc.com") && loginPassword.getText().equals("password")){
      Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaHome.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }

    if(!loginEmail.getText().equals("jsmith@abc.com") || loginPassword.getText().equals("password")){
      statusText.setText("Incorrect Email/Password. Don't \nhave an account? Sign up!");
    }
  }

  public void handleSignUpAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaSignUp.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
