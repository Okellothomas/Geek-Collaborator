package DAO;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/geek_collaborators", "chechesylvia", "0718500898");
}
