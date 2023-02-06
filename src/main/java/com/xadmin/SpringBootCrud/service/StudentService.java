package com.xadmin.SpringBootCrud.service;

import com.xadmin.SpringBootCrud.bean.Student;
import com.xadmin.SpringBootCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepo;
    public List<Student> getAllStudents(){

        return studentRepo.findAll();

    }

    public void addStudent(Student student){
        this.studentRepo.save(student);
    }

    public void updateStudent(String id,  Student student){
        studentRepo.save(student);
    }

    public void deleteStudent(String id){
        this.studentRepo.deleteById(id);
    }

    public Student getAStudent(String id){
        return this.studentRepo.findById(id).get();
        //return null;
    }
}
