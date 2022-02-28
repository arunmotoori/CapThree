package exeperiment;

import java.io.File;
import java.io.IOException;

public class DemoFour {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String autoitfilepath = System.getProperty("user.dir")+"\\AutoItCode\\DownloadingFileDemo.exe";
		
		String downloadFromFilePath = "https://the-internet.herokuapp.com/download/robot.png";
		
		String downloadToFilepath = System.getProperty("user.dir")+"\\Downloads\\robot.png";
		
		String[] cmd = {autoitfilepath,downloadToFilepath,downloadFromFilePath};
		
		Runtime.getRuntime().exec(cmd);
		
		Thread.sleep(5000);
				
		File file = new File(downloadToFilepath);
		
		if(file.exists()) {
			
			System.out.println("File got successfully downloaded");
			
		}
		
		
		
	}

}
