package ck.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mongodb.client.model.Projections;




public class Reporter {
//	public static final String sub_ReportingFolder = "MyReporting";
	public static final String sub_ReportingFolder = "CKReporting";
	
	
	private static List<Result> details;
	private static String resultPlaceholder = "<!-- INSERT_RESULTS -->";
//	private static final String templatePath = "C:\\Tools\\report_template.html";
	private static String Report_template = "report_template.html";
	private static String templatePath = sub_ReportingFolder+ "\\"+Report_template;
	private static Boolean includeScreenshots ;
	
//	private static final String screenshotPath = "C:\\Tools\\screenshots\\";
	
//	private static final String screenshotPath = reportingFolder +"\\screenshots\\";
	public static String screenshotPath ;
	public static int j;

	static Path RelativePath = Paths.get("");
	static String AbsolutePath = RelativePath.toAbsolutePath().toString();
//	public static String Projectsrc = AbsolutePath +"\\src";
	public static String Projectsrc = AbsolutePath;
	
	
	
	
	public Reporter() {
		
//		Remove the following code later
		System.out.println("Constructor execution ?");
	/*	if((new File("report_template.html")).exists() && new File(reportingFolder).exists()){
//			new File(reportingFolder).mkdir();
			System.out.println("Reporting Folder and Sample template exists");
		}else if(!new File("report_template.html").exists() && new File(reportingFolder).exists()){
			try {
				new File("report_template>html").createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(!new File(reportingFolder).exists()){
		new File(reportingFolder+"\\"+"report_template.html");
		}*/
	}

	public static void initialize() {
		details = new ArrayList<Result>();
		
		Path RelativePath = Paths.get("");
		String AbsolutePath = RelativePath.toAbsolutePath().toString();
//		String Projectsrc = AbsolutePath +"\\src";	
		String ReportFolder = Projectsrc+"\\"+sub_ReportingFolder;
		
		
		if(!new File(ReportFolder).exists()){
			new File(ReportFolder).mkdir();
			System.out.println("Reporting Folder created");
		}
		
		if(!new File(ReportFolder+"\\"+ Report_template).exists()){
			try {
				new File(ReportFolder+"\\"+Report_template).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}

		/*
		
		else if(!new File(reportingFolder).exists()){
		new File(reportingFolder+"\\"+"report_template.html");
		System.out.println("Creating Folder :"+reportingFolder+" & Creating File : report_template");
		}*/
			
		
	}

	public static void report(String Info) {
		Result r = new Result("<div align='center'><font color = '#0000FF' >Info</font></div>",Info,"");
		details.add(r);
	}

	public static void heading(String TestcaseName){
		Result r = new Result("<div align='left'><font color = '#0000FF' >hhhHeading</font></div>",TestcaseName,"");
		details.add(r);
		System.out.println("testheading method in Reporter");
	}

	public static void report(WebDriver driver, String actualValue,String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			Result r = new Result("<div align='center'><font color = '#00FF00' >Pass</font></div>", actualValue + "' displayed successfully'","");
			details.add(r);

		} else if(includeScreenshots && screenshotPath == "") {

//			String screenshotPath = "";
//			if(includeScreenshots) 
				screenshotPath = getScreenshot(driver);
			Result r = new Result("<div align='center'><font color = '#FF0000' >Fail</font></div>","Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'",screenshotPath);
			details.add(r);
		}

		System.out.println("Details List values :");
		if(details.iterator().hasNext()){
			System.out.println(details.iterator().next());	
		}

	}

	private static String getScreenshot(WebDriver driver) {

		// generate screenshot as a file object
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String currentDateTime = getCurrentDate();
		String location = screenshotPath + currentDateTime + ".png";

		try {
			// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(location));
		} catch (IOException e) {
			System.out.println("Error while generating screenshot:\n" + e.toString());
		}

		return location.replace("\\","\\\\");
	}

	private static String getCurrentDate() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(cal.getTime());
	}


	public static void writeResults() throws IOException {

		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String currentTime = new SimpleDateFormat("hh-mm-ss").format(new Date());
		/*
		 * // String reportPath = "C:\\Tools\\report_" + currentDate+"  "+currentTime+
		 * ".html"; // String reportPath = "src\\Tools\\report_" +
		 * currentDate+"  "+currentTime+ ".html";
		 * System.out.println("Projectsrc : "+Projectsrc);
		 * System.out.println("sub_ReportingFolder :"+sub_ReportingFolder);
		 * System.out.println("tail : "+"\\report_" + currentDate+"  "+currentTime+
		 * ".html");
		 */
		
		
		String reportPath = Projectsrc+"\\"+sub_ReportingFolder+"\\report_" + currentDate+"-"+currentTime+ ".html";
		System.out.println("reportPath : "+reportPath);

		FileWriter fw = new FileWriter(reportPath);
		try {
			
			/*
			 * System.out.println("templatePath : "+templatePath);
			 * 
			 * String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			 * System.out.println("reportin" + reportIn);
			 */

			/*	for(int i=0; i< details.size(); i++){
					System.out.println("Result :"+details.get(i).getResult().toString()+"   Res Text :"+details.get(i).getResultText().toString()+"   Screenshot :"+details.get(i).getResultScreenshot());

				} 
			 */	

			fw.write("<Table border='1' style='width:70%'>");

			for ( int i = 0; i < details.size();i++) {


				if(details.get(i).getResult().contains("hhh")){

					fw.write("</Table>");
					fw.write("<br>"); fw.write("<br>");fw.write("<br>");

					fw.write("<th><div align='center'><font size = '6'>"+details.get(i).getResultText()+"</font></div></th>");
					details.remove(i);
					fw.write("<Table border='1' style='width:70%'>");
					fw.write("<th><font size = '4'> S.no </font></th> <th> <font size = '4'>Result </font></th><th><font size = '4'> Descrption</font></th> <th> <font size = '4'>Screenshots</font></th>");
					j=1;
				} 

				if(details.get(i).getResultScreenshot().equals("")) {

					fw.write("<tr><td><div align='center'>" + Integer.toString(j++) + "</div></td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td><td></td></tr> <br>");

				} else {
					fw.write("<tr><td><div align='center'>" + Integer.toString(j++) + "</div></td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td><td><a href=\"" + new File(details.get(i).getResultScreenshot()).toURI().toURL() + "\">screenshot</a></td></tr> <br>");
				}
			}
			fw.write("</Table>");	
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		} finally {System.out.println("Print Finaly block");
		fw.close();
		}
	}
}