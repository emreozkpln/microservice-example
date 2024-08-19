package dev.buddly.factorycrm.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoomAlreadyExistException extends RuntimeException{
    private final String msg;
}
