package com.example.demo.student;

import org.hibernate.boot.cfgxml.internal.ConfigLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student milos = new Student(
                    "Milos",
                    25,
                    LocalDate.of(1995, 12,28),
                    "milos@gmail.com");

            Student marko = new Student(
                    "Marko",
                    25,
                    LocalDate.of(1995, 12,28),
                    "marko@gmail.com");

            studentRepository.saveAll( List.of(milos, marko) );

        };
    }

}
