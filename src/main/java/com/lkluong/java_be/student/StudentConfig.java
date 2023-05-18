package com.lkluong.java_be.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{

            var listStudent = List.of(
                    new Student( "Lê Kỳ Lương", LocalDate.of(2004, Month.MAY, 6), "le.ky.luong@gmail.com"),
                    new Student( "Nguyễn Văn Dũng", LocalDate.of(2006, Month.NOVEMBER, 15), "nguyen.van.dung@gmail.com"),
                    new Student( "Lê Quang Minh", LocalDate.of(2009, Month.DECEMBER, 25), "le.quang.minh@gmail.com"),
                    new Student( "Bùi Huỳnh Trung Nam", LocalDate.of(2001, Month.MAY, 3), "bui.huynh.trung.nam@gmail.com"),
                    new Student( "Ngô Nguyễn Kiết Tường", LocalDate.of(1999, Month.MAY, 12), "ngo.nguyen.kiet.tuong@gmail.com"),
                    new Student( "Nguyễn Đạt Thịnh", LocalDate.of(2003, Month.MARCH, 29), "nguyen.dat.thinh@gmail.com"),
                    new Student( "Phạm Minh Nguyên", LocalDate.of(2004, Month.JULY, 2), "pham.minh.nguyen@gmail.com"),
                    new Student( "Bùi Nhật Nam", LocalDate.of(2002, Month.JANUARY, 17), "bui.nhat.nam@gmail.com"),
                    new Student( "Phạm Minh Huy", LocalDate.of(1998, Month.JULY, 9), "pham.minh.huy@gmail.com"),
                    new Student( "Nguyễn Lâm Trường", LocalDate.of(2000, Month.OCTOBER, 22), "nguyen.lam.truong@gmail.com"),
                    new Student( "Vũ Mạnh Hùng", LocalDate.of(2003, Month.SEPTEMBER, 23), "vu.manh.hung@gmail.com"),
                    new Student( "Phạm Ninh Sơn", LocalDate.of(2001, Month.FEBRUARY, 8), "pham.ninh.son@gmail.com"),
                    new Student( "Trịnh Minh Triều", LocalDate.of(2006, Month.APRIL, 12), "trinh.minh.trieu@gmail.com"),
                    new Student( "Tăng Kim Long", LocalDate.of(2003, Month.AUGUST, 3), "tang.kim.long@gmail.com")
            );
            studentRepository.saveAll(listStudent);
        };
    }
}
