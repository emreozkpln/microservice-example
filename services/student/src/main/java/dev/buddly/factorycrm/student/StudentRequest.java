package dev.buddly.factorycrm.student;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record StudentRequest(

        Integer id,

        @NotNull(message = "Firstname is required")
        String firstname,

        @NotNull(message = "Lastname is required")
        String lastname,

        @NotNull(message = "Email is required")
        String email,

        @NotNull(message = "Company id is required")
        Integer companyId,

        @NotNull(message = "Lessons id is required")
        List<Integer> lessonsId
) {
}
