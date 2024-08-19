package dev.buddly.factorycrm.student;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponse toResponse(Student student){
        return new StudentResponse(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getCompanyId(),
                student.getLessonsId()
        );
    }

    public Student toStudent(StudentRequest request){
        return Student.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .companyId(request.companyId())
                .lessonsId(request.lessonsId())
                .build();
    }
}
