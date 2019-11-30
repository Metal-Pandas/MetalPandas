package MetalPandasCarApp;

public class UsersPayment {
  private String paymentCombo;
  private String cardHolder;
  private String cardNumber;
  private String ccvNumber;
  private String expirationMonth;
  private String expirationYear;

  public UsersPayment(
      String paymentCombo,
      String cardHolder,
      String cardNumber,
      String ccvNumber,
      String expirationMonth,
      String expirationYear) {
    this.paymentCombo = paymentCombo;
    this.cardHolder = cardHolder;
    this.cardNumber = cardNumber;
    this.ccvNumber = ccvNumber;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
  }

  public String getCardHolder() {
    return cardHolder;
  }

  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }

  public String getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
  }

  public String getPaymentCombo() {
    return paymentCombo;
  }

  public void setPaymentCombo(String paymentCombo) {
    this.paymentCombo = paymentCombo;
  }

  public String getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCcvNumber() {
    return ccvNumber;
  }

  public void setCcvNumber(String ccvNumber) {
    this.ccvNumber = ccvNumber;
  }
}
