import dao.Sql2ofullstackDao;
import dao.fullstackDao;
import model.fullstack;
import org.sql2o.Sql2o;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;
//import static spark.SparkBase.staticFileLocation;


public class App {
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


        // String connection = "jdbc:postgresql://ec2-54-172-175-251.compute-1.amazonaws.com:5432/d19tsrp5ts9arv";
//        Sql2o sql2o = new Sql2o(connection,"acutsmyrvfxroj","f6f2568b1bedb19e5723424cd139ea089f13b9effb3756dcc39ca0ba0196a631");


        String connect =  "jdbc:postgresql://localhost/geek_collaborators";
        Sql2o sql2o = new Sql2o(connect,"postgres","kamotho");

        Sql2ofullstackDao fullstackDao = new Sql2ofullstackDao(sql2o);

        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        //display form receive clients data
        get("/fullstack/new",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            List<fullstack> contacts = fullstackDao.getAllfullstack();
            model.put("fullstack",connect);
            return new ModelAndView(model,"fullstack-form.hbs");
        },new HandlebarsTemplateEngine());

//process new contact form
        post("/fullstack",(request,response)->{
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("name");
            String owner = request.queryParams("owner");
            String owner_contact = request.queryParams("owner_contact");
            fullstack fullstack = new fullstack(name, owner, owner_contact);
            fullstackDao.addfullstack(fullstack);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

// display all contacts
        get("/fullstack",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<fullstack> allContacts = fullstackDao.getAllfullstack();
            model.put("fullstack",allContacts);
            return new ModelAndView(model,"projects.hbs");
        },new HandlebarsTemplateEngine());


//delete contact by Id
        get("/fullstack/:id/delete",(request, response)->{
            Map<String, Object>model = new HashMap<>();
            int idOfContactToDelete = Integer.parseInt(request.params("id"));
            fullstackDao.deleteById(idOfContactToDelete);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
}}
