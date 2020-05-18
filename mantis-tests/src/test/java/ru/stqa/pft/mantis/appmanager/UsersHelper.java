package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class UsersHelper extends HelperBase {

  public UsersHelper(ApplicationManager app) {
    super(app);
    this.app = app;
    wd = app.getDriver();
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.xpath("//input[@type='submit']"));
    type(By.name("password"), password);
    click(By.xpath("//input[@type='submit']"));
  }

  public void manageUser(UserData user) {
    managePage();
    manageUsers();
    selectUser(user.getId());
    resetPassword();
    logout();
  }

  public void managePage() {
    click(By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/a/span"));
  }

  public void manageUsers() {
    click(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/ul/li[2]/a"));
  }

  public void selectUser(int userId) {
    click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + userId + "']"));
  }

  public void resetPassword() {
    click(By.xpath("//*[@id=\"manage-user-reset-form\"]/fieldset/span/input"));
  }

  public void logout() {
    click(By.xpath("//span[@class = 'user-info']"));
    click(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a"));
  }
}
