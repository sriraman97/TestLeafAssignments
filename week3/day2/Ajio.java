package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='facet-linkhead'])[1]//label")).click();
		driver.findElement(By.xpath("(//div[@class='facet-linkhead'])[4]//label")).click();
		
		System.out.println("COUNT: " + driver.findElement(By.className("length")).getText());
		
		List<WebElement> listOfBrandNameElements = driver.findElements(By.xpath("//div[@class='contentHolder']/div[@class='brand']"));
		System.out.println("Brand Names");
		for (WebElement brandNameElement : listOfBrandNameElements) {
			System.out.print(brandNameElement.getText() + ", ");
		}
		
		System.out.println();
		
		List<WebElement> listOfProductNames = driver.findElements(By.xpath("//div[@class='contentHolder']/div[@class='nameCls']"));
		System.out.println("Product names");
		for (WebElement productNameElement : listOfProductNames) {
			System.out.print(productNameElement.getText() + ", ");
		}
	}

}
