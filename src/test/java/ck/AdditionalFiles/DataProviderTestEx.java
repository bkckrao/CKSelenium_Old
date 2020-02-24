package ck.AdditionalFiles;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class DataProviderTestEx {
		/* 
		@DataProvider(name = "DP1")
	    public Object[][] createData() {
	        Object[][] retObjArr=new ExcelRetrieve().getTableArray("C:\\Excel\\Test.xls", "ApplicationLaunch", "Indicator");
	        return(retObjArr);
	    }

	@Test (dataProvider = "DP1")
	    public void login(String application, String url) throws BiffException, IOException{
		System.out.println("uname:"+application+"  url:"+url);
		 Workbook workbook1 = Workbook.getWorkbook(new File("C:\\Excel\\Test.xls"));
         Sheet sheet1 = workbook1.getSheet("Login");
         System.out.println(application+"user");
         Cell username= sheet1.findCell(application+"user", 0,0, 100, 64000,  false);                               
         int row=username.getRow();
         int col=username.getColumn();
         System.out.println("username:::"+username.getContents());
         String password=sheet1.getCell(col+1,row).getContents();
         System.out.println("password:::"+password);
	}*/
	
	
	/*@DataProvider(name = "DP2")
    public Object[][] createData1() {
        Object[][] retObjArr=new ExcelRetrieve().getTableArray("C:\\Excel\\Test.xls", "Login", "Indicator");
        return(retObjArr);
    }
	@Test (dataProvider = "DP2")
    public void login1(String username, String paswd) throws BiffException, IOException{
		System.out.println(username+"   "+paswd);
}*/
}
