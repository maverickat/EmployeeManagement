package model;

import java.util.Date;

public class Regulation {
	private String regulationid;
	private String details;
	private Date createDate;
	private String department;
	
	public Regulation() {
	};
	
	public String getRegulationid() {
		return regulationid;
	}
	public void setRegulationid(String regulationid) {
		this.regulationid = regulationid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
