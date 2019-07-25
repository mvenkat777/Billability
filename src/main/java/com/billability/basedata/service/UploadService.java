package com.billability.basedata.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.commons.collections4.ListUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.billability.basedata.model.DashboardVAO;
import com.billability.basedata.model.UploadExcelDAO;
import com.billability.basedata.repository.UploadExcelGenerateDashboardRepository;
import com.billability.projects.repository.ProjectRepository;

@Service("uploadService")
public class UploadService {
	
	private ProjectRepository projectRepository;
	
	private UploadExcelGenerateDashboardRepository uploadRepository;
	
    @Autowired
    public UploadService(ProjectRepository projectRepository, UploadExcelGenerateDashboardRepository uploadRepository) { 
      this.projectRepository = projectRepository;
      this.uploadRepository = uploadRepository;
    }
    
	public Boolean excelHeaderValidate(MultipartFile file) throws IOException {
		
		// static headers to be compared
		String[] headers = {"EMPLID","EMP_NAME","BUSINESS_WAIT_AGE","BV_STATUS","EMPLOYEE_CLASS_CATEGORY",
    			"GENDER","CATEGORY_CODE","HTR_FLAG","EMPLOYEE_IBU","BAND","TOTAL_EXPERIENCE",
    			"CURRENT_COUNTRY","CURRENT_LOCATION_CITY","ONSITE_OFFSHORE","BUSINESS_UNIT","ALLOCATED_PROJECT_COUNT",
    			"PROJECT_ID","PROJECT_DESCRIPTION","PROJECT_END_DATE","PROJECT_CONTRACT_TYPE","PROJECT_IBU","GEOGRAPHY",
    			"PROJECT_MAINTYPE_DESCR","PROJECT_TYPE","BILLABLITY_STATUS","NON_BILLABLE_DETAILS","CUSTOMER_ID","CUSTOMER_NAME",
    			"SUPERVISOR_ID","SUPERVISOR_NAME","PM_EMPLID","PM_NAME","PROGRAM_MANAGER_ID","PROGRAM_MANAGER_NAME","SO_ID",
    			"PJR_NO","LAST_WORKING_DAY","CONTRACT_NUMBER","PRIMARY_SKILL_CATEGORY_1","PRIMARY_SKILL_CATEGORY_2"};
    	List<String> headersList = Arrays.asList(headers);
    	
    	// get input stream from uploaded file
    	InputStream fileInputStream = file.getInputStream();
    	//Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        //Get the first row or header of excel
        XSSFRow row = sheet.getRow(0);
        
        List<Boolean> headerBooleanComparedList = new ArrayList<Boolean>();
        // Iterate through each cell in a row and compare each cell with static headers
        //System.out.println("Last cell number : "+ headers.length );
        for (int i = 0; i < headers.length-1; i++) {
             XSSFCell headerCell = row.getCell(i);
             //System.out.println(i+" Loop "+ headerCell.getStringCellValue().trim()+ "<-- Excel | static header-->"+ headersList.get(i));
             boolean eachHeaderBooleanValue = headerCell.getStringCellValue().trim().equalsIgnoreCase(headersList.get(i));
             headerBooleanComparedList.add(eachHeaderBooleanValue);
        }
        //System.out.println("All boolean values"+ headerBooleanComparedList.toString() );
        workbook.close();
        fileInputStream.close();
        
        if(headerBooleanComparedList.contains(false)) {
        	return false;
        }else {
        	return true;
        }
        
    }
	
	public List getExcelProjects(MultipartFile file) throws IOException {
    	
		InputStream fileInputStream = file.getInputStream();
    	//Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        
        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        
        Iterator<Row> rowIterator = sheet.iterator();
        //System.out.println( "Project IDS LIST: ");
        List<String> projectIds = new ArrayList<String>();
        while (rowIterator.hasNext())
        {
              Row row = rowIterator.next();
              if(row.getRowNum()==0){
                continue; //just skip the rows if row number is 0
              }
              if(row != null) {
            	  //System.out.println(row.getCell(16) + ", ");
            	  String cellValue = dataFormatter.formatCellValue(row.getCell(16));
            	  if(cellValue != "") {
            		  //double cellValue = row.getCell(16).getNumericCellValue();
            		  //String cellValueString = (int) cellValue + "";
                	  //if(cellValueString != "")
                	  projectIds.add(cellValue);
            	  }            	  
              }
              
        }
        workbook.close();
        fileInputStream.close();
        //System.out.println("All Project IDS : "+ projectIds.toString() );
        return projectIds;
	}
	
