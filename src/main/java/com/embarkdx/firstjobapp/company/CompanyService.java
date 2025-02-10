package com.embarkdx.firstjobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;
public interface CompanyService {

    List<Company> getAllCompany();
    boolean updateCompany(Company company,Long id);
    void deleteCompany(Long id);

    Company getCompanybyID(Long id);

    void createCompany(Company company);
}
