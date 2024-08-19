package dev.buddly.factorycrm.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCompanyId(Integer id);
    List<Student> findByLessonsId(Integer id);
}
