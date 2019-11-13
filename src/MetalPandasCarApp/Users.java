package MetalPandasCarApp;

/**
 * A class that creates fields of Users.
 */
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

  /**
   * A constructor that passes and returns fields of Users.
   *
   * @param firstName User first name (ie Kevin)
   * @param lastName User last name (ie Mak)
   * @param mail  User email address (ie 123km@gmail.com)
   * @param address User home address (ie 1234 makeIt st)
   * @param country country of User ( ie Florida)
   * @param phoneNumber User PhoneNumber ( ie 239 xxx xxxx)
   * @param pType User profile setup (ie Passenger or Driver)
   */
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

  /**
   * Method that enables access to firstName.
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Method that sets a value of firstName.
   *
   * @param firstName User first name (ie Kevin)
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Method that enables access to lastName.
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Method that sets a value of lastName.
   *
   * @param lastName User last name (ie Mak)
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Method that enables access to Email.
   *
   * @return mail
   */
  public String getMail() {
    return mail;
  }

  /**
   * Method that sets a value of Email.
   *
   * @param mail  User email address (ie 123km@gmail.com)
   */
  public void setMail(String mail) {
    this.mail = mail;
  }

  /**
   * Method that enables access to address.
   *
   * @return address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Method that sets a value of address.
   *
   * @param address User home address (ie 1234 makeIt st)
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Method that enables access to country.
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Method that sets a value of country.
   *
   * @param country country of User ( ie Florida)
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Method that enables access to phoneNumber.
   *
   * @return phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Method that sets a value of phoneNumber.
   *
   * @param phoneNumber User PhoneNumber ( ie 239 xxx xxxx)
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Method that enables access to password.
   *
   * @return password
   */
  public String getPass() {
    return pass;
  }

  /**
   * Method that sets a value of password.
   *
   * @param pass user unique password
   */
  public void setPass(String pass) {
    this.pass = pass;
  }

  /**
   * Method that enables access to personType.
   *
   * @return personType
   */
  public String getPType() {
    return pType;
  }

  /**
   * Method that sets a value of personType.
   *
   * @param pType  User profile setup (ie Passenger or Driver)
   */
  public void setPType(String pType) {
    this.pType = pType;
  }

  /**
   * Method that enables access to gender.
   *
   * @return gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * Method that sets a value of gender.
   *
   * @param gender Users sex (ie Male or Female)
   */
  public void setGender(String gender) {
    this.gender = gender;
  }
}
