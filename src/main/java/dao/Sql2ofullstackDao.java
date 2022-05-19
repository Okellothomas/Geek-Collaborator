package dao;

import model.Fullstack;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2ofullstackDao implements fullstackDao{

    private final Sql2o sql2o;

    public Sql2ofullstackDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Fullstack> getAllfullstack() {
        getDrivers();
        String sql = "SELECT * FROM Fullstack";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Fullstack.class);
        }
    }



    @Override
    public void addfullstack(Fullstack fullstack) {
        getDrivers();
        String sql = "INSERT INTO Fullstack (name,owner,owner_contact) VALUES (:name, :owner, :owner_contact)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(fullstack)
                    .executeUpdate()
                    .getKey();
            fullstack.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public Fullstack findfullstackById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Fullstack WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Fullstack.class);
        }
    }

    @Override
    public void deleteById(int id) {
        getDrivers();
        String sql = "DELETE FROM Fullstack WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllfullstack() {

    }
}
