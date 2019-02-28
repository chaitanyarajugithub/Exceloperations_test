package PageClass_Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Users {
	WebDriver driver;
	public Users(WebDriver driver)
	{
	this.driver=driver;
	}
	@FindBy(xpath="//input[@name='admin_user[email]']")
	WebElement EnterAdminEmail;
	@FindBy(xpath="//input[@id='admin_user_password']")
	WebElement EnterAdminPassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement AdminLogin;
	@FindBy(xpath="//a[@href='/admin/users']")
	WebElement Users;
	@FindBy(xpath="//input[@id='q_email']")
	WebElement Emailsearch;
	@FindBy(xpath="//input[@id='q_personal_email']")
	WebElement Personalemailsearch;
	@FindBy(xpath="//input[@value='Filter']")
	WebElement Filter;
	@FindBy(xpath="//a[@class='clear_filters_btn']")
	WebElement ClearFilter;
	@FindBy(xpath="//span[@class='blank_slate']")
	WebElement Nousersfound;
	@FindBy(xpath="//div[@class='pagination_information']")
	WebElement Displayusers;
	@FindBy(xpath="//a[@title='Edit']")
	WebElement Edit;
	@FindBy(xpath="//input[@name='user[password]']")
	WebElement password;
	@FindBy(xpath="//input[@id='user_password_confirmation']")
	WebElement confirmpassword;
	@FindBy(xpath="//input[@value='Update User']")
	WebElement Updateuser;
	
	public void finduser(String email,String password) {
		
			
		
	}
	public void updateuser(String email) throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Emailsearch);
		Thread.sleep(5000); 
		this.Emailsearch.clear();
		this.Emailsearch.sendKeys(email);
		this.Filter.click();
		
		
		
	}
}

