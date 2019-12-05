package MetalPandasCarApp;

// Users schedule
public class UsersSchedule {
  private String scheduleMonth;
  private String scheduleDay;
  private String hour;
  private String minute;
  private String amPm;
  private String time;
  private String date;

  public UsersSchedule(
      String scheduleMonth, String scheduleDay, String hour, String minute, String amPm) {
    this.scheduleMonth = scheduleMonth;
    this.scheduleDay = scheduleDay;
    this.hour = hour;
    this.minute = minute;
    this.amPm = amPm;
  }

  public UsersSchedule(String time, String date, String amPm) {
    this.time = time;
    this.date = date;
    this.amPm = amPm;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getScheduleMonth() {
    return scheduleMonth;
  }

  public void setScheduleMonth(String scheduleMonth) {
    this.scheduleMonth = scheduleMonth;
  }

  public String getScheduleDay() {
    return scheduleDay;
  }

  public void setScheduleDay(String scheduleDay) {
    this.scheduleDay = scheduleDay;
  }

  public String getHour() {
    return hour;
  }

  public void setHour(String hour) {
    this.hour = hour;
  }

  public String getMinute() {
    return minute;
  }

  public void setMinute(String minute) {
    this.minute = minute;
  }

  public String getAmPm() {
    return amPm;
  }

  public void setAmPm(String amPm) {
    this.amPm = amPm;
  }
}
