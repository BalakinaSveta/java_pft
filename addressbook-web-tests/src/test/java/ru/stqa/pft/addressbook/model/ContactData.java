package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String mobile;
  private final String email;
  private final String birthday;
  private final String birthmonth;
  private final String birthyear;
  public String group;

  public ContactData(String firstname, String middlename, String lastname, String mobile, String email, String day, String month, String year, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.birthday = day;
    this.birthmonth = month;
    this.birthyear = year;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getBirthday() {
    return birthday;
  }

  public String getBirthmonth() {
    return birthmonth;
  }

  public String getBirthyear() {
    return birthyear;
  }

  public String getGroup() {
    return group;
  }
}
