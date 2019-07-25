package com.billability.basedata.model;

import java.util.List;

public class DashboardVAO {
	
	private Object projectType;
	
	private Object poFlag;
	
	private Object onsiteOffshore;
	
	private Object billablityStatus;
	
	private Object  employeeClassCategory;
	
	private Object  ct;

	public Object getProjectType() {
		return projectType;
	}

	public void setProjectType(Object projectType) {
		this.projectType = projectType;
	}

	public Object getPoFlag() {
		return poFlag;
	}

	public void setPoFlag(Object poFlag) {
		this.poFlag = poFlag;
	}

	public Object getOnsiteOffshore() {
		return onsiteOffshore;
	}

	public void setOnsiteOffshore(Object onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}

	public Object getBillablityStatus() {
		return billablityStatus;
	}

	public void setBillablityStatus(Object billablityStatus) {
		this.billablityStatus = billablityStatus;
	}

	public Object getEmployeeClassCategory() {
		return employeeClassCategory;
	}

	public void setEmployeeClassCategory(Object employeeClassCategory) {
		this.employeeClassCategory = employeeClassCategory;
	}

	public Object getCt() {
		return ct;
	}

	public void setCt(Object ct) {
		this.ct = ct;
	}

	@Override
	public String toString() {
		return "DashboardVAO [projectType=" + projectType + ", poFlag=" + poFlag + ", onsiteOffshore=" + onsiteOffshore
				+ ", billablityStatus=" + billablityStatus + ", employeeClassCategory=" + employeeClassCategory
				+ ", ct=" + ct + "]";
	}
	
//	public DashboardVAO(Object dList) {
//			
//			setProjectType(dList.toString());
//			
//	}
	
		
}
