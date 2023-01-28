package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int id){      //Can we also pass parameter as getStudent(Student student)
        return studentRepository.getStudent(id);  //and then i can get it using  return studentRepository.getStudent(student.getAdmnNo)?
    }

    public String deleteStudent(int id){
        return studentRepository.deleteStudent(id);
    }

    public String updateStudent(int id, int age){
        return studentRepository.updateStudent(id,age);
    }
}
