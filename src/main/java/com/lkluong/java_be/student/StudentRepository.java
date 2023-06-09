package com.lkluong.java_be.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

        Optional<Student> findByEmail(String email);

        Optional<Student> findById(Long id);
        boolean existsByEmail(String email);

        boolean existsById(Long id);
}
