package Assignment.Framework_Q2;

import org.openqa.selenium.WebDriver;

import pageObject.loginPage;
import pageObject.postLogin;
import resources.base;

public class reusableMethods extends base {
	public WebDriver driver;
	public reusableMethods(WebDriver driver) {
		this.driver=driver;
	}
	public void login() {
		driver.get(prp.getProperty("baseURL"));
		driver.manage().window().maximize();
		postLogin obj_pl=new postLogin(driver);
		loginPage obj_login = new loginPage(driver);
		String sLab_Username= prp.getProperty("username");
		String sLab_pw= prp.getProperty("Password");
		obj_login.get_loginName().sendKeys(sLab_Username);
		obj_login.get_password().sendKeys(sLab_pw);
		obj_login.get_hitLogin().click();
	}

}
