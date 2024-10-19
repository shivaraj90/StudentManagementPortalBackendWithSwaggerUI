package org.shiva.SMS.controller;

import lombok.AllArgsConstructor;
import org.shiva.SMS.entity.Student;
import org.shiva.SMS.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    StudentService studentService ;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1 = studentService.createStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student student1 = studentService.getStudentById(id);
        return new ResponseEntity<>(student1,HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") Long id,@RequestBody Student student){
        Student student1 = studentService.updateStudentById(id,student);
        return ResponseEntity.ok(student1);
    }

    @GetMapping
    public ResponseEntity<List<Student>> studentList(){
        List<Student> students = studentService.studentsList();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSudentById(@PathVariable("id") Long id){
        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student with ID : "+id+" deleted successfully");
    }

}
