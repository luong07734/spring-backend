package com.lkluong.java_be.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getAllStudents(Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    public Student saveStudent(Student student){
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new IllegalStateException("email already been taken");
        }
        return studentRepository.save(student);
    }

    public Student findByEmail(String email){
        return studentRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("can not find any student with this email"));
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("can not find any student with this id"));
    }


    public Student updateStudent(Student student, Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException("can not find this student");
        }
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id ){
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException("can not find this student to delete");
        }
        studentRepository.deleteById(id);
    }
}
