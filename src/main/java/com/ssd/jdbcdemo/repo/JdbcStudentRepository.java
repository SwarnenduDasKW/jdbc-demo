package com.ssd.jdbcdemo.repo;

import com.ssd.jdbcdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcStudentRepository implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> findAll() {

        return jdbcTemplate.query("SELECT * FROM schooldb.student",
                BeanPropertyRowMapper.newInstance(Student.class
        ));
    }
}
