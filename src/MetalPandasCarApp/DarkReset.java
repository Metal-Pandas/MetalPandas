package MetalPandasCarApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DarkReset {
  @FXML public AnchorPane resetBackground;
  @FXML public Button confirmButton;
  @FXML public PasswordField password;
  @FXML public PasswordField reenterPassword;
  @FXML public Text resetPasswordLabel;
  @FXML public Pane backDrop;

  public void handleConfirmAction(ActionEvent actionEvent) throws IOException, SQLException {
    Users currentUser = UsersInfo.userProfilesGlobal.get(0);

    Connection conn = DatabaseDriver.initializeDB();
    String sql =
        "UPDATE USER SET PASSWORD = ? WHERE PASSWORD= '"
            + currentUser.getPassword()
            + "'";

    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1, password.getText());

    pstmt.executeUpdate();

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("Your password has been updated");
    alert.showAndWait();

    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
