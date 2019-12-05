package MetalPandasCarApp;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DarkAddPayments {

  @FXML public AnchorPane addPaymentBackground;
  @FXML public Pane backDrop;
  @FXML public Text addPaymentTitle;
  @FXML public Text paymentType;
  @FXML public ComboBox<String> paymentCombo;
  @FXML public Text cardHolderLabel;
  @FXML public TextField cardHolderName;
  @FXML public Text cardNumberLabel;
  @FXML public TextField cardNumber;
  @FXML public Text CCVlabel;
  @FXML public TextField paymentCCV;
  @FXML public Button paymentConfirm;
  @FXML public Button paymentBack;
  @FXML public Text expirationLabel;
  @FXML public ComboBox<String> expirationMonth;
  @FXML public TextField expirationYear;

  public void handleBackAction(ActionEvent actionEvent) {
    try {
      Parent homePageParent = FXMLLoader.load(getClass().getResource("darkSchedule.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
    }
  }

  public void handleConfirmAction(ActionEvent actionEvent) {
    try {
      if (paymentCombo.getValue().equals("")
          || cardHolderName.getText().equals("")
          || cardNumber.getText().equals("")
          || paymentCCV.getText().equals("")
          || expirationMonth.getValue().equals("")
          || expirationYear.getText().equals("")) {

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.WARNING);
        a.setContentText("Please fill all required fields!");
        a.show();
        //System.out.println("The top catch works");
      } else {
        addCardPayment();
        Parent homePageParent = FXMLLoader.load(getClass().getResource("darkPayments.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        homeStage.setScene(homePageScene);
        homeStage.show();
      }
    } catch (IOException | SQLException | NullPointerException e) {
      //System.out.println("the bottom exception works!");
      Alert a = new Alert(Alert.AlertType.NONE);
      a.setAlertType(Alert.AlertType.WARNING);
      a.setContentText("Please fill all required fields!");
      a.show();
    }
  }

  public void initialize() {
    try {
      paymentCombo.setItems(FXCollections.observableArrayList("Gift Card", "Debit/Credit"));
      expirationMonth.setItems(
          FXCollections.observableArrayList(
              "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void addCardPayment() throws SQLException {
    String PaymentType = paymentCombo.getValue();
    String CardHolder = cardHolderName.getText();
    String CardNumber = cardNumber.getText();
    String CcvNumber = paymentCCV.getText();
    String ExpMonth = expirationMonth.getValue();
    String ExpYear = expirationYear.getText();

    String[] cardPaymentSignUp = {
        PaymentType, CardHolder, CardNumber, CcvNumber, ExpMonth, ExpYear
    };

    DatabaseDriver.createCardPaymentInDb(cardPaymentSignUp);
  }
}
