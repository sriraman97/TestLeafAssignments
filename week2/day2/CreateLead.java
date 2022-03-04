package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); //setup the driver
		ChromeDriver driver = new ChromeDriver(); //opening chrome browser
		
		CreateLead c1 = new CreateLead();
		c1.createLead(driver);
		
		System.out.println("Page Title: " + driver.getTitle());
	}
	
	public void createLead(ChromeDriver driver) { //using X path
		
		driver.get("http://leaftaps.com/opentaps/control/main"); //load the url
		driver.manage().window().maximize(); //make browser window as full screen
		
		WebElement elementUserName = driver.findElement(By.xpath("//input[@id='username']"));//By.id("username")
		elementUserName.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));//By.id("password")
		elementPassword.sendKeys("crmsfa");
		
		WebElement elementLoginButton = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));//By.className("decorativeSubmit")
		elementLoginButton.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click(); //By.linkText("CRM/SFA")
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Sriraman");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("N");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Sriraman");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Retail");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Happy learning at Test Leaf !!");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("nsriraman97@gmail.com");
		
		Select stateProvinceDD = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		stateProvinceDD.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
	}

}
