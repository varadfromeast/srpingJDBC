package com.example.demo.controller;



import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dao.StudentDaoImpl;
import java.util.List;

@RestController
@RequestMapping("/user")

public class Controller {

    @Autowired
    StudentDAO studentDAO;


    @GetMapping("/all")
    public List<Student> getAll()
    {
        System.out.println("getall");
//        List<Student> students = studentDAO.display();
//
//        for(Student i :students)
//            System.out.println(i);

        return studentDAO.display();
    }


    @PostMapping("/insert")
    public ResponseEntity<String> createUser(@RequestBody Student student){

        studentDAO.insert(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody Student student){

        studentDAO.update(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {

        studentDAO.delete(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

}
