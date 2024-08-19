package dev.buddly.factorycrm.room;

import jakarta.validation.constraints.NotNull;

public record RoomRequest(
    Integer id,
    @NotNull(message = "Room name cannot be null")
    String roomName,
    @NotNull(message = "Capacity cannot be null")
    Integer capacity
) {
}
