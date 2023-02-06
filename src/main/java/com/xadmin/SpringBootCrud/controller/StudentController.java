package com.xadmin.SpringBootCrud.controller;

import com.xadmin.SpringBootCrud.bean.Student;
import com.xadmin.SpringBootCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public List<Student> getAllStudents(){

        return this.studentService.getAllStudents();
    }


    @GetMapping("/getstudent/{id}")
    public Student getAStudent(@PathVariable String id){

        return this.studentService.getAStudent(id);
    }

    @PostMapping ("/createstudent")
    public void addStudent(@RequestBody Student student){
        this.studentService.addStudent(student);
    }

    @PutMapping("/updatestudent{id}" )
    public String updateStudent( @PathVariable String id, @RequestBody Student student){
        this.studentService.updateStudent(id,student);
        return "updated successfully";
    }

      @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent( @PathVariable String id){
        this.studentService.deleteStudent(id);
    }
}
