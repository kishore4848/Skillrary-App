package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	//Declaration
	@FindBy(xpath="//span[text()='SkillRary Admin']")
	private WebElement adminIcon;
	
	@FindBy (xpath="//span[text()=\"Users\"]")
	private WebElement userTab;
	
	@FindBy (xpath="//span[text()=\"Courses\"]")
	private WebElement coursesTab;
	
	@FindBy (xpath="//a[.=\" Course List\"]")
	private WebElement courseListLink;
	
	@FindBy (xpath="//a[.=' Category']")
	private WebElement catagoryLink;
	
	@FindBy (xpath="//a[text()=\"Sign out\"]")
	private WebElement signOutLink;
	
	//Initialiazation
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getAdminIcon() {
		return adminIcon.getText();
	}
	
	public void clickUserTab() {
		userTab.click();
	}
	
	public void clickCoursesTab() {
		coursesTab.click();
	}
	
	public void clickCourseListLink() {
		courseListLink.click();
	}
	
	public void clickCatagoryLink() {
		catagoryLink.click();
	}
	
	public void signOutOfApp() {
		adminIcon.click();
		signOutLink.click();
	}
}
