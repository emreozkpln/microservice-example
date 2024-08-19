package dev.buddly.factorycrm.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Company findCompanyByCompanyNameContaining(String companyName);
}
