package DataProviderComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Login {
	
	@DataProvider(name="dp_InvalidLogin")
	public static Iterator<String[]> InvalidLogindata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Invalid_Login_test");
		return Obj.iterator();
		
		
	}

	
	@DataProvider(name="dp_ValidLogin")
	public static Iterator<String[]> ValidLogindata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Valid_Login_test");
		return Obj.iterator();
		
	}
	
	
	//to get the flag row count
	public static List<String[]> flagRowCount(String script_name) throws IOException
	{
		
		ExcelReadWrite x=new ExcelReadWrite("D:\\BSI\\TestData\\Test_Data.xls");
		HSSFSheet Scenario_Login = x.Setsheet("Scenario_Login");
		int xlRowcount = x.getrowcount(Scenario_Login);
		//Declare List
		
		List<String[]> List_login= new ArrayList<String[]>();
		//traversing Excel
		for(int xlRow=1;xlRow<=xlRowcount;xlRow++)
		{
			
			String Execute_Flag = x.Readvalue(Scenario_Login, xlRow, "Execute_Flag");
			String Scriptname = x.Readvalue(Scenario_Login, xlRow, "Scriptname");
			
			
			if((Execute_Flag.equals("Y")&&(Scriptname.equals(script_name))))
				{
				
				String[] arr_login= new String[5];
				
				arr_login[0]=x.Readvalue(Scenario_Login, xlRow, "TC_ID");
				arr_login[1]=x.Readvalue(Scenario_Login, xlRow, "Order");
				arr_login[2]=x.Readvalue(Scenario_Login, xlRow, "Uname");
				arr_login[3]=x.Readvalue(Scenario_Login, xlRow, "Pwd");
				arr_login[4]=x.Readvalue(Scenario_Login, xlRow, "Exp_Res");
				
				List_login.add(arr_login);			
				}//end of if
								
		}//end of for
		
		return List_login;
		
		
		
		
	}

}
