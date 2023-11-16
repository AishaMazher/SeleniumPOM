package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	public WebDriver driver;
	public landingPage(WebDriver driver) {
		this.driver=driver;
	}
	By signinButton = By.linkText("Login or register");
	public WebElement getSignin() {
		return driver.findElement(signinButton);
	}
	
	By promoSection=By.xpath("//section[contains(@class,'promo_section')]");
	public WebElement getPromo() {
		return driver.findElement(promoSection);
	}
	
	By navigationBar = By.cssSelector("ul[class$='categorymenu']");
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
	
	By menuText = By.cssSelector("div[class='menu_text']");
	public WebElement getMenuText() {
		return driver.findElement(menuText);
	}
	By doveLink = By.cssSelector("a[href='href=\"https://automationteststore.com/index.php?rt=product/manufacturer&manufacturer_id=18\']");
	public WebElement getDoveLink() {
		return driver.findElement(doveLink);
	}
	
	

}
