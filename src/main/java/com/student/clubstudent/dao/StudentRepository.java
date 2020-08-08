package com.student.clubstudent.dao;

import com.student.clubstudent.bo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
