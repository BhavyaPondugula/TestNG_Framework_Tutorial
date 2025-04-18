package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Register_Page;
@Listeners(utilities.ExtentReportUtility.class)
public class TC003_DataDriven extends BaseTest{
	@Test(dataProvider="dataprovider",dataProviderClass = utilities.Dataproviders.class)
	public void acc_registration(String F_Name,String L_Name,String Email_Id,String phn_no,String O_Pwd,String C_Pwd) {
		HomePage home=new HomePage(driver);
		home.my_acc_btn();
		home.Register_Btn();
		Register_Page register=new Register_Page(driver);
		register.first_name(F_Name);
		register.last_name(L_Name);
		register.email(Email_Id);
		register.mobilenum(phn_no);
		register.Password(O_Pwd);
		register.c_password(C_Pwd);
		register.checkbox();
		register.submit();
		String text=register.get_txt();
		Assert.assertEquals(text, "Your Account Has Been Created!");
		home.my_acc_btn();
		register.logout_btn();
			
		
		
		
	}

}
