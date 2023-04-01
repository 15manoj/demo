package base_limeroad;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

	public static WebDriver driver;

	public static FileReader fr1;
	public static Properties config1 = new Properties();
	
	public static FileReader fr2;
	public static Properties loc1 = new Properties();

	@BeforeMethod
	public static void setup() throws IOException {

		 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config1.load(fr1);
		
		 fr2 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\locators.properties");
		loc1.load(fr2);
		

		if (config1.getProperty("browser").equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			
			System.out.println("Chromebrowser launched Successfully");
			
			driver.get(config1.getProperty("url"));

		} else if (config1.getProperty("browser1").equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
			driver.get(config1.getProperty("url"));

		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
	}
	
	    @AfterMethod
	public static void teardown() {
		
		driver.quit();
		
		System.out.println("Teardown successfully");
	}

}
