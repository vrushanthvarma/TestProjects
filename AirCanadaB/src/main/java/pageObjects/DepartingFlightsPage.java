package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepartingFlightsPage {

	
	WebDriver driver;

	public DepartingFlightsPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String expectedURL = "faredriven";
	
	
	public void verifyDepartingFlightsPage() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains(expectedURL));
		
	}
	
	
	public void selectEarliestFlight(int time,String classType) {
		List<WebElement> iternaryRows = driver.findElements(By.className("flight-row-container"));
		
		
		Map<String,String> map1 = new HashMap<String,String>();

		for(WebElement eachRow:iternaryRows) {
		WebElement timeElement = eachRow.findElement(By.cssSelector(".itinerary-depart-time.depart-time"));

		String a = timeElement.getText();
		//System.out.println(a);
		String b = a.substring(0, 2);



		List<WebElement> buttonsList = eachRow.findElements(By.tagName("button"));

		if(Integer.parseInt(b)>=time&&map1.size()<1) {
		for(WebElement e:buttonsList) {
		if(e.getAttribute("id").contains(classType)) {

		String s1 = e.getAttribute("id");

		map1.put(a, eachRow.findElement(By.xpath("//*[contains(@id,'" + s1 + "')]//currency-amount/span")).getText());
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(e));
		e.click();



		break;
		}

		}


		}






		}

		
		for(Map.Entry<String, String> me:map1.entrySet()) {
			
				System.out.println("Earliest flight on or after 7:00 AM is at : " + me.getKey() + "\nPremium Economy fare is : " + me.getValue());
				
		}
	}
	




}
