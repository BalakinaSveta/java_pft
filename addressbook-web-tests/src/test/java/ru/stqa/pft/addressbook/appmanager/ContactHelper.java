package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper (WebDriver wd){
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),(contactData.getFirstname()));
    type(By.name("middlename"),(contactData.getMiddlename()));
    type(By.name("lastname"),(contactData.getLastname()));
    type(By.name("mobile"),(contactData.getMobile()));
    type(By.name("email"),(contactData.getEmail()));
    select(By.name("bday"), contactData.getBirthday(), By.xpath("//div[@id='content']/form/select/option[7]"));
    select(By.name("bmonth"), contactData.getBirthmonth(), By.xpath("//div[@id='content']/form/select[2]/option[6]"));
    type(By.name("byear"),(contactData.getBirthyear()));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
}
