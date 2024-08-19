package dev.buddly.factorycrm.company;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService service;

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getCompanies(){
        return ResponseEntity.ok(service.getCompanies());
    }

    @PostMapping
    public ResponseEntity<Integer> createCompany(
            @RequestBody @Valid CompanyRequest request
    ){
        return ResponseEntity.ok(service.createCompany(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCompany(
            @RequestBody @Valid CompanyRequest request
    ){
        service.updateCompany(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{company-id}")
    public ResponseEntity<Void> deleteCompany(
            @PathVariable("company-id") Integer id
    ){
        service.deleteCompany(id);
        return ResponseEntity.accepted().build();
    }
}
