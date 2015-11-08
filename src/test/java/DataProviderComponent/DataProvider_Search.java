package DataProviderComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Search {
	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<String[]> InvalidSearchdata() throws IOException
	{
		List<String[]> Obj = flagRowcount("Invalid_Search");
		return Obj.iterator();		
		
	}
	
	
	@DataProvider(name="dp_Valid_Search")
	public static Iterator<String[]> ValidSearchData() throws IOException
	{
		List<String[]> Obj = flagRowcount("Valid_Search");
		return Obj.iterator();
	}
	
	
	
	public static List<String[]> flagRowcount(String script_name) throws IOException
	{
		ExcelReadWrite x= new ExcelReadWrite("D:\\BSI\\TestData\\Test_Data.xls");
		HSSFSheet Scenario_Search = x.Setsheet("Scenario_Search");
		int xlRowcount = x.getrowcount(Scenario_Search);
		
		//Declare
		List<String[]> List_Search= new ArrayList<String[]>();
		
		
		for(int xlrow=1;xlrow<=xlRowcount;xlrow++)
		{
			String Execute_Flag = x.Readvalue(Scenario_Search, xlrow, "Execute_Flag");
			String Scriptname = x.Readvalue(Scenario_Search, xlrow, "Scriptname");
			
			if((Execute_Flag.equals("Y")&&(script_name.equals(Scriptname))))
			{
				String[] arr_Search= new String[4];
				arr_Search[0]=x.Readvalue(Scenario_Search, xlrow, "TC_ID");
				arr_Search[1]=x.Readvalue(Scenario_Search, xlrow, "Order");
				arr_Search[2]=x.Readvalue(Scenario_Search, xlrow, "Search_Item");
				arr_Search[3]=x.Readvalue(Scenario_Search, xlrow, "Exp_Res");
				arr_Search[3]=arr_Search[3].replace(".0", "");
				List_Search.add(arr_Search);			
			}
					
			
		}//end of the for loop
		
		return List_Search;
		
	}
	

}
