package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.BaseTest;

public class ExtentReportUtility implements ITestListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public String report_name;
	public String rep_name;
	public void onStart(ITestContext context) {
		    System.out.println("..............Test Started............");
		    
		  }
	public void onTestStart(ITestResult result) {
	    // not implemented
		rep_name=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/MyReport"+"-"+rep_name+".html");
		spark.config().setDocumentTitle("MyApplication");
		spark.config().setReportName("AccountRegister");
		spark.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Tester", "Bhavya");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("ApplicationName", "Open_Cart");
		report.setSystemInfo("OS", "windows");
	  }
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		test=report.createTest(result.getTestClass().getName());
		test.log(Status.PASS, "Test Case Passed: "+result.getName());
	  }
	public void onTestFailure(ITestResult result) {
	    // not implemented
		test=report.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, "Test Case Passed: "+result.getName());
		test.log(Status.INFO,"Error message is:"+ result.getThrowable().getMessage());
		try {
//			BaseTest baseTest = (BaseTest) result.getInstance();
//            String path = baseTest.takeScreenShot(result.getName());
//			test.addScreenCaptureFromPath(path);
			String path=new BaseTest().takeScreenShot(result.getName());
			test.addScreenCaptureFromPath(path);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	  }
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		test=report.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, "Test Case Passed: "+result.getName());
		test.log(Status.INFO,result.getThrowable().getMessage());
	  }
	public void onFinish(ITestContext context) {
	    // not implemented
		report.flush();
	  }
	

}
