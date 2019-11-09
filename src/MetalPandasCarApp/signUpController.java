package MetalPandasCarApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class signUpController{
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

//  @FXML public DatePicker birthday;3

  @FXML public Text iama;

  @FXML public ChoiceBox<String> driverPass;

  @FXML public Text genderLabel;

  @FXML public ChoiceBox<String> gender;

  @FXML public Button upSign;
  /*----------------------------------------------------------*/
  /* SIGN UP PAGE */
  /*----------------------------------------------------------*/
  public void handleUpSignAction(ActionEvent event) throws IOException, SQLException {
    addUser();
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handlePicEdit(ActionEvent event) {

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    chooseImage = new FileChooser();
    chooseImage.setTitle("Open Image");

    // Set to user's directory or go to the default C drive if cannot access
    String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
    File userDirectory = new File(userDirectoryString);

    if (!userDirectory.canRead()) {
      userDirectory = new File("C:/");
    } else {
      chooseImage.setInitialDirectory(userDirectory);
    }

    this.filePath = chooseImage.showOpenDialog(stage);

    // Try to update the image by loading the new image
    try {
      BufferedImage bufferedImage = ImageIO.read(filePath);

      Image image = SwingFXUtils.toFXImage(bufferedImage, null);

      signProfilePic.setImage(image);
    } catch (IOException e) {

      System.out.println(e.getMessage());
    }
  }

  public void initialize() {
    try {
      driverPass.setItems(FXCollections.observableArrayList("Driver", "Passenger"));
      gender.setItems(
          FXCollections.observableArrayList("Female", "Male", "Non-binary", "Metal Panda"));
    } catch (java.lang.NullPointerException exception) {
      exception.printStackTrace();
    }
  }


  public void addUser() throws SQLException {
    String FirstName = firstName.getText();
    String LastName = lastName.getText();
    String Email = email.getText();
    String Address = address.getText();
    String PickCountry = pickCountry.getText();
    String PhoneNum = phoneNumber.getText();
    String EnterPass = enterPassword.getText();
    String personType = driverPass.getValue();
    String Gender = gender.getValue();

    String[] signUpUser = {
      FirstName, LastName, Email, Address, PickCountry, PhoneNum, EnterPass, personType, Gender
    };
    
    Users au = new Users(FirstName, LastName, Email, Address, PickCountry, PhoneNum, EnterPass);
    profileInfo.userProfilesGlobal.add(au);
}
}
