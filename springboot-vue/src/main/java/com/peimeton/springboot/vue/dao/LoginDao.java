package com.peimeton.springboot.vue.dao;

import com.peimeton.springboot.vue.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jzj
 * @create 2019/7/11-- 13:16
 * @since 1.0.0
 */
@Repository
public interface LoginDao extends JpaRepository<Student,String> {
    @Query("select s from  Student s where username =?1 ")
    Student findByUserName(String username);

//    @Transactional
//    @Modifying
//    @Query("update Student  set s_name = ?1 where s_id = ?2")
//    void updateStudent(String s_name, String s_id);
//
//    @Query("select s.courses from Student as s where s_id = ?1 ")
//    List findCourseByStudentId(@Param(value = "s_id") String s_id);




}

