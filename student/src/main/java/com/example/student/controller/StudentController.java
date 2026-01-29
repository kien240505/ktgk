package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // LIST
    @GetMapping("/students")
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // FORM ADD
    @GetMapping("/students/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // SAVE (ADD + EDIT)
    @PostMapping("/students/save")
    public String save(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // FORM EDIT
    @GetMapping("/students/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student",
                studentService.getStudentById(id));
        return "student-form";
    }

    // DELETE
    @GetMapping("/students/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
