package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 *This class is  responsible for processing incoming REST API requests, preparing a model, and returning the view to be rendered as a response
 */


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1", produces = APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;


    /**
     * The function receives a GET request , processes it, and .
     * @return return a list of student as a response
     */
    @GetMapping("/students")
    public ResponseEntity <List<Student>> getAllStudent() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }


    /**
     * The function receives a POST request, processes it, creates a new student object and saves it to the database.
     * @param student used to contain student fields
     * @return  a resource link to the created student
     */
    @PostMapping("/student")
    public ResponseEntity <Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(this.studentService.saveStudent(student));
    }


    @GetMapping("/student/{id}")
    public ResponseEntity <Student> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok().body(studentService.getStudentById(studentId));
    }

    /**
     * The function receives a PUT request, updates the student with the specified Id and returns the updated
     * @param id student id
     * @param student used to contain student fields
     * @return and returns the updated student
     */
    @PutMapping("/Student/{id}")
    public ResponseEntity <Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student studId = studentService.getStudentById(id);

        return ResponseEntity.ok().body(this.studentService.updateStudent(student));
    }

    /**
     * The function receives a DELETE request, deletes the student with specified id.
     * @param id student ID
     * @return standard response for successful
     */
    @DeleteMapping("/student/{id}")
    public HttpStatus deleteStudent(@PathVariable long id) {
        this.studentService.deleteStudentById(id);
        return HttpStatus.OK;
    }
}