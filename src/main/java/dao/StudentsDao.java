package dao;

import model.Developers;
import model.Students;

import java.util.List;

public interface StudentsDao {

    //CRUD
    void add(Students students);

    List<Students> getAll();

    Students findById(int id);

    void update(int id, Students students);

    void deleteById(int id);
}
