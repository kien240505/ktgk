package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student.model.Student;
import java.util.List;
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
