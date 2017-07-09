package com.byAJ.persistence.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String jtitle; 
	
	private String jcompany; 
	
	private int sdate; 
	
	private int edate;
	
	private String username;
	

	private String duty1;
	
	private String duty2;
	
	public String getJtitle() {
		return jtitle;
	}
	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}
	public String getJcompany() {
		return jcompany;
	}
	public void setJcompany(String jcompany) {
		this.jcompany = jcompany;
	}
	public int getSdate() {
		return sdate;
	}
	public void setSdate(int sdate) {
		this.sdate = sdate;
	}
	public int getEdate() {
		return edate;
	}
	public void setEdate(int edate) {
		this.edate = edate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDuty1() {
		return duty1;
	}
	public void setDuty1(String duty1) {
		this.duty1 = duty1;
	}
	public String getDuty2() {
		return duty2;
	}
	public void setDuty2(String duty2) {
		this.duty2 = duty2;
	}
	public int getId() {
		return id;
	}
	
	
	

}
