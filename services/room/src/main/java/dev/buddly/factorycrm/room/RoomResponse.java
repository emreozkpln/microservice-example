package dev.buddly.factorycrm.room;

import dev.buddly.factorycrm.lesson.LessonResponse;

public record RoomResponse(
    Integer id,
    String roomName,
    Integer capacity,
    Integer capacityAvailable,
    LessonResponse lesson
) {
}
