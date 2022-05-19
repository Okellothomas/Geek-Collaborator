import dao.Sql2ofullstackCollaboratorsDao;
import dao.Sql2ofullstackDao;
import model.Fullstack;
import model.fullstack;
import model.fullstackCollaborators;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
//import static spark.SparkBase.staticFileLocation;


public class App {
    // String connection = "jdbc:postgresql://ec2-54-172-175-251.compute-1.amazonaws.com:5432/d19tsrp5ts9arv";
//        Sql2o sql2o = new Sql2o(connection,"acutsmyrvfxroj","f6f2568b1bedb19e5723424cd139ea089f13b9effb3756dcc39ca0ba0196a631");


//        String connect =  "jdbc:postgresql://localhost/geek_collaborators";
//        Sql2o sql2o = new Sql2o(connect,"postgres","kamotho");

    public static void main(String[] args) {


//        String connect =  "jdbc:postgresql://localhost/geek_collaborators";
//        Sql2o sql2o = new Sql2o(connect,"postgres","kamotho");

        Sql2ofullstackCollaboratorsDao sql2ofullstackCollaboratorsDao;
        sql2ofullstackCollaboratorsDao = new Sql2ofullstackCollaboratorsDao(sql2o);

        Sql2ofullstackDao fullstackDao = new Sql2ofullstackDao(sql2o);

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
            fullstack fullstack = new Fullstack(name, owner, owner_contact);
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
        get("/Fullstack/:id/delete",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            int idOfContactToDelete = Integer.parseInt(request.params("id"));
            fullstackDao.deleteById(idOfContactToDelete);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/fullstackCollaborator/new",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            List<fullstackCollaborators> contacts = sql2ofullstackCollaboratorsDao.getAllfullstackCollaborator();
            model.put("Fullstack_collaborators",connect);
            return new ModelAndView(model,"Fullstack.hbs");
        },new HandlebarsTemplateEngine());


        //process new contact form
        post("/fullstackCollaborators",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("name");
            String language = request.queryParams("language");
            String contact = request.queryParams("contact");
            String role = request.queryParams("role");
            fullstackCollaborators fullstackCollaborators = new fullstackCollaborators(name, language, contact, role);
            sql2ofullstackCollaboratorsDao.addfullstackCollaborator(fullstackCollaborators);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        get("/fullstackCollaborators",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            List<fullstackCollaborators> contacts = sql2ofullstackCollaboratorsDao.getAllfullstackCollaborator();
            model.put("fullstack_collaborators",connect);
            return new ModelAndView(model,"projects.hbs");
        },new HandlebarsTemplateEngine());

        get("/view/fullstackCollaborators",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("fullstackCollaborators",sql2ofullstackCollaboratorsDao.getAllfullstackCollaborator());
            return new ModelAndView(model,"projects.hbs");
        },new HandlebarsTemplateEngine());
}}