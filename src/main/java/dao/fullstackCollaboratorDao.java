package dao;

import model.fullstackCollaborators;

import java.util.List;

public interface fullstackCollaboratorDao {
    //CRUD

    // list all contacts
    List<fullstackCollaborators> getAllfullstackCollaborator();


    // create a new contacts
    void addfullstackCollaborator(fullstackCollaborators fullstackCollaborators);


    // get a specific contact
    fullstackCollaborators findfullstackById(int id);

    // delete by id
    void deleteById(int id);

    // delete all contacts.
    void deleteAllfullstackCollaborators();
}
