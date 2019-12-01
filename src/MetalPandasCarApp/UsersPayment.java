package MetalPandasCarApp;

public class UsersPayment {
    private String paymentOption;
    private String tipAmount;
    private String totalAmount;

    public UsersPayment(String paymentOption, String tipAmount, String totalAmount){
        this.paymentOption = paymentOption;
        this.tipAmount = tipAmount;
        this.totalAmount = totalAmount;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(String tipAmount) {
        this.tipAmount = tipAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
