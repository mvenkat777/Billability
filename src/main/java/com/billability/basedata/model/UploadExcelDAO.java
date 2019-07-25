package com.billability.basedata.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_excel_ibu_data")
public class UploadExcelDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "empl_id")
	private String emplId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "business_wait_age")
	private String businessWaitAge;
	
	@Column(name = "bv_status")
	private String bvStatus;
	
	@Column(name = "employee_class_category")
	private String employeeClassCategory;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "category_code")
	private String categoryCode;
	
	@Column(name = "htr_flag")
	private String htrFlag;
	
	@Column(name = "employee_ibu")
	private String employeeIbu;
	
	@Column(name = "band")
	private String band;
	
	@Column(name = "total_experience")
	private String totalExperience;
	
	@Column(name = "current_country")
	private String currentCountry;
	
	@Column(name = "current_location_city")
	private String currentLocationCity;
	
	@Column(name = "onsite_offshore")
	private String onsiteOffshore;
	
	@Column(name = "business_unit")
	private String businessUnit;
	
	@Column(name = "allocated_project_count")
	private String allocatedProjectCount;
	
	@Column(name = "project_id")
	private String projectId;
	
	@Column(name = "project_description")
	private String projectDescription;
	
	@Column(name = "project_end_date")
	private String projectEndDate;
	
	@Column(name = "project_contract_type")
	private String projectContractType;
	
	@Column(name = "projectIbu")
	private String projectIbu;
	
	@Column(name = "geography")
	private String geography;
	
	@Column(name = "project_maintype_descr")
	private String projectMaintypeDescr;
	
	@Column(name = "project_type")
	private String projectType;
	
	@Column(name = "billablity_status")
	private String billablityStatus;
	
	@Column(name = "non_billable_details")
	private String nonBillableDetails;
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "supervisor_id")
	private String supervisorId;
	
	@Column(name = "supervisor_name")
	private String supervisorName;
	
	@Column(name = "pm_emplid")
	private String pmEmplid;
	
	@Column(name = "pm_name")
	private String pmName;
	
	@Column(name = "program_manager_id")
	private String programManagerId;
	
	@Column(name = "program_manager_name")
	private String programManagerName;
	
	@Column(name = "so_id")
	private String soId;
	
	@Column(name = "pjr_no")
	private String pjrNo;
	
	@Column(name = "last_working_day")
	private String lastWorkingDay;
	
	@Column(name = "contract_number")
	private String contractNumber;
	
	@Column(name = "primary_skill_category_1")
	private String primarySkillCategory1;
	
	@Column(name = "primary_skill_category_2")
	private String primarySkillCategory2;
	
