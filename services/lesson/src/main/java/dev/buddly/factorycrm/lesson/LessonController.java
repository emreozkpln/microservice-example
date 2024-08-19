package dev.buddly.factorycrm.lesson;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getLessons() {
        return ResponseEntity.ok(lessonService.getLessons());
    }

    @GetMapping("/{room-id}")
    public ResponseEntity<LessonResponse> getLessonByRoomId(
            @PathVariable("room-id") Integer roomId
    ) {
        return ResponseEntity.ok(lessonService.getLessonsByRoomId(roomId));
    }

    @PostMapping
    public ResponseEntity<Integer> createLesson(
            @RequestBody @Valid LessonRequest request
    ) {
        return ResponseEntity.ok(lessonService.createLesson(request));
    }
}
