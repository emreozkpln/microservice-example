package dev.buddly.factorycrm.educator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EducatorRequest(

        String id,

        @NotNull(message = "Firstname is required")
        String firstname,

        @NotNull(message = "Lastname is required")
        String lastname,

        @NotNull(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        List<Integer> lessonsId
) {
}
