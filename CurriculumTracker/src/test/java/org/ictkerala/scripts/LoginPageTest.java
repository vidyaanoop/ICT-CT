package org.ictkerala.scripts;
import java.io.IOException;
import org.junit.Assert;
import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.LoginPage;
//import org.ictkerala.testcases.BeforeMethod;
//import org.ictkerala.testcases.Test;
//import org.ictkerala.testcases.BaseClass;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginPageTest extends BaseClass{
	LoginPage login;
	
	@BeforeMethod
	public void intitMethod() {
		login = new LoginPage();
	}

	//verify admin login with valid email and valid password
	@Test(priority=1,description="admin valid login")
	public void admValidLogin() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"AdminLogin");
		String password = ExcelUtility.readExcel(1,1,"AdminLogin");
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);
		Assert.assertTrue(login.loginmsg.getText().contains(AutomationConstants.LOGIN_SUCCESS_MSG));
	}
	
	//verify admin login with valid email and invalid password
	@Test(priority=2,description="admin valid email/invalid password")
	public void admValEmailInvalPass() throws IOException {
		String email =ExcelUtility.readExcel(2,0,"AdminLogin");
		String password =ExcelUtility.readExcel(2,1,"AdminLogin");
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);
		Assert.assertTrue(login.loginmsg.getText().contains(AutomationConstants.LOGIN_FAILURE_MSG));
	}
		
	//verify admin logout
	@Test(priority=3,description="admin logout")	
	public void admLogout() throws IOException {	
		String email =ExcelUtility.readExcel(1,0,"AdminLogin");
		String password =ExcelUtility.readExcel(1,1,"AdminLogin");
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);
		login.clickLogoutBtn();
	}

	//verify faculty login with valid email and valid password
	@Test(priority=4,description="faculty valid login")
	public void facValidLogin() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"FacultyLogin");
		String password = ExcelUtility.readExcel(1,1,"FacultyLogin");
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);
		Assert.assertTrue(login.loginmsg.getText().contains(AutomationConstants.LOGIN_SUCCESS_MSG));
	}
		
	//verify faculty login with valid email and invalid password
	@Test(priority=5,description="faculty valid email/invalid password")
	public void facValEmailInvalPass() throws IOException {
		String email =ExcelUtility.readExcel(2,0,"FacultyLogin");
		String password =ExcelUtility.readExcel(2,1,"FacultyLogin");
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);
		Assert.assertTrue(login.loginmsg.getText().contains(AutomationConstants.LOGIN_FAILURE_MSG));
	}
			
	//verify faculty logout
	@Test(priority=6,description="faculty logout")	
	public void facLogout() throws IOException {	
		String email =ExcelUtility.readExcel(1,0,"FacultyLogin");
		String password =ExcelUtility.readExcel(1,1,"FacultyLogin");
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);
		login.clickLogoutBtn();
	}
}



