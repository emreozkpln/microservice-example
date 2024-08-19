package dev.buddly.factorycrm.room;

import dev.buddly.factorycrm.lesson.LessonClient;
import dev.buddly.factorycrm.lesson.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomMapper {
    private final LessonClient client;
    public RoomResponse toResponse(Room room) {
        LessonResponse lesson = client.getLessonByRoomId(room.getId());

        return new RoomResponse(
                room.getId(),
                room.getRoomName(),
                room.getCapacity(),
                room.getCapacityAvailable(),
                lesson
        );
    }

    public Room toRoom(RoomRequest request) {
        return Room.builder()
                .roomName(request.roomName())
                .capacity(request.capacity())
                .build();
    }
}
