package com.LearningJPA.Hibernate.learn_jpa_and_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LearningJPA.Hibernate.learn_jpa_and_hibernate.Course.Course;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = "INSERT into course"
    +"(id,name,author)"
    + "VALUES"
    + "(?,?,?)";

    private static String Delete_Query = "Delete from Course" + " where id=?";

    private static String Select_Query = "Select * from Course" + " where id=?";

    public Course selectByid(long id){
        // Mapping Result set -> Bean by using RowMapper
       return springJdbcTemplate.queryForObject(Select_Query,new BeanPropertyRowMapper<>(Course.class),id);
    }

    public void deleteByid(long id){
        springJdbcTemplate.update(Delete_Query,id);
    }

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }
}
