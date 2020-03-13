package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	By header = By.id(":2a");
	
	public DashboardPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String pageheader() {
    	
    	return driver.findElement(header).getText();
    	
    }
}
