//package dao;
//
//import model.Students;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class Sql2oStudentsDaoTest {
//   private static Sql2oStudentsDao sql2oStudentsDao ;
//   private static Sql2oDevelopersDao sql2oDevelopersDao;
//    private static Sql2oCollaborationDao sql2oCollaborationDao;
//    private static Connection conn;
//
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/geek_collab_test";
////        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "postgres", "1234");
//
//        sql2oStudentsDao =new Sql2oStudentsDao(sql2o);
//        sql2oCollaborationDao = new Sql2oCollaborationDao(sql2o);
//        sql2oDevelopersDao =new Sql2oDevelopersDao(sql2o);
//        System.out.println("connected to database");
//        conn=sql2o.open();
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        System.out.println("clearing database");
//    }
//    @Test
//    public void newStudent(){
//        Students student = new Students("John", "as@gmail.com", "223");
//        sql2oStudentsDao.add(student);
//    }
//}