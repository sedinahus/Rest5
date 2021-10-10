package com.example.hibernatefall21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssignmentController {
    @Autowired
    private AppDAO appDAO = new AppDAO();
    private ArrayList<App> namesMap;
    int id = 0;

    public AssignmentController() {
        namesMap = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            id = i;
            namesMap.add(new App(i, "Sedina" + i));
        }
    }


    @RequestMapping(value="/getNames", method= RequestMethod.GET)
    public List<App> getNames() {return appDAO.getAll();}
//    public ArrayList<App> getNames() {
//        return namesMap;
//    }

//    @RequestMapping("/getName")
//    public App getName(@RequestParam(value = "id") int id) {
//        for (int i = 0; i < namesMap.size(); i++) {
//            if (namesMap.get(i).getId() == id) {
//                return namesMap.get(i);
//            }
//        }
//        return new App(0, "ID NOT FOUND!");
//    }

    @RequestMapping(value = "getNames/{id}", method = RequestMethod.GET)
    public App helloByID(@PathVariable int id) {
        return  appDAO.getById(id);
    }
//    public App nameById(@PathVariable int id) {
//        int index = findName(id);
//        if (index < 0) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID " + index + " not found");
//        }
//        return namesMap.get(index);
//    }

    @RequestMapping(value = "getNames", method = RequestMethod.POST)
    public App hellos(@RequestBody App app) {
        App resp = appDAO.create(app);
        return resp;
    }
//    public App createName(@RequestBody App bodyReq) {
//        /*
//         * test sample
//         * {
//         *   "id" : 100,
//         *   "name" : "sedina create name"
//         * }
//         * */
//        bodyReq.setId(++id);
//        namesMap.add(bodyReq);
//        return bodyReq;
//    }

    @RequestMapping(value = "getNames", method = RequestMethod.PUT)
    public App updateHello(@RequestBody App app) {
        App resp = appDAO.updateByApp(app);
        return resp;
    }
//    public App updateName(@RequestBody App bodyReq) {
//        int index = findName(bodyReq.getId());
//        namesMap.get(index).setName(bodyReq.getName());
//        return namesMap.get(index);
//    }

    @RequestMapping(value = "getNames/{id}", method = RequestMethod.DELETE)
    public String deleteHello(@PathVariable int id) {
        appDAO.deleteByID(id);
        return "ID " + id + " deleted.";
    }
//    public String deleteName(@PathVariable int id) {
//        int index = findName(id);
//        namesMap.remove(index);
//        return id + " deleted.";
//    }

    @RequestMapping(value = "sendNames", method = RequestMethod.POST)
    public List<App> hellosList(@RequestBody List<App> bodyReq) {
        for (App a : bodyReq) {
            a.setId(++id);
            this.namesMap.add(a);
        }
        return this.namesMap;
    }

    private int findName(int id) {
        int found = -1;
        for (int index = 0; index < namesMap.size(); index++) {
            if (namesMap.get(index).getId() == id) {
                found = index;
            }
        }
        return found;
    }
}
