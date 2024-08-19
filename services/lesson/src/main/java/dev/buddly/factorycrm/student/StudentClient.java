package dev.buddly.factorycrm.student;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "student",
        url = "${application.config.student-url}"
)
public interface StudentClient {

    @GetMapping("/lesson/{lessonId}")
    List<StudentResponse> getStudentsByLessonId(
            @PathVariable("lessonId") Integer lessonId
    );
}
