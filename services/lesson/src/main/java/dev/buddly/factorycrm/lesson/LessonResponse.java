package dev.buddly.factorycrm.lesson;

import dev.buddly.factorycrm.educator.EducatorResponse;
import dev.buddly.factorycrm.student.StudentResponse;

import java.util.List;

public record LessonResponse(
    Integer id,
    String lessonName,
    String description,
    Integer roomId,
    EducatorResponse educatorId,
    List<StudentResponse> students
) {
}
