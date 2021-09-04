package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Repository

public class StudentDaoImpl implements StudentDAO{
     @Autowired
     JdbcTemplate jdbcTemplate;

//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name = ?, city = ? where id = ?";
        int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return result;
    }

    @Override
    public int delete(int id) {
        String query = "delete from student where id = ?";
        int result = this.jdbcTemplate.update(query,id);
        return result;
    }

    @Override
    public List<Student> display(){
        String query = "select * from student";
        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setCity(resultSet.getString(3));

                return student;
            }
        };

        List<Student> res = this.jdbcTemplate.query(query,rowMapper);
        return res;

    }


}
