package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class Categorypage {
	
	//Decleration //h1[normalize-space(text())='category']
	@FindBy(xpath = "//a[text()=' Category']")
	private WebElement pageHeader ;
	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton ;
	
	private String deletePath = "//td[text()='%s']/ancestor::tr" + "/descendant::button[text()=' Delete']";

	
	@FindBy(name = "delete")
	private WebElement deleteButton ;
	
	@FindBy(xpath = "//h4[text()=\" Success!\"]")
	private WebElement successMessage;
	
	//initialization
			public Categorypage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			//utilization
			public String getPageHeader()
			{
				return pageHeader.getText();
			}
			public void clickNewbutton() {
				newButton.click();
			}
			public void deleteCourse(WebDriverUtility web , String categoryName)
			{
				web.convertPathToWebElement(deletePath, categoryName).click();
				deleteButton.click();
			}
			public String getSuccessMessage()
			{
				return successMessage.getText();
			}
}
