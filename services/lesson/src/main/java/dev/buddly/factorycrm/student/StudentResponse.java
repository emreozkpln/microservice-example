package dev.buddly.factorycrm.student;

public record StudentResponse(
    Integer id,
    String firstname,
    String lastname,
    String email,
    Integer companyId
) {
}
