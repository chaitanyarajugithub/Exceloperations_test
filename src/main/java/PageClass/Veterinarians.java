package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Veterinarians {
WebDriver driver;
Actions ac;
public Veterinarians(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath="//*[text()='Welcome Admin']")
WebElement Click_Welcome;
@FindBy(xpath="//*[text()='Logout']")
WebElement Click_Logout;
public void Verify_Logout() throws InterruptedException {
	ac=new Actions(driver);
	ac.moveToElement(Click_Welcome).click().perform();
	Thread.sleep(4000);
	ac.moveToElement(Click_Logout).click().perform();
	Thread.sleep(4000);
}
}
