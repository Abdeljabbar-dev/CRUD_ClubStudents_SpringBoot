package com.student.clubstudent.services;

import com.student.clubstudent.bo.Student;
import com.student.clubstudent.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    public Collection<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudent(int id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

}
