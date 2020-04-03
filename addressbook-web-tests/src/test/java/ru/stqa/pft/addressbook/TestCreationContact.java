package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCreationContact {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  private void login(String username, String pass) {
    wd.get("http://localhost/addressbook/group.php?new=New+group");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(pass);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testCreationContact() throws Exception {

    createNewContact();
    fillContactForm(new FullNameData("Ivan", "Ivanovich", "Ivanov"), new ContactInfo("891655555555", "ivanov@mail.ru"), new DateOfBirth("5", "May", "1975"));
    submitContactCreation();
    returnToHomePage();
  }

  private void createNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void fillContactForm(FullNameData fullNameData, ContactInfo contactInfo, DateOfBirth dateOfBirth) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(fullNameData.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(fullNameData.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(fullNameData.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactInfo.getMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactInfo.getEmail());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(dateOfBirth.getDay());
    wd.findElement(By.xpath("//div[@id='content']/form/select/option[7]")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(dateOfBirth.getMonth());
    wd.findElement(By.xpath("//div[@id='content']/form/select[2]/option[6]")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(dateOfBirth.getYear());
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
