package DAO;

import model.jobs;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oJobsDao implements JobsDao {
    private final Sql2o sql2o;

    public Sql2oJobsDao(Sql2o sql2o) {
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
    public void add(jobs job) {
        getDrivers();
        String insertQuery = "INSERT INTO jobs (company, title, description, duration, languages) VALUES (:company, :title, :description, :duration, :languages)";
        try (Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(insertQuery, true)
                    .addParameter("company", job.getCompany())
                    .addParameter("title", job.getTitle())
                    .addParameter("description", job.getDescription())
                    .addParameter("duration", job.getDuration())
                    .addParameter("languages", job.getLanguages())
                    .executeUpdate()
                    .getKey();
            job.setId(id);
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public List<jobs> getAll() {

        getDrivers();
        String sql = "SELECT * FROM jobs";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(jobs.class);
        }
    }

    @Override
    public jobs findById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM jobs WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(jobs.class);
        }
    }

    @Override
    public void update(int id, jobs job) {
        String updateQuery = "UPDATE jobs SET (company, title, description, duration, languages) = (:company, :title, :description, :duration, :languages) WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(updateQuery)
                    .addParameter("company", job.getCompany())
                    .addParameter("title", job.getTitle())
                    .addParameter("description", job.getDescription())
                    .addParameter("duration", job.getDuration())
                    .addParameter("languages", job.getLanguages())
                    .executeUpdate();
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void deleteById(int id) {
        String deleteQuery = "DELETE from jobs WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(deleteQuery)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void deleteAll() {
        getDrivers();
        String sql = "DELETE from jobs";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }

}