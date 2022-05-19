package dao;

import model.Collaboration;
import model.Developers;

import java.util.List;

public interface CollaborationDao {
    //CRUD
    void add(Collaboration collaboration);

    List<Collaboration> getAll();

    Collaboration findById(int id);
    void update(int id, Collaboration collaboration);

    void deleteById(int id);
}
