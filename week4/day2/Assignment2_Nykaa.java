package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_Nykaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions builder = new Actions(driver);		
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		if(driver.getTitle().contains("L'Oreal Paris")) {
			driver.findElement(By.id("first-filter")).click(); //click on category dd
			driver.findElement(By.xpath("//span[text()='Hair']")).click(); //click on hair dd
			driver.findElement(By.xpath("//span[text()='Hair Care']")).click(); //click on haircare dd
			driver.findElement(By.xpath("//span[text()='Shampoo']")).click(); //click on shampoo check box
			driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj'])[6]")).click(); //click on concern
			driver.findElement(By.xpath("//span[text()='Color Protection']")).click(); //click on color protection
			List<WebElement> listOfShampoo = driver.findElements(By.xpath("//div[@class='css-xrzmfa']")); //get the result after applying filter
			boolean isShampoo = true;
			for (WebElement shampoo : listOfShampoo) {
				if(! shampoo.getText().contains("Shampoo")) {
					isShampoo = false;
					break;
				}
			}
			if(isShampoo) {
				System.out.println("Validated filter results successfully!!");
				listOfShampoo.get(0).click(); //click on the 1st product
				Set<String> setOfWindowHandles = driver.getWindowHandles();
				List<String> listOfWindowHandles = new ArrayList<String>(setOfWindowHandles);
				driver.switchTo().window(listOfWindowHandles.get(1)); //switch to selected product window
				WebElement elementQuantityDD = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
				Select quantity = new Select(elementQuantityDD);
				quantity.selectByVisibleText("175ml"); //select quantity from dd
				System.out.println("MRP: " + driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText());
				driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[2]")).click(); //click on ADD TO BAG button
				driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click(); //click on bag icon
				
				driver.switchTo().frame(0);
				String grandTotal = driver.findElement(By.xpath("(//div[@class='table-row ']/div)[2]")).getText().replaceAll("[^0-9]", "");
				System.out.println("Grand total: " + grandTotal); //grand total //div[@class='value medium-strong']
				
				driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click(); //click on proceed button
				driver.findElement(By.xpath("//button[@class='btn full big']")).click(); //continue as guest
				String grandTotalFinal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText().replaceAll("[^0-9]", "");
				System.out.println("Grand Total validation: " +  grandTotalFinal.equals(grandTotal));
				driver.quit(); //close all windows 

			}
			else
				System.out.println("error when applying filter");
			
		}
		else
			System.out.println("Failure");
	}

}
