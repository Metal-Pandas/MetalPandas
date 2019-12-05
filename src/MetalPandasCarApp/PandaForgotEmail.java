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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PandaForgotEmail {
  @FXML public AnchorPane forgotEmailBackground;
  @FXML public TextField forgotPhoneNumber;
  @FXML public Label forgotEmailLabel;
  @FXML public Button confirm;
  @FXML public Button back;
  @FXML public Label forgotEmailStatus;
  @FXML public Pane backDrop;

  private ObservableList<Users> userPhone = FXCollections.observableArrayList();


  public void handleConfirmAction(ActionEvent actionEvent) throws SQLException, IOException {
    Connection conn = DatabaseDriver.initializeDB();
    String phoneNumber = forgotPhoneNumber.getText();

    String sql = "SELECT * FROM USER WHERE PHONENUMBER = ?";

    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, phoneNumber);

    ResultSet rs = pstmt.executeQuery();

    String dbPhoneNumber = "";

    while (rs.next()) {
      dbPhoneNumber = rs.getString("phoneNumber");

    }

    if ((phoneNumber.equals(dbPhoneNumber))) {
      System.out.println("GetPhoneNumber =" + phoneNumber);
      Alert a = new Alert(Alert.AlertType.NONE);
      a.setAlertType(AlertType.INFORMATION);
      a.setContentText("Text has been sent!");
      a.show();

      Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
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
