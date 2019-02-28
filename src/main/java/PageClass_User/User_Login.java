/*
 * @autor : Chaitanya 
 * 
 * * 
 */
package PageClass_User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Login {
	WebDriver driver;
	public User_Login(WebDriver driver)
	{
	this.driver=driver;
	}
	@FindBy(xpath="//div[@class='sign-in-with-email ng-scope']")
	WebElement Signinwithemail;
	@FindBy(xpath="//input[@id='input_0']")
	WebElement EnterEmail;
	@FindBy(xpath="//input[@id='input_1']")
	WebElement EnterPassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Signin;
	@FindBy(xpath="//a[@class='h6 forgot-password md-accent-color ng-binding md-default-theme']")
	WebElement forgotpassword;
	
	public void Loginuser(String email,String password) {
		
	if (Signinwithemail.isDisplayed()) {
		Signinwithemail.click();
		this.EnterEmail.clear();
		this.EnterEmail.sendKeys(email);
		this.EnterPassword.clear();
		this.EnterPassword.sendKeys(password);
		this.Signin.click();	
		}
	else {
		this.EnterEmail.clear();
		this.EnterEmail.sendKeys(email);
		this.EnterPassword.clear();
		this.EnterPassword.sendKeys(password);
		this.Signin.click();		
		}
	}
	public void Mehod2() {
		
		}
	}