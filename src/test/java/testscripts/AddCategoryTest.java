package testscripts;

import java.util.Map;
//This test verifies is user is able to create Addcategory

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.Baseclass;
import genericUtilities.IConstantPath;

public class AddCategoryTest extends Baseclass{
	@Test
	public void addCategoryTest() {
		SoftAssert soft=new SoftAssert();
		home.clickCoursesTab();
		home.clickcategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewbutton();
		soft.assertEquals(addCategory.getPageHeader(), "Add New Category");
		Map<String, String> map = excel.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
		
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		category.deleteCourse(web, map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		if(category.getSuccessMessage().equals("success!"))
			excel.updateTestStatus("Add Category", "Pass", IConstantPath.Excel_PATH);
		else
			excel.updateTestStatus("Add Category", "Pass", IConstantPath.Excel_PATH);
		
		soft.assertAll();
		
	}

}
