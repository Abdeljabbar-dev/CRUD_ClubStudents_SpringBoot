package com.student.clubstudent.controllers;


import com.student.clubstudent.bo.Student;
import com.student.clubstudent.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @GetMapping(path = "")
    public Collection<Student> getAllStudent() {

        return studentServices.findAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Student findStudent(@PathVariable int id ) throws Exception {
        return studentServices.findStudent(id).orElseThrow(() -> new Exception("student not found for id " + id));
    }

    @PostMapping(path = "")
    public Student creatStudent(@RequestBody Student student) throws Exception {
        Collection<Student> students = studentServices.findAllStudents();
        for (Student studentCureent : students) {
            if (student.getCne().equals(studentCureent.getCne())) {
                throw new Exception("Student already exist");
            }
        }
        return studentServices.saveStudent(student);
    }
    

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentServices.deleteStudent(id);
    }


   @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) throws Exception {
        Student student1 = studentServices.findStudent(id).orElseThrow(() -> new Exception("student not found for id " + id));
        student.setId(id);
        if (student.getCne() == null) student.setCne(student1.getCne());
        if(student.getName()==null) student.setName(student1.getName());
        if(student.getAdmis()==null)student.setAdmis(student1.getAdmis());
        if(student.getFiliere()==null)student.setFiliere(student1.getFiliere());

        return studentServices.saveStudent(student);
    }
}
