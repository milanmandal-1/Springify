package com.ironman.springCore.rest;


import com.ironman.springCore.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestPathVariables {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Jack", "Bauer"));
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Doe"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint or "/students/{studentId}"- return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }
}


    //Adding an exception handler using @ExceptionHandler

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        //creating a StudentErrorResponse
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//
//        //return ResponseEntity
//
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//
//        //return ResponseEntity
//
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }

//}