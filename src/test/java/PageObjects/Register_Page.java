package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page extends BaseClass {
	
	public Register_Page(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement First_Name;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement Last_Name;
	@FindBy(xpath="//input[@name='email']") WebElement Email;
	@FindBy(xpath="//input[@name='telephone']") WebElement Mobile_No;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='confirm']") WebElement C_password;
	@FindBy(xpath="//input[@type='checkbox']") WebElement check_box;
	@FindBy(xpath="//input[@value='Continue']") WebElement submit_btn;
	@FindBy(xpath="//h1[text()=\"Your Account Has Been Created!\"]") WebElement txt;
	@FindBy(xpath="//a[text()='Logout']") WebElement Logout_btn;
	
	public void first_name(String f_name) {
		First_Name.sendKeys(f_name);
	}
	
	public void last_name(String l_name) {
		Last_Name.sendKeys(l_name);
	}
	
	public void email(String email_id) {
		Email.sendKeys(email_id);
	}
	
	public void mobilenum(String num) {
		Mobile_No.sendKeys(num);
	}
	
	public void Password(String pwd) {
		password.sendKeys(pwd);
		
	}
	
	public void c_password(String C_pwd) {
		C_password.sendKeys(C_pwd);
		
	}
	
	public void checkbox() {
		check_box.click();
	}
	
	public void submit() {
		submit_btn.click();
	}
	
	public String get_txt() {
		try {
			String s=txt.getText();
			return s;
		}
		catch(Exception e) {
			return e.getMessage();
			
		}
	}
	
	public void logout_btn() {
		Logout_btn.click();
	}
	

}
