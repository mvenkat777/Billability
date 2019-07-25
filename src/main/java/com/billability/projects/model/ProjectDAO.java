package com.billability.projects.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "projects")
public class ProjectDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message="Project Id is mandatory")
    @Size(max=100,message="Project Id cannot exceed more than 100 characters")
	@Column(name = "project_code", nullable = false, unique = true)
    private String projectId;
	
	@NotBlank(message="Project Type is mandatory")
    @Size(max=100,message="Project Type cannot exceed more than 100 characters")
	@Column(name = "project_type")
    private String projectType;
    
	@NotBlank(message="Project Description is mandatory")
    @Size(max=250,message="Project Description cannot exceed more than 250 characters")
	@Column(name = "project_description")
    private String projectDescription;
    
	@NotBlank(message="Customer name is mandatory")
    @Size(max=200,message="Customer name cannot exceed more than 200 characters")
	@Column(name = "customer_name")
    private String customerName;
    
	@NotNull(message="Select PO flag as its mandatory")
    @Column(name = "po_flag")
    private Integer poFlag;
    
	@NotBlank(message="Delivery manager is mandatory")
    @Size(max=200,message="Delivery manager cannot exceed more than 200 characters")
    @Column(name = "delivery_manager")
    private String deliveryManager;
    
    @Column(name = "sales_manager")
    private String salesManager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getPoFlag() {
		return poFlag;
	}

	public void setPoFlag(Integer poFlag) {
		this.poFlag = poFlag;
	}

	public String getDeliveryManager() {
		return deliveryManager;
	}

	public void setDeliveryManager(String deliveryManager) {
		this.deliveryManager = deliveryManager;
	}

	public String getSalesManager() {
		return salesManager;
	}

	public void setSalesManager(String salesManager) {
		this.salesManager = salesManager;
	}

	@Override
	public String toString() {
		return "ProjectDAO [id=" + id + ", projectId=" + projectId + ", projectType=" + projectType
				+ ", projectDescription=" + projectDescription + ", customerName=" + customerName + ", poFlag=" + poFlag
				+ ", deliveryManager=" + deliveryManager + ", salesManager=" + salesManager + "]";
	}
}
