package PageClass_User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
WebDriver driver;
public Home(WebDriver driver)
{
this.driver=driver;
}
@FindBy(linkText="home page")
WebElement Click_Home;
@FindBy(xpath="//*[@id=\"main-navbar\"]/ul/li[2]/a")
WebElement Click_ownersandpets;
@FindBy(linkText="veterinarians")
WebElement Click_veterinarians;

public void Clickhome() {
	this.Click_Home.click();
	}
public void Clickownersandpets() {
	this.Click_ownersandpets.click();
	}
public void Clickveterinarians() {
	this.Click_veterinarians.click();
	}
}
