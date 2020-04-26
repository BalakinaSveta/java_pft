package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withId(0).withFirstname("Ivan").withLastname("Ivanov").withAddress("address")
              .withEmail1("1").withEmail2("2").withEmail3("3").withHomePhone("111").withMobilePhone("222").withWorkPhone("333"));
    }
  }

  @Test
  public void testContactInfo(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(ContactHelper.mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAllPhones(), equalTo(ContactHelper.mergePhones(contactInfoFromEditForm)));
  }
}

