package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() throws Exception {

    app.createNewContact();
    app.fillContactForm(new ContactData("Ivan", "Ivanovich", "Ivanov", "891655555555", "ivanov@mail.ru", "5", "May", "1975"));
    app.submitContactCreation();
    app.returnToHomePage();
  }
}