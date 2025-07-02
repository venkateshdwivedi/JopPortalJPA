package com.example.jobportaljpa.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jobportaljpa.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer>{
        

    @Query("SELECT j FROM JobPost j WHERE j.postDesc LIKE %:keyword% OR j.postProfile LIKE %:keyword%")
    List<JobPost> findbyKeywords(String keyword);
  
}


