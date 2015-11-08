package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Search {
	
	WebDriver browser;
	
	@FindBy(id="srchword")
	WebElement Enter_SearchBook;
	
	@FindBy(css="input[class='newsrchbtn'][type='button']")
	WebElement Click_btn;
	
	@FindBy(css="html body div#wrap div#myDataDiv.hide center div#notify.div_notify p.sorrymsg")
	WebElement msg_Invalid_Search;
	
	@FindBy(id="find")
	WebElement msg_Valid_search;
	
	
	public PageObject_Search(WebDriver Dbrowser)
	{
		this.browser=Dbrowser;
		PageFactory.initElements(browser, this);
	}
	
		public void EnterSearch(String Value)
		{
			Enter_SearchBook.sendKeys(Value);
		}
	
	
		public void Click_Search()
		{
			Click_btn.click();
		}
		
		public String getInvalidSearch()
		{
			return msg_Invalid_Search.getText();
		}
		
		public String getValidSearch()
		{
			return msg_Valid_search.getText();
		}
		
		
		public void Commonprocess_Search(String Search_Item)
		{
			
			EnterSearch(Search_Item);
			Click_Search();		
			
		}

}
