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
public interface StudentDao extends JpaRepository<Student,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Student s set s.username = ?1,s.password = ?2 where s.id = ?3 ")
    void updateStudent(String username,String password,int id);
}

