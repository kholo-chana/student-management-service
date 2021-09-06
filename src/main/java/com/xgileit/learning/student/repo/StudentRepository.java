package com.xgileit.learning.student.repo;

import com.xgileit.learning.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface provides CRUD functions already implemented
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}