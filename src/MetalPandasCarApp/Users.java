package MetalPandasCarApp;

public class Users {
  private String firstName;
  private String lastName;
  private String mail;
  private String address;
  private String country;
  private String phoneNumber;
  private String pass;
  private String pType;
  private String gender;


  public Users(
      String firstName,
      String lastName,
      String mail,
      String address,
      String country,
      String phoneNumber,
      String pType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mail = mail;
    this.address = address;
    this.country = country;
    this.phoneNumber = phoneNumber;
    this.pType = pType;
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


  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getPType() {
    return pType;
  }

  public void setPType(String pType) {
    this.pType = pType;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
