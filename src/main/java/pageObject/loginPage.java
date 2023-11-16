package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	By login_Name = By.xpath("//input[@name='user-name']");
	public WebElement get_loginName() {
		return driver.findElement(login_Name);
	}
	
	By password = By.xpath("//input[@name='password']");
	public WebElement get_password() {
		return driver.findElement(password);
	}
	
	By hitLogin = By.xpath("//input[@id='login-button']");
	public WebElement get_hitLogin() {
		return driver.findElement(hitLogin);
	}
	
	By errorContainer = By.xpath("//h3[@data-test='error']");
	public WebElement getErrorContainer() {
		return driver.findElement(errorContainer);
	}
	

}
