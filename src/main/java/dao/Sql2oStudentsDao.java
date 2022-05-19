package dao;
import dao.Sql2oStudentsDao;

import model.Students;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import java.util.List;

public class Sql2oStudentsDao implements StudentsDao {
    private final Sql2o sql2o;

    public Sql2oStudentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;

    }

    @Override
    public void add(Students students) {
        String query = "INSERT INTO students (name,email,password) values(:name,:email,:password)";

        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(students)
                    .executeUpdate()
                    .getKey();
            students.setId(id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<Students> getAll() {
        String query = "SELECT * from students";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(Students.class);
        }
    }

    @Override
    public Students findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM students WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Students.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, Students students) {
        String query = "UPDATE students SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(query)
                    .bind(students)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE from students WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}

