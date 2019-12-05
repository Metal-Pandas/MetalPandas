package MetalPandasCarApp;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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

  private ObservableList<Users> userList = FXCollections.observableArrayList();

  public void handleLoginAction(ActionEvent actionEvent) throws SQLException {
    if(loginEmail.getText().equals("") || loginPassword.getText().equals("")){
      Alert a = new Alert(Alert.AlertType.NONE);
      a.setAlertType(Alert.AlertType.WARNING);
      a.setContentText("Incorrect Email/Password. Don't have an account? Sign up!");
      a.show();
    }else{
      Connection conn = DatabaseDriver.initializeDB();
      String getEmail = loginEmail.getText();
      String getPassword = loginPassword.getText();
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
          Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaHome.fxml"));
          Scene homePageScene = new Scene(homePageParent);
          Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
          homeStage.setScene(homePageScene);
          homeStage.show();
        } catch (IOException e) {
          e.printStackTrace();
        }
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(AlertType.INFORMATION);
        a.setContentText("Welcome Back!");
        a.show();
      }
      UsersInfo.userProfilesGlobal = DatabaseDriver.getUserInfo(dbEmail);
      userList = DatabaseDriver.getUserInfo(dbEmail);
      conn.close();
    }
  }

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

  public void handleSignUpAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaSignUp.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

}
