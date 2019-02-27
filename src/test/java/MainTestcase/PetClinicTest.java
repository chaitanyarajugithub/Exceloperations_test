package MainTestcase;

import java.io.FileInputStream;
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
import PageClass.Ownersandpets;

public class PetClinicTest {
  WebDriver driver;
  ExtentReports report;
  ExtentTest logger;
  Properties p;
  FileInputStream fi;
   
  @BeforeTest
  public void setUp() throws Exception {
	//phantom JS windows
	//System.setProperty("phantomjs.binary.path","phantomjs.exe");
	//phantom JS Linux
	System.setProperty("phantomjs.binary.path","/usr/bin/phantomjs");
    driver = new PhantomJSDriver();
	  
	//driver = new ChromeDriver();
    //Thread.sleep(5000); 
    report = new ExtentReports("./Reports/PomReport.html");
    p =new Properties();
	fi =new FileInputStream("./src/main/java/Resource/Data.properties");
	p.load(fi);
	driver.get(p.getProperty("objurl1"));
	driver.manage().window().maximize();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(description="AddOwnerandpet",enabled = true)
  public void Test1() {
	  Ownersandpets pet=PageFactory.initElements(driver, Ownersandpets.class);
	  logger=report.startTest("AddownerandPet");
	  pet.Addnewowner("CHAITA","RAJU","2-30/1","HYD","8885563555");
	  WebElement text = driver.findElement(By.xpath("/html/body/div/div/h2[2]"));
	 
	  if(text.getText().equals("Pets and Visits")) {
		Reporter.log("Owner Added success",true);
		logger.log(LogStatus.PASS, "Owner Added");
		pet.Addnewpet("Raju", "2018/11/11", 1);
	  }
	  else {
		Reporter.log("Owner Added Fail",true);
		logger.log(LogStatus.FAIL, "Owner Not Added");  
	  }
	   
  }
  
  @Test(description="Findowner",enabled = true)
  public void Test2() throws InterruptedException {
	  Ownersandpets pet=PageFactory.initElements(driver, Ownersandpets.class);
	  logger = report.startTest("Findowner");
	  pet.Findowner("Chaitanyatest", "rajutest");
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  WebElement Sucess=driver.findElement(By.xpath("/html/body/div/div/h2[1]"));
	  WebElement notfound=driver.findElement(By.xpath("/html/body/div/div/h2"));
	  if(Sucess.getText().contains("Information")) {
		  Reporter.log("User information found",true);
		  logger.log(LogStatus.PASS, "Owner found");
	  }
	  else if (notfound.getText().contains("Find")) {
		  Reporter.log("User information not found",true);
		  logger.log(LogStatus.PASS, "Owner not found");
	}
	  
  }

  @AfterTest
  public void tearDown() throws Exception {
	report.flush();
	report.endTest(logger);  
    driver.quit();
   }
}
