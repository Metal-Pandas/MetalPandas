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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

  public void handleUpdateAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void initialize(){
    try{
      driverPassenger.setItems(FXCollections.observableArrayList("Driver", "Passenger"));
      gender.setItems(FXCollections.observableArrayList("Female", "Male", "Non-binary", "Metal Panda"));
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
