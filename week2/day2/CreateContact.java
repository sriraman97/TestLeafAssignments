package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Sriraman");
		driver.findElement(By.id("lastNameField")).sendKeys("N");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Sriram");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("N");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Retail");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Happy learning at testleaf!!");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("nsriraman97@gmail.com");
		WebElement elementStateProvinceDD = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select stateProvinceDD = new Select(elementStateProvinceDD);
		stateProvinceDD.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("testing is fun..");
		
		driver.findElement(By.xpath("//td[@colspan='4']/input")).click();
		
		System.out.println(driver.getTitle());
	}

}
