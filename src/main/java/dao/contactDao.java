package dao;

import model.Contacts;

import java.util.List;

public interface contactDao {


    // list all contacts
     List<Contacts> getAllContacts();


//    List<Contacts> getAllContacts();

    // create a new contacts
    void addContacts(Contacts contacts);


//    void addContacts(Contacts contacts);

    // get a specific contact
    Contacts findSightingById(int id);

    // delete by id
//    static void deleteById(int id);

    void deleteById(int id);

    // delete all contacts.
//    static void deleteAllContacts();

    void deleteAllContacts();
}
