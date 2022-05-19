//package dao;
//
//import model.Contacts;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.sql2o.Sql2o;
//
//import java.sql.Connection;
//
//import static org.junit.Assert.*;
//
//public class Sql2oContactTest {
//
//    private Sql2oContact contactDao;
//    private Connection connection;
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/geek_collaborators_test";
//        Sql2o sql2o = new Sql2o(connectionString,"postgres","okello");
//        contactDao = new Sql2oContact(sql2o);
//        connection = (Connection) sql2o.open();
//    }
//
//    @Test
//    public void addingContactSetsId() throws Exception {
//        Contacts contacts = setNewContact();
//        int originalContactId = contacts.getId();
//        contactDao.addContacts(contacts);
//        assertNotEquals(originalContactId, contacts.getId());
//    }
//
//    @Test
//    public void existingContactCanBeFoundById() throws Exception {
//        Contacts contacts = setNewContact();
//        contactDao.addContacts(contacts);
//        Contacts foundContacts = contactDao.findSightingById(contacts.getId());
//        assertEquals(contacts, foundContacts);
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectContacts() throws Exception {
//        Contacts contacts = new  Contacts("Thoma", "example001@gmail.com","account","login");
//        contactDao.addContacts(contacts);
//        contactDao.deleteById(contacts.getId());
//        assertEquals(0,contactDao.getAllContacts().size());
//    }
//
//    @Test
//    public void clearAllContacts() throws Exception {
//        Contacts contacts = setNewContact();
//        Contacts contacts1 = new  Contacts("Thoma", "example001@gmail.com","account","login");
//        contactDao.addContacts(contacts);
//        contactDao.addContacts(contacts1);
//        int sizeOfDao = contactDao.getAllContacts().size();
//        contactDao.deleteAllContacts();
//        assertTrue(sizeOfDao > 0 && sizeOfDao >contactDao.getAllContacts().size());
//    }
//
//    // the helper classes
//
//    public Contacts setNewContact(){
//        return new Contacts("John", "example@gmail.com","jobs","clarification");
//    }
//    @After
//    public void tearDown() throws Exception {
//    }
//}