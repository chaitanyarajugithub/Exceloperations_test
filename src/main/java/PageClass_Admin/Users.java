package PageClass_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Users {
	WebDriver driver;
	public Users(WebDriver driver)
	{
	this.driver=driver;
	}
	@FindBy(xpath="//a[@href='/admin/users']")
	WebElement Users;
	@FindBy(xpath="//input[@id='admin_user_password']")
	WebElement EnterAdminPassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement AdminLogin;

}
