package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution Starts");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Execution Starts");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Fail");
		System.out.println("Fail due to: "+result.getThrowable());
		WebDriverUtility web = new WebDriverUtility();
		web.captureScreenshot(Baseclass.sdriver, Baseclass.sjutil, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Skipped");
		System.out.println("Skipped due to:"+result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Terminates");
	}
	
	

}
