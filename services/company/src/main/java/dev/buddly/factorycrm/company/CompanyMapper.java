package dev.buddly.factorycrm.company;

import dev.buddly.factorycrm.student.StudentClient;
import dev.buddly.factorycrm.student.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyMapper {

    private final StudentClient studentClient;

    public CompanyResponse toResponse(Company company) {

        List<StudentResponse> students = studentClient.getStudentsByCompanyId(company.getId());

        return new CompanyResponse(
                company.getId(),
                company.getCompanyName(),
                company.getAddress(),
                students
        );
    }

    public Company toCompany(CompanyRequest request){
        return Company.builder()
                .companyName(request.companyName())
                .address(request.address())
                .build();
    }
}
