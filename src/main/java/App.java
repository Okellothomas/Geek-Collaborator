import dao.Sql2ofullstackCollaboratorsDao;
import model.*;
import dao.*;
import org.sql2o.Sql2o;
import dao.Sql2ofullstackDao;
import model.Fullstack;
import model.fullstack;

import dao.Sql2oCollaborationDao;
import dao.Sql2oDevelopersDao;
import dao.Sql2oStudentsDao;
import model.Collaboration;
import model.Developers;
import model.Students;

import spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.*;

import model.Contacts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class App {

    // String connection = "jdbc:postgresql://ec2-54-172-175-251.compute-1.amazonaws.com:5432/d19tsrp5ts9arv";
//        Sql2o sql2o = new Sql2o(connection,"acutsmyrvfxroj","f6f2568b1bedb19e5723424cd139ea089f13b9effb3756dcc39ca0ba0196a631");


//        String connect =  "jdbc:postgresql://localhost/geek_collaborators";
//        Sql2o sql2o = new Sql2o(connect,"postgres","kamotho");

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        String connect =  "jdbc:postgresql://localhost/geek_collaborators";
        Sql2o sql2o = new Sql2o(connect,"postgres","kamotho");

        Sql2ofullstackCollaboratorsDao sql2ofullstackCollaboratorsDao;
        sql2ofullstackCollaboratorsDao = new Sql2ofullstackCollaboratorsDao(sql2o);

        Sql2ofullstackDao fullstackDao = new Sql2ofullstackDao(sql2o);


//
//    public static void main(String[] args) {
//        String connect =  "jdbc:postgresql://localhost/geek_collaborators";
//        Sql2o sql2o = new Sql2o(connect,"postgres","okello");
        Sql2oStudentsDao sql2oStudentsDao ;
        Sql2oDevelopersDao sql2oDevelopersDao;
        Sql2oCollaborationDao sql2oCollaborationDao;

        sql2oStudentsDao = new Sql2oStudentsDao(sql2o);
        sql2oDevelopersDao = new Sql2oDevelopersDao(sql2o);
        sql2oCollaborationDao = new Sql2oCollaborationDao(sql2o);


        Sql2oContact contactDao = new Sql2oContact(sql2o);


            /*----------------------------Consume API--------------------------------*/
            get("/android", (request, response) ->{
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "android.hbs");
            }, new HandlebarsTemplateEngine());
            get("/create/student", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "student-form.hbs");
            }, new HandlebarsTemplateEngine());
            get("/create/developer", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "developer-form.hbs");
            }, new HandlebarsTemplateEngine());
            get("/add/student", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "loginStudent.hbs");
            }, new HandlebarsTemplateEngine());
            get("/add/developer", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "loginDeveloper.hbs");
            }, new HandlebarsTemplateEngine());
            get("/projects/students", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "studentProjects.hbs");
            }, new HandlebarsTemplateEngine());
            get("/projects/developers", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "developerProjects.hbs");
            }, new HandlebarsTemplateEngine());

            /*-------------------------------------ADD INTO THE DATABASE----------------------------*/
            post("/create/student/new", (request, response) -> {
                Map<String, Objects> model = new HashMap<String, Objects>();
                String name = request.queryParams("name");
                String email = request.queryParams("email");
                String password = request.queryParams("password");
                Students students = new Students(name, email, password);
                sql2oStudentsDao.add(students);
                return new ModelAndView(model, "student-form.hbs");
            }, new HandlebarsTemplateEngine());

            post("/create/developer/new", (request, response) -> {
                Map<String, Objects> model = new HashMap<String, Objects>();
                String name = request.queryParams("name");
                String email = request.queryParams("email");
                String password = request.queryParams("password");
                Developers developers = new Developers(name, email, password);
                sql2oDevelopersDao.add(developers);
                return new ModelAndView(model, "developer-form.hbs");
            }, new HandlebarsTemplateEngine());

        post("/projects/developers/new", (request, response) -> {
            Map<String, Objects> model = new HashMap<String, Objects>();
            String username = request.queryParams("username");
            String resume = request.queryParams("resume");
            String project_code = request.queryParams("project_code");
            String date = request.queryParams("date");
            Collaboration collaboration = new Collaboration(username,resume, project_code, new Date());
            sql2oCollaborationDao.add(collaboration);
            return new ModelAndView(model, "developerProjects.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view/collaborators",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("collaboration",sql2oCollaborationDao.getAll());
            return new ModelAndView(model,"collaborate-view.hbs");
        },new HandlebarsTemplateEngine());


        // String connection = "jdbc:postgresql://ec2-54-172-175-251.compute-1.amazonaws.com:5432/d19tsrp5ts9arv";
//        Sql2o sql2o = new Sql2o(connection,"acutsmyrvfxroj","f6f2568b1bedb19e5723424cd139ea089f13b9effb3756dcc39ca0ba0196a631");



        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        //display form receive clients data
        get("/Fullstack/new",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            List<Fullstack> contacts = fullstackDao.getAllfullstack();
            model.put("Fullstack",connect);
            return new ModelAndView(model,"Fullstack-form.hbs");
        },new HandlebarsTemplateEngine());

//process new contact form
        post("/Fullstack",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("name");
            String owner = request.queryParams("owner");
            String owner_contact = request.queryParams("owner_contact");
            Fullstack fullstack = new Fullstack(name, owner, owner_contact);
            fullstackDao.addfullstack(fullstack);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

// display all contacts
        get("/Fullstack",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Fullstack> allContacts = fullstackDao.getAllfullstack();
            model.put("Fullstack",allContacts);
            return new ModelAndView(model,"projects.hbs");
        },new HandlebarsTemplateEngine());



//delete contact by Id
        get("/Fullstack/:id/delete",(request, response)-> {
            Map<String, Object> model = new HashMap<>();
            int idOfContactToDelete = Integer.parseInt(request.params("id"));
            fullstackDao.deleteById(idOfContactToDelete);
            return null;
        }, new HandlebarsTemplateEngine());

            //clear all contacts
            get("/contact/delete", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                contactDao.deleteAllContacts();
                response.redirect("/");
                return null;
            }, new HandlebarsTemplateEngine());

            get("/fullstackCollaborator/new", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                List<fullstackCollaborators> contacts = sql2ofullstackCollaboratorsDao.getAllfullstackCollaborator();
                model.put("Fullstack_collaborators", connect);
                return new ModelAndView(model, "Fullstack.hbs");
            }, new HandlebarsTemplateEngine());


            //process new contact form
            post("/fullstackCollaborators", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String name = request.queryParams("name");
                String language = request.queryParams("language");
                String contact = request.queryParams("contact");
                String role = request.queryParams("role");
                fullstackCollaborators fullstackCollaborators = new fullstackCollaborators(name, language, contact, role);
                sql2ofullstackCollaboratorsDao.addfullstackCollaborator(fullstackCollaborators);
                response.redirect("/");
                return null;
            }, new HandlebarsTemplateEngine());


            get("/fullstackCollaborators", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                List<fullstackCollaborators> contacts = sql2ofullstackCollaboratorsDao.getAllfullstackCollaborator();
                model.put("fullstack_collaborators", connect);
                return new ModelAndView(model, "projects.hbs");
            }, new HandlebarsTemplateEngine());

            get("/view/fullstackCollaborators", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("fullstackCollaborators", sql2ofullstackCollaboratorsDao.getAllfullstackCollaborator());
                return new ModelAndView(model, "projects.hbs");
            }, new HandlebarsTemplateEngine());

}}