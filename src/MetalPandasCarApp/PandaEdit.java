package MetalPandasCarApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class PandaEdit {
  @FXML public AnchorPane editBackground;
  @FXML public ImageView profileImage;
  @FXML public Button editButton;
  @FXML public TextField firstName;
  @FXML public TextField lastName;
  @FXML public TextField emailAddress;
  @FXML public TextField phoneNumber;
  @FXML public TextField street;
  @FXML public TextField state;
  @FXML public TextField city;
  @FXML public TextField zipCode;
  @FXML public TextField country;
  @FXML public PasswordField password;
  @FXML public PasswordField reenterPassword;
  @FXML public Pane backDrop;
  @FXML public Label driverPassLabel;
  @FXML public Label genderLabel;
  @FXML public ComboBox<String> driverPassenger;
  @FXML public ComboBox<String> gender;
  @FXML public Button update;

  public void handleEditAction(ActionEvent actionEvent) {
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    FileChooser chooseImage = new FileChooser();
    chooseImage.setTitle("Open Image");

    // Set to user's directory or go to the default C drive if cannot access
    String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
    File userDirectory = new File(userDirectoryString);

    if (!userDirectory.canRead()) {
      userDirectory = new File("C:/");
    } else {
      chooseImage.setInitialDirectory(userDirectory);
    }

    File filePath = chooseImage.showOpenDialog(stage);

    // Try to update the image by loading the new image
    try {
      BufferedImage bufferedImage = ImageIO.read(filePath);

      Image image = SwingFXUtils.toFXImage(bufferedImage, null);

      profileImage.setImage(image);
    } catch (IOException e) {

      System.out.println(e.getMessage());
    }
  }

  public void handleUpdateAction(ActionEvent actionEvent) throws IOException, SQLException {
      Users currentUser = UsersInfo.userProfilesGlobal.get(0);

      Connection conn = DatabaseDriver.initializeDB();
      String sql =
          "UPDATE USER SET FIRSTNAME=?, LASTNAME=?, EMAIL=?, PHONENUMBER=?, ADDRESS=?,"
              + "CITY=?, STATE=?, ZIP=?, COUNTRY=?, PASSWORD=?, REPASSWORD=?,"
              + "GENDER=?, PERSONTYPE=? WHERE EMAIL= '" + currentUser.getMail()+ "'";

      PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, firstName.getText());
        pstmt.setString(2, lastName.getText());
        pstmt.setString(3, emailAddress.getText());
        pstmt.setString(4, phoneNumber.getText());
        pstmt.setString(5, street.getText());
        pstmt.setString(6, city.getText());
        pstmt.setString(7, state.getText());
        pstmt.setString(8, zipCode.getText());
        pstmt.setString(9, country.getText());
        pstmt.setString(10, password.getText());
        pstmt.setString(11, reenterPassword.getText());
        pstmt.setString(13, driverPassenger.getValue());
        pstmt.setString(12, gender.getValue());
        pstmt.executeUpdate();

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Information Dialog");
      alert.setHeaderText("User details has been updated");
      alert.showAndWait();

    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();

  }

  public void initialize() {
    try {
      driverPassenger.setItems(FXCollections.observableArrayList("Driver", "Passenger"));
      gender.setItems(
          FXCollections.observableArrayList("Female", "Male", "Non-binary", "Metal Panda"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
