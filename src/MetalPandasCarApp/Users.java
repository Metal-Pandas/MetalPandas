package MetalPandasCarApp;

public class Users {
  private String firstName;
  private String lastName;
  private String mail;
  private String phoneNumber;
  private String address;
  private String city;
  private String state;
  private String zip;
  private String country;
  private String password;
  private String month;
  private String day;
  private String year;
  private String gender;
  private String driverPass;
  private String rePassword;

  public Users(
      String firstName,
      String lastName,
      String mail,
      String phoneNumber,
      String address,
      String city,
      String state,
      String zip,
      String country,
      String password,
      String month,
      String day,
      String year,
      String gender,
      String driverPass,
      String rePassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mail = mail;
    this.phoneNumber = phoneNumber;
    this.month = month;
    this.day = day;
    this.year = year;
    this.address = address;
    this.state = state;
    this.city = city;
    this.zip = zip;
    this.country = country;
    this.password = password;
    this.gender = gender;
    this.driverPass = driverPass;
    this.rePassword = rePassword;
  }

  public String getRePassword() {
    return rePassword;
  }

  public void setRePassword(String rePassword) {
    this.rePassword = rePassword;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPass(String password) {
    this.password = password;
  }

  public String getDriverPass() {
    return driverPass;
  }

  public void setDriverPass(String driverPass) {
    this.driverPass = driverPass;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
