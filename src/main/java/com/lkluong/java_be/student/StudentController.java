package com.lkluong.java_be.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy
    ){
        Pageable pageable;
        if(sortBy != null){
            pageable = PageRequest.of(page, size, Sort.by(sortBy));
        }else{
            pageable = PageRequest.of(page, size);
        }
        Page<Student> studentPage =  studentService.getAllStudents(pageable);
        if(studentPage.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(studentPage.getContent());
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<Student> findStudentByEmail(
            @RequestParam String email
    )
    {
        Student student = studentService.findByEmail(email);
        return ResponseEntity.ok(student);
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> findByEmail(@PathVariable("studentId") Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }


    @PostMapping
    public  ResponseEntity<Student> addNewStudent(@RequestBody Student student){
        Student savedStudent =  studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student, id);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete student with id " + id.toString() + " successfully");
    }
}
