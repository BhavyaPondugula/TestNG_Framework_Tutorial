package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass{
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']") WebElement My_account_btn;
	@FindBy(linkText="Register") WebElement Register_btn;
	@FindBy(linkText="Login") WebElement Login_btn;
	
	public void my_acc_btn() {
		My_account_btn.click();
	}
	
	public void Register_Btn() {
		Register_btn.click();
	}
	
	public void Login_Btn() {
		Login_btn.click();
	}
	

}
