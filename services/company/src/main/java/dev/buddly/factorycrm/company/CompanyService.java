package dev.buddly.factorycrm.company;

import dev.buddly.factorycrm.exception.CompanyAllreadyExistException;
import dev.buddly.factorycrm.exception.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public List<CompanyResponse> getCompanies() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Integer createCompany(CompanyRequest request) {
        var existingCompany = repository.findCompanyByCompanyNameContaining(request.companyName());

        if(existingCompany != null) {
            throw new CompanyAllreadyExistException(
                    format("Company with name %s already exists", request.companyName())
            );
        }

        var company = mapper.toCompany(request);
        repository.save(company);
        return company.getId();
    }

    public void updateCompany(CompanyRequest request) {
        var company = repository.findById(request.id())
                .orElseThrow(() -> new CompanyNotFoundException(
                        format("Cannot update company with id: %s", request.id())
                ));
        company.setCompanyName(request.companyName());
        company.setAddress(request.address());
        repository.save(company);
    }

    public void deleteCompany(Integer id) {
        repository.deleteById(id);
    }
}
