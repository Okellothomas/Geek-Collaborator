package dao;

import model.Developers;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDevelopersDao implements DevelopersDao {
    private final Sql2o sql2o;

    public Sql2oDevelopersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Developers developers) {
        String query = "INSERT INTO developers (name,email,password) values(:name,:email,:password)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(developers)
                    .executeUpdate()
                    .getKey();
            developers.setId(id);
            System.out.println("my id"+id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Developers> getAll() {
        String query = "SELECT * from developers";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(query)
                    .executeAndFetch(Developers.class);
        }
    }

    @Override
    public Developers findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM developers WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Developers.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, Developers developers) {
        String query = "UPDATE developers SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(query)
                    .bind(developers)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE from developers WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
