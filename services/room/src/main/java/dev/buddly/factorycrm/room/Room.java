package dev.buddly.factorycrm.room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Room {

    @Id
    @GeneratedValue
    private Integer id;
    private String roomName;
    private Integer capacity;
    private Integer capacityAvailable;
}
