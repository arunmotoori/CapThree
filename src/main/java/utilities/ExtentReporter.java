package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport = null;
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\Reports\\ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("TutorialsNinja - Automation Results Report");
		reporter.config().setDocumentTitle("TutorialsNinja Report");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Project Name","TutorialsNinja");
		extentReport.setSystemInfo("Application Version","3.7.0");
		extentReport.setSystemInfo("Operating System","Windows 11");
		extentReport.setSystemInfo("Run By","Arun Motoori");
		
		
		return extentReport;
		
	}

}
