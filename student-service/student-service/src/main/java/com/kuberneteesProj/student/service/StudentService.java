package com.kuberneteesProj.student.service;

import com.kuberneteesProj.student.VO.Department;
import com.kuberneteesProj.student.VO.ResponseTemplateVO;
import com.kuberneteesProj.student.entity.Student;
import com.kuberneteesProj.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Student saveStudent(Student student) {
        log.info("saveStudent method service");
        return studentRepository.save(student);
    }

    public ResponseTemplateVO findByStudentId(Long studentId) {
        log.info("findStudent method service");
        ResponseTemplateVO vo = new ResponseTemplateVO();

        Student student =  studentRepository.findByStudentId(studentId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+student.getDepartmentId(),Department.class);
        vo.setStudent(student);
        vo.setDepartment(department);
        return vo;
    }
}
