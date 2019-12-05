package MetalPandasCarApp;

public class UsersFavourites {

  private String driver;
  private String startDestination;
  private String endDestination;

  public UsersFavourites(String driver, String startDestination, String endDestination){
    this.driver = driver;
    this.startDestination = startDestination;
    this.endDestination = endDestination;

  }

  public String getDriver(){ return this.driver; }

  public void setDriver(String driver){ this.driver = driver;}

  public String getStartDestination(){ return this.startDestination; }

  public void setStartDestination(String startDestination){ this.startDestination = startDestination;}

  public String getEndDestination(){ return this.endDestination; }

  public void setEndDestination(String endDestination){ this.endDestination = endDestination;}
}
