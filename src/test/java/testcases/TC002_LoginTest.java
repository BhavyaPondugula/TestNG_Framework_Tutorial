package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Login_Page;

public class TC002_LoginTest extends BaseTest {
	
	@Test
	public void login_application() {
		HomePage page=new HomePage(driver);
		page.my_acc_btn();
		page.Login_Btn();
		Login_Page login_page=new Login_Page(driver);
		login_page.enter_email("PondugulaBhavyaLakshmi13190@gmail.com");
		login_page.enter_pwd("Bhavya@44721");
		login_page.Login_Btn();
		Assert.assertTrue(login_page.acc_validation());
	}

}
