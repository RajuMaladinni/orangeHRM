package TestNgScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class IlestenerClass extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		capturescreentshot(result.getMethod().getMethodName()+".jpg");
		System.out.println(result.getMethod().getMethodName());
	}

	
}
