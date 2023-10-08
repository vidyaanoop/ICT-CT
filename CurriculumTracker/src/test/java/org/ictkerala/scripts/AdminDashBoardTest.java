package org.ictkerala.scripts;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.DashBoard;
import org.ictkerala.pages.LoginPage;
//import org.ictkerala.testcases.BeforeMethod;
//import org.ictkerala.testcases.Test;
//import org.ictkerala.testcases.TestBase;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class AdminDashBoardTest extends BaseClass{ 

	DashBoard addreqpage;
	LoginPage login;
	
	@BeforeMethod
	public void login() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"AdminLogin");
		String password = ExcelUtility.readExcel(1,1,"AdminLogin");
		addreqpage = new DashBoard();
		login= new LoginPage();
		login.clickLoginBtn();
		login.clickSubmitBtn(email,password);			
	}

	//Test Create requirement functionality
	@Test(priority=2, description="verify Create requirement functionality")
	public void verifyCreateReqt() throws IOException {
		addreqpage.clickCreateReqBtn(); 	
		String req	=  ExcelUtility.readExcel(1,0,"CreateReqt");
		String area =  ExcelUtility.readExcel(1,1,"CreateReqt");
		String inst =  ExcelUtility.readExcel(1,2,"CreateReqt");
		String catg =  ExcelUtility.readExcel(1,3,"CreateReqt");
		String hrs  =  ExcelUtility.readExcel(1,4,"CreateReqt");	
		String path =  ExcelUtility.readExcel(1,5,"CreateReqt");	
		addreqpage.clickReqSubmitBtn(req,area,inst,catg,hrs,path);
	    Assert.assertEquals(addreqpage.getReqAlert(), AutomationConstants.EXP_REQ_ALERT);			
	}
	
	
	//Approve functionality
	@Test(priority=5, description="approve pending curriculum ")
	public void apprCurrlm() throws IOException {
		String req	=  ExcelUtility.readExcel(1,0,"CreateReqt");
		addreqpage.apprPendCurrlm(req);
		Assert.assertEquals(addreqpage.getReqAlert(), AutomationConstants.EXP_CURR_APPR_ALERT);
	}
}


}
