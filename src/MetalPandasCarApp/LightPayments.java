package MetalPandasCarApp;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LightPayments {
  @FXML public AnchorPane paymentBackground;
  @FXML public Text paymentTitle;
  @FXML public Pane backdrop;
  @FXML public Text selectPaymentLabel;
  @FXML public Text tipLabel;
  @FXML public Text totalCostLabel;
  @FXML public Button addPaymentMethod;
  @FXML public Pane backDrop;
  @FXML public ComboBox<String> paymentOption;
  @FXML public TextField tipAmount;
  @FXML public TextField totalCostAmount;
  @FXML public Button pay;
  @FXML public Button backButton;
  @FXML public Button calcTotal;

  public void handleAddPaymentAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightAddPayments.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handlePayAction(ActionEvent actionEvent) throws IOException, SQLException {
    addPayment();
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightProfileRating.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleBackAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightSchedule.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void initialize(){
    try{
      paymentOption.setItems(FXCollections.observableArrayList("Gift Card", "Debit/Credit"));
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  private void addPayment() throws SQLException {
    String PaymentOption = paymentOption.getValue();
    String TipAmount = tipAmount.getText();
    String TotalAmount = totalCostAmount.getText();

    String[] paymentSignUp = {PaymentOption, TipAmount, TotalAmount};

    DatabaseDriver.createPaymentInDb(paymentSignUp);
  }

  public void handleCalcPayment(ActionEvent actionEvent) {
    int TipAmount = Integer.parseInt(tipAmount.getText());
    int totalAmount = TipAmount + 10;
    totalCostAmount.setText( String.valueOf(totalAmount));
  }
}
