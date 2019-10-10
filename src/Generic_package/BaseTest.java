package Generic_package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
public WebDriver driver;

@BeforeMethod 
public void openapp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	driver.get(URL);
	
}
@AfterMethod
public void closeApp(ITestResult testResult) throws IOException {
	String name= testResult.getName();
	int status =  testResult.getStatus();
	if ( status ==1) {
		Reporter.log("Test"+name+ "is passed",true);
		
	}else {
		Reporter.log("Test"+name+ " is failed",true);
		String path = IMG_PATH +name+".png";
		FWUtil.getphoto(driver, path);
	}
	driver.close();
	}
}


