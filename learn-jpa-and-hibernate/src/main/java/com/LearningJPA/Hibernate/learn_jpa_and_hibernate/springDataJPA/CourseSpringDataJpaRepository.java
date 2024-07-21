package com.LearningJPA.Hibernate.learn_jpa_and_hibernate.springDataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);

}
