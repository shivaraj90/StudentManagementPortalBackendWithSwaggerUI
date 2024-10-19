package org.shiva.SMS.service;

import lombok.AllArgsConstructor;
import org.shiva.SMS.entity.Student;
import org.shiva.SMS.exceptions.ResourceNotFound;
import org.shiva.SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    StudentRepository studentRepository;
    public Student createStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public List<Student> studentsList(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Student getStudentById(Long id){
        Student savedStudent = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("No student found with id :" + id)
                );
        return savedStudent;
    }

    public Student updateStudentById(Long id,Student student){
        Student savedStudent = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("No student found with id :" + id)
        );
        savedStudent.setEmail(student.getEmail());
        savedStudent.setName(student.getName());
        studentRepository.save(savedStudent);
        return savedStudent;
    }

    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("No Students found with id : "+id)
                );
        studentRepository.deleteById(id);
    }
}
