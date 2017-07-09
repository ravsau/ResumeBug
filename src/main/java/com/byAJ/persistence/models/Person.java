package com.byAJ.persistence.models;

import java.util.ArrayList;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Person {
     
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String fName;
	@NotEmpty
	private String lName;
	
	
	@NotEmpty
    private String email;
	
	
	private ArrayList <Education> eduList;
	private ArrayList <Job> jobList;
	private ArrayList <Skills> skillList;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
	
	public Person(){
		jobList = new ArrayList<Job>(); 
		eduList = new ArrayList<Education>(); 
		skillList = new ArrayList<Skills>();
	}
	public Person(String fname, String lname, String email) {	
		this.fName = fname; 
		this.lName = lname; 
		this.email = email; 
		jobList = new ArrayList <Job>(); 
		eduList = new ArrayList<Education>(); 
		skillList = new ArrayList<Skills>();
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Education> getEduList() {
		return eduList;
	}
	public void setEduList(ArrayList<Education> eduList) {
		this.eduList = eduList;
	}
	public ArrayList<Job> getJobList() {
		return jobList;
	}
	public void setJobList(ArrayList<Job> jobList) {
		this.jobList = jobList;
	}
	public ArrayList<Skills> getSkillList() {
		return skillList;
	}
	public void setSkillList(ArrayList<Skills> skillList) {
		this.skillList = skillList;
	}
	public int getId() {
		return id;
	}
	
	
	
	
}
