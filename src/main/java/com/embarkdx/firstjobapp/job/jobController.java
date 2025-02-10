package com.embarkdx.firstjobapp.job;

import com.embarkdx.firstjobapp.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class jobController{
    @Autowired
    private jobService jobservice;

    public jobController(jobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<job>> findAll(){

        return ResponseEntity.ok(jobservice.findAll());
    }
    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody job job){
        jobservice.createJob(job);
       // Company c =job.getCompany();

        return new ResponseEntity<>("job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<job> getJobById(@PathVariable Long id){
        job j=jobservice.getJobByID(id);
        if (j!=null)
            return new ResponseEntity<>(j, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        jobservice.deletejobById(id);
        return new ResponseEntity<>(id+ " job has been deleted ",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobByID(@PathVariable Long id, @RequestBody job j3){
        boolean update=jobservice.updateJobByID(id,j3);
        if (update)
            return new ResponseEntity<>("Job Updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
