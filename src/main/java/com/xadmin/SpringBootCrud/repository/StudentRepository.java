package com.xadmin.SpringBootCrud.repository;

import com.xadmin.SpringBootCrud.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student,String> {

}
