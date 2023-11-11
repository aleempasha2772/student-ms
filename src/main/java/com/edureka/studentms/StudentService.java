package com.edureka.studentms;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }

//    public Optional<Student> findByStudentd(Integer schoold){
//
//        return repository.findAllById()
//    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @SuppressWarnings("unchecked")
    public ResponseEntity<Student> updateStudent(Student student){
        Optional<Student> studentDb = this.repository.findById(student.getId());
        if(studentDb.isPresent()) {
            Student studentUpdate = studentDb.get();
            studentUpdate.setFirstname(student.getFirstname());
            studentUpdate.setLastname(student.getLastname());
            studentUpdate.setEmail(student.getEmail());
            studentUpdate.setSchoolId(student.getSchoolId());
            repository.save(studentUpdate);

            return ResponseEntity.ok().body(studentUpdate);
        }
        else {
            return (ResponseEntity<Student>) ResponseEntity.badRequest();
        }

    }
}
