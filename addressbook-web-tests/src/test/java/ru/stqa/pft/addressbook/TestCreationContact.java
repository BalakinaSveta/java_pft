package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class TestCreationContact extends TestBase {

  @Test
  public void testCreationContact() throws Exception {

    createNewContact();
    fillContactForm(new ContactData("Ivan", "Ivanovich", "Ivanov", "891655555555", "ivanov@mail.ru", "5", "May", "1975"));
    submitContactCreation();
    returnToHomePage();
  }
}