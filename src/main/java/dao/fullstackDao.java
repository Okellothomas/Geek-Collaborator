package dao;

import model.Fullstack;

import java.util.List;

public interface fullstackDao {
        //CRUD

        // list all contacts
        List<Fullstack> getAllfullstack();


        // create a new contacts
        void addfullstack(Fullstack fullstack);


        // get a specific contact
        Fullstack findfullstackById(int id);

        // delete by id
        void deleteById(int id);

        // delete all contacts.
        void deleteAllfullstack();
}