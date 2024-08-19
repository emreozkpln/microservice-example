package dev.buddly.factorycrm.room;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getRooms() {
        return ResponseEntity.ok(roomService.getRooms());
    }

    @PostMapping
    public ResponseEntity<Integer> createRoom(
            @RequestBody @Valid RoomRequest request
    ) {
        return ResponseEntity.ok(roomService.createRoom(request));
    }

    @DeleteMapping("/{room-id}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable("room-id") Integer id
    ) {
        roomService.deleteRoom(id);
        return ResponseEntity.accepted().build();
    }
}
