package com.peimeton.springboot.vue.controller;

import com.peimeton.springboot.vue.model.Book;
import com.peimeton.springboot.vue.model.Student;
import com.peimeton.springboot.vue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author jiazj
 * @create 2019/7/17- 9:40
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/addStudent")
    public List<Student> addStudent(@RequestParam String username,@RequestParam String password){
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        List<Student> students = studentService.addStudent(student);
        return students;
    }

    @RequestMapping("/findAllStudent")
    public List<Student> findAllStudent(){
        List<Student> students = studentService.findStudents();
        return students;
    }

    @RequestMapping("/findAllBook")
    public List<Book> findAllBook(){
        List<Book> books = studentService.findAllBook();
        return books;
    }

    @RequestMapping("/getStudent")
    public Student getStudent(@RequestParam Integer id){
       Student student = studentService.getStudent(id);
       return student;
    }


    @RequestMapping("/updateStudent")
    public List<Student> updateStudent(@RequestParam Map<String,Object> map){
        String s_id = (String) map.get("student[id]");
        String username = (String) map.get("student[username]");
        String password  = (String) map.get("student[password]");
        Student student = new Student();

        student.setId(Integer.parseInt(s_id));
        student.setUsername(username);
        student.setPassword(password);
        List<Student> s= studentService.updateStudent(student);
        return s;

    }

    @RequestMapping("/delStudent")
    public List<Student>  delStudent(Integer id){
        studentService.delStudent(id);
        List<Student> students = studentService.findStudents();
        return students;
    }
    @RequestMapping("findBooks")
    public List<Book> findBooks(Integer userId){
        List<Book> books = studentService.findBooks(userId);
        return books;
    }
}
