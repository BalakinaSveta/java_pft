package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddInGroupTest extends TestBase {

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
  public void testContactAddInGroup() {
    ContactData contact= notInGroupContact();
    GroupData group = groupWithoutContact();
    Groups before = contact.getGroups();
    app.goTo().homePage();
    app.contact().addToGroup(contact, group);
    Groups after = contact.getGroups().withAdded(group);
    assertThat(after.size(), equalTo(before.size()+1));
    Assert.assertTrue(after.contains(group));
  }

  public ContactData notInGroupContact() {
    ContactData notInGroupContact = new ContactData();
    for (ContactData contact : app.db().contacts()) {
      for (GroupData group : app.db().groups()) {
        if (!contact.getGroups().contains(group)) {
          notInGroupContact = contact;
          break;
        }
          app.goTo().groupPage();
          app.group().create(new GroupData().withName("test11").withHeader("test2").withFooter("test3"));
        }
      }
    return notInGroupContact;
  }

  public GroupData groupWithoutContact() {
    GroupData groupWithoutContact = new GroupData();
    for (GroupData group : app.db().groups()) {
      for (ContactData contact : app.db().contacts()) {
        if (!group.getContacts().contains(contact)) {
          groupWithoutContact = group;
          break;
        }
          app.goTo().homePage();
          app.contact().create(new ContactData().withId(0).withFirstname("Ivan").withLastname("Ivanov"), false);
        }
      }
    return groupWithoutContact;
  }
}
