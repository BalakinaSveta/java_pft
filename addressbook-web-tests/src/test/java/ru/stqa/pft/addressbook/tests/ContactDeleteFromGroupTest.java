package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTest  extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withId(0).withFirstname("Ivan").withLastname("Ivanov"), false);
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }

  @Test
  public void testContactDeleteFromGroup() {
    ContactData contact = inGroupContact();
    GroupData group = contact.getGroups().iterator().next();
    Groups before = contact.getGroups();
    app.goTo().homePage();
    app.contact().removeFromGroup(contact, group);
    Groups after = contact.getGroups().without(group);
    assertThat(after.size(), equalTo(before.size() - 1));
    Assert.assertFalse(after.contains(group));
  }

  public ContactData inGroupContact() {
    ContactData inGroupContact = new ContactData();
    for (ContactData contact : app.db().contacts()) {
      for (GroupData group : app.db().groups()) {
        if (contact.getGroups().contains(group)) {
          inGroupContact = contact;
          break;
        }
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
      }
    }
    return inGroupContact;
  }
}

