package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions () {
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0) {
    app.goTo().homePage();
      app.contact().create(new ContactData().withId(0).withFirstname("Ivan").withLastname("Ivanov")
              .withAddress("Moscow").withEmail1("test@mail.ru").withEmail2("test@gmail.com").withEmail3("test@yandex.ru")
              .withHomePhone("21").withMobilePhone("906").withWorkPhone("495").inGroup((groups.iterator().next())),true);
    }
  }

  @Test
  public void testContactModification(){
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Boris")
            .withMiddlename("Borisovich").withLastname("Borisov").withCompany("Kaktus")
            .withAddress("Moscow").withEmail1("").withEmail2("").withEmail3("test@yandex.ru")
            .withHomePhone("").withMobilePhone("906").withWorkPhone("");
    app.goTo().homePage();
    app.contact().modify(contact, false);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}

