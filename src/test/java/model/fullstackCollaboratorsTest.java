//package model;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class fullstackCollaboratorsTest {
//
//    @Test
//    public void getNameReturnCorrectName_String() {
//        fullstackCollaborators fullstackCollaborators = newCollaborator();
//        assertEquals("MOSE", fullstackCollaborators.getName());
//    }
//    @Test
//    public void getLanguageReturnCorrectLanguage_String() {
//        fullstackCollaborators fullstackCollaborators = newCollaborator();
//        assertEquals("JAVA", fullstackCollaborators.getLanguage());
//    }
//    @Test
//    public void getContactsReturnCorrectContacts_String() {
//        fullstackCollaborators fullstackCollaborators = newCollaborator();
//        assertEquals("2345654345", fullstackCollaborators.getContact());
//    }
//    @Test
//    public void getRoleReturnCorrectRole_String() {
//        fullstackCollaborators fullstackCollaborators = newCollaborator();
//        assertEquals("JUNIOR", fullstackCollaborators.getRole());
//    }
//
//    public fullstackCollaborators newCollaborator(){
//        return new fullstackCollaborators("MOSE","JAVA", "2345654345","JUNIOR");
//
//    }
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//}