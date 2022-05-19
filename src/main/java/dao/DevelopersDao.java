package dao;

import model.Developers;

import java.util.List;

public interface DevelopersDao {
    //CRUD
    void add(Developers developers);

    List<Developers> getAll();

    Developers findById(int id);
    void update(int id, Developers developers);

    void deleteById(int id);
}
