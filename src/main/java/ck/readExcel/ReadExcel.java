package ck.readExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//import jxl.Workbook;
/**
 * This class is used to get the data from Excel, 
 * For this we have to create an object for the class ReadExcel and call the method readexceldatawithheadings
 * 
 */
public class ReadExcel {
	//	public static void main(String args[]) throws InvalidFormatException, IOException {
	
	int colnum; 
	int rownum;	
	Workbook wb = null;
/**
 *  This method gets the data by passing the column name, row name, which means we get the value where the column and row intersect 
 *  a new folder "testFiles" should be created in ckFramework and excel sheet with test data should be placed in testFiles folder. 
 *  sTestdata_Path = sproject_path + //testFiles//test_data.xlsx 
 *  Here test_data.xlsx is the sheet you created in testFiles folder. where as sproject_path will consider the current project path.
 *  
 * @param path - sub Path of excel under the testFiles folder
 * @param sheetname - Name of the sheet
 * @param rowheading - Heading of the row to get the data from that row
 * @param columnHeading - Heading of the column to get the data from that column
 * @return
 */
	public String readexceldatawithheadings (String path, String sheetname, String rowheading, String columnHeading){
//		public void readexceldatawithheadings (String path, String sheetname, String rowheading, String columnHeading){

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
		int rowmax = sheet.getLastRowNum() +1;
//		int rownum = sheet.getLastRowNum() ;
		int colmax = sheet.getRow(0).getLastCellNum();


		for(int rowtemp=0; rowtemp<rowmax;rowtemp++){
			if(sheet.getRow(rowtemp).getCell(0).toString().contentEquals(rowheading)){
				System.out.println("Row index :"+rowtemp +" Row value :"+sheet.getRow(rowtemp).getCell(0).toString());
				this.rownum = rowtemp;
				break;
			}	}

		for(int coltemp=0; coltemp<colmax;coltemp++){

			if(sheet.getRow(0).getCell(coltemp).toString().contentEquals(columnHeading)){
				System.out.println("Column index :"+coltemp +" Column value :"+sheet.getRow(0).getCell(coltemp).toString());
				this.colnum = coltemp;
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
		String Value = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
//		System.out.println("Value : "+Value);
		return Value;
		
	}

}

