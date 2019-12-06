package MetalPandasCarApp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PandaDriverProfile implements Initializable {
  @FXML public SplitPane profileBackground;
  @FXML public VBox drawer;
  @FXML public HBox hBox;
  @FXML public ToolBar toolBar;
  @FXML public Button menuButton;
  @FXML public ToggleButton lightMode;
  @FXML public ToggleButton pandaMode;
  @FXML public Pane backDrop;
  @FXML public Label firstNameLabel;
  @FXML public Label lastNameLabel;
  @FXML public Label emailLabel;
  @FXML public Label phoneNumberLabel;
  @FXML public Label addressLabel;
  @FXML public Label birthdayLabel;
  @FXML public Label genderLabel;
  @FXML public Label modeLabel;
  @FXML public Label ratingLabel;
  @FXML public TextField firstName;
  @FXML public TextField lastName;
  @FXML public TextField emailAddress;
  @FXML public TextField phoneNumber;
  @FXML public TextField address;
  @FXML public TextField birthday;
  @FXML public TextField gender;
  @FXML public TextField mode;
  @FXML public TextField rating;
  @FXML public Button profileUpdate;
  @FXML public ImageView profileImage;
  @FXML public Button homeButton;
  @FXML public Button favouritesButton;
  @FXML public Button logoutButton;
  @FXML public Button schedules;
  @FXML public Button carInformation;
  @FXML public Button scheduleButton;

  /**
   * setProfilePage passes an ArrayList of Users called user. setText from database to text fields
   * of profileController. calls the first index in db. userList should only be at ZERO!
   *
   * @param user an arrayList that holds Users.
   */
  private void setProfilePage(ObservableList<Users> user) {
    firstName.setText(user.get(0).getFirstName());
    lastName.setText(user.get(0).getLastName());
    emailAddress.setText(user.get(0).getMail());
    phoneNumber.setText(user.get(0).getPhoneNumber());
    address.setText(
        user.get(0).getAddress()
            + " "
            + user.get(0).getCity()
            + ","
            + " "
            + user.get(0).getState()
            + " "
            + user.get(0).getZip());
    birthday.setText(
        user.get(0).getMonth() + " / " + user.get(0).getDay() + " / " + user.get(0).getYear());
    gender.setText(user.get(0).getGender());
    mode.setText(user.get(0).getDriverPass());
    //  rating.setText(user.get(0).getRating());
  }

  /**
   * First method and code to run when window opens. It initialize userProfileGlobal to
   * setProfilePage.
   *
   * @param url Database connection
   * @param resourceBundle Database library.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    setProfilePage(UsersInfo.userProfilesGlobal);
  }

  public void handleUpdateAction(ActionEvent actionEvent) throws IOException, SQLException {
    Connection conn = DatabaseDriver.initializeDB();
    String sql = "SELECT * FROM USER";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.executeQuery();

    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkEdit.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handlePandaModeAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLightModeAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleMenuAction(ActionEvent actionEvent) {
    hBox.setVisible(true);
    TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
    openNav.setToX(0);
    TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
    menuButton.setOnAction(
        (ActionEvent evt) -> {
          if (drawer.getTranslateX() != 0) {
            openNav.play();
          } else {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
          }
        });
  }

  public void handleLogoutAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleHomeAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkDriverHome.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleCarInformationAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkDriverSchedule.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleScheduleButton(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkDriverSchedule.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
