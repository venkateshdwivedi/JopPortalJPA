package com.example.jobportaljpa.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

	@Id
	private int postId;
	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;	

	@ElementCollection
	private List<String> postTechStack;
	

}

