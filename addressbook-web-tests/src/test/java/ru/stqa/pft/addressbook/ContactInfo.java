package ru.stqa.pft.addressbook;

public class ContactInfo {
  private final String mobile;
  private final String email;

  public ContactInfo(String mobile, String email) {
    this.mobile = mobile;
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }
}
