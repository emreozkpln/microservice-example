package dev.buddly.factorycrm.lesson;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "lesson-service",
        url = "${application.config.lesson-url}"
)
public interface LessonClient {

    @GetMapping("/{roomId}")
    LessonResponse getLessonByRoomId(
            @PathVariable("roomId") Integer roomId
    );
}
