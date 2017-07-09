package com.byAJ.persistence.models;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Skills {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;



@NotEmpty
private String skill, proficiency;

private String username;


public String getSkill() {
	return skill;
}

public void setSkill(String skill) {
	this.skill = skill;
}

public String getProficiency() {
	return proficiency;
}

public void setProficiency(String proficiency) {
	this.proficiency = proficiency;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public long getId() {
	return id;
}



}	