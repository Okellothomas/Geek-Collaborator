//package model;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class contactsTest {
//
//    @Test
//    public void getNameReturnsCorrectName_String() throws Exception {
//        Contacts newContact = setNewContact();
//        assertEquals("John", newContact.getName());
//    }
//
//    @Test
//    public void getEmailReturnsCorrectEmail_String() {
//        Contacts newContact = setNewContact();
//        assertEquals("example@gmail.com", newContact.getEmail());
//    }
//
//    @Test
//    public void getSubjectReturnsCorrectSubject_int() {
//        Contacts newContact = setNewContact();
//        assertEquals("jobs", newContact.getSubject());
//    }
//
//    @Test
//    public void getMessageReturnsCorrectMessage_int() {
//        Contacts newContact = setNewContact();
//        assertEquals("clarification", newContact.getMessage());
//    }
//
//    // the helper classes
//
//    public Contacts setNewContact(){
//        return new Contacts("John", "example@gmail.com","jobs","clarification");
//    }
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//
//}