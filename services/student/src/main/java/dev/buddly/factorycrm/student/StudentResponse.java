package dev.buddly.factorycrm.student;

import java.util.List;

public record StudentResponse(
    Integer id,
    String firstname,
    String lastname,
    String email,
    Integer companyId,
    List<Integer> lessonsId
) {
}
