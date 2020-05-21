package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

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
    ContactData contactingroup = app.db().contactInGroup(contact.getId());
    Groups after = contactingroup.getGroups();
    assertThat(after.size(), equalTo(before.size()-1));
    assertFalse(after.contains(group));
    assertThat(after, equalTo(before.without(group)));
  }

  public ContactData inGroupContact() {
    ContactData inGroupContact = new ContactData();
    for (ContactData contact : app.db().contacts()) {
      for (GroupData group : app.db().groups()) {
        if (contact.getGroups().contains(group)) {
          inGroupContact = contact.withId(app.db().contacts().stream().mapToInt((c) -> c.getId()).max().getAsInt());
          break;
        }
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
      }
    }
    return inGroupContact;
  }
}

