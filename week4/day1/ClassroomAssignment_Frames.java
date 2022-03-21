package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomAssignment_Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriver frame = driver.switchTo().frame("iframeResult"); //switch from main page to frame using string(id)
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert promptAlert = driver.switchTo().alert(); //switch to alert
		String myName = "Sriraman";
		promptAlert.sendKeys(myName);
		promptAlert.accept();
		
		System.out.println(driver.findElement(By.id("demo")).getText().contains(myName) ? "success" : "Failure");
		
		driver.switchTo().defaultContent(); //switching back from frame to main page
		
		
	}

}
