package com.example.recipebox.service;

import com.example.recipebox.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private Map<Integer, Student> db = new HashMap<>();
    private int idCounter = 1;

    public List<Student> listAll() {
        return new ArrayList<>(db.values());
    }

    public Student save(Student student) {
        if (student.getId() == 0) {
            student.setId(idCounter++);
        }
        db.put(student.getId(), student);
        return student;
    }

    public Student get(int id) {
        return db.get(id);
    }

    public void delete(int id) {
        db.remove(id);
    }
}
