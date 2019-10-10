package Test_Pom;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic_package.BaseTest;
import Generic_package.XL;
import Pom.EnterTimeTrackPage;
import Pom.LoginPage;

public class TestValidLogin extends BaseTest {
	
	@Test
	public void testValidLogin() throws EncryptedDocumentException, FileNotFoundException, IOException {
		String UN= XL.getdata(XL_PATH, "Sheet1", 1, 0);
		String pw = XL.getdata(XL_PATH, "Sheet1", 1, 1);
		
		String title = XL.getdata(XL_PATH, "Sheet1",1,2);
		
		LoginPage lp = new LoginPage(driver);
		lp.username(UN);
		lp.setpassword(pw);
		lp.LoginButton();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyHPisDisplayed(driver, 5, title);
		
	}

}
