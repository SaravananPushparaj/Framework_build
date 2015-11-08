package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Login {
	
	
	public WebDriver browser;
	
	//*************************************************
	//Strorage for Elements
	@FindBy(linkText="Sign In")
	WebElement lnk_Signin;
	
	@FindBy(name="logid")
	WebElement txt_Uname;
	
	@FindBy(name="pswd")
	WebElement txt_Pwd;
	
	@FindBy(css="html body table tbody tr td table tbody tr td table tbody tr td.sb2 table tbody tr td.sb1 input")
	WebElement btn_Login;
	
	@FindBy(css="html body table tbody tr td table tbody tr td table tbody tr td table tbody tr td font b")
	WebElement msg_Invalid_result;
	
	
	@FindBy(css="html body div#wrap div#header.topborder.relative div.floatR.extra_gap div.floatL div span#username.bold a.proper")
	WebElement msg_Valid_result;
	
	@FindBy(linkText="Sign Out")
	WebElement lnk_Signout;
	//***************************************
	
	//Action on those Elements through different methods
	
	//constructor to initialize browser
	
	public PageObject_Login(WebDriver Dbrowser)
	{
		this.browser=Dbrowser;
		PageFactory.initElements(browser, this);
				
	}
	//methods for different actions
	
	public void Click_Signin()
	{
		lnk_Signin.click();
		
	}
	
	public void Enterusername(String Value)
	{
		txt_Uname.sendKeys(Value);
	}
	
	
	public void EnterPassword(String Value)
	{
		txt_Pwd.sendKeys(Value);
	}
	
	
	public void Click_Login()
	{
		btn_Login.click();
		
	}
	
	
	public String getInvalidLoginResult()
	{
		return msg_Invalid_result.getText();
	}
	
	
	public String getvalidLoginResult()
	{
		return msg_Valid_result.getText();
	}
	
	public void Click_Sigout()
	{
		lnk_Signout.click();
		
	}
	
	//**********************************************************************************
	
	//Common process component
	
	public void CommonprocessLogin(String TC_ID, String Uname, String Pwd)
	{
		
		Click_Signin();
		Enterusername(Uname);
		EnterPassword(Pwd);
		Click_Login();	
		
		
	}
	

}
