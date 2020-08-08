package com.student.clubstudent.services;

import com.student.clubstudent.bo.Filiere;
import com.student.clubstudent.dao.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FiliereServices {
    @Autowired
    private FiliereRepository filiereRepository;

    public Optional<Filiere> findFiliere(int id){
        return filiereRepository.findById(id);
    }

    public Collection<Filiere> findAllFilieres(){
        return filiereRepository.findAll();
    }

    public Filiere saveFiliere(Filiere filiere){
        return filiereRepository.save(filiere);
    }

}
