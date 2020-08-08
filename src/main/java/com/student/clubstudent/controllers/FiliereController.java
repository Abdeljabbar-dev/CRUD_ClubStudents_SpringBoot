package com.student.clubstudent.controllers;

import com.student.clubstudent.bo.Filiere;
import com.student.clubstudent.bo.Student;
import com.student.clubstudent.services.FiliereServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filieres")
public class FiliereController {

    @Autowired
    private FiliereServices filiereServices;

    @PostMapping(path = "")
        public Filiere createFiliere(@RequestBody Filiere filiere) throws Exception {
        Collection<Filiere> filieres = filiereServices.findAllFilieres();
        for (Filiere filiereCureent : filieres) {

            if (filiere.getName().contentEquals(filiereCureent.getName())) {
                throw new Exception("Filiere already exist");
            }

        }
        return filiereServices.saveFiliere(filiere);
    }

    @GetMapping(path = "")
    public Collection<Filiere> getAllFilieres(){
        return filiereServices.findAllFilieres();
    }
}
