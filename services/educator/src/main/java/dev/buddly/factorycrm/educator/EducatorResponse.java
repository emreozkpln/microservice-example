package dev.buddly.factorycrm.educator;

import java.util.List;

public record EducatorResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    List<Integer> lessonsId
) {
}
