package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSparkReportNG {

	//public static ExtentSparkReporter  reporter;
	public static ExtentSparkReporter reporter;
	
	public static ExtentReports getReportObject() {
	
		String file = System.getProperty("user.dir")+"/report/index.html";
		
		reporter = new ExtentSparkReporter(file);
		
		reporter.config().setDocumentTitle("Web Application Report");
		
		reporter.config().setReportName("Test Result");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Software Test Engineer","Viraj D. Utekar");
		
		return extent;
	}
}
