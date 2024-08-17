package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviderwithexcelmethods {
	
	// data will be read from excel file using excel utility class file methods
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException
	{
	   String path = System.getProperty("user.dir") + "//testData//userdata.xlsx";
	   ExcelDataReaderUtility xl = new ExcelDataReaderUtility(path);
	   int rowcount = xl.getRowCount("Sheet1");
	   int colcount = xl.cellRowCount("Sheet1",1);

	   String apidata[][] = new String[rowcount][colcount];
	   for(int i =1; i<=rowcount;i++)
	   { 
	      for(int j=0; j<colcount; j++)
	       {
	         apidata[i-1][j] = xl.getCellData("Sheet1",i,j);
	       } 

	    }
	    return apidata;
	    
	    
	 }





}
