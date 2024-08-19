package dev.buddly.factorycrm.educator;

import dev.buddly.factorycrm.exception.EducatorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class EducatorService {

    private final EducatorRepository repository;
    private final EducatorMapper mapper;

    public List<EducatorResponse> getEducators() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public String createEducator(EducatorRequest request) {
        var educator = repository.save(mapper.toEducator(request));
        return educator.getId();
    }

    public void updateEducator(EducatorRequest request) {
        var educator = repository.findById(request.id())
                        .orElseThrow(() -> new EducatorNotFoundException(
                                format("Cannot update educator with id: %s", request.id())
                        ));
        mergerEducator(educator, request);
        repository.save(educator);
    }

    private void mergerEducator(Educator educator, EducatorRequest request) {
        if(StringUtils.isNotBlank(request.firstname())) {
            educator.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())) {
            educator.setLastname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())) {
            educator.setEmail(request.email());
        }
    }

    public EducatorResponse getEducatorById(String id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EducatorNotFoundException(
                        format("Cannot find educator with id: %s", id)
                ));
    }

    public void deleteEducator(String id) {
        repository.deleteById(id);
    }

    public EducatorResponse getEducatorByLessonId(Integer id) {
        Educator educator = repository.findByLessonsId(id);
        return mapper.toResponse(educator);
    }
}
