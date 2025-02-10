package com.embarkdx.firstjobapp.company.impl;

import com.embarkdx.firstjobapp.company.Company;
import com.embarkdx.firstjobapp.company.CompanyRepository;
import com.embarkdx.firstjobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> CompOptional = companyRepository.findById(id);
        if (CompOptional.isPresent()){
            Company company1 =CompOptional.get();
            company1.setId(company.getId());
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());
            companyRepository.save(company1);
            return true;


        }

        return false;
    }

    @Override
    public void deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Company getCompanybyID(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
}
