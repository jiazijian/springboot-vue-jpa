package com.peimeton.springboot.vue.dao;

import com.peimeton.springboot.vue.model.Book;
import com.peimeton.springboot.vue.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jzj
 * @create 2019/7/11-- 13:16
 * @since 1.0.0
 */
@Repository
public interface BookDao extends JpaRepository<Book,String> {
    @Query(value = "select book from Book book where s_id = ?1")
    List<Book> findBookByUserId(Integer id);
}

