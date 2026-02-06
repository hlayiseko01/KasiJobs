package com.bennet.Job.Board.model;


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer jobId;
   String title;
   String description;
   String requirements;
   Double salary;
   String street;
   String suburb;
   String city;
   String employerName;
   LocalDate postedAt;

   @ManyToOne
   @JoinColumn(name = "employer_id",nullable = false)
   private User employer;

    public Job(Integer jobId, String title, String description, String requirements, Double salary, String street, String suburb, String city, String employerName, LocalDate postedAt, User employer) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.salary = salary;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.employerName = employerName;
        this.postedAt = postedAt;
        this.employer = employer;
    }

    public Job() {
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public User getEmployer() {
        return employer;
    }

    public void setEmployer(User employer) {
        this.employer = employer;
    }
}
