package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignment_Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text - simple alert: " + alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		System.out.println("Alert text - confirm box: " + alert.getText());
		alert.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		System.out.println("Alert text - prompt box: " + alert.getText());
		alert.sendKeys("Sriraman");
		alert.accept();
	}

}
