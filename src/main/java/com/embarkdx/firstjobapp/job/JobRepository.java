package com.embarkdx.firstjobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<job,Long> {

}
