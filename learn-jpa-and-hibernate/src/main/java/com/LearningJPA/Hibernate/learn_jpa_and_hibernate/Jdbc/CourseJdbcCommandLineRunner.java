package com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String ...args)throws Exception{
        repository.insert(new Course(1, "learn JPA", "anubhav"));
        
        repository.insert(new Course(2, "learn hibernate", "anubhav"));
        repository.insert(new Course(3, "learn Spring", "anubhav"));

        repository.deleteByid(1);

        System.out.println(repository.selectByid(2));
    }
}
