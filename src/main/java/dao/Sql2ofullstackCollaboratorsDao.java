package dao;

import model.fullstackCollaborators;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

import static java.sql.DriverManager.getDrivers;

public class Sql2ofullstackCollaboratorsDao implements fullstackCollaboratorDao{
    private final Sql2o sql2o;

    public Sql2ofullstackCollaboratorsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public List<fullstackCollaborators> getAllfullstackCollaborator() {
        getDrivers();
        String sql = "SELECT * FROM fullstack_collaborators";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(fullstackCollaborators.class);
        }
    }

    @Override
    public void addfullstackCollaborator(fullstackCollaborators fullstackCollaborators) {
        getDrivers();
        String sql = "INSERT INTO fullstack_collaborators(name, language, contact, role) VALUES (:name, :language, :contact, :role)";
        try (Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(fullstackCollaborators)
                    .executeUpdate()
                    .getKey();
            fullstackCollaborators.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public fullstackCollaborators findfullstackById(int id) {
        getDrivers();
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM fullstack_collaborators WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(fullstackCollaborators.class);
        }
    }

    @Override
    public void deleteById(int id) {
        getDrivers();
        String sql = "DELETE FROM fullstack_collaborators WHERE id =:id";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllfullstackCollaborators() {

    }
}
