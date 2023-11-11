package com.edureka.studentms;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    //private final StudentService service = new StudentService();

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){

        studentService.saveStudent(student);
        return ResponseEntity.ok().body("ok");

    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/students/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }

    @DeleteMapping("/student/{school-id}")
    public ResponseEntity<String> delete(@PathVariable("school-id") Integer id){
        studentService.deleteById(id);
        return ResponseEntity.ok().body("Deleted Student");
    }


    @PutMapping("/student/{school-id}")
    public ResponseEntity<String> update(@PathVariable("school-id") Integer id,@RequestBody Student student){
        studentService.updateStudent(student);
        return ResponseEntity.ok().body("Updated Successfully");
    }




}
