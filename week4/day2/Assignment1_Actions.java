package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions builder = new Actions(driver);

		resize(driver, builder);

		driver.get("http://www.leafground.com/pages/drag.html"); 
		draggable(driver,builder);

		driver.get("http://www.leafground.com/pages/drop.html"); 
		dragAndDrop(driver,builder);

		driver.get("http://www.leafground.com/pages/selectable.html");
		selectable(driver, builder);

		driver.get("http://www.leafground.com/pages/sortable.html");
		sortable(driver, builder);
	}

	public static  void resize(ChromeDriver driver, Actions builder) {

		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//switch to frame
		WebElement elementResizeable = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

		builder.dragAndDropBy(elementResizeable, 35, 15).perform();
	}

	public static void draggable(ChromeDriver driver, Actions builder) {

		WebElement elementToBeDragged = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		builder.dragAndDropBy(elementToBeDragged, 80, 0).perform();
	}

	public static void dragAndDrop(ChromeDriver driver, Actions builder) {

		builder.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();
	}

	public static void selectable(ChromeDriver driver, Actions builder) {

		WebElement ulItems = driver.findElement(By.id("selectable"));
		List<WebElement> listOfItems = ulItems.findElements(By.tagName("li"));

		builder.keyDown(Keys.CONTROL); //enable control to select all items
		for (WebElement item : listOfItems) {
			builder.click(item).perform(); //click every element
		}
		builder.keyUp(Keys.CONTROL);//release control

	}

	public static void sortable(ChromeDriver driver, Actions builder) { //tbd

		WebElement elementUL = driver.findElement(By.id("sortable"));
		List<WebElement> listOfItems = elementUL.findElements(By.tagName("li"));

		WebElement element1 = listOfItems.get(0);
		WebElement element3 = listOfItems.get(2);

		builder.dragAndDropBy(element1, element3.getLocation().getX(), element3.getLocation().getY()).perform();
	}

}
