package dev.buddly.factorycrm.lesson;

import dev.buddly.factorycrm.educator.EducatorClient;
import dev.buddly.factorycrm.educator.EducatorResponse;
import dev.buddly.factorycrm.student.StudentClient;
import dev.buddly.factorycrm.student.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonMapper {

    private final StudentClient client;
    private final EducatorClient educatorClient;
    public LessonResponse toResponse(Lesson lesson) {
        List<StudentResponse> students = client.getStudentsByLessonId(lesson.getId());
        EducatorResponse educator = educatorClient.getEducatorByLessonId(lesson.getId());

        return new LessonResponse(
                lesson.getId(),
                lesson.getLessonName(),
                lesson.getDescription(),
                lesson.getRoomId(),
                educator,
                students
        );
    }

    public Lesson toEntity(LessonRequest request) {
        return new Lesson(
                request.id(),
                request.lessonName(),
                request.description(),
                request.roomId(),
                request.educatorId()
        );
    }
}
