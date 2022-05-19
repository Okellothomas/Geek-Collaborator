package dao;

import model.fullstack;

import java.util.List;

public interface fullstackDao {
        void create();
        List<fullstack> getAllfullstack();

        void addFullstack(fullstack fullstack);

        fullstack findSightingById(int id);
}