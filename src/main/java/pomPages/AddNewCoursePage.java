package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverUtility;

public class AddNewCoursePage {
	
	//Declaration

	@FindBy (xpath="//b[text()=\"Add New Course\"]")
	private WebElement pageHeader;
	
	@FindBy (xpath="//input[@id=\"name\"]")
	private WebElement nameTF;
	
	@FindBy (xpath="//select[@id=\"category\"]")
	private WebElement catagoryDropdown;
	
	@FindBy (xpath="(//input[@name=\"price\"])")
	private WebElement priceTF;
	
	@FindBy (xpath="(//input[@name=\"photo\"])[2]")
	private WebElement photoButton;
	
	@FindBy (xpath="//button[@name=\"add\"]")
	private WebElement saveButton;
	
	@FindBy (xpath="//html/body/p")
	private WebElement descriptionTextArea;
	
	@FindBy (xpath="//iframe[@title='Rich Text Editor, editor1']")
	private WebElement descriptionFrame;
	
	//Initialiazation
	
	public AddNewCoursePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	//Utilization
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setName(String name) {
		nameTF.sendKeys(name);
	}
	
	public void selectCatagory(WebDriverUtility web,String category) {
		web.handleDropdown(category, catagoryDropdown);
	}
	
	public void setPrice(String price) {
		priceTF.sendKeys(price);
	}
	
	public void uploadPhoto(String photoPath) {
		photoButton.sendKeys(photoPath);
	}
	
	public void setDescription(WebDriverUtility web,String text) {
		web.switchToFrame(descriptionFrame);
		descriptionTextArea.sendKeys(text);
		web.switchBackFromFrame();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
}
