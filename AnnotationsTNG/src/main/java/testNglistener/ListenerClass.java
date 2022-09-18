 package testNglistener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{


	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start method invoked..:");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finished method invoked..");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("name of the method started:"+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("name of the method succesfully executed:"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("name of method failed:"+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("name of the method skipped:"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}


	
	

}
