package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.DepartingFlightsPage;
import pageObjects.LandingPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected LandingPage objLandingPage;
	protected DepartingFlightsPage  objDepartingFlightsPage;
	
	protected String url = "https://www.aircanada.com/ca/en/aco/home.html";
	protected int time=7;
	protected String classType="PREM";
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
			
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
