package dev.buddly.factorycrm.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyAllreadyExistException extends RuntimeException {
    private final String msg;
}
