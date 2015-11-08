package Scenario_Component;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.istack.internal.logging.Logger;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_InvalidSearch",dataProviderClass=DataProviderComponent.DataProvider_Search.class,groups={"smoke"})
	public void testInvalidSearch(String TC_ID, String Order,String Search_Item,String Exp_Res) throws IOException
	{
		log.info("Executing the Testcase  " +TC_ID +" Order is "+Order);
		initBrowsersession();
		PageObject_Search BSpob=new PageObject_Search(browser);
		BSpob.Commonprocess_Search(Search_Item);
		String Actual_Res = BSpob.getInvalidSearch();
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Actual msg was same as Expected");
		}
		else
		{
			log.info("Failed as Expected msg was " +Exp_Res+ " Actual msg is  "+Actual_Res);
			sAssert.fail("Failed as Expected msg was " +Exp_Res+ " Actual msg is  "+Actual_Res);
		}
		
		tearDown();
		sAssert.assertAll();
		
		
	}
	
	
	@Test(dataProvider="dp_Valid_Search",dataProviderClass=DataProviderComponent.DataProvider_Search.class,groups={"regression"})
	public void testValidSearch(String TC_ID, String Order,String Search_Item,String Exp_Res) throws IOException
	{
		log.info("Executing the Testcase  " +TC_ID +" Order is "+Order);
		initBrowsersession();
		PageObject_Search BSpob=new PageObject_Search(browser);
		BSpob.Commonprocess_Search(Search_Item);
		String Actual_Res = BSpob.getValidSearch();
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Actual msg was same as Expected");
		}
		else
		{
			log.info("Failed as Expected msg was " +Exp_Res+ " Actual msg is  "+Actual_Res);
			sAssert.fail("Failed as Expected msg was " +Exp_Res+ " Actual msg is  "+Actual_Res);
		}
		
		tearDown();
		sAssert.assertAll();
		
		
	}

}
