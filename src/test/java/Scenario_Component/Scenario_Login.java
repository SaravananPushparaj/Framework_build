package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Login;
import junit.framework.Assert;

public class Scenario_Login extends Base_Class {
	
	SoftAssert sAssert= new SoftAssert();
	static Logger log=Logger.getLogger(Scenario_Login.class);
	
	@Test(dataProvider="dp_InvalidLogin",dataProviderClass=DataProviderComponent.DataProvider_Login.class,groups={"smoke"})
	public void testLogin(String TC_ID,String Order,String Uname,String Pwd,String Exp_Res) throws IOException
	{
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		initBrowsersession();
		PageObject_Login lpob= new PageObject_Login(browser);
		lpob.CommonprocessLogin(TC_ID, Uname, Pwd);
		String Actual_Res = lpob.getInvalidLoginResult();		
		//Assert.assertEquals(Exp_Res, Actual_Res);
		//sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Expected msg was Valid");	
		}
		else
		{
			log.info("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
			//sAssert.fail("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
		}
		tearDown();
		//sAssert.assertAll();
		log.info("******************************************");
				
	}
	
	
	@Test(dataProvider="dp_ValidLogin",dataProviderClass=DataProviderComponent.DataProvider_Login.class,groups={"regression"})
	public void testValid_Login(String TC_ID, String Order, String Uname, String Pwd, String Exp_Res) throws IOException
	{
		initBrowsersession();
		PageObject_Login lpob= new PageObject_Login(browser);
		lpob.CommonprocessLogin(TC_ID, Uname, Pwd);
		String Actual_Result = lpob.getvalidLoginResult();
		
		if(Actual_Result.equals(Exp_Res))
		{
			log.info("Passed as Expected user logged in to app");
			lpob.Click_Sigout();
		}
		else
		{
			log.info("Failed as Expected user was  " +Exp_Res+ " Actual Result is  "+Actual_Result);
			sAssert.fail("Failed as Expected user was  " +Exp_Res+ " Actual Result is  "+Actual_Result);
			snapshot(TC_ID,Order);
		}
						
		tearDown();
		sAssert.assertAll();
		
	}
	
	

}
