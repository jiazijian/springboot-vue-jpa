package com.peimeton.springboot.vue.service;

import com.peimeton.springboot.vue.dao.BookDao;
import com.peimeton.springboot.vue.dao.LoginDao;
import com.peimeton.springboot.vue.dao.StudentDao;
import com.peimeton.springboot.vue.model.Book;
import com.peimeton.springboot.vue.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author jzj
 * @create 2019/7/11-- 13:19
 * @since 1.0.0
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao baseDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private LoginDao loginDao;


    public List<Student> addStudent(Student student) {
        Student s = loginDao.findByUserName(student.getUsername());
        if (s != null) {
            return null;
        } else {
            baseDao.save(student);
            List<Student> studentList = baseDao.findAll();
            return studentList;
        }
    }

    public List<Student> findStudents() {
        List<Student> sutdents = baseDao.findAll();
        return sutdents;
    }

    public List<Book> findAllBook() {
        List<Book> allBook = bookDao.findAll();
        return allBook;
    }

    public Student getStudent(int id) {
        Optional<Student> student = baseDao.findById(id);
        return student.get();
    }

    public List<Student> updateStudent(Student student) {
        Student s = loginDao.findByUserName(student.getUsername());
        if (s != null && s.getId()!=student.getId()) {
            return null;
        } else {
            baseDao.updateStudent(student.getUsername(),student.getPassword(),student.getId());
            List<Student> studentList = baseDao.findAll();
            return studentList;
        }
    }

    public void delStudent(Integer id) {
        baseDao.deleteById(id);
    }

    public List<Book> findBooks(Integer id){
        return bookDao.findBookByUserId(id);
    }
}