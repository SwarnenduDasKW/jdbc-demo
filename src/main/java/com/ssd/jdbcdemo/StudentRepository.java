package com.ssd.jdbcdemo;

import java.util.List;
public interface StudentRepository {
    List<Student> findAll();

}
