package DAO;

import model.jobs;

import java.util.List;


public interface JobsDao {
    //CRUD functionality

    //create new job opening
    void add(jobs job);
    //list job openings
    List<jobs> getAll();
    //get specific job
    jobs findById(int id);
    //update job
    void update(int id, jobs job);
    //delete specific job
    void deleteById(int id);
    void deleteAll();
}