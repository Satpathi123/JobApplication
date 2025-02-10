package com.embarkdx.firstjobapp.job.impl;

import com.embarkdx.firstjobapp.job.JobRepository;
import com.embarkdx.firstjobapp.job.job;
import com.embarkdx.firstjobapp.job.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class jobServiceimpl implements jobService {

   // private List<job> job1 =new ArrayList<>();
    @Autowired
    private JobRepository jr;
    private Long nextInt =1L;
    @Override
    public List<job> findAll() {
        return jr.findAll();
    }

    @Override
    public void createJob(job j) {
        j.setId(nextInt++);
        jr.save(j);

    }

    public job getJobByID(Long id){

        return jr.findById(id).orElse(null);




    }

    @Override
    public void deletejobById(Long id) {
        try {
            jr.deleteById(id);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public boolean updateJobByID(Long id,job uj) {

        Optional<job> jobOpt =jr.findById(id);
        if (jobOpt.isPresent()){
            job j=jobOpt.get();
            j.setId(uj.getId());
            j.setDescription(uj.getDescription());
            j.setLocation(uj.getLocation());
            j.setTitle(uj.getTitle());
            j.setMinSalary(uj.getMinSalary());
            j.setMaxSalary(uj.getMaxSalary());
            jr.save(j);
            return true;

        }else{
            return  false;
        }

    }
}
