package sample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

// this is a test
public class Controller {
  /*----------------------------------------------------------*/
  /* LOGIN PAGE ITEMS */
  /*----------------------------------------------------------*/
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
  /* HOME PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public GridPane homePageBack;

  @FXML public SplitPane homePageSplitPane;

  @FXML public VBox setUp;

  @FXML public ToolBar topToolBar;

  @FXML public Button menuButton;

  @FXML public StackPane stackPane;

  @FXML public HBox part1Menu;

  @FXML public VBox drawer;

  @FXML public GridPane imageGrid;

  @FXML public ImageView profileImage;

  @FXML public BorderPane buttonMenu;

  @FXML public Button profileButton;

  @FXML public Button favouritesButton;

  @FXML public BorderPane logOutBorderPane;

  @FXML public Button logoutButton;
  /*----------------------------------------------------------*/
  /* SIGN UP PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public Pane signUpPane;

  @FXML public Pane seeGender;

  @FXML public ImageView signProfilePic;

  @FXML public Button picEdit;

  @FXML private FileChooser chooseImage;

  @FXML private File filePath;

  @FXML public TextField firstName;

  @FXML public TextField lastName;

  @FXML public TextField email;

  @FXML public TextField address;

  @FXML public TextField pickCountry;

  @FXML public PasswordField enterPassword;

  @FXML public PasswordField reenterPassword;

  @FXML public TextField phoneNumber;

  @FXML public DatePicker birthday;

  @FXML public Text iama;

  @FXML public ChoiceBox<String> driverPass;

  @FXML public Text genderLabel;

  @FXML public ChoiceBox<String> gender;

  @FXML public Button upSign;
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
  /*----------------------------------------------------------*/
  /* FAVOURITES PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public SplitPane favSplit;
  /*----------------------------------------------------------*/
  /* EDIT PROFILE PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public Button updateProfile;
  /*----------------------------------------------------------*/
  /* FORGOT EMAIL AND PASSWORD PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML  public AnchorPane forgotEmailPane;

  @FXML public TextField enterPhoneNumber;

  @FXML public Text phoneNumberInvalid;

  @FXML public AnchorPane forgotPasswordPane;

  @FXML public TextField phoneNumberEnter;

  @FXML private Text forgotPasswordTxt;

  @FXML public Button confirmButton;

  @FXML public Button backButton;
  /*----------------------------------------------------------*/
  /* LOGIN PAGE */
  public void handleLoginAction(ActionEvent event) throws IOException {
    if (UsernameField.getText().equals("jsmith@abc.com")
        && PasswordField.getText().equals("password")) {

      Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }
    if (!UsernameField.getText().equals("jsmith@abc.com")
        || !PasswordField.getText().equals("password")) {
      Statustxt.setText("Email/Password incorrect. Don't have an account? Sign up now.");
    }
  }

  public void handleSignUpAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("signupPage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
  /*----------------------------------------------------------*/
  /* HOME PAGE */
  public void handleMenuAction(ActionEvent event) {
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

  public void handleProfileAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("favourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLogoutAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
  /*----------------------------------------------------------*/
  /* PROFILE PAGE */
  public void handleUpdateAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("editPage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
  /*----------------------------------------------------------*/
  /* FAVOURITES PAGE */
  public void handleHomeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
  /*----------------------------------------------------------*/
  /* SIGN UP PAGE */
  public void handleUpSignAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handlePicEdit(ActionEvent event) {

    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

    chooseImage = new FileChooser();
    chooseImage.setTitle("Open Image");

    // Set to user's directory or go to the default C drive if cannot access
    String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
    File userDirectory = new File(userDirectoryString);

    if(!userDirectory.canRead()){
      userDirectory = new File("C:/");
    }
    else{
      chooseImage.setInitialDirectory(userDirectory);
    }

    this.filePath = chooseImage.showOpenDialog(stage);

    // Try to update the image by loading the new image
    try{
      BufferedImage bufferedImage = ImageIO.read(filePath);

      Image image = SwingFXUtils.toFXImage(bufferedImage, null);

      signProfilePic.setImage(image);
    }
    catch (IOException e){

      System.out.println(e.getMessage());
    }

  }
  /*----------------------------------------------------------*/
  /* EDIT PROFILE PAGE */
  public void handleEditProfileAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
  /*----------------------------------------------------------*/
  /* FORGOT EMAIL AND PASSWORD PAGE */
  public void handleConfirmButton(ActionEvent event) {
    forgotPasswordTxt.setText("Email/Phone number is invalid.");
    phoneNumberInvalid.setText("Phone number is invalid.");
  }

  public void handleBackAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
  /*----------------------------------------------------------*/
  public void initialize(){
    try{
      driverPass.setItems(FXCollections.observableArrayList("Driver","Passenger"));
    }
    catch(java.lang.NullPointerException exception){
      exception.printStackTrace();
    }
    try{
      gender.setItems(FXCollections.observableArrayList("Female","Male", "Non-binary", "Metal Panda"));
    }
    catch(java.lang.NullPointerException exception){
      exception.printStackTrace();
    }
  }


}
