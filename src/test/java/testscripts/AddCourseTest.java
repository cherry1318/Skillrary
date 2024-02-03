package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.Baseclass;
import genericUtilities.IConstantPath;
//This test is verifies user ia able to create to add course
public class AddCourseTest extends Baseclass {
	@Test
	public void addCourseTest() {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertTrue(courseList.getPageHeader().contains("Course List"));
		courseList.clickNewButton();
		soft.assertEquals(addCourse.getPageHeader(), "Add New Course");

		Map<String, String> map = excel.readFromExcel("Add Course");
		addCourse.setName(map.get("Name"));
		addCourse.selectCategory(web, map.get("Category"));
		addCourse.setprice(map.get("Price"));
		addCourse.uploadPhoto(map.get("Photo"));
		addCourse.setdescription(map.get("Description"), web);
		addCourse.clicksave();
		
		soft.assertEquals(courseList.getSuccessMessage(), "Success!");
		courseList.deleteCourse(web, map.get("Name"));
		soft.assertEquals(courseList.getSuccessMessage(), "Success!");
		
		if(courseList.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add Course", "Pass", IConstantPath.Excel_PATH);
		else
			excel.updateTestStatus("Add Course", "Fail", IConstantPath.Excel_PATH);
		soft.assertAll();
			
	}

}
