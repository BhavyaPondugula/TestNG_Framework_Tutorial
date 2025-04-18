package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Register_Page;



public class TC001_AccountRegistration extends BaseTest{
	
	@Test()
	public void acc_registration() {
		HomePage home=new HomePage(driver);
		home.my_acc_btn();
		home.Register_Btn();
		Register_Page register=new Register_Page(driver);
		register.first_name("MalleswariMum");
		register.last_name("Pondugula");
		register.email("malleswarimummy@gmail.com");
		register.mobilenum("6281610189");
		register.Password("malli@345");
		register.c_password("malli@345");
		register.checkbox();
		register.submit();
		String text=register.get_txt();
		Assert.assertEquals(text, "Your Account Has Been Created!");
		home.my_acc_btn();
		register.logout_btn();
			
		
		
		
	}
	

}
