package org.ictkerala.scripts;
import org.junit.Assert;

import java.io.IOException;
//import static org.junit.Assert.assertTrue;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.pages.SignUpPage;
//import org.ictkerala.testcases.BeforeMethod;
//import org.ictkerala.testcases.Test;
//import org.ictkerala.testcases.TestBase;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



	public class SignUpPageTest extends BaseClass{
		
		SignUpPage signup;
		LoginPage login;
		
		@BeforeMethod
		public void intitMethod() {
			signup = new SignUpPage(driver,wait);
			login = new LoginPage();	
			login.clickLoginBtn();
			signup.clickNewAcctLink();
		}
		
		//verify faculty Create Account link redirects to correct page
		@Test(priority=1,description="verify faculty Create Account link")
		public void verifyCrtAcctNowLink() throws IOException {
			Assert.assertTrue(signup.verifySignUpURL());
		}
		
		//create faculty account with valid data
		@Test(priority=2,description="create faculty account with valid data")
		public void validSignUpTest() throws IOException {
			signup.setName(ExcelUtility.readExcel(1,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(1,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(1,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(1,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(1,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertTrue(signup.signUpMsg.getText().contains(AutomationConstants.LOGIN_SUCCESS_MSG));
			signup.clickOKBtn();
			
		}
		
		//verify if mandatory fields give error on blank
		@Test(priority=3,description="create faculty account with blank fields")
		public void blankFieldsTest() throws IOException {
			signup.setName("");
			signup.setEmail("");
			signup.setPhone("");
			signup.setPassword("");
			signup.setConfPassword("");
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getNameError(), AutomationConstants.EXP_NAME_ERR);
			Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);
			Assert.assertEquals(signup.getEmailError(), AutomationConstants.EXP_EMAIL_ERR);
			Assert.assertEquals(signup.getPassError(), AutomationConstants.EXP_PASS_ERR);
			Assert.assertEquals(signup.getConfPassEmptyError(), AutomationConstants.EXP_CONFPASS_EMPTY_ERR);
		}
		
		//verify error when name has non alphabets
		@Test(priority=4,description="user name has non alphabets")
		public void userNonAlph() throws IOException {
			signup.setName(ExcelUtility.readExcel(2,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(2,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(2,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(2,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(2,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getNameError(), AutomationConstants.EXP_NAME_ERR);
		}
		
		//verify error when email is not in proper format
		@Test(priority=5,description="email invalid")
		public void emailInvalidChar() throws IOException {
			signup.setName(ExcelUtility.readExcel(3,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(3,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(3,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(3,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(3,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getEmailError(), AutomationConstants.EXP_EMAIL_ERR);
		}	
		
		//verify error when phone number greater than 10 digits
		@Test(priority=6,description="phone number greater than 10 digits")
		public void phoneMoreThan10() throws IOException {
			signup.setName(ExcelUtility.readExcel(3,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(3,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(3,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(3,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(3,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);		
		}
			
		//verify error when phone number less than 10 digits
		@Test(priority=7,description="phone number less than 10 digits")
		public void phoneLessThan10() throws IOException {
			signup.setName(ExcelUtility.readExcel(4,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(4,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(4,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(4,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(4,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);	
		}	
		
		//verify error when phone number has invalid characters
		@Test(priority=8,description="phone number invalid characters")
		public void phoneNoInvalidChar() throws IOException {
			signup.setName(ExcelUtility.readExcel(5,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(5,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(5,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(5,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(5,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);	
		}	
					
		//verify error when password does meet specifications
		@Test(priority=8,description="password invalid")
		public void passLessThan6Char() throws IOException {
			signup.setName(ExcelUtility.readExcel(6,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(6,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(6,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(6,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(6,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getPassError(), AutomationConstants.EXP_PASS_ERR);	
		}
		
		//verify error when confirm password does not match password
		@Test(priority=9,description="confirm password different")
		public void confirmPassNotMatching() throws IOException {
			signup.setName(ExcelUtility.readExcel(7,0,"FacultySignUp"));
			signup.setEmail(ExcelUtility.readExcel(7,1,"FacultySignUp"));
			signup.setPhone(ExcelUtility.readExcel(7,2,"FacultySignUp"));
			signup.setPassword(ExcelUtility.readExcel(7,3,"FacultySignUp"));
			signup.setConfPassword(ExcelUtility.readExcel(7,4,"FacultySignUp"));
			signup.clickSignUpBtn();
			Assert.assertEquals(signup.getConfPassMatchError(), AutomationConstants.EXP_CONFPASS_MATCH_ERR);	
		}	

	}


