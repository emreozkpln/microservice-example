package dev.buddly.factorycrm.student;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudents(){
        return ResponseEntity.ok(service.getStudents());
    }

    @GetMapping("/company/{company-id}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCompanyId(
            @PathVariable("company-id") Integer id
    ){
        return ResponseEntity.ok(service.getStudentsByCompanyId(id));
    }

    @GetMapping("/lesson/{lesson-id}")
    public ResponseEntity<List<StudentResponse>> getStudentsByLessonId(
            @PathVariable("lesson-id") Integer id
    ){
        return ResponseEntity.ok(service.getStudentsByLessonId(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createStudent(
            @RequestBody @Valid StudentRequest request
    ){
        return ResponseEntity.ok(service.createStudent(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateStudent(
            @RequestBody @Valid StudentRequest request
    ){
        service.updateStudent(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable("student-id") Integer id
    ){
        service.deleteStudent(id);
        return ResponseEntity.accepted().build();
    }
}
