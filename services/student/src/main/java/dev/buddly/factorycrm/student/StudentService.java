package dev.buddly.factorycrm.student;

import dev.buddly.factorycrm.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public List<StudentResponse> getStudents() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Integer createStudent(StudentRequest request) {
        return repository.save(mapper.toStudent(request))
                .getId();
    }

    public void updateStudent(StudentRequest request) {
        var student = repository.findById(request.id())
                .orElseThrow(() -> new StudentNotFoundException(
                        format("Cannot update student with id: %s", request.id())
                ));
        student.setFirstname(request.firstname());
        student.setLastname(request.lastname());
        student.setEmail(request.email());
        repository.save(student);
    }

    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    public List<StudentResponse> getStudentsByCompanyId(Integer id) {
        List<Student> students = repository.findByCompanyId(id);
        return students
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<StudentResponse> getStudentsByLessonId(Integer id) {
        List<Student> students = repository.findByLessonsId(id);
        return students
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
