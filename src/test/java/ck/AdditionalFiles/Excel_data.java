package ck.AdditionalFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;

import ck.readExcel.ReadExcel;

public class Excel_data {
	
	public static void main(String args[]){
//	ReadExcel getdata = new ReadExcel();
//	readexceldatawithheadings(pathoftestdata, "Sheet1", "Naukri_ProfileUpdate","Username"), "UsernameTextField");
//	readexceldatawithheadings("C:\"", "Sheet1", "Naukri_ProfileUpdate","Username");
	
	
//	String a = getdata.readexceldatawithheadings("C:\\Users\\kbachu\\Desktop\\Book1.xlsx", "Firstsheet", "user", "2");
	String a = readexceldatawithheadings("C://Users//kbachu//Desktop//data - Copy.xlsx", "Firstsheet", "2", "name");
	
	System.out.println("Value :"+ a);

}
	
	public static String readexceldatawithheadings (String path, String sheetname, String rowheading, String columnHeading){
//		public void readexceldatawithheadings (String path, String sheetname, String rowheading, String columnHeading){
int I = 0,J = 0 ;
Workbook wb = null;

		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetname);
//		Iterator<Row> rowiter = 	sheet.rowIterator();
		int rownum = sheet.getLastRowNum() +1;
//		int rownum = sheet.getLastRowNum() ;
		int colnum = sheet.getRow(0).getLastCellNum();


		System.out.println("rowheading : "+ rowheading);
		
		for(int j=0; j<rownum;j++){
			if(sheet.getRow(j).getCell(0).toString().contentEquals(rowheading)){
				System.out.println("Row index :"+j +" Row value :"+sheet.getRow(j).getCell(0).toString());
				J=j;
				break;
			}	}

		for(int i=0; i<colnum;i++){

			if(sheet.getRow(0).getCell(i).toString().contentEquals(columnHeading)){
				System.out.println("Column index :"+i +" Column value :"+sheet.getRow(0).getCell(i).toString());
				I = i;
				break;
			}	}

		/*		for(i=0,j=0;j<rownum; i++,j++){
			if(sheet.getRow(j).getCell(0).toString().contentEquals(rowheading)){
				if(sheet.getRow(0).getCell(i).toString().contentEquals(columnHeading)){
					System.out.println("Row index :"+j +" Row value :"+sheet.getRow(j).getCell(i).toString());
			break;
				}	}
		 */

//		System.out.println("Value as per the Row and Column :"+sheet.getRow(j).getCell(i));
		System.out.println("I = "+I+"  J = "+J);
		
		String Value = sheet.getRow(J).getCell(I).getStringCellValue();
//		System.out.println("Value : "+Value);
		return Value;
	
	}
}