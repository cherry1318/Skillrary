package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class AddnewcoursePage {
	//Decleration 
	@FindBy(xpath="//b[text()='Add New Course']")
	private WebElement pageHeader;
	
	@FindBy(id="name")
	private WebElement nameTF;
	
	@FindBy(id="category")
	private WebElement categoryDropdown;
	
	@FindBy(id="price")
	private WebElement priceTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement uploadPhotoButton;
	
	@FindBy(xpath="//html/body/p")
	private WebElement descriptionTextArea;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, editor1']")
	private WebElement descriptionFrame;
	
	@FindBy(xpath="//button[text()=' Save' and @name='add']")
	private WebElement saveButton;
	
	//initialization
		public AddnewcoursePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//utilization
		public String getPageHeader()
		{
			return pageHeader.getText();
		}
		public void setName(String courseName)
		{
			nameTF.sendKeys(courseName);
		}
		
		public void selectCategory(WebDriverUtility web,String text) 
		{
			web.selectFromDropdown(text, categoryDropdown);
		}
		public void setprice(String price) 
		{
			priceTF.sendKeys(price);
		}
		public void uploadPhoto(String path) 
		{
			uploadPhotoButton.sendKeys(path);
		}
		public void setdescription(String description,WebDriverUtility web) {
			web.switchToFrame(descriptionFrame);
			descriptionTextArea.sendKeys(description);
			web.switchBackFromFrame();
		}	
		public void clicksave() {
			saveButton.click();
		}
}
