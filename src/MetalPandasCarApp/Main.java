package MetalPandasCarApp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    primaryStage.setTitle("Metal Pandas");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
}



  public static void main(String[] args) {
      launch(args);

    }
}
