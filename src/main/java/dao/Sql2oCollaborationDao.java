package dao;

import model.Collaboration;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCollaborationDao implements CollaborationDao{
    private final Sql2o sql2o;

    public Sql2oCollaborationDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Collaboration collaboration) {
        String query = "INSERT INTO collaboration (username,resume,project_code,date) values(:username,:resume,:project_code,:date)";

        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(collaboration)
                    .executeUpdate()
                    .getKey();
            collaboration.setId(id);
            System.out.println("my id"+id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Collaboration> getAll() {
        String query = "SELECT * from collaboration";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(Collaboration.class);
        }
    }

    @Override
    public Collaboration findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM collaboration WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Collaboration.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, Collaboration collaboration) {
        String query = "UPDATE collaboration SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(query)
                    .bind(collaboration)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void deleteById(int id) {
        String query = "DELETE from collaboration WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