//	@Column(name = "derived_project_type")
//	private String derivedProjectType;
//	
//	@Column(name = "derived_po_flag")
//	private String derivedPoFlag;


	public UploadExcelDAO(List<String> cellList) {
		
		//this.emplId = cellList.get(0);
		//this.projectId = cellList.get(16);
		setEmplId(cellList.get(0));
		setEmpName(cellList.get(1));
		setBusinessWaitAge(cellList.get(2));
		setBvStatus(cellList.get(3));
		setEmployeeClassCategory(cellList.get(4));
		setGender(cellList.get(5));
		setCategoryCode(cellList.get(6));
		setHtrFlag(cellList.get(7));
		setEmployeeIbu(cellList.get(8));
		setBand(cellList.get(9));
		setTotalExperience(cellList.get(10));
		setCurrentCountry(cellList.get(11));
		setCurrentLocationCity(cellList.get(12));
		setOnsiteOffshore(cellList.get(13));
		setBusinessUnit(cellList.get(14));
		setAllocatedProjectCount(cellList.get(15));
		setProjectId(cellList.get(16));
		setProjectDescription(cellList.get(17));
		setProjectEndDate(cellList.get(18));
		setProjectContractType(cellList.get(19));
		setProjectIbu(cellList.get(20));
		setGeography(cellList.get(21));
		setProjectMaintypeDescr(cellList.get(22));
		setProjectType(cellList.get(23));
		setBillablityStatus(cellList.get(24));
		setNonBillableDetails(cellList.get(25));
		setCustomerId(cellList.get(26));
		setCustomerName(cellList.get(27));
		setSupervisorId(cellList.get(28));
		setSupervisorName(cellList.get(29));
		setPmEmplid(cellList.get(30));
		setPmName(cellList.get(31));
		setProgramManagerId(cellList.get(32));
		setProgramManagerName(cellList.get(33));
		setSoId(cellList.get(34));
		setPjrNo(cellList.get(35));
		setLastWorkingDay(cellList.get(36));
		setContractNumber(cellList.get(37));
		setPrimarySkillCategory1(cellList.get(38));
		setPrimarySkillCategory2(cellList.get(39));		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmplId() {
		return emplId;
	}

	public void setEmplId(String emplId) {
		this.emplId = emplId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getBusinessWaitAge() {
		return businessWaitAge;
	}

	public void setBusinessWaitAge(String businessWaitAge) {
		this.businessWaitAge = businessWaitAge;
	}

	public String getBvStatus() {
		return bvStatus;
	}

	public void setBvStatus(String bvStatus) {
		this.bvStatus = bvStatus;
	}

	public String getEmployeeClassCategory() {
		return employeeClassCategory;
	}

	public void setEmployeeClassCategory(String employeeClassCategory) {
		this.employeeClassCategory = employeeClassCategory;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getHtrFlag() {
		return htrFlag;
	}

	public void setHtrFlag(String htrFlag) {
		this.htrFlag = htrFlag;
	}

	public String getEmployeeIbu() {
		return employeeIbu;
	}

	public void setEmployeeIbu(String employeeIbu) {
		this.employeeIbu = employeeIbu;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getCurrentCountry() {
		return currentCountry;
	}

	public void setCurrentCountry(String currentCountry) {
		this.currentCountry = currentCountry;
	}

	public String getCurrentLocationCity() {
		return currentLocationCity;
	}

	public void setCurrentLocationCity(String currentLocationCity) {
		this.currentLocationCity = currentLocationCity;
	}

	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}

	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getAllocatedProjectCount() {
		return allocatedProjectCount;
	}

	public void setAllocatedProjectCount(String allocatedProjectCount) {
		this.allocatedProjectCount = allocatedProjectCount;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectContractType() {
		return projectContractType;
	}

	public void setProjectContractType(String projectContractType) {
		this.projectContractType = projectContractType;
	}

	public String getProjectIbu() {
		return projectIbu;
	}

	public void setProjectIbu(String projectIbu) {
		this.projectIbu = projectIbu;
	}

	public String getGeography() {
		return geography;
	}

	public void setGeography(String geography) {
		this.geography = geography;
	}

	public String getProjectMaintypeDescr() {
		return projectMaintypeDescr;
	}

	public void setProjectMaintypeDescr(String projectMaintypeDescr) {
		this.projectMaintypeDescr = projectMaintypeDescr;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getBillablityStatus() {
		return billablityStatus;
	}

	public void setBillablityStatus(String billablityStatus) {
		this.billablityStatus = billablityStatus;
	}

	public String getNonBillableDetails() {
		return nonBillableDetails;
	}

	public void setNonBillableDetails(String nonBillableDetails) {
		this.nonBillableDetails = nonBillableDetails;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getPmEmplid() {
		return pmEmplid;
	}

	public void setPmEmplid(String pmEmplid) {
		this.pmEmplid = pmEmplid;
	}

	public String getPmName() {
		return pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}

	public String getProgramManagerId() {
		return programManagerId;
	}

	public void setProgramManagerId(String programManagerId) {
		this.programManagerId = programManagerId;
	}

	public String getProgramManagerName() {
		return programManagerName;
	}

	public void setProgramManagerName(String programManagerName) {
		this.programManagerName = programManagerName;
	}

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}

	public String getPjrNo() {
		return pjrNo;
	}

	public void setPjrNo(String pjrNo) {
		this.pjrNo = pjrNo;
	}

	public String getLastWorkingDay() {
		return lastWorkingDay;
	}

	public void setLastWorkingDay(String lastWorkingDay) {
		this.lastWorkingDay = lastWorkingDay;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getPrimarySkillCategory1() {
		return primarySkillCategory1;
	}

	public void setPrimarySkillCategory1(String primarySkillCategory1) {
		this.primarySkillCategory1 = primarySkillCategory1;
	}

	public String getPrimarySkillCategory2() {
		return primarySkillCategory2;
	}

	public void setPrimarySkillCategory2(String primarySkillCategory2) {
		this.primarySkillCategory2 = primarySkillCategory2;
	}

	@Override
	public String toString() {
		return "UploadExcelDAO [id=" + id + ", emplId=" + emplId + ", empName=" + empName + ", businessWaitAge="
				+ businessWaitAge + ", bvStatus=" + bvStatus + ", employeeClassCategory=" + employeeClassCategory
				+ ", gender=" + gender + ", categoryCode=" + categoryCode + ", htrFlag=" + htrFlag + ", employeeIbu="
				+ employeeIbu + ", band=" + band + ", totalExperience=" + totalExperience + ", currentCountry="
				+ currentCountry + ", currentLocationCity=" + currentLocationCity + ", onsiteOffshore=" + onsiteOffshore
				+ ", businessUnit=" + businessUnit + ", allocatedProjectCount=" + allocatedProjectCount + ", projectId="
				+ projectId + ", projectDescription=" + projectDescription + ", projectEndDate=" + projectEndDate
				+ ", projectContractType=" + projectContractType + ", projectIbu=" + projectIbu + ", geography="
				+ geography + ", projectMaintypeDescr=" + projectMaintypeDescr + ", projectType=" + projectType
				+ ", billablityStatus=" + billablityStatus + ", nonBillableDetails=" + nonBillableDetails
				+ ", customerId=" + customerId + ", customerName=" + customerName + ", supervisorId=" + supervisorId
				+ ", supervisorName=" + supervisorName + ", pmEmplid=" + pmEmplid + ", pmName=" + pmName
				+ ", programManagerId=" + programManagerId + ", programManagerName=" + programManagerName + ", soId="
				+ soId + ", pjrNo=" + pjrNo + ", lastWorkingDay=" + lastWorkingDay + ", contractNumber="
				+ contractNumber + ", primarySkillCategory1=" + primarySkillCategory1 + ", primarySkillCategory2="
				+ primarySkillCategory2 + "]";
	}

//	public String getDerivedProjectType() {
//		return derivedProjectType;
//	}
//
//	public void setDerivedProjectType(String derivedProjectType) {
//		this.derivedProjectType = derivedProjectType;
//	}
//
//	public String getDerivedPoFlag() {
//		return derivedPoFlag;
//	}
//
//	public void setDerivedPoFlag(String derivedPoFlag) {
//		this.derivedPoFlag = derivedPoFlag;
//	}

	
	
	
}
