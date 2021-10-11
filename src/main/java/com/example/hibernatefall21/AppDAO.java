package com.example.hibernatefall21;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AppDAO {
    @PersistenceContext
    private EntityManager entMan;

    public App create(App app){
        entMan.persist(app);
        entMan.flush();
        return app;
    }

    public List<App> createListOfData(List<App> a){
        for (App app: a) {
            entMan.createNativeQuery("INSERT INTO apptbl (id, name) VALUES (?, ?)")
                    .setParameter(1, null)
                    .setParameter(2, app.getName())
                    .executeUpdate();
        }
        return a;
    }

    public App getById(int id){
        App app = entMan.find(App.class, id);
        if (app == null){
            String msg = " ID: " + id + " not found.";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
        }
        return app;
    }

    public List<App> getAll(){
        List<App> apps = entMan.createQuery("Select a from App a", App.class).getResultList();
        return apps;
    }

    public App updateByApp(App app){
        getById(app.getId());
        entMan.merge(app);
        entMan.flush();
        return app;
    }

    public void deleteByID(int id){
        App app = getById(id);
        entMan.remove(app);
    }
}
