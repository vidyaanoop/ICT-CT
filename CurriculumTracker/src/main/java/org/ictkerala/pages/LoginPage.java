package org.ictkerala.pages;

import org.ictkerala.constants.AutomationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
WebDriver driver;
WebDriver wait;

//locate elements

@FindBy(linkText = "Login")
WebElement loginBtn;

@FindBy(name="email")
WebElement email;

@FindBy(name="password")
WebElement password;

@FindBy(xpath="//button[text()='submit']")
WebElement submitBtn;

@FindBy(id="swal2-title")
public WebElement loginmsg;

@FindBy(xpath="//button[text()='OK']")
WebElement OKBtn;

@FindBy(xpath="//i[(@class='bi bi-box-arrow-left']")
WebElement logoutBtn;

//methods for different fields 
// click login btn
public void clickLoginBtn() {
	loginBtn.click();
}

//enter email password and click submit btn 
public void clickSubmitBtn(String inpemail,String inputpassword) {
	email.clear();
	password.clear();
	email.sendKeys(inpemail);
	password.sendKeys(inputpassword);
	submitBtn.click();
	OKBtn.click();

}

//click logoutbtn
public void clickLogoutBtn() {
	logoutBtn.click();
}}
	/*verify login url
	
		public boolean verifyLoginURL() {
		return wait.until(ExpectedConditions.urlToBe(AutomationConstants.LOGIN_URL));
		}
*/
	

//}


	
	


