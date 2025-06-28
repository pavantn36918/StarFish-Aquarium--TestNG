import java.io.*;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

public class ExcelUtils  //Do not change the class name
{  

	public static String[][] readExcelData(String fileName, String sheetName) throws Exception { //Do not change the method signature
		
		//Using the fileName and sheetName passed to this method, read the data and store it in a string array

		//Eg. array declaration is String[][] userData=new String[1][7];
	
		//use switch case for reading different datatypes
		
		//return the array
		XSSFSheet worksheet;
	    XSSFWorkbook workbook;
	    FileInputStream work_file;
    	String file_path;
		
		String[][] userData=new String[1][7];
		
		String workingDir = System.getProperty("user.dir");
		
		file_path = workingDir+File.separator+fileName;
		work_file = new FileInputStream(file_path);
		workbook = new XSSFWorkbook(work_file);
		worksheet =  workbook.getSheet(sheetName);
        XSSFRow row = worksheet.getRow(0);
        
        for(int cnt=0;cnt<7;cnt++)
        {	 	  	  		 	     	     	      	 	
        	switch (row.getCell(cnt).getCellTypeEnum())
        	{
        	case STRING:
        		//System.out.println("String Value " + row.getCell(cnt).getStringCellValue());
        		userData[0][cnt]=row.getCell(cnt).getStringCellValue();
                break;
        	case NUMERIC:
        		 if(HSSFDateUtil.isCellDateFormatted(row.getCell(cnt)))
                 {
        			 //DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                     DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                     Date date = row.getCell(cnt).getDateCellValue();
                     String cellValue = df.format(date);
                     //System.out.println(cellValue);
                     userData[0][cnt]=cellValue;
                 }
        		 else
        		 {
        			//System.out.println("Numeric Value " + (long)row.getCell(cnt).getNumericCellValue());
             		userData[0][cnt]=(long)row.getCell(cnt).getNumericCellValue()+"";
        		 }
        		break;	
        	}
        }
        return userData;
	}
}
   