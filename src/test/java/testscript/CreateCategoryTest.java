package testscript;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;

public class CreateCategoryTest  extends BaseClass{
	@Test
	public void createCategoryTest() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		home.clickCoursesTab();
		home.clickCatagoryLink();
		soft.assertTrue(category.getPageHeader().contains("Category"));
		
		category.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		Map<String, String> map=excel.readFromExcel("Sheet1", "Add Category");
		String cateoryName=map.get("Name")+jutil.generateRandomNum(100);
		addCategory.setName(cateoryName);
		addCategory.clickSave();
		
		soft.assertTrue(category.getSuccessMessage().contains("Success"));
		boolean isPresent=false;
		List<WebElement> categoryList=category.getCategoryList();
		for(WebElement e:categoryList) {
			if(e.getText().equals(cateoryName)) {
				isPresent=true;
				break;
			}
		}
		soft.assertTrue(isPresent);
		
		category.clickDeleteButton(cateoryName, driver);
		category.clickDelete();
		soft.assertTrue(category.getSuccessMessage().contains("Success"));
		soft.assertAll();
		
	}

}
