package dev.buddly.factorycrm.student;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "student-service",
        url = "${application.config.student-url}"
)
public interface StudentClient {

    @GetMapping("/company/{companyId}")
    List<StudentResponse> getStudentsByCompanyId(
            @PathVariable("companyId") Integer companyId
    );
}
