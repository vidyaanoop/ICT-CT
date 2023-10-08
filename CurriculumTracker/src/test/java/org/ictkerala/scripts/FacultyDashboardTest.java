package org.ictkerala.scripts;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.DashBoard;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FacultyDashboardTest extends BaseClass{
	
	DashBoard addreqpage;
	LoginPage login;

	@BeforeMethod
	public void login() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"FacultyLogin");
		String password = ExcelUtility.readExcel(1,1,"FacultyLogin");
		addreqpage = new DashBoard();
		login = new LoginPage();
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);			
	}

	//Search for a req, open  and submit
	//@Test(priority=1, description="verify search functionality")
	/*public void SearchEditReqt() throws IOException {
		String req	=  ExcelUtility.readExcel(1,0,"CreateReqt");
		String slNo	=  ExcelUtility.readExcel(1,6,"CreateReqt");
		String desc	=  ExcelUtility.readExcel(1,7,"CreateReqt");
		String file	=  ExcelUtility.readExcel(1,8,"CreateReqt");
		String resp	=  ExcelUtility.readExcel(1,9,"CreateReqt");
		addreqpage.searchReq(req);
		addreqpage.clickSrchReq(req); 	
		Assert.assertTrue(objAddReqPage.verifyReqURL());
		addreqpage.submitReq(slNo,desc,file,resp);
		Assert.assertEquals(addreqpage.getReqAlert(), AutomationConstants.EXP_REQ_SUBMIT_ALERT);		
	}*/
}



