package com.ssd.jdbcdemo.repo;

import com.ssd.jdbcdemo.entity.Student;

import java.util.List;
public interface StudentRepository {
    List<Student> findAll();

}
