package dev.buddly.factorycrm.educator;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/educator")
public class EducatorController {

    private final EducatorService service;

    @GetMapping
    public ResponseEntity<List<EducatorResponse>> getEducators() {
        return ResponseEntity.ok(service.getEducators());
    }

    @GetMapping("/lesson/{lesson-id}")
    public ResponseEntity<EducatorResponse> getEducatorByLessonId(
            @PathVariable("lesson-id") Integer id
    ){

        return ResponseEntity.ok(service.getEducatorByLessonId(id));
    }

    @PostMapping
    public ResponseEntity<String> createEducator(
            @RequestBody @Valid EducatorRequest request
    ){
        return ResponseEntity.ok(service.createEducator(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateEducator(
            @RequestBody @Valid EducatorRequest request
    ){
        service.updateEducator(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{educator-id}")
    public ResponseEntity<EducatorResponse> getEducatorById(
            @PathVariable("educator-id") String id
    ) {
        return ResponseEntity.ok(service.getEducatorById(id));
    }

    @DeleteMapping("/{educator-id}")
    public ResponseEntity<Void> deleteEducator(
            @PathVariable("educator-id") String id
    ) {
        service.deleteEducator(id);
        return ResponseEntity.accepted().build();
    }

}
