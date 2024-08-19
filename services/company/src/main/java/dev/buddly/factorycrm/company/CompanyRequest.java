package dev.buddly.factorycrm.company;

import dev.buddly.factorycrm.address.Address;
import jakarta.validation.constraints.NotNull;

public record CompanyRequest(

        Integer id,

        @NotNull(message = "Company name is required")
        String companyName,

        Address address
) {
}
