package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class Dataproviderwithoutexcelmethods {
	
	@DataProvider (name = "getData")
	public String[][] getData() throws Exception {
	{
	File excelFile = new File("./src/test/resources/TestData/ExcelTestDataAPI.xlsx");
	System.out.println(excelFile.exists());
	
	FileInputStream fis = new FileInputStream(excelFile);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet("sheet1");
    
    int noOfRows = sheet.getPhysicalNumberOfRows();
    int nOfColumns = sheet.getRow(0).getLastCellNum();
    
    String[][] data = new String[noOfRows-1][nOfColumns];
     for (int i=0; i < noOfRows-1 ; i++ )
     {
    	 for (int j = 0 ; j < nOfColumns ; j++ )
    	 {
    		 DataFormatter df = new DataFormatter();
    		 data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j)); 	 
    	 }
     } 
     
    workbook.close();
    fis.close();
	
	/*for (String[] dataArr : data) 
	 {
		System.out.println(Arrays.toString(dataArr));
	  }*/
	return data;
	}
 }
}



