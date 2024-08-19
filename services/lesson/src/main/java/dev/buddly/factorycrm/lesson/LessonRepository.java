package dev.buddly.factorycrm.lesson;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Lesson findByLessonName(String lessonName);
    Lesson findByRoomId(Integer roomId);
}
