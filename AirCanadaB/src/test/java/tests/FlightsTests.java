package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.DepartingFlightsPage;
import pageObjects.LandingPage;

public class FlightsTests extends BaseTest{
	
	@Test
	public void testFlight() {
		Reporter.log("navigating to url: " + url );
		driver.get(url);
		objLandingPage = new LandingPage(driver);
		objLandingPage.verifyLanuage();
		Reporter.log("Clicking Language button");
		objLandingPage.clickEnglishLanguage();
		objLandingPage.setSourceAirport("Vancouver");
		objLandingPage.setDestinationAirport("Toronto");
		
		objLandingPage.setStartDate("17");
		objLandingPage.setEndDate("24");
		
		objLandingPage.clickSelectButton();
		objLandingPage.clickFindBtn();
		
		objDepartingFlightsPage = new DepartingFlightsPage(driver);
		objDepartingFlightsPage.verifyDepartingFlightsPage();
		objDepartingFlightsPage.selectEarliestFlight(time, classType);

	}

}
