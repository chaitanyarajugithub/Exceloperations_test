/*
 * @autor : Chaitanya 
 * 
 * * 
 */
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

	public void Clickonusers() {
		this.Users.click();	
	}	
	public void Movetoelement(WebElement element) {
		//This will scroll until the element is in view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void finduser(String email) throws InterruptedException {
		Movetoelement(Emailsearch);
		this.Emailsearch.clear();
		this.Emailsearch.sendKeys(email);
		this.Filter.click();		
	}
	public void updateuserpassword(String password) {
		this.Edit.click();
		this.password.click();
		this.password.sendKeys(password);
		this.confirmpassword.click();
		this.confirmpassword.sendKeys(password);
		Movetoelement(Updateuser);
		this.Updateuser.click();
		
	}
}