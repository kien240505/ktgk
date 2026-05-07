package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentService studentService;

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // ADD
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody Student student) {
        student.setId(id);
        return studentService.saveStudent(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @PostMapping("/update/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        student.setId(id);
        return studentService.updateStudent(student);
    }
    // API SEARCH BY NAME
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentService.searchByName(name);
    }
}
