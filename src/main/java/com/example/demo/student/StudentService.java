package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("Email is taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if(studentRepository.findStudentById(id).isPresent()){
            studentRepository.deleteById(id);
        }else{
            throw new IllegalStateException("Student with that ID does not exist!");
        }
    }
}
