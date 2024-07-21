package com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Course.Course;
import com.LearningJPA.Hibernate.learn_jpa_and_hibernate.springDataJPA.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String ...args)throws Exception{
        repository.save(new Course(1, "learn JPA", "anubhav"));
        
        repository.save(new Course(2, "learn hibernate!!", "anubhav"));
        repository.save(new Course(3, "learn Spring", "anubhav"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());

        
        System.out.println(repository.findByAuthor("anubhav"));
    }
}