	public List getProjectsNotAvailbleInDatabase(List<String> projectIds) {
		
		List<String> dbProjectIds = projectRepository.findByProjectCodes(projectIds);
		//System.out.println("Service Existing DB Project IDS" + dbProjectIds.toString());
		
		//projectIds.forEach(action);
		List<String> notInDbProjectIds = projectIds.stream().filter(proj->!(dbProjectIds.contains(proj))).collect(Collectors.toList());
		
//		projectIds.forEach(proj->{
//			if(!dbProjectIds.contains(proj)){
//				//System.out.println(item);
//				notInDbProjectIds.add(proj);
//			}
//		});
		
		//List<String> notInDbProjectIds = ListUtils.subtract(projectIds,dbProjectIds);
		
		return notInDbProjectIds;
	}
	
	public void readExcelSaveData(MultipartFile file)throws IOException {
	
	try {	
		InputStream fileInputStream = file.getInputStream();
    	
    	//Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        
        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        
        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        
        //System.out.println("Row Last number :" + rowIterator.getLastRowNum() + "\t\t");
	      while (rowIterator.hasNext())
	      {
	          Row row = rowIterator.next();
	          //System.out.println("ROW STARTS :");
	          //System.out.println("Row number :" + row.getRowNum() + "\t\t");
	          
	          if(row.getRowNum()==0){
	              continue; //just skip the rows if row number is 0
	          }
	          
	          //For each row, iterate through all the columns
	          Iterator<Cell> cellIterator = row.cellIterator();
	          List<String> cellList = new ArrayList<>();  
	          while (cellIterator.hasNext())
	          {
	          	//System.out.println("CELL STARTS :");
	          	//Cell cell = cellIterator.next();
	          	//String cellValue = dataFormatter.formatCellValue(cellIterator.next());
	          	//dataFormatter.formatCellValue(cellIterator.next()))
				
	        	  cellList.add(dataFormatter.formatCellValue(cellIterator.next()));
	        	  
	        	  //System.out.print("FIRST CELLL:" + dataFormatter.formatCellValue(cellIterator.next()) + "\t"); 
	        	  //System.out.print("SECOND CELLL:" + dataFormatter.formatCellValue(cellIterator.next()) + "\t"); 
	        	//modelExcel.setEmplId(dataFormatter.formatCellValue(cellIterator.next()));
	          	//modelExcel.setEmpName(dataFormatter.formatCellValue(cellIterator.next()));
	          	
	          	
	          	//System.out.print(cellValue + "\t");
	              
	              
	          }
	          //System.out.print("Cell list -->"+ cellList.toString() + "\t" + "Cell size "+cellList.size());
	          if(cellList.isEmpty() || cellList.size() == 1) continue;
	          uploadRepository.save(new UploadExcelDAO(cellList));
	          //System.out.println(""+);
	      }
	      workbook.close();
	      fileInputStream.close();      
	  } catch (IOException e) {
	      e.printStackTrace();
	  }
	}
	
	public List<DashboardVAO> getResultsforDashboard(String pickDate) {
		
		//System.out.print("Dashboard Values -->"+ uploadRepository.getDashboardValues(pickDate).get(0).toString());
		
		List<Object[]> dashboardDBList = uploadRepository.getDashboardValues(pickDate);
		List<DashboardVAO> DashboardVAOList = new ArrayList<DashboardVAO>();
		Iterator<Object[]> dashboardDBListIterator = dashboardDBList.iterator();
		while(dashboardDBListIterator.hasNext()){
		     Object[] line = dashboardDBListIterator.next();
		     //System.out.println("Each DB Item :"+line[0]);
		     
		     DashboardVAO dv = new DashboardVAO();
		     //System.out.println("Each DB Project type Item :"+line[0]);
		     dv.setProjectType(line[0]);
		     //System.out.println("Each DB PoFlag Item :"+line[1]);
		     dv.setPoFlag(line[1]);
		     //System.out.println("Each DB OnsiteOffshore Item :"+line[2]);
		     dv.setOnsiteOffshore(line[2]);
		     //System.out.println("Each DB BillablityStatus Item :"+line[3]);
		     dv.setBillablityStatus(line[3]);
		     //System.out.println("Each DB EmployeeClassCategory Item :"+line[4]);
		     dv.setEmployeeClassCategory(line[4]);
		     //System.out.println("Each DB Count Item :"+line[5]);
		     dv.setCt(line[5]);
		     
		     DashboardVAOList.add(dv);
		}
		//DashboardVAOList.get(0).toString();
		return DashboardVAOList;
		
	}
	
	public int dashboardValuesExistsOrNot() {
		return uploadRepository.checkWhetherDashboardDataExists();
	}
}
