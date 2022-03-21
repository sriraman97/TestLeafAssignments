package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5_AlertsAndWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		
		Set<String> setOfWindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(setOfWindows);
		driver.switchTo().window(listOfWindows.get(1));
		driver.findElement(By.linkText("Contact Us")).click();
		System.out.println("Customer care mail id: " + driver.findElement(By.xpath("(//div[@class='dropdown-menu show']/a)[3]")).getText());
		
		driver.switchTo().window(listOfWindows.get(0)).close();
	}

}
