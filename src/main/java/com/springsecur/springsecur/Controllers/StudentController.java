package com.springsecur.springsecur.Controllers;

import com.springsecur.springsecur.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Paramesh", 19),
            new Student(2, "Praveen", 20),
            new Student(3, "Rahul", 21)
    ));

    @GetMapping("/students")
    public List<Student> getstudents(){
        return students;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getcsrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student getStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
