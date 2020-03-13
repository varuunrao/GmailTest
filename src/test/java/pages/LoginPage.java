package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	
	WebDriver driver;

    By email = By.id("identifierId");

    By nextBtn = By.id("identifierNext");

    By password = By.name("password");
    
    By submitBtn = By.id("passwordNext");
    
    /*private By error = By.xpath = "//div[@class='OyEIQ uSvLId']//span")
    private List<WebElement> error;
	*/
    public void enterData(WebElement element, String data) {
    	
    	element.sendKeys(data);
    }
    
    public LoginPage(WebDriver driver) {
    	
    	this.driver = driver;
    }
    
    public void enterEmail(String emailid) {
    	
        WebElement mail = driver.findElement(email);
    	enterData(mail, emailid);
    }
    
    public void clickNext(By by) {
    	
        driver.findElement(by).click();
    }
    
    public void enterPassword(String passwordd) {
    	
        WebElement pass = driver.findElement(password);
    	enterData(pass, passwordd);
    }
    
    public void login(String email, String password) {
    	
    	this.enterEmail(email);
    	this.clickNext(nextBtn);
    	this.enterPassword(password);
    	this.clickNext(submitBtn);
    }
    
    
 /*   public int getErrorDisplayed() {
    	
    	//waitForVisibility(this.error);
    	
    	return this.error.size();
    }*/
    

}
