package PageClass_Admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin_Login {
	WebDriver driver;
	public Admin_Login(WebDriver driver)
	{
	this.driver=driver;
	}
	@FindBy(xpath="//input[@name='admin_user[email]']")
	WebElement EnterAdminEmail;
	@FindBy(xpath="//input[@id='admin_user_password']")
	WebElement EnterAdminPassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement AdminLogin;
	
	public void Loginuser(String email,String password) {
		
		this.EnterAdminEmail.clear();
		this.EnterAdminEmail.sendKeys(email);
		this.EnterAdminPassword.clear();
		this.EnterAdminPassword.sendKeys(password);
		this.AdminLogin.click();	
		
	}
}
