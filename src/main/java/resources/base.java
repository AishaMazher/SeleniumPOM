package resources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class base {
	public WebDriver driver;
	String browserName="";
	public ExtentReports report;
	public ExtentTest test;
	public Properties prp = new Properties();
	
	public WebDriver inilitilizeDriver() throws IOException, SQLException {

		
		FileInputStream fis= new FileInputStream("\\Goals\\API Testing\\API Testing Automation (Rest Assured)\\Scripts\\Framework-Q2\\data.properties");
		prp.load(fis);
		browserName=prp.getProperty("browser");
		//System.out.println(browserName);
	
		
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\VentureDive\\Softwares\\ChromeD\\ChromeDriver.exe");
			 driver = new ChromeDriver();
			 
			
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\VentureDive\\Softwares\\geckoD\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", "C:\\VentureDive\\Softwares\\IED\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}
	
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//Rows for how many time test needs to be executed 
		//columns for how many values are passing per test 
		Object[][] data= new Object[2][2];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		
		
		data[1][0]="standard_user";
		data[1][1]= "secret_sauce12";
		return data;
				}
	
	@BeforeSuite
	public void initializeReport() {
		report=new ExtentReports(System.getProperty("user.dir") +"/ExtentReports.html" );
	}
	
	@AfterSuite
	public void generateReport() {
		report.endTest(test);
		report.flush();
	}
	
	@BeforeMethod
	public void initialize() throws IOException, SQLException {
		driver=inilitilizeDriver();
		driver.manage().window().maximize();
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
		
	}
	

		
	
	
}
