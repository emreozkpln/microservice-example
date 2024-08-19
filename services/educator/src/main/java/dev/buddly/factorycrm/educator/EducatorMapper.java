package dev.buddly.factorycrm.educator;

import org.springframework.stereotype.Service;

@Service
public class EducatorMapper {
    public EducatorResponse toResponse(Educator educator) {
        return new EducatorResponse(
                educator.getId(),
                educator.getFirstname(),
                educator.getLastname(),
                educator.getEmail(),
                educator.getLessonsId()
        );
    }

    public Educator toEducator(EducatorRequest request) {
        if(request == null) {
            return null;
        }
        return Educator.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .lessonsId(request.lessonsId())
                .build();
    }
}
