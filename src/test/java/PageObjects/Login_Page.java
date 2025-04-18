package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends BaseClass {
	public Login_Page(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement email_id;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@value=\"Login\"]") WebElement login_btn;
	@FindBy(xpath="//h2[text()=\"My Account\"]") WebElement acc_txt;
	
	public void enter_email(String s) {
		email_id.sendKeys(s);
	}
	
	public void enter_pwd(String e_pwd) {
		password.sendKeys(e_pwd);
		
	}
	
	public void Login_Btn() {
		login_btn.click();
	}
	
	public boolean acc_validation() {
		try {
			return acc_txt.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}

}
