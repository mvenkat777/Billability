package com.billability.basedata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billability.basedata.model.UploadExcelDAO;


@Repository("uploadExcelGenerateDashboardRepository")
public interface UploadExcelGenerateDashboardRepository extends CrudRepository<UploadExcelDAO, Long> {
	
	public static final String DASHBOARD_VALUES = "SELECT p.project_type,p.po_flag,b.onsite_offshore,b.billablity_status,b.employee_class_category, count(*) ct \r\n" + 
			"FROM base_excel_ibu_data b \r\n" + 
			"LEFT JOIN projects p ON b.project_id = p.project_code\r\n" + 
			"WHERE DATE(b.created_at) = :pickDate \r\n" + 
			"GROUP BY b.onsite_offshore, p.po_flag, p.project_type, b.billablity_status, b.employee_class_category\r\n" + 
			"ORDER BY (p.project_type = 'Delivery') DESC, p.project_type != 'Delivery',p.project_type = 'Buffer'";
	@Query(value = DASHBOARD_VALUES, nativeQuery = true)
	public  List<Object[]> getDashboardValues(@Param("pickDate") String pickDate);
	
	@Query(value = "select count(*) as ct from base_excel_ibu_data where DATE(created_at) = CURDATE()", nativeQuery = true)
	public int checkWhetherDashboardDataExists();

}
