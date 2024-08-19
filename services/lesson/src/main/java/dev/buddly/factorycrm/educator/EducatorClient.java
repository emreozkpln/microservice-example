package dev.buddly.factorycrm.educator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "educator-service",
        url = "${application.config.educator-url}"
)
public interface EducatorClient {

    @GetMapping("/lesson/{lessonId}")
    EducatorResponse getEducatorByLessonId(
            @PathVariable("lessonId") Integer lessonId
    );
}
