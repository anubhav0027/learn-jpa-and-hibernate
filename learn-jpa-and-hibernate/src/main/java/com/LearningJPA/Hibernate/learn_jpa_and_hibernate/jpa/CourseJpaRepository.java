package com.LearningJPA.Hibernate.learn_jpa_and_hibernate.jpa;

import org.springframework.stereotype.Repository;

import com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public  void deleteByid(long id){
        Course course = entityManager.find(Course.class,id);
         entityManager.remove(course);
    }
}
