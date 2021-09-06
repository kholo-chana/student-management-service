package com.xgileit.learning.student.service;

import com.xgileit.learning.student.exception.ResourceNotFoundException;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * This class is used to provide some business functionalities.
 */

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{


    private final  StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studId) {

        Optional<Student> studentId = this.studentRepository.findById(studId);

        if (studentId.isPresent()) {
            return studentId.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + studId);
        }
    }


    @Override
    public Student updateStudent(Student student) {
        Optional <Student> studentDb = this.studentRepository.findById(student.getId());

        if (studentDb.isPresent()) {
            Student studUpdate = studentDb.get();
            studUpdate.setId(studentDb.get().getId());
            studUpdate.setFirstName(student.getFirstName());
            studUpdate.setLastName(student.getLastName());
            studUpdate.setEmail(student.getEmail());
            studentRepository.save(studUpdate);
            return studUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + student.getId());
        }
    }


    @Override
    public void deleteStudentById(Long studId) {
        Optional <Student> studentId = this.studentRepository.findById(studId);

        if (studentId.isPresent()) {
            this.studentRepository.delete(studentId.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + studentId);
        }

    }
}