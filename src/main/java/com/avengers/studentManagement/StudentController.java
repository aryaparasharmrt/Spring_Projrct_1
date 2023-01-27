package com.avengers.studentManagement;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer, Student> db = new HashMap<>();

    @GetMapping("/get_student")
    public  Student getStudent(@RequestParam("admnNo") int admnNo)
    {
        return db.get(admnNo);
    }

    @PostMapping("/add_student")
    public String addStudent( @RequestBody Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo, student);
        return "Student Added Successfully";

    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id, @RequestParam("age") int age)
    {

        if(!db.containsKey(id)){
            return "Invalid Id";
        }
        db.get(id).setAge(age);
        return "Student Updated";
    }

    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){

        if(!db.containsKey(id))
            return "Invalid Id";

        db.remove(id);
        return "Student Deleted Successfully";
    }
}
