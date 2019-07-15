package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	String url = "https://www.aircanada.com/ca/en/aco/home.html";
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	
	@FindBy(id="enCAEdition")
	private WebElement language;
	
	
	
	@FindBy(id="origin_R_0")
	private WebElement sourceAirport;
	
	@FindBy(id="destination_R_0")
	WebElement destinationAirport;
	
	WebElement startDate;
	
	WebElement endDate;
	
	@FindBy(id="calendarSelectActionBtn")
	private WebElement selectBtn;
	
	@FindBy(xpath="//*[@id=\"magnet-fields-wrapper\"]/div[3]/div[3]/input")
	private WebElement findBtn;

	public void verifyLanuage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(language));
	}
	
	
	public void clickEnglishLanguage() {
		
		language.click();
	}
	
	
	

	public void setSourceAirport(String strSourceAirport) {
		
			sourceAirport.sendKeys(strSourceAirport);
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		WebElement originLocations = driver.findElement(By.xpath("//*[@id='flightLocationListOrginId0']"));
		List<WebElement> originList = originLocations.findElements(By.tagName("li"));
		//System.out.println(originList.size());
		originList.get(0).click();

		}
	

	

	public void setDestinationAirport(String strDestinationAirport) {
		destinationAirport.sendKeys(strDestinationAirport);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement destinationLocations = driver.findElement(By.xpath("//*[@id='flightLocationListDestinationId0']"));
		List<WebElement> destinationList = destinationLocations.findElements(By.tagName("li"));
		
		destinationList.get(0).click();
	}

	

	public void setStartDate(String strStartDate) {
				destinationAirport.sendKeys(Keys.TAB);
				try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				WebElement e1 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div[1]/table/tbody/tr[3]"));
		
				List<WebElement> list1 = e1.findElements(By.tagName("td"));
				for(WebElement e2:list1) {
					if(e2.getAttribute("data-date").equals(strStartDate)) {
						e2.click();
						break;
				}
							
		}
		
		
	}

	

	public void setEndDate(String strEndDate) {
		WebElement d1 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div[1]/table/tbody/tr[4]"));
		List<WebElement> list2 = d1.findElements(By.tagName("td"));
		
		for(WebElement d2:list2) {
			
			if(d2.getAttribute("data-date").equals(strEndDate)) {
				d2.click();
				break;
			}
							
		}
	}
	
	
	public void clickSelectButton() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(selectBtn));
		selectBtn.click();
	}
	
	//non void method
	public void clickFindBtn() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(findBtn));
		findBtn.sendKeys(Keys.RETURN);
		
	}
	
	
	
	

}
