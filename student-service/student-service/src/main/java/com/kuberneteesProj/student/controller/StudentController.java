package com.kuberneteesProj.student.controller;

import com.kuberneteesProj.student.VO.ResponseTemplateVO;
import com.kuberneteesProj.student.entity.Student;
import com.kuberneteesProj.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        log.info("saveStudent method controller");
        return studentService.saveStudent(student);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO findStudent(@PathVariable("id") Long studentId){
        log.info("findStudent method controller");
        return studentService.findByStudentId(studentId);
    }
}
