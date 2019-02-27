package PageClass_User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class Ownersandpets {
	WebDriver driver;
	Actions action;
	public Ownersandpets(WebDriver driver){
		this.driver = driver;
	}
//store Repository
	@FindBy(id="firstName")
	WebElement Enter_FirstName;
	@FindBy(name="lastName")
	WebElement Enter_Lastname;
	//find owner
	@FindBy(xpath="//*[@id=\"search-owner-form\"]/button")
	WebElement Click_Clickfindowner;
	@FindBy(xpath="//*[@id=\"owner.errors\"]")
	WebElement Findownererror;
	//add owner
	@FindBy(xpath="//*[@id=\"search-owner-form\"]/a")
	WebElement Click_Addnewowner;
	@FindBy(id="address")
	WebElement Enter_address;
	@FindBy(id="city")
	WebElement Enter_City;
	@FindBy(id="telephone")
	WebElement Enter_Mobile;
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[2]/div/button")
	WebElement Click_Addowner;
	@FindBy(xpath="/html/body/div/div/a[1]")
	WebElement ClickEditowner;
	//Addnewpet
	@FindBy(xpath="/html/body/div/div/a[2]")
	WebElement ClickAddnewpet;
	@FindBy(id="name")
	WebElement EnterName;
	@FindBy(id="birthDate")
	WebElement Enterdateofbirth;
	@FindBy(id="type")
	WebElement Selecttype;
	@FindBy(xpath="//*[@id=\"pet\"]/div[2]/div/button")
	WebElement Addpet;
	//updateowner
	@FindBy(xpath="//*[@id=\"add-owner-form\"]/div[2]/div/button")
	WebElement Updateownwer;
	//NewVisit
	@FindBy(id="date")
	WebElement Date;
	@FindBy(id="description")
	WebElement Description;
	@FindBy(xpath="//*[@id=\"visit\"]/div[2]/div/button")
	WebElement AddVisit;
	//updatepet
	@FindBy(xpath="//*[@id=\"pet\"]/div[2]/div/button")
	WebElement Updatepet;
	
	
	//Home home=new Home(driver);
	Select type;
	
public void Addnewowner(String firstname,String lastname,String address,String City,String mobile) {
	Home home = PageFactory.initElements(driver, Home.class);
	home.Clickownersandpets();
	this.Click_Addnewowner.click();
	this.Enter_FirstName.clear();
	this.Enter_FirstName.sendKeys(firstname);
	this.Enter_Lastname.clear();
	this.Enter_Lastname.sendKeys(lastname);
	this.Enter_address.clear();
	this.Enter_address.sendKeys(address);
	this.Enter_City.clear();
	this.Enter_City.sendKeys(City);
	this.Enter_Mobile.clear();
	this.Enter_Mobile.sendKeys(mobile);;
	this.Click_Addowner.click();
	}	
	
public void Findowner(String firstname,String lastname) throws InterruptedException {
	Home home = PageFactory.initElements(driver, Home.class);
	home.Clickownersandpets();
	Thread.sleep(3000);
	action = new Actions(driver);
    action.moveToElement(this.Enter_FirstName);
    action.click();
    action.sendKeys(firstname);
    action.perform();
    //while executin below code i am getting error
/*	this.Enter_FirstName.click();
	this.Enter_FirstName.sendKeys(firstname);
	this.Enter_Lastname.click();
	this.Enter_Lastname.sendKeys(lastname);*/
    Thread.sleep(2000);
    action.moveToElement(this.Enter_Lastname);
    action.click();
    action.sendKeys(lastname);
    action.perform();
	this.Click_Clickfindowner.click();
	
}

public void Addnewpet(String name,String date,int Pettype ) {
	this.ClickAddnewpet.click();
	this.EnterName.clear();
	this.EnterName.sendKeys(name);
	this.Enterdateofbirth.clear();
	this.Enterdateofbirth.sendKeys(date);
	this.Enterdateofbirth.sendKeys(Keys.ESCAPE);
	type =new Select(Selecttype);
	this.type.selectByIndex(Pettype);
	this.Addpet.click();
	
}


}














