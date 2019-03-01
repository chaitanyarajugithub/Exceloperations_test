/*
 * @autor : Chaitanya 
 * 
 * * 
 */
package MainTestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClass_Admin.Admin_Login;
import PageClass_Admin.Users;
import PageClass_User.Ownersandpets;
import PageClass_User.User_Login;
import Resource.ExcelUtilMethods;

public class PetClinicTest {
  private static final boolean flase = false;
WebDriver driver;
  ExtentReports report;
  ExtentTest logger;
  Properties p;
  FileInputStream fi;
  String inputpath = "./Data/Input/Sapling Server Credentials.xlsx";
  
   
  @BeforeTest(enabled = flase)
  public void setUp() throws Exception {
	//phantom JS windows
	//System.setProperty("phantomjs.binary.path","phantomjs.exe");
	//phantom JS Linux
/*	System.setProperty("phantomjs.binary.path","/usr/bin/phantomjs");
    driver = new PhantomJSDriver();*/
	  
	driver = new ChromeDriver();
    Thread.sleep(5000); 
    report = new ExtentReports("./Reports/PomReport.html");
    p =new Properties();
	fi =new FileInputStream("./src/main/java/Resource/Data.properties");
	p.load(fi);
	driver.get(p.getProperty("objurl"));
	driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(description="AddOwnerandpet",enabled = flase)
  public void Test1() throws InterruptedException {
	  Admin_Login pet=PageFactory.initElements(driver, Admin_Login.class);
	  logger=report.startTest("AddownerandPet");
	 pet.Loginadmin("admin@example.com" , "password");
	 Users u=PageFactory.initElements(driver, Users.class);
	 u.Clickonusers();
	 Thread.sleep(5000);
	 u.finduser("chaita");
	 
	 
  }
  @Test(description="ExcelRead",enabled = flase)
  public void Test3() throws InterruptedException, IOException {
	  ExcelUtilMethods excel= new ExcelUtilMethods(inputpath);
	
	  for (int i=0; i<5; i++) {
		  String Url=excel.getCellData(i, 8, 2);
		  String UrlAdmin=excel.getCellData(i, 9, 2);
		  Reporter.log("URL is = "+ Url,true);
		 // System.out.println(Url);
		  
		    for (int j=13; j<18; j++) {
			  String Email=excel.getCellData(i, j, 2);
			  String Password=excel.getCellData(i, j, 3);
			  Reporter.log("Email and password is = "+ Email +"  "+ Password,true);
			  driver = new ChromeDriver();
			  driver.get(Url);
			  Thread.sleep(6000);
			 // userlogin.Loginuser(Email, Password);
			  Thread.sleep(2000);
			  driver.close();
	  }
	  }
  }
  
  @Test(description="Findowner",enabled = true)
  public void Test2() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://rock.shr-eng.com/");
	  Thread.sleep(6000);
	  User_Login userlogin=PageFactory.initElements(driver, User_Login.class);
	  userlogin.Loginuser("hamza@rock.com", "admin123!");
	  Thread.sleep(2000);
	  driver.close();
	  
	}

 /* @AfterTest
  public void tearDown() throws Exception {
	report.flush();
	report.endTest(logger);  
    //driver.quit();
   }*/
}
