package com.embarkdx.firstjobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){

       return new ResponseEntity<>(companyService.getAllCompany(),HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        boolean uc= companyService.updateCompany(company,id);
        if (uc){
            return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyByID(@PathVariable Long id){
        Company c= companyService.getCompanybyID(id);
        if (c!=null)
            return new ResponseEntity<>(c,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company  created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return  new ResponseEntity<>("Company deleted Successfully",HttpStatus.OK);


    }


}
