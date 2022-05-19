package dao;

import model.fullstack;

import java.util.List;

public interface fullstackDao {
        //CRUD

        // list all contacts
        List<fullstack> getAllfullstack();


        // create a new contacts
        void addfullstack(fullstack fullstack);


        // get a specific contact
        fullstack findfullstackById(int id);

        // delete by id
        void deleteById(int id);

        // delete all contacts.
        void deleteAllfullstack();
}