package com.student.clubstudent.dao;

import com.student.clubstudent.bo.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;


@CrossOrigin("*")
@RepositoryRestResource
@Transactional
public interface FiliereRepository extends JpaRepository<Filiere, Integer> {


}
