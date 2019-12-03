package MetalPandasCarApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PandaForgotPassword {
  @FXML public AnchorPane forgotPasswordBackground;
  @FXML public Label forgotPassLabel;
  @FXML public TextField forgotPasswordPhoneNumber;
  @FXML public Button passwordConfirm;
  @FXML public Label forgotPassStatus;
  @FXML public Label orLabel;
  @FXML public Label forgotPasswordLabel;
  @FXML public TextField forgotPasswordEmail;
  @FXML public Button passConfirm;
  @FXML public Label forgotPasswordStatus;
  @FXML public Button passBack;
  @FXML public Pane backDrop;

  private ObservableList<Users> userPhone = FXCollections.observableArrayList();
  private ObservableList<Users> userEmail = FXCollections.observableArrayList();

  public void handleConfirmAction(ActionEvent actionEvent) throws SQLException {
    Connection conn = DatabaseDriver.initializeDB();
    String forgotEmail = forgotPasswordEmail.getText();

    String sql = "SELECT * FROM USER WHERE EMAIL = ?";

    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, forgotEmail);

    ResultSet rs = pstmt.executeQuery();

    String dbForgotEmail = "";

    while (rs.next()) {
      dbForgotEmail = rs.getString("email");

    }

    if ((forgotEmail.equals(dbForgotEmail))){
      System.out.println(
          "GetPhoneNumber ="
              + forgotEmail);

      try {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaReset.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        homeStage.setScene(homePageScene);
        homeStage.show();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      Alert a = new Alert(Alert.AlertType.NONE);
      a.setAlertType(Alert.AlertType.WARNING);
      a.setContentText("Incorrect Phone Number!");
      a.show();
    }
    UsersInfo.userProfilesGlobal = DatabaseDriver.getUserInfo(dbForgotEmail);
    userEmail = DatabaseDriver.getUserInfo(dbForgotEmail);
    conn.close();
  }


  public void handlePasswordConfirmAction(ActionEvent actionEvent) throws SQLException {
    Connection conn = DatabaseDriver.initializeDB();
    String phoneNumber = forgotPasswordPhoneNumber.getText();

    String sql = "SELECT * FROM USER WHERE PHONENUMBER = ?";

    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, phoneNumber);

    ResultSet rs = pstmt.executeQuery();

    String dbPhoneNumber = "";

    while (rs.next()) {
      dbPhoneNumber = rs.getString("phoneNumber");

    }

    if ((phoneNumber.equals(dbPhoneNumber))){
      System.out.println(
          "GetPhoneNumber ="
              + phoneNumber);

      try {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaReset.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        homeStage.setScene(homePageScene);
        homeStage.show();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      Alert a = new Alert(Alert.AlertType.NONE);
      a.setAlertType(Alert.AlertType.WARNING);
      a.setContentText("Incorrect Phone Number!");
      a.show();
    }
    UsersInfo.userProfilesGlobal = DatabaseDriver.getUserInfo(dbPhoneNumber);
    userPhone = DatabaseDriver.getUserInfo(dbPhoneNumber);
    conn.close();
  }

  public void handleBackAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
