package com.xgileit.learning.student.service;

import com.xgileit.learning.student.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}