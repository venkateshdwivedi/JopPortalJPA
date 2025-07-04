package com.example.jobportaljpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportaljpa.model.JobPost;
import com.example.jobportaljpa.service.JobService;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;
    

    @GetMapping("jobpost")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobpost/{id}")
    public JobPost getjob(@PathVariable int id){
        return service.getjob(id);
    }

    @PostMapping("jobpost")
    public void addJob(@RequestBody JobPost jobpost){
        service.addJob(jobpost);
    }


    @PutMapping("jobpost")
    public void updatejob(@RequestBody JobPost jobpost){
        service.updatejob(jobpost);
    }

    @DeleteMapping("jobpost/{id}")
    public String deletejob(@PathVariable int id){
        service.deletejob(id);
        return "deleted";
    }

    // @GetMapping("load")
    // public String loadData(){
    //     service.loadData();
    //     return "succesfully loaded";
    // }

    @GetMapping("jobpost/search/{keyword}")
    public List<JobPost> searchData(@PathVariable("keyword")String keyword){

        return service.searchData(keyword);
    }
}
