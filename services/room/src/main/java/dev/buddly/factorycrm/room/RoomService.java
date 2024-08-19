package dev.buddly.factorycrm.room;

import dev.buddly.factorycrm.exception.RoomAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;
    private final RoomMapper mapper;

    public List<RoomResponse> getRooms() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Integer createRoom(RoomRequest request) {
        var room = repository.findByRoomName(request.roomName());
        if(room != null){
            throw new RoomAlreadyExistException(
                format("Room with name: %s already exist", request.roomName())
            );
        }

        return repository.save(mapper.toRoom(request)).getId();
    }

    public void deleteRoom(Integer id) {
        repository.deleteById(id);
    }
}
