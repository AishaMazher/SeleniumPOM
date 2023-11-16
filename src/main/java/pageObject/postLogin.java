package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class postLogin {
	public WebDriver driver;
	public postLogin(WebDriver driver) {
		this.driver=driver;
	}

	By titleBar = By.xpath("//span[@class='title']");
	public WebElement gettitleBar() {
		return driver.findElement(titleBar);

}
	By sortContainer = By.className("product_sort_container");
	public WebElement getSortContainer() {
		return driver.findElement(sortContainer);

}
	By itemsPrices = By.className("inventory_item_price");
	public List<WebElement> getItemsPrices() {
		return driver.findElements(itemsPrices);

}
	By ProductsList = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	public List<WebElement> getProductsList() {
		return driver.findElements(ProductsList);

}
	By cart=By.xpath("//a[@class='shopping_cart_link']");
	public WebElement getCart() {
		return driver.findElement(cart);
	}
	
	By cartQuantity= By.cssSelector("div[class='cart_quantity']");
	public List<WebElement> getcartQuantity() {
		return driver.findElements(cartQuantity);

}
	
	By menu=By.id("react-burger-menu-btn");
	public WebElement getMenu() {
		return driver.findElement(menu);
	}
	By aboutLink=By.id("about_sidebar_link");
	public WebElement getAboutLink() {
		return driver.findElement(aboutLink);
	}
	By footer= By.xpath("//div[@class='footer-has-text-white']");
	public WebElement getfooter() {
		return driver.findElement(footer);
	}
	
	By fbLink=By.cssSelector("i.svg.svg-facebook");
	public WebElement getfbLink() {
		return driver.findElement(fbLink);
	}
	
	By ContactSales = By.linkText("Contact sales");
	public WebElement getContactSales() {
		return driver.findElement(ContactSales);
	}
By FirstName= By.id("FirstName");
public WebElement getFname() {
	return driver.findElement(FirstName);
}

By LastName= By.id("LastName");
public WebElement getLname() {
	return driver.findElement(LastName);
}

By cName= By.id("Company");
public WebElement getCname() {
	return driver.findElement(cName);
}

By Email= By.id("Email");
public WebElement getEmail() {
	return driver.findElement(Email);
}
By companySize= By.id("Company_Size__c");
public WebElement getCompanySize() {
	
	return driver.findElement(companySize);
}

By CountryDropdown= By.id("Country");
public WebElement getCountryDropdown() {
	
	return driver.findElement(CountryDropdown);
}

By phoneFeild= By.id("Phone");
public WebElement getphoneFeild() {
	
	return driver.findElement(phoneFeild);
}

By mobileTestingCB= By.xpath("//input[@value='Mobile Testing']");
public WebElement getmobileTesting() {
	
	return driver.findElement(mobileTestingCB);
}

By textfld=By.id("How_did_you_hear_about_Sauce_Labs__c");
public WebElement gettxtFld() {
	
	return driver.findElement(textfld);
}

By commentBox=By.id("Sales_Contact_Comments__c");
public WebElement getComments() {
	
	return driver.findElement(commentBox);
}

}
