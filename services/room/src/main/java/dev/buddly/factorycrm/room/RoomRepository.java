package dev.buddly.factorycrm.room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    Room findByRoomName(String roomName);
}
