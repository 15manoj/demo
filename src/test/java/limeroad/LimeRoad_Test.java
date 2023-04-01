package limeroad;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base_limeroad.BaseTest;


      
       public class LimeRoad_Test extends BaseTest{
    	   
       @Test
	   public  void Lime_script() throws InterruptedException, IOException {
		
		
		//selecting mens shop
		driver.findElement(By.xpath(loc1.getProperty("Shop_Men"))).click();
		
		//click the search box
		driver.findElement(By.xpath(loc1.getProperty("Search"))).click();
		
		//enter the product in the search box 
		driver.findElement(By.xpath(loc1.getProperty("Enter"))).sendKeys("hoodies for men");
		
		//click the search icon
		driver.findElement(By.xpath(loc1.getProperty("Search_Icon"))).click();
		//colour
		driver.findElement(By.xpath(loc1.getProperty("Colour_Component"))).click();
		driver.findElement(By.xpath(loc1.getProperty("Blue"))).click();
		driver.findElement(By.xpath(loc1.getProperty("Colour_Component"))).click();
		//brand
		driver.findElement(By.xpath(loc1.getProperty("Brand"))).click();
		driver.findElement(By.xpath(loc1.getProperty("brand_Name"))).click();
		
		//select product
		driver.findElement(By.id(loc1.getProperty("Product"))).click();
		
		//select th size		
		driver.findElement(By.id(loc1.getProperty("Size"))).click();
		
		//addcart
		driver.findElement(By.xpath(loc1.getProperty("Add-Cart"))).click();
		
		//quantity
		WebElement quantity=driver.findElement(By.xpath(loc1.getProperty("Quantity")));
		
		Select sc = new Select(quantity);
		sc.selectByVisibleText("2");
		
		WebElement dress_img =driver.findElement(By.id("views"));
		
		File m1=((TakesScreenshot)dress_img).getScreenshotAs(OutputType.FILE);
		File m2= new File("C:\\Users\\User\\eclipse-workspace\\maven2\\snap1/img.png");
		FileHandler.copy(m1, m2);
		
	}

	

}
