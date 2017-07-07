package com.byAJ.persistence.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String jtitle; 
	private String jcompany; 
	private LocalDateTime sdate; 
	private LocalDateTime edate;
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
	public LocalDateTime getSdate() {
		return sdate;
	}
	public void setSdate(LocalDateTime sdate) {
		this.sdate = sdate;
	}
	public LocalDateTime getEdate() {
		return edate;
	}
	public void setEdate(LocalDateTime edate) {
		this.edate = edate;
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
