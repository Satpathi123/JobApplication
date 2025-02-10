package com.embarkdx.firstjobapp.job;

import java.util.List;

public interface jobService {

    List<job> findAll();
    void createJob(job j);

    job getJobByID(Long id);

    void deletejobById(Long id);
    boolean updateJobByID(Long id ,job j);
}
