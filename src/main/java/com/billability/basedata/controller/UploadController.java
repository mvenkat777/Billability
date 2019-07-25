package com.billability.basedata.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.billability.basedata.model.DashboardVAO;
import com.billability.basedata.service.UploadService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
	@Value("${upload.location}")
    private static String UPLOADED_FOLDER;
	
	private UploadService uploadService;
	
	@Autowired
	public UploadController(UploadService uploadService) {	     
      this.uploadService = uploadService;
    }
	
	@PostMapping("/home")
	public String getAllDashboardValues(Model model, @RequestParam("dashboard_date") String pickDate) {
		
//		 String formatStr = "MM/dd/yyyy";
//	     SimpleDateFormat format = new SimpleDateFormat(formatStr);
//	     
//	     try {
//	         Date formatted = format.parse(pickDate);
//	         System.out.println("Date: " + formatted);
//	         
//	         String formatStr1 = "yyyy-MM-dd";
//	         format = new SimpleDateFormat(formatStr1);
//	         String format2 = format.format(formatted);
//	         System.out.println("pickedDate ---->: " + format2);
//	         model.addAttribute("pickedDate", format2);
//	     } catch (ParseException ex) {
//	         //Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, ex.getMessage());
//	     }
		List<DashboardVAO> DashboardVAOList =uploadService.getResultsforDashboard(pickDate);
		HashMap<String, Integer> DashboardMap = new HashMap<String, Integer>(); 
		//System.out.println("DB Ouput first row ---->: " + DashboardVAOList.get(0).toString());
		DashboardVAOList.forEach((each) -> {
			String projectType = each.getProjectType().toString();
			String onsiteOffshore = each.getOnsiteOffshore().toString();
			String poFlagString = each.getPoFlag().toString();
			int poFlag = Integer.parseInt(poFlagString);
			String billablityStatus = each.getBillablityStatus().toString();
			String employeeClassCategory = each.getEmployeeClassCategory().toString();
			String ctString =  each.getCt().toString();
			int ct = Integer.parseInt(ctString);
			System.out.println("Each Item employeeClassCategory: "+employeeClassCategory);
			DashboardMap.put(projectType+'_'+poFlag+'_'+billablityStatus+'_'+onsiteOffshore, ct);
			//if(employeeClassCategory == "Designated- Non Billable(DNB)")
			DashboardMap.put(projectType+'_'+poFlag+'_'+onsiteOffshore+'_'+billablityStatus+'_'+employeeClassCategory, ct);
			
//			if(projectType == "Delivery" && poFlag == 1) {
//				if(billablityStatus == "Y") {
//					if(onsiteOffshore == "OFFSHORE") {
//						//DashboardMap.put(projectType+'_'+poFlag, value);
//					}else if(onsiteOffshore == "ONSITE") {
//						
//					}
//				}else if(billablityStatus == "N") {
//					if(onsiteOffshore == "OFFSHORE") {
//						
//					}else if(onsiteOffshore == "ONSITE") {
//						
//					}
//					
//				}								
//			}
			
		});
		System.out.println("Final dashborad rows ---->: " + DashboardMap.toString());
		model.addAttribute("dashboardMap", DashboardMap);
		model.addAttribute("pickedDate", pickDate);
		model.addAttribute("pickedDateText", "Summary results for date : "+pickDate);
		return "home";
	}
	
    @GetMapping("/import-base-data")
    public String index() {
        return "upload_base_data";
    }
    
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(Model model, @RequestParam("file") MultipartFile file) throws IOException {    	
    	
    	if (file.isEmpty()) {
    		 model.addAttribute("message", "Please upload file !");
    		 return "upload_base_data";
    	}
    	
    	String[] contentTypes = { "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" };
    	List<String> contentTypesList = Arrays.asList(contentTypes);
    	
    	if (!contentTypesList.contains(file.getContentType()) ) {
    		model.addAttribute("message", "Please upload valid file as only xls and xlsx file are allowed");
   		 	//model.addAttribute("message", "Please upload valid file as only xls and xlsx file are allowed"+ file.getContentType());
   		 	return "upload_base_data";
    	}
    	
    	if(!uploadService.excelHeaderValidate(file)) {
    		model.addAttribute("message", "Please upload the excel file with correct headers matched as mentioned in the sample xlsx link which is available to download");
   		 	return "upload_base_data";
    	}
    	System.out.println("DASHBORAD values:" + uploadService.dashboardValuesExistsOrNot());
    	if(uploadService.dashboardValuesExistsOrNot() > 0) {
			model.addAttribute("message", "You are allowed to import only once per day(multiple uploads are not allowed)");
   		 	return "upload_base_data";
		}
    	
    	List projectIds = uploadService.getExcelProjects(file);
    	//System.out.println("Excel Project IDS" + projectIds.toString());
    	List unavailbleProjectIds = uploadService.getProjectsNotAvailbleInDatabase(projectIds);
    	//System.out.println("Not available Missing Project IDS" + unavailbleProjectIds.toString());
		if(unavailbleProjectIds.size() > 0) {
			String unavailbleProjectIdsCommaSeparated = String.join(", ", unavailbleProjectIds);
			model.addAttribute("message", "The uploaded excel does not have these project ids: "+ unavailbleProjectIdsCommaSeparated +" . Please add them in the projects and try to import again! ");
   		 	return "upload_base_data";
		}
		
		uploadService.readExcelSaveData(file);
//    	try {

        	//InputStream fileInputStream = file.getInputStream();
        	
        	//Create Workbook instance holding reference to .xlsx file
            //XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            
         // Retrieving the number of sheets in the Workbook
            //System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
            
            //Get first/desired sheet from the workbook
            //XSSFSheet sheet = workbook.getSheetAt(0);
            
         // Create a DataFormatter to format and get each cell's value as String
            //DataFormatter dataFormatter = new DataFormatter();

            //Iterate through each rows one by one
            //Iterator<Row> rowIterator = sheet.iterator();
            
            
            
//            while (rowIterator.hasNext())
//            {
//                Row row = rowIterator.next();
//                System.out.println("ROW STARTS :");
//                System.out.println("Row number :" + row.getRowNum() + "\t\t");
//                if(row.getRowNum()==0){
//                    continue; //just skip the rows if row number is 0
//                }
//                
//                //For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//                 
//                while (cellIterator.hasNext())
//                {
//                	//System.out.println("CELL STARTS :");
//                	Cell cell = cellIterator.next();
//                    
//                	String cellValue = dataFormatter.formatCellValue(cell);
//                    System.out.print(cellValue + "\t");
//                    
//                }
//                System.out.println("");
//            }
//            workbook.close();
//            fileInputStream.close();
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "redirect:/upload-base-data-status";
    }

    @GetMapping("/upload-base-data-status")
    public String uploadStatus() {
        return "upload_base_data_status";
    }

}

