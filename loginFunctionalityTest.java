package FabHeads.Assignment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FabHeads.Assignment.ExtentReportManager;
import FabHeads.Assignment.ScreenShotFunctionality;
import FabHeads.Assignment.WebDriverFactory;

//implementation of login using google
public class loginFunctionalityTest {
	String userDIR = System.getProperty("user.dir");
	String mainPageHandle;
	JavascriptExecutor js;
	  //Initializing the driver
	    WebDriver driver;
	    Properties prop = new Properties();
	    ExtentReports report = ExtentReportManager.getReportInstance();
	    
	   @Parameters({"browser","Path0"})
	    @BeforeTest
	    public void setup(String browser, String Path0) throws Exception{
 
	    driver = WebDriverFactory.setDriver(browser);
         
	   driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   
	   
	   try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path0 );} //Take Screenshot
		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}

	    }
	    
	 
	   //test method to open the browser
	    @Parameters({"URL","Path1"})
	    @Test(priority = 0)
	    public void openBrowser(String URL, String Path1) throws Exception{
	    	
	    	//addition of extent report
	    	ExtentTest logger = report.createTest("openBrowser");
	    	
	    	//opening the page 
	    	logger.log(Status.INFO, "Initializing the Browser ");
	    	
	    	driver.get(URL);
	    	//getting the page title
	    	String title = driver.getTitle(); 
	    	
	    	String expectedTitle =  "Fabheads Slic4R";
	    	
	    	//Checking if the right page opened
	    	Assert.assertEquals(title, expectedTitle); //Checking expected and actual result
	    	//Waiting 
	    	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    	 driver.findElement(By.xpath("//*[@id=\"email-input\"]/input")).sendKeys("email");
		    driver.findElement(By.xpath("//*[@id=\"password-input\"]/input")).sendKeys("password");
		    Thread.sleep(2000);
	    	 
	    	 //screenshot taken
	    	 try{ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path1 );} //Take Screenshot
	 		catch(ScreenshotException e) {System.out.println("Unable to take Screen Shot");}
	    }
	    
	    @AfterTest
		// function to close the driver
		public void closeDriver() {
	    	report.flush();
			driver.quit();
		}
	 
}
