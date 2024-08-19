package dev.buddly.factorycrm.lesson;

import dev.buddly.factorycrm.exception.LessonAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository repository;
    private final LessonMapper mapper;

    public List<LessonResponse> getLessons() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Integer createLesson(LessonRequest request) {
        var lesson = repository.findByLessonName(request.lessonName());
        if (lesson != null) {
            throw new LessonAlreadyExistException(
                    format("Lesson with name: %s already exist", request.lessonName())
            );
        }

        return repository.save(mapper.toEntity(request)).getId();
    }

    public LessonResponse getLessonsByRoomId(Integer roomId) {
        return mapper.toResponse(repository.findByRoomId(roomId));
    }
}
