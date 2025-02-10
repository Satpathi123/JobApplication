package com.embarkdx.firstjobapp.company;

import com.embarkdx.firstjobapp.job.job;
import com.embarkdx.firstjobapp.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Company {
    @Id

    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<job> jobs;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<job> getJobs() {
        return jobs;
    }

    public void setJobs(List<job> jobs) {
        this.jobs = jobs;
    }
}
