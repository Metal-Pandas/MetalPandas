package MetalPandasCarApp;

import java.io.IOException;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PandaProfile implements Initializable {

  /*----------------------------------------------------------*/
  /* PROFILE PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public SplitPane profileSplit;

  @FXML public Pane profileBackdrop;

  @FXML public Text profileFirst;

  @FXML public Text profileLast;

  @FXML public Text profileEmail;

  @FXML public Text profileNumber;

  @FXML public Text profileBirthday;

  @FXML public Text profileAddress;

  @FXML public Text profileCountry;

  @FXML public Text profileMode;

  @FXML public TextField profileFName;

  @FXML public TextField profileLName;

  @FXML public TextField proEmail;

  @FXML public TextField profNumber;

  @FXML public TextField profBirthday;

  @FXML public TextField profAddress;

  @FXML public TextField countryCombo;

  @FXML public TextField modeBox;

  @FXML public Button update;

  @FXML public GridPane homePageBack;

  @FXML public VBox setUp;

  @FXML public ToolBar topToolBar;

  @FXML public Button menuButton;

  @FXML public ToggleButton darkMode;

  @FXML public ToggleButton lightMode;

  @FXML public StackPane stackPane;

  @FXML public HBox part1Menu;

  @FXML public VBox drawer;

  @FXML public GridPane imageGrid;

  @FXML public ImageView signProfilePic;

  @FXML public BorderPane buttonMenu;

  @FXML public Button profileButton;

  @FXML public Button favouritesButton;

  @FXML public BorderPane logOutBorderPane;

  @FXML public Button logoutButton;

  Connection conn;
  Statement stmt;
  private String querySQL;
  /*----------------------------------------------------------*/
  /* PROFILE PAGE */
  /*----------------------------------------------------------*/

  /**
   * setProfilePage passes an ArrayList of Users called user.
   * setText from database to text fields of profileController. calls the first index in db.
   *  userList should only be at ZERO!
   *
   * @param user an arrayList that holds Users.
   */
  void setProfilePage(ArrayList<Users> user)  {
    profileFName.setText(user.get(0).getFirstName());
    profileLName.setText(user.get(0).getLastName());
    proEmail.setText(user.get(0).getMail());
    profAddress.setText(user.get(0).getAddress());
    countryCombo.setText(user.get(0).getCountry());
    modeBox.setText(user.get(0).getPType());
    profNumber.setText(user.get(0).getPhoneNumber());
  }

  /**
   * First method and code to run when window opens. It initialize userProfileGlobal to setProfilePage.
   * @param url Database connection
   * @param resourceBundle Database library.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    setProfilePage(profileInfo.userProfilesGlobal);
  }

  public void handleMenuAction(ActionEvent event) {
    part1Menu.setVisible(true);
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

  public void handleUpdateAction(ActionEvent event) throws IOException, SQLException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaEdit.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();

    updateProfile();
  }

  /** START CODE **/
  public void updateProfile() throws SQLException {
    String FirstName = profileFName.getText();
    String LastName = profileLName.getText();
    String Email = proEmail.getText();
    String Address = profAddress.getText();
    String PickCountry = countryCombo.getText();
    String PhoneNum = profNumber.getText();
    String Birthday = profBirthday.getText();
    String Mode = modeBox.getText();
    String[] updateUser = {
            FirstName, LastName, Email, Address, PickCountry, PhoneNum, Birthday, Mode
    };

    DatabaseDriver.updateUserInDB(updateUser);
  }

  public void initialize() {
    try {
    } catch (java.lang.NullPointerException exception) {
      exception.printStackTrace();
    }

    // Calls the Database
    DatabaseDriver.initializeDB();
  }

  /** END CODE **/


  public void handleHomeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaHome.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaFavourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLogoutAction(ActionEvent event) throws IOException {
    profileInfo.userProfilesGlobal.clear();
    System.out.println("list is clear");
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleDarkModeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLightModeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
