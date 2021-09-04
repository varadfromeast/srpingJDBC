package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;



public interface StudentDAO {
    public int insert(Student student);
    public int update(Student student);
    public int delete(int id);
    public List<Student> display();

}
