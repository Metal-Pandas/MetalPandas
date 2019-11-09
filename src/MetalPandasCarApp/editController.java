package MetalPandasCarApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class editController {
  /*----------------------------------------------------------*/
  /* EDIT PROFILE PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public Button updateProfile;

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

  @FXML public Text iama;

  @FXML public ChoiceBox<String> driverPass;

  @FXML public Text genderLabel;

  @FXML public ChoiceBox<String> gender;
  /*----------------------------------------------------------*/
  /* EDIT PROFILE PAGE */
  /*----------------------------------------------------------*/
  public void handleEditProfileAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
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
