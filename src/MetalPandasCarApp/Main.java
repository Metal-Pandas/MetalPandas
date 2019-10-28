package MetalPandasCarApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {

  public boolean darkTheme = false;
  public boolean lightTheme = false;
  public boolean pandaTheme = false;

  @Override
  public void start(Stage primaryStage) throws Exception {
    if (darkTheme = true) {
      Parent root = FXMLLoader.load(getClass().getResource("darkLogin.fxml"));
      primaryStage.setTitle("Metal Pandas");
      primaryStage.setScene(new Scene(root, 600, 400));
      primaryStage.show();
    } else if (lightTheme = true) {
      Parent root = FXMLLoader.load(getClass().getResource("lightLogin.fxml"));
      primaryStage.setTitle("Metal Pandas");
      primaryStage.setScene(new Scene(root, 600, 400));
      primaryStage.show();
    } else {
      Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
      primaryStage.setTitle("Metal Pandas");
      primaryStage.setScene(new Scene(root, 600, 400));
      primaryStage.show();
    }
  }

  public static void main(String[] args) {
      launch(args);

    }
}
