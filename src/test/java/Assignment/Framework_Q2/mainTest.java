package Assignment.Framework_Q2;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import pageObject.landingPage;
import pageObject.loginPage;
import pageObject.postLogin;
import resources.base;



public class mainTest extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());

	
	
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) {
		driver.get(prp.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		postLogin obj_pl=new postLogin(driver);
		loginPage obj_login = new loginPage(driver);
		test= report.startTest("Validate login Credentials");
		obj_login.get_loginName().sendKeys(username);
	   obj_login.get_password().sendKeys(password);
		obj_login.get_hitLogin().click();
		 String error= prp.getProperty("text");
		// System.out.println(obj_login.getErrorContainer().getText());
		try {
		Assert.assertTrue(obj_pl.gettitleBar().isEnabled());
		test.log(LogStatus.PASS, "User Logged in successfully");
		}
	catch(Exception e){
			Assert.assertEquals((obj_login.getErrorContainer().getText()), error);
			test.log(LogStatus.PASS, "Invalid Username/password");
			
		}
		
		
	
	
		
	}
	
	
	
@Test()
public void verifyURL() {
	postLogin obj_pl=new postLogin(driver);
	loginPage obj_login = new loginPage(driver);
	test= report.startTest("Validate Fb URL");
	driver.get(prp.getProperty("baseURL"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	String sLab_Username= prp.getProperty("username");
	String sLab_pw= prp.getProperty("Password");
	obj_login.get_loginName().sendKeys(sLab_Username);
	obj_login.get_password().sendKeys(sLab_pw);
	obj_login.get_hitLogin().click();
	obj_pl.getMenu().click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30,1));
	wait.until(ExpectedConditions.visibilityOf(obj_pl.getAboutLink()));
	obj_pl.getAboutLink().click();
	obj_pl.getContactSales().click();
	String f_Name=prp.getProperty("FirstName");
	String l_Name=prp.getProperty("LastName");
	String p_Number=prp.getProperty("PhoneNumber");
	String c_Name=prp.getProperty("Company");
	String b_Email=prp.getProperty("businessEmail");
	String Comments=prp.getProperty("Comment");
	String text=prp.getProperty("txt");
	obj_pl.getFname().sendKeys(f_Name);
	obj_pl.getLname().sendKeys(l_Name);
	obj_pl.getCname().sendKeys(c_Name);
	WebElement Companysize=obj_pl.getCompanySize();
	Select c_size=new Select(Companysize);
	obj_pl.getEmail().sendKeys(b_Email);
	c_size.selectByValue("11-50");
	WebElement Country=obj_pl.getCountryDropdown();
	Select cntry=new Select(Country);
	cntry.selectByValue("Pakistan");
	obj_pl.getphoneFeild().sendKeys(p_Number);
	WebElement clickCheckbox= obj_pl.getmobileTesting();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", clickCheckbox);
	obj_pl.gettxtFld().sendKeys(text);
	obj_pl.getComments().sendKeys(Comments);
	driver.navigate().back();
	WebElement clickfbLink=obj_pl.getfbLink();
	js.executeScript("arguments[0].click()", clickfbLink);
	Set<String> windows= driver.getWindowHandles();
	Iterator<String> it= windows.iterator();
	String parentId=it.next();
	String childId=it.next();
	driver.switchTo().window(childId);
	String assertURL=prp.getProperty("FBUrl");
	try {
	Assert.assertEquals(driver.getCurrentUrl(),assertURL );
	test.log(LogStatus.PASS, "Facebook URL is correct");
	}
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Facebook URL is NOT correct");
		
	}
	
}
	
	
@Test()
public void verifyPrices() {
	
	postLogin obj_pl=new postLogin(driver);
	loginPage obj_login = new loginPage(driver);
	test= report.startTest("Validate prices of products in cart");
	driver.get(prp.getProperty("baseURL"));
	driver.manage().deleteAllCookies();
	String sLab_Username= prp.getProperty("username");
	String sLab_pw= prp.getProperty("Password");
	obj_login.get_loginName().sendKeys(sLab_Username);
	obj_login.get_password().sendKeys(sLab_pw);
	obj_login.get_hitLogin().click();
	WebElement sortElement=obj_pl.getSortContainer();
	Select sortDropdown=new Select(sortElement);
	sortDropdown.selectByValue("lohi");
	List<WebElement> priceOfProduct=obj_pl.getItemsPrices();
	int length=priceOfProduct.size();
	System.out.println(length);
	Float[] prices = new Float[length];
	for(int i=0;i<length;i++) {
		Float value= Float.parseFloat((priceOfProduct.get(i).getText()).substring(1));
		prices[i]= value;
		
	}
	//Verify Items are sorted 
	
	Float[] copyofPrices = Arrays.copyOfRange(prices, 0, length);   
	
	Arrays.sort(copyofPrices, 0, length);

	try {
		Assert.assertTrue(Arrays.equals(copyofPrices, prices));	
		test.log(LogStatus.PASS, " Items on webpage are Sorted");
	}
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Items on webpage are not Sorted");
		
	}
		
	
	
	
	//Verify Quantity of items in Cart	
	
	obj_pl.getProductsList().get(0).click();
	obj_pl.getProductsList().get(0).click();
	
	
	System.out.println(Arrays.toString(prices));
	
	
	Float sum= prices[0] + prices[1];
	System.out.println(sum);
	obj_pl.getCart().click();
	String quantity_1=obj_pl.getcartQuantity().get(0).getText();
	try {
	Assert.assertEquals(quantity_1, "1");
	test.log(LogStatus.PASS, "Quantity of product 1 is verified");
	}
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Quantity is not as expexted");
	}
	String quantity_2=obj_pl.getcartQuantity().get(1).getText();
	try {
		Assert.assertEquals(quantity_2, "1");
		test.log(LogStatus.PASS, "Quantity of product 2 is verified");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Quantity is not as expexted");
		}
	
	//Verify Total in cart 
	List<WebElement> cartPrice=obj_pl.getItemsPrices();
	int lengthCart=cartPrice.size();
	System.out.println(lengthCart);
	for(int i=0;i<lengthCart;i++) {
		Float value1= Float.parseFloat((cartPrice.get(i).getText()).substring(1));
		prices[i]= value1;
		
	}
	Float sumCart=prices[0] + prices[1];
	System.out.println(sumCart);
	try {
	Assert.assertEquals(sumCart, sum);
	test.log(LogStatus.PASS, "Sum is verified");
	}
	catch(Exception e){
		test.log(LogStatus.FAIL, "Sum is not equal");
	}
	
	
	}
	
	


	

}



