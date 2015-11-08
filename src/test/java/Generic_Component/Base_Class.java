package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Scenario_Component.Scenario_Login;

public class Base_Class {
	
	protected WebDriver browser;
	Utility_Class c1= new Utility_Class();
	static Logger log=Logger.getLogger(Base_Class.class);
	
	
	public void initBrowsersession() throws IOException
	{
		String browsertype = c1.Reading_Properties("btype");
		if(browsertype.equals("ff"))
		{
		browser= new FirefoxDriver();
		log.info("Intialized the browser in Firefox");
		}
		
		else if(browsertype.equals("ch"))
		{
			System.setProperty("webdriver.chrome.driver", c1.Reading_Properties("Chrome_Path"));
			browser= new ChromeDriver();
			log.info("Intialized the browser in Chrome");
		}
		
		else if(browsertype.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", c1.Reading_Properties("IE_Path"));
			browser= new InternetExplorerDriver();
			log.info("Intialized the browser in IE");
			
		}
		
		
		browser.manage().deleteAllCookies();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		browser.get(c1.Reading_Properties("URL"));
				
		
	}
	
	
	public void tearDown()
	{
		browser.quit();
		log.info("Closed the Browser");
		
	}
	
	//screenshot
	
	public void snapshot(String TC_ID,String Order) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		File file= new File(dateFormat.format(date) +".png");
		
		TakesScreenshot screenshot=(TakesScreenshot) browser;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\BSI\\Snapshot\\"+TC_ID+"-"+"Order"+"-"+file));
		
		
		
	}
	

}
