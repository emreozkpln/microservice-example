package dev.buddly.factorycrm.company;

import dev.buddly.factorycrm.address.Address;
import dev.buddly.factorycrm.student.StudentResponse;

import java.util.List;

public record CompanyResponse(
    Integer id,
    String companyName,
    Address address,
    List<StudentResponse> students
) {
}
