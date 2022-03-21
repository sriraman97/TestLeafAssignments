package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6_Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER); //search oneplus 9 pro
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();//  (//span[@class='a-price']/span)[1]
		System.out.println("Price: " + price); //get the price of 1st product
		System.out.println("Number of ratings: " + driver.findElement(By.xpath("((//div[@class='a-row a-size-small'])[1]/span)[2]/a")).getText()); //no of ratings
		
		driver.findElement(By.xpath("((//div[@class='a-row a-size-small'])[1]/span)[1]")).click(); //click on the ratings
		WebElement ratingsTable = driver.findElement(By.id("histogramTable"));
		List<WebElement> listOfColumns = ratingsTable.findElements(By.tagName("td"));
		List<WebElement> listOfSpan = listOfColumns.get(2).findElements(By.tagName("span"));
		System.out.println("Percentage rating for 5 star: " + listOfSpan.get(1).findElement(By.tagName("a")).getText());
		
		driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]/a")).click(); //click on 1st text link
		Set<String> setOfWindowHandles = driver.getWindowHandles();
		List<String> listOfWindowHandles = new ArrayList<String>(setOfWindowHandles);
		
		driver.switchTo().window(listOfWindowHandles.get(1));
		driver.findElement(By.id("add-to-cart-button")).click(); //add to cart 
		String cartSubTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText(); // (//div[@class='a-column a-span11 a-text-left a-spacing-top-large']/span)[2]/span
		System.out.println("Cart subtotal: " + cartSubTotal);
		System.out.println(price.contains(cartSubTotal) ? "Price validated successfully": "Price validation failure");
		
		
	}

}
