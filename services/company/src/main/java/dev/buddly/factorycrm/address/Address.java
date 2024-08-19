package dev.buddly.factorycrm.address;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
}
