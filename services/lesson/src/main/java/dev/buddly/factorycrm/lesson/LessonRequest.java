package dev.buddly.factorycrm.lesson;

import jakarta.validation.constraints.NotNull;

public record LessonRequest(
        Integer id,
        @NotNull(message = "Lesson name cannot be null")
        String lessonName,
        @NotNull(message = "Description cannot be null")
        String description,
        @NotNull(message = "Room id cannot be null")
        Integer roomId,

        String educatorId
) {
}
