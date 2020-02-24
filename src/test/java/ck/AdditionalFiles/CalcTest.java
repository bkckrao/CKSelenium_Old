package ck.AdditionalFiles;

import java.io.File;

public class CalcTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		String jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";  jacob-1.18-x64
		String jacobDllVersionToUse = "jacob-1.18-x64";
//		String jacobDllVersionToUse = "only test";

//		File file = new File("D:\\ck\\My_WorkSpace\\Autoit\\lib", jacobDllVersionToUse);
		File file = new File("D://ck//My_WorkSpace//Autoit//lib", jacobDllVersionToUse);
//		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		
/*		
		AutoItX x = new AutoItX();
		
		x.run("calc.exe");
		x.winActivate("Calculator");
		x.winWaitActive("Calculator");
		//Enter 3
		x.controlClick("Calculator", "", "133") ;
		Thread.sleep(1000);
		//Enter +
		x.controlClick("Calculator", "", "93") ;
		Thread.sleep(1000);
		//Enter 3
		x.controlClick("Calculator", "", "133") ;
		Thread.sleep(1000);
		//Enter =
		x.controlClick("Calculator", "", "121") ;
*/
		}

}




