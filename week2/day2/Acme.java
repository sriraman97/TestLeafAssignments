package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Acme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//div[@class='control-group form-group']/preceding-sibling::div)[1]//input")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("(//div[@class='form-group control-group']/following-sibling::div)[1]//input")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Log Out")).click();
		
		driver.close();
	}

}
