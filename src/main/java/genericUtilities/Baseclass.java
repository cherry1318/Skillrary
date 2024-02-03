package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.AddnewUserpage;
import PomPages.AddnewcoursePage;
import PomPages.Categorypage;
import PomPages.CourseListPage;
import PomPages.HomePage;
import PomPages.Loginpage;
import PomPages.Userpage;
import PomPages.addnewcategorypage;

public class Baseclass {
	protected WebDriver driver;
	protected PropertiesUtilities property;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected ExcelUtility excel;
	protected Loginpage login;
	protected HomePage home;
	protected Userpage users;
	protected CourseListPage courseList;
	protected Categorypage category;
	protected AddnewUserpage addUser;
	protected AddnewcoursePage addCourse;
	protected addnewcategorypage addCategory;

	public static WebDriver sdriver;
	public static JavaUtility sjutil;

	// @BeforeSuite
	// @BeforeTest

	@BeforeClass
	public void classSetup() {
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		property = new PropertiesUtilities();
		excel = new ExcelUtility();

		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);

		driver = web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		sdriver = driver;
		sjutil = jutil;

	}

	@BeforeMethod
	public void methodSetup() {
		login = new Loginpage(driver);
		home = new HomePage(driver);
		users = new Userpage(driver);
		courseList = new CourseListPage(driver);
		category = new Categorypage(driver);
		addUser = new AddnewUserpage(driver);
		addCourse = new AddnewcoursePage(driver);
		addCategory = new addnewcategorypage(driver);

		excel.excelInit(IConstantPath.Excel_PATH, "Sheet1");

		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "Login");
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		Assert.assertEquals(home.getPageHeader(), "Home");

	}

	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signOutOfApp();

	}

	@AfterClass
	public void classTeadDown() {
		web.quitAllWindows();
	}
	// @AfterTest
	// @AfterSuite

}
