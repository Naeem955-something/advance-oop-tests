package com.example.recipebox.controller;

import com.example.recipebox.model.Student;
import com.example.recipebox.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/getAll")
    public List<Student> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return service.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student, @PathVariable int id) {
        student.setId(id);
        return service.save(student);
    }

    @PatchMapping("/{id}")
    public Student partialUpdate(@RequestBody Student student, @PathVariable int id) {
        Student existing = service.get(id);
        if (existing == null) {
            return null;
        }
        if (student.getName() != null && !student.getName().isEmpty()) {
            existing.setName(student.getName());
        }
        if (student.getEmail() != null && !student.getEmail().isEmpty()) {
            existing.setEmail(student.getEmail());
        }
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Deleted " + id;
    }
}
