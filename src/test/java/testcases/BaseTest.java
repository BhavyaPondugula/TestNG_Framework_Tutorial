package testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    public static WebDriver driver;
    public Properties p;

    @BeforeClass
    //@Parameters({"browser"})
    public void launch_Application() throws IOException {
    	FileReader file=new FileReader("./src//test//resources//config.properties");
        p=new Properties();
        p.load(file);
        if(p.getProperty("exe_env").equals("remote")) {
        	DesiredCapabilities cap=new DesiredCapabilities();
        	cap.setPlatform(Platform.WIN11);
        	cap.setBrowserName("chrome");
        	String hubURL="http://localhost:4444/wd/hub";
        	driver = new RemoteWebDriver(new URL(hubURL), cap);
        	
        	
        }
        else {
        	  if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
                  ChromeOptions options = new ChromeOptions();

                  Map<String, Object> prefs = new HashMap<>();
                  prefs.put("credentials_enable_service", false);
                  prefs.put("profile.password_manager_enabled", false);
                  options.setExperimentalOption("prefs", prefs);

                  driver = new ChromeDriver(options);
              }
              else if (p.getProperty("browser").equalsIgnoreCase("firefox")) {
                  FirefoxOptions options = new FirefoxOptions();
                  options.addPreference("signon.rememberSignons", false);
                  options.addPreference("credentials_enable_service", false);

                  driver = new FirefoxDriver(options);
              }
              else if (p.getProperty("browser").equalsIgnoreCase("edge")) {
                  EdgeOptions options = new EdgeOptions();

                  Map<String, Object> prefs = new HashMap<>();
                  prefs.put("credentials_enable_service", false);
                  prefs.put("profile.password_manager_enabled", false);
                  options.setExperimentalOption("prefs", prefs);

                  driver = new EdgeDriver(options);
              }
              else {
                  throw new IllegalArgumentException("Unsupported browser: " + p.getProperty("browser"));
              }

        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void close_Application() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public String takeScreenShot(String file_name) throws IOException {
    	String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	TakesScreenshot t=(TakesScreenshot)driver;
    	File src=t.getScreenshotAs(OutputType.FILE);
    	String img_path=System.getProperty("user.dir")+"\\screenshots\\"+file_name+"-"+time+".png";
    	File des=new File(img_path);
    	FileUtils.copyFile(src, des);
    	return img_path;
    	
    	
    }
}
