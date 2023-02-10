package com.xadmin.SpringBootCrud.repository;

import com.xadmin.SpringBootCrud.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    List<Student> findByCity(String city);
}
