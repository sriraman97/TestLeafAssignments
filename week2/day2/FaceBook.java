package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		List<WebElement> listOfInputBox = driver.findElements(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
		
		listOfInputBox.get(0).sendKeys("Abcdef");
		listOfInputBox.get(1).sendKeys("G");
		listOfInputBox.get(2).sendKeys("9876543210");
		listOfInputBox.get(4).sendKeys("Password");
		
		WebElement elementDropDownDay = driver.findElement(By.id("day"));
		
		List<WebElement> listOfDropDown = driver.findElements(By.xpath("//span[@class='_5k_4']//select"));
		Select ddDay = new Select(listOfDropDown.get(0));
		Select ddMonth = new Select(listOfDropDown.get(1));
		Select ddYear = new Select(listOfDropDown.get(2));
		ddDay.selectByIndex(28);
		ddMonth.selectByValue("12");
		ddYear.selectByVisibleText("1997");
		
		driver.findElement(By.xpath("(//span[@class='_5k_3']//input)[1]")).click();

	}

}
