package TestNgDay4;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day4 
{
	public WebDriver d;
@Test
public void launch()
 	{
		//ChromeOptions p = new ChromeOptions();
		//p.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "C://jeet material//chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.amazon.com");
		d.manage().window().maximize();
 	}
@Test(dependsOnMethods =  "launch")
public void todaysdeal()
{
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	JavascriptExecutor j = (JavascriptExecutor)d;
	WebElement deal = d.findElement(By.xpath("//a[@class='nav-a  '][1]"));
	j.executeScript("arguments[0].click()", deal);
	d.findElement(By.xpath("//span[text() ='10% off or more']")).click();
	WebElement item = d.findElement(By.xpath("//div[contains(text(),'E8 Active Noise Cancelling Wireless Headphones')]"));
	j.executeScript("arguments[0].click()", item);
	Actions a = new Actions(d);
	WebElement color = d.findElement(By.xpath("//li[@id='color_name_7']"));
	a.moveToElement(color).perform();
	//d.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
}
@Test(dependsOnMethods = "todaysdeal")
public void handling() throws InterruptedException 
{
	  JavascriptExecutor j = (JavascriptExecutor)d;
	  d.navigate().to("https://demoqa.com/radio-button");
	  WebElement radio =  d.findElement(By.xpath("//input[@id='yesRadio']"));
	  j.executeScript("arguments[0].click()", radio);
	  d.navigate().to("https://demoqa.com/browser-windows");
	  String parent = d.getWindowHandle();
	  WebElement tab = d.findElement(By.xpath("//button[@id='tabButton']"));
	  j.executeScript("arguments[0].click()", tab);
	  Set<String>child = d.getWindowHandles();
	  for (String child1 : child) 
	    {
		  if(!child1.equals(parent))
		  {
			Thread.sleep(5000);
			d.switchTo().window(child1);
			d.manage().window().maximize();
			String t=d.getCurrentUrl();
			System.out.println(t);
		  }
		  d.switchTo().window(parent);
		  WebElement newtab = d.findElement(By.xpath("//button[@id='windowButton']"));
		  j.executeScript("arguments[0].click()", newtab);
		  Set<String> child2 = d.getWindowHandles();
		  for (String newt1 : child2) 
		  {
			  if(!newt1.equals(parent))
			  {
				  Thread.sleep(5000);
				  d.switchTo().window(newt1);
				  d.manage().window().maximize();
				  String s = d.getTitle();
				  System.out.println(s);
			  }
		}
	}
}

}